package com.strikalov.myserials.Model;

import com.strikalov.myserials.DataBase.AppDatabase;
import com.strikalov.myserials.DataBase.Entity.Serial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

public class ModelDatabase implements Model{

    private final AppDatabase database;

    private Map<Long, Serial> identityMap = new ConcurrentHashMap<>();

    public ModelDatabase(AppDatabase database){
        this.database = database;
    }

    @Override
    public void loadData(DisposableMaybeObserver<List<Serial>> observer) {

        database.serialDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    @Override
    public void add(final Serial serial, DisposableCompletableObserver observer) {

        Completable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long newSerialId = database.serialDao().insert(serial);
                identityMap.put(newSerialId, serial);
                return newSerialId;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }

    @Override
    public void update(Serial serial, DisposableCompletableObserver observer) {

        identityMap.put(serial.getId(), serial);

        Completable.fromCallable(() -> database.serialDao().update(serial))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    @Override
    public void delete(Serial serial, DisposableCompletableObserver observer) {

        identityMap.remove(serial.getId());

        Completable.fromCallable(() -> database.serialDao().delete(serial))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    @Override
    public void getById(Long serialId, DisposableMaybeObserver<Serial> observer) {

        if(identityMap.containsKey(serialId)){

            Maybe.just(identityMap.get(serialId))
                    .subscribe(observer);

        }else {

            Maybe.fromCallable(new Callable<Serial>() {
                @Override
                public Serial call() throws Exception {
                    Serial serial = database.serialDao().getById(serialId);
                    identityMap.put(serial.getId(), serial);
                    return serial;
                }
            }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);

        }

    }
}

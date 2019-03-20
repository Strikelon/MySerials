package com.strikalov.myserials.Model;

import com.strikalov.myserials.DataBase.AppDatabase;
import com.strikalov.myserials.DataBase.Entity.Serial;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

public class ModelDatabase implements Model{

    private final AppDatabase database;

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

        Completable.fromCallable(() -> database.serialDao().insert(serial))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}

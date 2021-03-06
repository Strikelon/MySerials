package com.strikalov.myserials.Model;

import com.strikalov.myserials.DataBase.Entity.Serial;

import java.util.List;

import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableMaybeObserver;

public interface Model {

    void loadData(DisposableMaybeObserver<List<Serial>> observer);

    void add(Serial serial, DisposableCompletableObserver observer);

    void update(Serial serial, DisposableCompletableObserver observer);

    void delete(Serial serial, DisposableCompletableObserver observer);

    void getById(Long serialId, DisposableMaybeObserver<Serial> observer);

}

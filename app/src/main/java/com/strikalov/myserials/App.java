package com.strikalov.myserials;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.strikalov.myserials.DataBase.AppDatabase;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database").build();
        appComponent = DaggerAppComponent.builder().apiModule(new ApiModule(database)).build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}

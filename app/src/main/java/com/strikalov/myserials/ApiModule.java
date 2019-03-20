package com.strikalov.myserials;

import com.strikalov.myserials.DataBase.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    private AppDatabase database;

    public ApiModule(AppDatabase database){
        this.database = database;
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(){
        return database;
    }

}

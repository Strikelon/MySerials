package com.strikalov.myserials.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.strikalov.myserials.DataBase.Entity.Serial;

@Database(entities = {Serial.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SerialDao serialDao();

}

package com.strikalov.myserials.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.strikalov.myserials.DataBase.Entity.Serial;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface SerialDao {

    @Query("SELECT * FROM serial")
    Maybe<List<Serial>> getAll();

    @Insert
    Long insert(Serial serial);

    @Update
    int update(Serial serial);

    @Delete
    int delete(Serial serial);

}

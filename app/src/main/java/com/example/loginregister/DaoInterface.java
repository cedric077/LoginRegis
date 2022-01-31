package com.example.loginregister;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

@Dao
public interface DaoInterface {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM user WHERE userId LIKE :username")
    User getAccount(String username);
}

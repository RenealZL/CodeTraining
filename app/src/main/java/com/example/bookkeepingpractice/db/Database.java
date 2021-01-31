package com.example.bookkeepingpractice.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "neal.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql = "create table accounttb(id integer primary key autoincrement, title varchar(20), remark varchar(80). amount float," +
               "time varchar(60), year integer, month integer, day integer)";
      db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

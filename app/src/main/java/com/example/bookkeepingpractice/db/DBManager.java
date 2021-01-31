package com.example.bookkeepingpractice.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private static SQLiteDatabase db;
    public static void initDB(Context context){
        Database creater = new Database(context);
        db = creater.getWritableDatabase();
    }

    public static void insertItemToAccounttb(AccountRecord record){
        ContentValues values = new ContentValues();
        values.put("title", record.getTitle());
        values.put("remark", record.getRemark());
        values.put("amount", record.getAmount());
        values.put("time", record.getTime());
        values.put("year", record.getYear());
        values.put("month", record.getMonth());
        values.put("day", record.getDay());
        db.insert("accounttb", null, values);

    }


}

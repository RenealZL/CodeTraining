package com.example.bookkeepingpractice.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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

    public static List<AccountRecord> getAccountListOneDayFromAccounttb(){
        List<AccountRecord>list = new ArrayList<>();
        String sql = "select * from accounttb order by id desc";
        Cursor cursor = db.rawQuery(sql, new String[]{});
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String remark = cursor.getString(cursor.getColumnIndex("remark"));
            float amount = cursor.getFloat(cursor.getColumnIndex("amount"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            int year = cursor.getInt(cursor.getColumnIndex("year"));
            int month = cursor.getInt(cursor.getColumnIndex("month"));
            int day = cursor.getInt(cursor.getColumnIndex("day"));
            AccountRecord accountRecord = new AccountRecord(id, title, remark, amount, time, year, month, day);
            list.add(accountRecord);
        }
        return list;
    }


}

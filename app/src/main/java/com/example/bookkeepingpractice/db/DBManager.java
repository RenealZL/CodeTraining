package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private static SQLiteDatabase db;
    public static void initDB(Context context){
        Database creater = new Database(context);
        db = creater.getWritableDatabase();


    }
}

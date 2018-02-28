package com.example.cva.attendance;

/**
 * Created by CVA on 26-02-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Atdb  extends SQLiteOpenHelper{
    public static final String TAG = Atdb.class.getSimpleName();
    public static final String DB_NAME = "Att.db";
    public static final int DB_VERSION = 1;

    public static final String STUD_TABLE = "stud";
    public static final String COLUMN_DATE= "date";
    public static final String COLUMN_ID = "_roll";
    public static final String COLUMN_STAT = "status";
    public static final String CREATE_TABLE_STUD = "CREATE TABLE " + STUD_TABLE + "("
            + COLUMN_DATE + " TEXT,"
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT + " TEXT);";

    public Atdb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE);
        onCreate(db);
    }

    public void addDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, date);


        long id = db.insert(STUD_TABLE, null, values);
        db.close();

        Log.d(TAG, " inserted" + id);
    }


}

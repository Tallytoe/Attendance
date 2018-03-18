package com.example.cva.attendance;

/**
 * Created by CVA on 16-03-2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class Studdb extends SQLiteOpenHelper {
    public static final String TAG = Studdb.class.getSimpleName();
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_4 = "MARKS";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_NAME + "("
            + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_4 + " TEXT);";


    public Studdb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(String Rollno) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_4, Rollno);

        long id = db.insert(TABLE_NAME, null, values);

        db.close();

        Log.d(TAG, "user inserted" + id);

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        // query to obtain the names of all tables in your database
        Cursor c = db.rawQuery("SELECT MARKS FROM TABLE_NAME", null);


        return c;



    }


}
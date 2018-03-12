package com.example.cva.attendance;

/**
 * Created by CVA on 26-02-2018.
 */
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Atdb  extends SQLiteOpenHelper  {
    public static final String TAG = Atdb.class.getSimpleName();
    public static final String DB_NAME = "1A.db";
    public static final int DB_VERSION = 1;
    public String value =substud.all ;
    public String STUD_TABLE = value;
    public static final String COLUMN_DATE= "date";
    public static final String COLUMN_ID = "roll";
    public static final String COLUMN_NAM = "name";
    public static final String COLUMN_STAT = "status";

    public final String CREATE_TABLE_STUD = "CREATE TABLE " + STUD_TABLE + "("
            + COLUMN_DATE + " TEXT,"
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAM+"TEXT,"
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
        db.close();
    }

}

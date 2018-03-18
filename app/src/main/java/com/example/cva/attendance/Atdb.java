package com.example.cva.attendance;

/**
 * Created by CVA on 26-02-2018.
 */
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Atdb  extends SQLiteOpenHelper  {
    public static final String TAG = Atdb.class.getSimpleName();
    public static final String DB_NAME = "1A.db";
    public static final int DB_VERSION = 1;
    public String value1 =substud.all1 ;
    public String value2 =substud.all2 ;
    public String value3 =substud.all3 ;
    public String value4 =substud.all4 ;
    public String value5 =substud.all5 ;
    public String value6 =substud.all6 ;

    public String STUD_TABLE1 = value1;
    public String STUD_TABLE2 = value2;
    public String STUD_TABLE3 = value3;
    public String STUD_TABLE4 = value4;
    public String STUD_TABLE5 = value5;
    public String STUD_TABLE6 = value6;


    public static final String COLUMN_DATE1= "date";
    public static final String COLUMN_DATE2= "date";
    public static final String COLUMN_ID1 = "roll";
    public static final String COLUMN_ID2 = "roll";
    public static final String COLUMN_STAT1 = "status";
    public static final String COLUMN_STAT2 = "status";

    public static final String COLUMN_DATE3= "date";
    public static final String COLUMN_DATE4= "date";
    public static final String COLUMN_ID3 = "roll";
    public static final String COLUMN_ID4 = "roll";
    public static final String COLUMN_STAT3 = "status";
    public static final String COLUMN_STAT4 = "status";

    public static final String COLUMN_DATE5= "date";
    public static final String COLUMN_DATE6= "date";
    public static final String COLUMN_ID5 = "roll";
    public static final String COLUMN_ID6 = "roll";
    public static final String COLUMN_STAT5 = "status";
    public static final String COLUMN_STAT6 = "status";

    public final String CREATE_TABLE_STUD1 = "CREATE TABLE " + STUD_TABLE1 + "("
            + COLUMN_DATE1 + " TEXT,"
            + COLUMN_ID1 + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT1 + " TEXT);";
    public final String CREATE_TABLE_STUD2 = "CREATE TABLE " + STUD_TABLE2 + "("
            + COLUMN_DATE2 + " TEXT,"
            + COLUMN_ID2 + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT2 + " TEXT);";
    public final String CREATE_TABLE_STUD3 = "CREATE TABLE " + STUD_TABLE3 + "("
            + COLUMN_DATE3 + " TEXT,"
            + COLUMN_ID3 + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT3 + " TEXT);";
    public final String CREATE_TABLE_STUD4 = "CREATE TABLE " + STUD_TABLE4 + "("
            + COLUMN_DATE4 + " TEXT,"
            + COLUMN_ID4 + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT4 + " TEXT);";
    public final String CREATE_TABLE_STUD5 = "CREATE TABLE " + STUD_TABLE5 + "("
            + COLUMN_DATE5 + " TEXT,"
            + COLUMN_ID5 + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT5 + " TEXT);";
    public final String CREATE_TABLE_STUD6 = "CREATE TABLE " + STUD_TABLE6 + "("
            + COLUMN_DATE6 + " TEXT,"
            + COLUMN_ID6 + " INTEGER PRIMARY KEY,"
            + COLUMN_STAT6 + " TEXT);";


    public Atdb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUD1);
        db.execSQL(CREATE_TABLE_STUD2);
        db.execSQL(CREATE_TABLE_STUD3);
        db.execSQL(CREATE_TABLE_STUD4);
        db.execSQL(CREATE_TABLE_STUD5);
        db.execSQL(CREATE_TABLE_STUD6);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE2);

        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE3);
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE4);
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE5);
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE6);

        onCreate(db);
        db.close();
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        // query to obtain the names of all tables in your database
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);


       return c;



        }

}

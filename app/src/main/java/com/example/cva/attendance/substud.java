package com.example.cva.attendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class substud extends AppCompatActivity  {
    private ImageButton adsub1;

    private EditText subname;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substud);
        adsub1 = findViewById(R.id.button1);
        subname = (EditText) findViewById(R.id.etdbname);
        db=openOrCreateDatabase("1A.db", Context.MODE_PRIVATE,null);
        adsub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("CREATE TABLE IF NOT EXISTS " +subname.getText()+"(Date VARCHAR,Name VARCHAR,Status VARCHAR);");
                displayToast("Inserted");
            }

        });

    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
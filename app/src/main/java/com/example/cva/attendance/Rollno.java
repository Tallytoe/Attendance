package com.example.cva.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class Rollno extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rollno);
        TextView tv = (TextView) findViewById(R.id.textView1);
        String s = getIntent().getStringExtra("dat");
        tv.setText("Welcome ," + s);

    }
    public static String _utfValue = "";

    void sendValue()
    {
        _utfValue = "some value";
    }
}



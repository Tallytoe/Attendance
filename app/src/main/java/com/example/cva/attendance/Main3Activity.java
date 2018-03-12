package com.example.cva.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageButton imgb;

        imgb = (ImageButton) findViewById(R.id.imageButton8);
        imgb.setOnClickListener(this);
    }

    public void onClick(View v) {

        startActivity(new Intent(Main3Activity.this, substud.class));

    }

}


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
        ImageButton imgb2;

        imgb = (ImageButton) findViewById(R.id.imageButton8);
        imgb2 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton imgb3 = (ImageButton) findViewById(R.id.imageButton4);

        imgb.setOnClickListener(this);
        imgb2.setOnClickListener(this);
        imgb3.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton8:
                startActivity(new Intent(Main3Activity.this, substud.class));

                break;
            case R.id.imageButton3:
                startActivity(new Intent(Main3Activity.this, AttMain.class));
                break;
            case R.id.imageButton4:
                startActivity(new Intent(Main3Activity.this, Stud.class));
                break;

            default:

        }
    }
}


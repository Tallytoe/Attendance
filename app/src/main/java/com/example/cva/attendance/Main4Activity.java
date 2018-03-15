package com.example.cva.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        private EditText sub;
        private Button adsub;
        sub=(EditText)findViewById(R.id.etdbname);
        adsub = (Button)findViewById(R.id.button1);
        adsub.setOnClickListener(this);
    }
    public void onClick(View v) {

        startActivity(new Intent(Main4Activity.this, substud.class));

    }

}

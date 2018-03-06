package com.example.cva.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class substud extends AppCompatActivity implements View.OnClickListener {
    private Button adsub;
    private Button delsub;
    private Button upsub;
    private EditText subname;
    private EditText subname2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substud);
        adsub = (Button)findViewById(R.id.button1);
        delsub = (Button)findViewById(R.id.button3);
        upsub = (Button)findViewById(R.id.button2);
        subname=(EditText)findViewById(R.id.etdbname);
        subname2=(EditText)findViewById(R.id.etdbname2);
        adsub.setOnClickListener(this);
        delsub.setOnClickListener(this);
        upsub.setOnClickListener(this);

    }


    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                adddb();
                break;
            case R.id.button3:
                deldb();
                break;
            case R.id.button2:
                updb();
                break;
            default:
        }
    }
    public static String all="" ;
    public static String all2="";
    public void adddb(){
        String dbname1 = subname.getText().toString();
        all=dbname1;
    }
    public void deldb(){
        String dbname1=subname.getText().toString();
        all=dbname1;
    }
    public void updb()
    {
        String dbname1=subname.getText().toString();
        String dbname2=subname2.getText().toString();
        all=dbname1;
        all2=dbname2;

    }
}

package com.example.cva.attendance;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class substud extends AppCompatActivity implements View.OnClickListener {
    private Button adsub1;
    private Button adsub2;
    private Button adsub3;
    private Button adsub4;
    private Button adsub5;
    private Button adsub6;
    private EditText subname;
    private Atdb db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substud);
        adsub1 = (Button)findViewById(R.id.button1);
        adsub2 = (Button)findViewById(R.id.button2);
        adsub3 = (Button)findViewById(R.id.button3);
        adsub4 = (Button)findViewById(R.id.button4);
        adsub5 = (Button)findViewById(R.id.button5);
        adsub6 = (Button)findViewById(R.id.button6);
        subname=(EditText)findViewById(R.id.etdbname);
        adsub1.setOnClickListener(this);
        adsub2.setOnClickListener(this);
        adsub3.setOnClickListener(this);
        adsub4.setOnClickListener(this);
        adsub5.setOnClickListener(this);
        adsub6.setOnClickListener(this);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                adddb1();

                break;
            case R.id.button2:
                adddb2();
                break;
            case R.id.button3:
                adddb3();

            break;
            case R.id.button4:
                adddb4();

                break;
            case R.id.button5:
                adddb5();

                break;
            case R.id.button6:
                adddb6();
                SQLiteDatabase db6= new Atdb(this).getWritableDatabase();
                break;

            default:
        }
    }
    public static String all1="" ;
    public static String all2="" ;
    public static String all3="" ;
    public static String all4="" ;
    public static String all5="" ;
    public static String all6="" ;
    public String adddb1(){

        String dbname1 = subname.getText().toString();
        all1=dbname1;
        return all1;

            }
    public String adddb2(){

        String dbname1 = subname.getText().toString();
        all2=dbname1;
        return all2;

    }

    public String adddb3(){

        String dbname1 = subname.getText().toString();
        all3=dbname1;
        return all3;

    }

    public String adddb4(){

        String dbname1 = subname.getText().toString();
        all4=dbname1;
        return all4;

    }

    public String adddb5(){

        String dbname1 = subname.getText().toString();
        all5=dbname1;
        return all5;

    }

    public String adddb6(){

        String dbname1 = subname.getText().toString();
        all6=dbname1;
        return all6;

    }


}

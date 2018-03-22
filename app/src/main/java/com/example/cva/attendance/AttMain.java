package com.example.cva.attendance;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AttMain extends AppCompatActivity implements View.OnClickListener{
    private Atdb dbb;
    private Button btn;
    private TextView textView;
    private Button buttons[] = new Button[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_main);
        dbb = new Atdb(this);
        btn = (Button) findViewById(R.id.btnc);

        buttons[0] = (Button)findViewById(R.id.button1);
        buttons[1] = (Button)findViewById(R.id.button2);
        buttons[2] = (Button)findViewById(R.id.button3);
        buttons[3] = (Button)findViewById(R.id.button4);
        buttons[4] = (Button)findViewById(R.id.button5);
        buttons[5] = (Button)findViewById(R.id.button6);
        textView=(TextView)findViewById(R.id.textView2);
        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);

        viewAll();
    }

        public void viewAll() {
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> arrTblNames = new ArrayList<String>();
                        Cursor c = dbb.getAllData();
                        if (c.moveToFirst()) {
                            while (!c.isAfterLast()) {
                                arrTblNames.add( c.getString( c.getColumnIndex("name")) );
                                c.moveToNext();

                            }
                        }
                        String [] myary = arrTblNames.toArray(new String[arrTblNames.size()]);
                        for(int i=0;i<6;i++){
                            buttons[i].setVisibility(View.VISIBLE);

                            buttons[i].setText(myary[i+1]);

                        }

                    }
                });

            }
    public void onClick(View v){
        if (v.getId() == R.id.button1) {
            oh();
            String [] myary = oh().toArray(new String[oh().size()]);
            Intent intent = new Intent(AttMain.this,Attendance.class);
            intent.putExtra("datt",myary[1]);
            startActivity(intent);
        } else if (v.getId() == R.id.button2) {
            oh();
            String [] myary = oh().toArray(new String[oh().size()]);
            Intent intent = new Intent(AttMain.this,Attendance.class);
            intent.putExtra("datt",myary[2]);
            startActivity(intent);
        } else if (v.getId() == R.id.button3){
            oh();
            String [] myary = oh().toArray(new String[oh().size()]);
            Intent intent = new Intent(AttMain.this,Attendance.class);
            intent.putExtra("datt",myary[3]);
            startActivity(intent);
        }
        else if (v.getId() == R.id.button4){
            oh();
            String [] myary = oh().toArray(new String[oh().size()]);
            Intent intent = new Intent(AttMain.this,Attendance.class);
            intent.putExtra("datt",myary[4]);
            startActivity(intent);
        }
        else if (v.getId() == R.id.button5){
            oh();
            String [] myary = oh().toArray(new String[oh().size()]);
            Intent intent = new Intent(AttMain.this,Attendance.class);
            intent.putExtra("datt",myary[5]);
            startActivity(intent);
        }
        else if (v.getId() == R.id.button6){
            oh();
            String [] myary = oh().toArray(new String[oh().size()]);
            Intent intent = new Intent(AttMain.this,Attendance.class);
            intent.putExtra("datt",myary[6]);
            startActivity(intent);
        }
    }



    ArrayList<String> oh(){
        Cursor c = dbb.getAllData();
        ArrayList<String> arrTblNames = new ArrayList<String>();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                arrTblNames.add( c.getString( c.getColumnIndex("name")) );
                c.moveToNext();

            }
        }
        return arrTblNames;
    }
        }









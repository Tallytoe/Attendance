package com.example.cva.attendance;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {
    private Button btn;
    private Studdb dbd;
    private CheckBox checkBoxes[] = new CheckBox[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend);
        dbd = new Studdb(this);
        String s = getIntent().getStringExtra("datt");
        btn = (Button) findViewById(R.id.btncc);
        checkBoxes[0] = (CheckBox) findViewById(R.id.cb1);
        checkBoxes[1] = (CheckBox) findViewById(R.id.cb2);
        checkBoxes[2] = (CheckBox)findViewById(R.id.cb3);
        checkBoxes[3] = (CheckBox)findViewById(R.id.cb4);


        viewAll();

    }
    public void viewAll() {
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> arrTbblNames = new ArrayList<String>();
                        Cursor c = dbd.getAllData();
                        if (c.moveToFirst()) {
                            while (!c.isAfterLast()) {
                                arrTbblNames.add(c.getString(c.getColumnIndex("MARKS")));
                                c.moveToNext();

                            }
                        }
                        String [] myaryy = arrTbblNames.toArray(new String[arrTbblNames.size()]);
                        for(int i=0;i<myaryy.length;i++){
                            checkBoxes[i].setVisibility(View.VISIBLE);

                            checkBoxes[i].setText(myaryy[i]);

                        }
                    }
                });
    }
}
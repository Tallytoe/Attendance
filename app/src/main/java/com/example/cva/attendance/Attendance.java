package com.example.cva.attendance;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Attendance extends AppCompatActivity {
    private Button btn;
    private Button btnpro;
    private Studdb dbd;
    private CheckBox checkBoxes[] = new CheckBox[15];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend);
        dbd = new Studdb(this);
        btn = (Button) findViewById(R.id.btncc);
        btnpro=(Button)findViewById(R.id.buttonp);
        checkBoxes[0] = (CheckBox) findViewById(R.id.cb1);
        checkBoxes[1] = (CheckBox) findViewById(R.id.cb2);
        checkBoxes[2] = (CheckBox)findViewById(R.id.cb3);
        checkBoxes[3] = (CheckBox)findViewById(R.id.cb4);
        checkBoxes[4] = (CheckBox)findViewById(R.id.cb5);
        checkBoxes[5] = (CheckBox)findViewById(R.id.cb6);
        checkBoxes[6] = (CheckBox)findViewById(R.id.cb7);
        checkBoxes[7] = (CheckBox)findViewById(R.id.cb8);
        checkBoxes[8] = (CheckBox)findViewById(R.id.cb9);
        checkBoxes[9] = (CheckBox)findViewById(R.id.cb10);
        checkBoxes[10] = (CheckBox)findViewById(R.id.cb11);
        checkBoxes[11] = (CheckBox)findViewById(R.id.cb12);
        checkBoxes[12] = (CheckBox)findViewById(R.id.cb13);
        checkBoxes[13] = (CheckBox)findViewById(R.id.cb14);




        viewAll();
AddData();
    }
    public void viewAll()  {
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gett();
                        String [] mya = gett().toArray(new String[gett().size()]);
                        for(int i=0;i<mya.length;i++){
                            checkBoxes[i].setVisibility(View.VISIBLE);

                            checkBoxes[i].setText(mya[i]);

                        }
                    }
                });
    }
    public ArrayList<String> gett(){
        ArrayList<String> arrTbblNames = new ArrayList<String>();
        Cursor c = dbd.getAllData();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                arrTbblNames.add(c.getString(c.getColumnIndex("MARKS")));
                c.moveToNext();


            }
        }

        return arrTbblNames;
    }
    public  void AddData() {
        btnpro.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SQLiteDatabase db;
                        db = openOrCreateDatabase("1A.db", Context.MODE_PRIVATE, null);

                        try {

                            String [] maa = gett().toArray(new String[gett().size()]);

                            Date currentTime = Calendar.getInstance().getTime();
                            String Tablename = getIntent().getStringExtra("datt");


                            for(int i=0;i<maa.length;i++) {

                                if(checkBoxes[i].isChecked()) {
                                    String rol= (String) checkBoxes[i].getText();


                                    db.execSQL("INSERT INTO "+Tablename+" VALUES('"+currentTime+"','"+rol+"','Present');");


                                }
                                else
                                {
                                    String rol= (String) checkBoxes[i].getText();
                                    db.execSQL("INSERT INTO "+Tablename+" VALUES('"+currentTime+"','"+rol+"','Absent');");


                                }
                            }

                        } catch (Exception e)

                        {
                            Toast.makeText(Attendance.this, "ERROR " + e.toString(), Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }
}

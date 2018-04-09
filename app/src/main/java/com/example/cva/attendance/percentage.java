package com.example.cva.attendance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class percentage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage);
        final EditText pet = (EditText) findViewById(R.id.etp);
        Button pbu = (Button) findViewById(R.id.bp);
       final TextView ptext = (TextView) findViewById(R.id.tvp);


        pbu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View vv) {
                SQLiteDatabase sqldb;
                sqldb = openOrCreateDatabase("1A.db", Context.MODE_PRIVATE, null);
                Cursor c = null;
                String Tablen = getIntent().getStringExtra("pp");
                c= sqldb.rawQuery("SELECT * FROM " + Tablen + " WHERE Name='"+pet.getText()+"'",null);
                String[] array = new String[c.getCount()];
                int i=0;
                float count=0;
                float acount=0;
                while(c.moveToNext())
                {
                    String uname = c.getString(c.getColumnIndex("Status"));
                    array[i] = uname;
                    i++;
                }

                for(int j = 0; j<array.length; j++){

                    if(array[j].equals("Present"))
                    {
                        count=count+1;

                    }
                    else if(array[j].equals("Absent"))
                    {
                        acount=++acount;
                    }
                }
                float tot=((count/(count+acount))*100);
                String a=new String(Float.toString(tot));
                ptext.setText(a+"%");


            }

        });
    }
}
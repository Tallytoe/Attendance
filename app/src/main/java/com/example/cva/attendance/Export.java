package com.example.cva.attendance;

import android.app.ActionBar;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Export extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);
        Button btnexport = (Button) findViewById(R.id.btnexport); //my button with ID btnexport
        final TextView infotext=(TextView)findViewById(R.id.info);
        btnexport.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                SQLiteDatabase sqldb;
                sqldb = openOrCreateDatabase("1A.db",Context.MODE_PRIVATE, null);
                Cursor c = null;
                String Tablename = getIntent().getStringExtra("datt");
                try {
                    c = sqldb.rawQuery("select * from "+Tablename+"", null);
                    int rowcount = 0;
                    int colcount = 0;
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    String filename = "l.csv";
                    // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = c.getCount();
                    colcount = c.getColumnCount();
                    if (rowcount > 0) {
                        c.moveToFirst();

                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {

                                bw.write(c.getColumnName(i) + ",");

                            } else {

                                bw.write(c.getColumnName(i));

                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            c.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                    bw.write(c.getString(j) + ",");
                                else
                                    bw.write(c.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        infotext.setText("Exported Successfully.");
                    }
                } catch (Exception ex) {
                    if (sqldb.isOpen()) {
                        sqldb.close();
                        infotext.setText(ex.getMessage().toString());
                    }

                } finally {

                }

            }
        });


    }
}

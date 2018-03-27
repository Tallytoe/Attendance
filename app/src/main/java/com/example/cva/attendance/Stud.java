package com.example.cva.attendance;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Stud extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private Button btnAdd;
    private Studdb studdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud);
        studdb = new Studdb(this);
        btnAdd= (Button)findViewById(R.id.add);
        editTextId=(EditText)findViewById(R.id.editText3);
        btnAdd.setOnClickListener(this);


    }
    public void onClick(View v) {
        AddData();
    }

    public  void AddData() {

        String Rollno =  editTextId.getText().toString();
        studdb.addUser(Rollno);
        displayToast("STUDENT ADDED");
    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }



}




package com.example.cva.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


public class Date extends AppCompatActivity implements View.OnClickListener {
private DatePicker datep;
private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        datep=(DatePicker) findViewById(R.id.dpick);
        next=(Button)findViewById(R.id.btnnxt);
 next.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnnxt:
                Next();
                break;
            default:

        }
    }

    private void Next(){
        String date = ""+datep.getDayOfMonth()+""+datep.getMonth()+""+datep.getYear();
        if(date.isEmpty()){
            displayToast("No date selected");
        }else{
            Intent intent = new Intent(Date.this,Rollno.class);
            intent.putExtra("dat",date);
            startActivity(intent);
            finish();
        }
    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

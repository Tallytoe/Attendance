package com.example.cva.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogout;
    private Button btn3;
    private Button btn4;

    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session = new Session(this);
        if (!session.loggedin()) {
            logout();
        }
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);

        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

        public void onClick(View v){
            switch(v.getId()){

                case R.id.button3:
                    Intent intent3=new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(intent3);
                    break;
                case R.id.button4:
                    Intent intent4=new Intent(Main2Activity.this,exportsele.class);
                    startActivity(intent4);
                    break;

                default:
            }
        }




    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }
}
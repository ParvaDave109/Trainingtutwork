package com.example.foodiefaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginpage extends AppCompatActivity {
    Button login,register;
    TextView alreadyreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        login = findViewById(R.id.login);
        register = findViewById(R.id.Register);
        alreadyreg = findViewById(R.id.alreadyreg);
        getSupportActionBar().hide();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(loginpage.this,login.class);
                startActivity(intent);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this,register.class);
                startActivity(intent);
            }
        });
        alreadyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this,login.class);
                startActivity(intent);

            }
        });

    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}
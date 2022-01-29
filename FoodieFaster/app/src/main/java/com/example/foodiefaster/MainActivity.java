package com.example.foodiefaster;

import static com.example.foodiefaster.login.MyPREFERENCES;
import static com.example.foodiefaster.login.Name;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                String email = (shared.getString(Name, ""));
                if(email!="")
                {
                    Intent intent = new Intent(MainActivity.this,foodcategory.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }else
                {
                    Intent intent = new Intent(MainActivity.this,loginpage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }
            }
        },4000);

    }
}
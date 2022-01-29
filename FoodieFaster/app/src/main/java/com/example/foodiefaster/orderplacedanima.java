package com.example.foodiefaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class orderplacedanima extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderplacedanima);
        getSupportActionBar().hide();
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(orderplacedanima.this, foodcategory.class);
                startActivity(intent);
            }
        },4000);

    }

}
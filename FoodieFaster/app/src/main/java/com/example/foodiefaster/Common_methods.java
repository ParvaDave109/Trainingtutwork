package com.example.foodiefaster;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Common_methods {
    public Common_methods(Context context, Class<?> nextClass){
        Intent intent = new Intent(context,nextClass);
        //startActivity(intent);
        context.startActivity(intent);
    }

    public Common_methods(Context context, String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }

   }

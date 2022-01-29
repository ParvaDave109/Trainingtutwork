package com.example.foodiefaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    ImageView img,plus,minus;
    TextView foodname;
    TextView price;
    TextView desciption;
    TextView quantitycount;
    int flag=1;
    Button order;
    EditText yourname,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setTitle("Order Pizza");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img = findViewById(R.id.Image);
        quantitycount = findViewById(R.id.quantitycount);
        foodname = findViewById(R.id.Food_name);
        price = findViewById(R.id.price);
        order = findViewById(R.id.orderbutton);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        desciption = findViewById(R.id.detaildescription);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               flag++;
                quantitycount.setText(String.valueOf(flag));

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(flag>1)
                    flag--;

                    quantitycount.setText(String.valueOf(flag));

                }


        });

        final int image = getIntent().getIntExtra("Image",0);
        final String foodnaame = getIntent().getStringExtra("Pizzaname");
        final String pizzaprice = getIntent().getStringExtra("Pizzaprice");
        final String deatailldescription = getIntent().getStringExtra("description");

        img.setImageResource(image);
        foodname.setText(foodnaame);
        price.setText("$"+pizzaprice);
        desciption.setText(deatailldescription);
        final DBhelper helper = new DBhelper(this);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            boolean isinserted =  helper.insertorder(""
                    ,""
                    ,pizzaprice
                    ,image
                    ,String.valueOf(flag)
                    ,foodnaame


            );
            if(isinserted){
                Toast.makeText(OrderActivity.this, "Item Added to Cart", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(OrderActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }

            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
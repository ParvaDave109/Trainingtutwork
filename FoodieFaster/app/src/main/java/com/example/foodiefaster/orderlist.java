package com.example.foodiefaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodiefaster.Adapter.orderlistadapter;
import com.example.foodiefaster.Adapter.pizzaadapter;
import com.example.foodiefaster.ordermodel.orderlistmodel;
import com.example.foodiefaster.pizzamodel.pizzamodel;

import java.util.ArrayList;

public class orderlist extends AppCompatActivity {
    RecyclerView recyclerView,recyclerVieworder;
    ImageView img;
    Button btnorderdetails,buttonplaceorder;
    int i=0,count=0;
    String foodname,quality;
    String kangaro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Your Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_orderlist);
        recyclerView = findViewById(R.id.orderrecyclerView);
        btnorderdetails = findViewById(R.id.orderdetails);
        DBhelper helper = new DBhelper(this);
        ArrayList<orderlistmodel> list = helper.getorders();

        orderlistadapter adapter = new orderlistadapter(list, this);
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        ArrayList<orderlistmodel> orders = new ArrayList<>();
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price,description from orders", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {

                orderlistmodel model = new orderlistmodel();
                model.setOrderfoodname(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setOrderprice(cursor.getString(3));
                model.setOrderdescription(cursor.getString(4));
                orders.add(model);
            }
        }

        //DBhelper helper = new DBhelper(this);
          //ArrayList<orderlistmodel> list= helper.getorders();
         //ArrayList<orderlistmodel> list = new ArrayList<>();
        // list.add(new orderlistmodel(R.drawable.marghereta,"$12" , "Marghereta","Cheesy marghereta pizza"));
        //list.add(new orderlistmodel(R.drawable.onion_capcicum_pizza, "$12", "onion capcicum","Exotic pizza with onion and capcicum"));
        /*DBhelper helper = new DBhelper(this);
        ArrayList<orderlistmodel> list = helper.getorders();

        orderlistadapter adapter = new orderlistadapter(list, this);
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        ArrayList<orderlistmodel> orders = new ArrayList<>();
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price,description from orders", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {

                orderlistmodel model = new orderlistmodel();
                model.setOrderfoodname(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setOrderprice(cursor.getString(3));
                model.setOrderdescription(cursor.getString(4));
                orders.add(model);
                }
                }

//                Toast.makeText(this, "orders"+cursor.getString(1)+cursor.getString(3)+cursor.getString(4), Toast.LENGTH_SHORT).show();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);
                int i=cursor.getString(1).length();
                while(i<=cursor.getString(1).length()) {
                    foodname = foodname+"\n" + cursor.getString(1) ;
                    i++;
                    //kangaro = foodname.toCharArray();

                }
                int j=cursor.getString(4).length();
                while(j<=cursor.getString(4).length()) {
                    quality = quality+"\n" + cursor.getString(4);
                    j++;
                    //kangaro = quality.toCharArray();

                }
                for(int a=cursor.getString(1).length();a<=cursor.getString(1).length();a++){
                    for(int b=cursor.getString(4).length();b<=cursor.getString(4).length();b++){
                        kangaro = kangaro +"\n"+ cursor.getString(1)+" "+ cursor.getString(4)+"\t";
                    }
                }

                String pizza = null;
                pizza = pizza + cursor.getString(1);

                Toast.makeText(this, ""+cursor.getString(1), Toast.LENGTH_SHORT).show();
                String quantity = cursor.getString(4);
                String price = cursor.getString(3);
                StringBuilder builder = new StringBuilder();


                String finalPizza = pizza;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        try {
                            GMailSender sender = new GMailSender("parvadave109@gmail.com", "parvadave@4321");
                            sender.sendMail("Order Received",
                                    ("Productname:\t" + kangaro +
                              "\nQuantity:\t" +  quality + "\nAddress:\t" + " \"\\nPrice:\\t\"" + price
                                            + "\nPhoneNumber:\t"),
                                    "parvadave109@gmail.com",
                                    "carwars95@gmail.com");

                        } catch (Exception e) {
                            Log.d("SendMail", e.getMessage(), e);

                        }
                        Intent intent = new Intent(orderlist.this, yourorders.class);
                            startActivity(intent);

                        orders.add(model);

                        StrictMode.ThreadPolicy policy2 = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                        StrictMode.setThreadPolicy(policy2);

                    }






                });
                btnorderdetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bottomsheet bottomsheet = new Bottomsheet();
                        bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
                    }
                });
            }

            cursor.close();
            database.close();
        }
    }*/
        btnorderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bottomsheet bottomsheet = new Bottomsheet();
                bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
            }
        });

    }




    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,foodcategory.class);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            Intent intent = new Intent(this,foodcategory.class);
            startActivity(intent);
            finish();

        }


        return super.onOptionsItemSelected(item);
    }

}

package com.example.foodiefaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.foodiefaster.Adapter.orderlistadapter;
import com.example.foodiefaster.ordermodel.orderlistmodel;

import java.util.ArrayList;

public class yourorders extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourorders);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            setContentView(R.layout.activity_orderlist);
            recyclerView = findViewById(R.id.orderrecyclerView);
            //     DBhelper helper = new DBhelper(this);
            //   ArrayList<orderlistmodel> list= helper.getorders();
            // ArrayList<orderlistmodel> list = new ArrayList<>();
            // list.add(new orderlistmodel(R.drawable.marghereta,"$12" , "Marghereta","Cheesy marghereta pizza"));
            //list.add(new orderlistmodel(R.drawable.onion_capcicum_pizza, "$12", "onion capcicum","Exotic pizza with onion and capcicum"));
            DBhelper helper = new DBhelper(this);
            ArrayList<orderlistmodel> list = helper.getorders();

            orderlistadapter adapter = new orderlistadapter(list,this);
            recyclerView.setAdapter(adapter);

            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            ArrayList<orderlistmodel> orders = new ArrayList<>();
            SQLiteDatabase database = helper.getWritableDatabase();
            Cursor cursor = database.rawQuery("Select id,foodname,image,price,description from orders",null);
            if(cursor.moveToFirst()){
                while (cursor.moveToNext()){

                    orderlistmodel model = new orderlistmodel();
                    model.setOrderfoodname(cursor.getString(1));
                    model.setOrderimage(cursor.getInt(2));
                    model.setOrderprice(cursor.getString(3));
                    model.setOrderdescription(cursor.getString(4));
//                Toast.makeText(this, "orders"+cursor.getString(1)+cursor.getString(3)+cursor.getString(4), Toast.LENGTH_SHORT).show();

                    orders.add(model);

                }
            }

            cursor.close();
            database.close();

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

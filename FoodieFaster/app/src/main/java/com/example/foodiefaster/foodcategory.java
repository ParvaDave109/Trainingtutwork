package com.example.foodiefaster;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodiefaster.Adapter.CategoryAdapter;
import com.example.foodiefaster.Classes.RecyclerItemClickListener;
import com.example.foodiefaster.Models.Models;

import java.util.ArrayList;

public class foodcategory extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcategory);
        recyclerView = findViewById(R.id.recyclerview);
        ArrayList<Models> list = new ArrayList<>();
        list.add(new Models(R.drawable.pizza, "Pizza"));
        list.add(new Models(R.drawable.pasta, "Pasta"));
        list.add(new Models(R.drawable.garlicbread, "Garlic Bread"));
        list.add(new Models(R.drawable.sides, "Sides"));
        list.add(new Models(R.drawable.lava_cake, "Lava Cake"));
        list.add(new Models(R.drawable.beaverages, "Beaverages"));



        CategoryAdapter adapter = new CategoryAdapter(list, this);
        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //      recyclerView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(foodcategory.this, pizza.class);
                        startActivity(intent);
                        break;

                    case 1:

                        Intent intent2 = new Intent(foodcategory.this, pasta.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(foodcategory.this, garlic_bread.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(foodcategory.this, sides.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(foodcategory.this, lava_cake.class);
                        startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6 = new Intent(foodcategory.this, beaverage.class);
                        startActivity(intent6);
                        break;

                }
            }


            @Override
            public void onLongItemClick(View view, int position) {

            }
        }
        ));


    }
    @Override
    public void onBackPressed() {
       // Intent intent = new Intent(this,login.class);
        //startActivity(intent);
        finishAffinity();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_order,menu);
        ImageView imageView;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Foodieorders:
                Intent intent = new Intent(this,orderlist.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

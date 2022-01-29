package com.example.foodiefaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodiefaster.Adapter.pizzaadapter;
import com.example.foodiefaster.pizzamodel.pizzamodel;

import java.util.ArrayList;

public class beaverage extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaverage);
        getSupportActionBar().setTitle("Beaverages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.beavragerecyclerView);
        ArrayList<pizzamodel> list = new ArrayList<>();

        list.add(new pizzamodel(R.drawable.thumbsup, "Thumbsup", "4","450ml thumbs up"));
        list.add(new pizzamodel(R.drawable.oreoshake, "Oreo chocolate shake", "5","Oreo chocolate shake"));


        pizzaadapter adapter = new pizzaadapter(list, this);
        recyclerView.setAdapter(adapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);


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
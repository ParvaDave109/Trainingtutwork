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

public class lava_cake extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lava_cake);
        getSupportActionBar().setTitle("Lava cake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.lavarecyclerView);
        ArrayList<pizzamodel> list = new ArrayList<>();

         list.add(new pizzamodel(R.drawable.chocolava, "Choco lava", "6","Choco lava cake with molten chocolate center"));
        list.add(new pizzamodel(R.drawable.browneyicecream, "Brownie icecream", "7","Brownie with icecream"));


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
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

public class sides extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides);
        getSupportActionBar().setTitle("Sides");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.sidesrecyclerView);
        ArrayList<pizzamodel> list = new ArrayList<>();
        list.add(new pizzamodel(R.drawable.taco, "Mushroom taco", "6","Mushroom golden corn tacos"));
        list.add(new pizzamodel(R.drawable.tacopanner, "Paneer taco", "8","Paneer golden corn tacos"));


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
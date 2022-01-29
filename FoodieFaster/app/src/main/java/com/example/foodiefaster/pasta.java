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

public class pasta extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);
        getSupportActionBar().setTitle("Pasta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.pastarecyclerView);
        ArrayList<pizzamodel> list = new ArrayList<>();
        list.add(new pizzamodel(R.drawable.pasta, "Foodie pasta", "6","our special foodie pasta pizza"));
        list.add(new pizzamodel(R.drawable.paneertikkapasta, "Panner tikka pasta", "8","Red spicy pasta with exotic panner"));
        list.add(new pizzamodel(R.drawable.foodiepasta, "Spicy red pasta", "6","Red spicy pasta for spice lovers"));


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
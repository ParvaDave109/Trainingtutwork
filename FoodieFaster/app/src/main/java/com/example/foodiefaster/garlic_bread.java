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

public class garlic_bread extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garlic_bread);
        getSupportActionBar().setTitle("Sides");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.garlicbreadrecyclerView);
        ArrayList<pizzamodel> list = new ArrayList<>();

        list.add(new pizzamodel(R.drawable.cheesygarlicbread, "Plain garlic bread", "8","plain garlic bread"));
        list.add(new pizzamodel(R.drawable.garlicbread, "Foodie garlic bread", "6","Foodie faster garlic bread"));
        list.add(new pizzamodel(R.drawable.cheesygarlicbread, "Cheese garlic bread", "8","Garlic bread loaded with extra cheese"));
        list.add(new pizzamodel(R.drawable.supremegarlicbread, "Supreme garlic bread", "7","Garlic bread of supremacy"));


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
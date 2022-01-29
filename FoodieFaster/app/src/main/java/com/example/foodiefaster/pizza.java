package com.example.foodiefaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.foodiefaster.Adapter.CategoryAdapter;
import com.example.foodiefaster.Adapter.pizzaadapter;
import com.example.foodiefaster.Classes.RecyclerItemClickListener;
import com.example.foodiefaster.Models.Models;
import com.example.foodiefaster.pizzamodel.pizzamodel;

import java.util.ArrayList;

public class pizza extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        getSupportActionBar().setTitle("Pizza");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.pizzarecyclerView);
        ArrayList<pizzamodel> list = new ArrayList<>();
        list.add(new pizzamodel(R.drawable.marghereta, "Marghereta", "8","Cheesy marghereta pizza"));
        list.add(new pizzamodel(R.drawable.onion_capcicum_pizza, "Onion capcicum pizza", "8","Exotic pizza with onion and capcicum"));
        list.add(new pizzamodel(R.drawable.seven_cheese_pizza, "Seven cheesy pizza", "12","Super cheesy pizza with seven types of cheese"));
        list.add(new pizzamodel(R.drawable.veg_feast, "Veggie feast", "14","pizza with onion capcicum tomatoes and jalepanos"));
        list.add(new pizzamodel(R.drawable.jalepano_pizza, "Jalepano dip pizza", "14","Jalepenoes paneer with tandoori sauce"));
        list.add(new pizzamodel(R.drawable.tandoori_paneer_pizza, "Tandoori paneer pizza", "15","Onion capcicum red-peprica with paneer and tandoori sauce"));
        list.add(new pizzamodel(R.drawable.spice_route, "Spice route", "15","Extra spicy pizza for spice lovers with karahi dip sauce with red paprica"));
        list.add(new pizzamodel(R.drawable.paneertikapizza, "Paneer tikka pizza", "15","Paneer capcicum onion with exotic paneer tika font"));
        list.add(new pizzamodel(R.drawable.mushroom_pizza, "Mushroom route", "15","Mushroom onion capcicum pizza"));


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

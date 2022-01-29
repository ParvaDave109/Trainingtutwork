package com.example.foodiefaster.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodiefaster.OrderActivity;
import com.example.foodiefaster.R;
import com.example.foodiefaster.pizzamodel.pizzamodel;

import java.util.ArrayList;

public class pizzaadapter extends RecyclerView.Adapter<pizzaadapter.viewholder> {
    ArrayList<pizzamodel> list;
    Context context;


    public pizzaadapter(ArrayList<pizzamodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.pizzalist,parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull pizzaadapter.viewholder holder, int position) {
        pizzamodel model = list.get(position);
        holder.image.setImageResource(model.getPic());
        holder.pizzaname.setText(model.getPizza_name());
        holder.pizzaprice.setText(model.getPizza_price());
        holder.description.setText(model.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("Image",model.getPic());
                intent.putExtra("Pizzaname",model.getPizza_name());
                intent.putExtra("Pizzaprice",model.getPizza_price());
                intent.putExtra("description",model.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView pizzaname,pizzaprice,description;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.pizzaimage);
            pizzaname = itemView.findViewById(R.id.pizzaname);
            pizzaprice = itemView.findViewById(R.id.pizzaprice);
            description = itemView.findViewById(R.id.description);
        }
    }
}

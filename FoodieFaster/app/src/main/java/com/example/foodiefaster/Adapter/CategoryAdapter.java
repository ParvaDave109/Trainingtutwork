package com.example.foodiefaster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodiefaster.Models.Models;
import com.example.foodiefaster.R;

import java.util.ArrayList;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder>{
    ArrayList<Models> list;
    Context context;

    public CategoryAdapter(ArrayList<Models> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categorylist,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryAdapter.viewholder holder, int position) {
       Models mod = list.get(position);
       holder.imageview.setImageResource(mod.getPic());
       holder.textview.setText(mod.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView textview;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.CategoryImage);
            textview = itemView.findViewById(R.id.Categoryname);
        }
    }
}

package com.example.foodiefaster.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodiefaster.DBhelper;
import com.example.foodiefaster.R;
import com.example.foodiefaster.foodcategory;
import com.example.foodiefaster.orderlist;
import com.example.foodiefaster.ordermodel.orderlistmodel;
import com.example.foodiefaster.sampleorder;

import java.util.ArrayList;
import java.util.logging.LogRecord;

public class orderlistadapter extends RecyclerView.Adapter<orderlistadapter.viewholder>{
    ArrayList<orderlistmodel> list;
    Context context;

    public orderlistadapter(ArrayList<orderlistmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull

    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {    View view = LayoutInflater.from(context).inflate(R.layout.pizzalist,parent,false);
        View vieww = LayoutInflater.from(context).inflate(R.layout.activity_sampleorder,parent,false);
        return new orderlistadapter.viewholder(vieww);
    }

    @Override
    public void onBindViewHolder(@NonNull orderlistadapter.viewholder holder, int position) {
    final orderlistmodel model = list.get(position);
        holder.orderfoodname.setText(model.getOrderfoodname());
        holder.ordernumber.setText(model.getOrderdescription());
        holder.orderprice.setText(model.getOrderprice());
        holder.orderedimage.setImageResource(model.getOrderimage());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DBhelper helper = new DBhelper(context);
                new AlertDialog.Builder(context)
                        .setIcon(R.drawable.food_logo)
                        .setTitle("Cancel")
                        .setMessage("Are you sure want to cancel this order")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                helper.deleteorder(model.getOrderimage());
                                Intent intent = new Intent(context,orderlist.class);
                                context.startActivity(intent);

                            }


                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                    }

                }).show();





                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView orderedimage;
        TextView orderfoodname,ordernumber,orderprice;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            orderedimage = itemView.findViewById(R.id.orderimage);
            orderfoodname= itemView.findViewById(R.id.ordername);
            orderprice= itemView.findViewById(R.id.orderprice);
            ordernumber = itemView.findViewById(R.id.orderdescription);

        }
    }
}

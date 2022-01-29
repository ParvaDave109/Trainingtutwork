package com.example.foodiefaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodiefaster.ordermodel.orderlistmodel;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    final static String Dbname = "mydatabase.db";
    final static int DBversion = 5;

    public DBhelper(@Nullable Context context) {

        super(context, Dbname, null, DBversion);
    }

    /*public DBhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DBhelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders" +
                "(id integer primary key autoincrement," +
                "name text," +
                "phone text," +
                "price text," +
                "image int,"+
                "quantity int," +
                "description text," +
                "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);

    }

    public boolean insertorder(String name, String phone, String price,int image, String desc, String foodname) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname",foodname);
        long id = database.insert("orders", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }



    }
    public int deleteorder(int ordername) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","image="+ordername,null);
    }
        public ArrayList<orderlistmodel> getorders(){
        ArrayList<orderlistmodel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price,description from orders",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){

                orderlistmodel model = new orderlistmodel();
                model.setOrderfoodname(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setOrderprice(cursor.getString(3));
                model.setOrderdescription(cursor.getString(4));
                orders.add(model);

            }
        }

        cursor.close();
        database.close();
        return orders;
}
}


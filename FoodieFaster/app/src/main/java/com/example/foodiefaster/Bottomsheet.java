package com.example.foodiefaster;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodiefaster.Adapter.orderlistadapter;
import com.example.foodiefaster.ordermodel.orderlistmodel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bottomsheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bottomsheet extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String str = "";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Bottomsheet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bottomsheet.
     */
    // TODO: Rename and change types and number of parameters
    public static Bottomsheet newInstance(String param1, String param2) {
        Bottomsheet fragment = new Bottomsheet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView recyclerView;
    String foodname, kangaro, quality;
    Button butn;
    EditText phone,address,yourname,pin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottomsheet, container, false);
        recyclerView = view.findViewById(R.id.orderdetailsrecyclerview);
        butn = view.findViewById(R.id.buttonplaceorder);
        phone = view.findViewById(R.id.Your_phone_mail);
        address = view.findViewById(R.id.addresstomail);
        yourname = view.findViewById(R.id.Your_name);
        pin = view.findViewById(R.id.pincode);
       DBhelper helper = new DBhelper(getContext());
        ArrayList<orderlistmodel> list = helper.getorders();

        orderlistadapter adapter = new orderlistadapter(list, getContext());
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        ArrayList<orderlistmodel> orders = new ArrayList<>();
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price,description from orders", null);
        if (cursor.moveToFirst()) {
            StringBuffer buffer = new StringBuffer();

            while (cursor.moveToNext()) {

                orderlistmodel model = new orderlistmodel();
                model.setOrderfoodname(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setOrderprice(cursor.getString(3));
                model.setOrderdescription(cursor.getString(4));
                buffer.append("\nName of item: " + cursor.getString(1));
                buffer.append("\tQuantity: " + cursor.getString(4));
                buffer.append("\tPrice: " + cursor.getString(3));
                str = buffer.toString();
//                Toast.makeText(this, "orders"+cursor.getString(1)+cursor.getString(3)+cursor.getString(4), Toast.LENGTH_SHORT).show();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);
            /*    int i = cursor.getString(1).length();
                while (i <= cursor.getString(1).length()) {
                    foodname = foodname + "\n" + cursor.getString(1);

                    i++;
                    //kangaro = foodname.toCharArray();

                }
                int j = cursor.getString(3).length();
                while (j <= cursor.getString(3).length()) {
                    quality = quality + "\n" + cursor.getString(3);
                    j++;
                    //kangaro = quality.toCharArray();

                }


                for (int a = cursor.getString(1).length(); a <= cursor.getString(1).length(); a++) {
                    for (int b = cursor.getString(4).length(); b <= cursor.getString(4).length(); b++) {
                        kangaro = kangaro + "\n" + cursor.getString(1) + "\t" + "Quantity" + cursor.getString(4) + "\t";
                    }
                }*/

                String pizza = null;
                pizza = pizza + cursor.getString(1);

                String quantity = cursor.getString(4);
                String price = cursor.getString(3);
                StringBuilder builder = new StringBuilder();


                String finalPizza = pizza;
                butn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (yourname.getText().toString().isEmpty()) {
                            yourname.setError("Enter username");
                        }
                        if (phone.getText().toString().isEmpty()) {
                            phone.setError("Enter phonenumber");
                        }
                        if (address.getText().toString().isEmpty()) {
                            address.setError("Enter address");
                        }
                        if (pin.getText().toString().isEmpty()) {
                            pin.setError("Enter pincode");
                        } else {

                            try {


                             //   GMailSender sender = new GMailSender("parvadave109@gmail.com", "");
                              //  sender.sendMail("Order Received",
                               //         ("\nUser name:  " + yourname.getText().toString() + str + "\nAddress:\t" + address.getText().toString().trim()
                                //                + "\nPhoneNumber:\t" + phone.getText().toString().trim())+"\npincode:\t"+pin.getText().toString().trim(),
                                //        "parvadave109@gmail.com",
                                //        "");

                            } catch (Exception e) {
                                Log.d("SendMail", e.getMessage(), e);

                            }
                            Intent intent = new Intent(getContext(), orderplacedanima.class);
                            startActivity(intent);

                            orders.add(model);

                            StrictMode.ThreadPolicy policy2 = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                            StrictMode.setThreadPolicy(policy2);

                        }

                    }
                });


            }
            }


                return view;
            }
        }


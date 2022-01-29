package com.example.foodiefaster;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class register extends AppCompatActivity {
    EditText username, phonenumber, email, password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        phonenumber = findViewById(R.id.phonenumber);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.registerbutton);
        getSupportActionBar().setTitle("Register");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty()) {
                    username.setError("Enter email");
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("Enter password");
                }
                //else if (Password.getText().toString().trim().equals(Confirmpassword.getText().toString().trim())) {
                // new Common_methods(Register.this, MYAPPLICATION.class);
                //}
                // else if (Password != Confirmpassword) {
                //  Confirmpassword.setError("Password and Confirm password is not same");
                // }
                else {
                    if (new ConnectionDetector(register.this).isConnectingToInternet()) {

                        new signupdata().execute();
                    } else {
                        new ConnectionDetector(register.this).connectiondetect();
                    }
                }


                   /* String confirmpassword = Confirmpassword.getText().toString()String user = username.getText().toString();
                    String password = Password.getText().toString();
                    Myhandeler splashappandlogin = new Myhandeler(Register.this);
                    contact harry = new contact();
                    harry.setName(user);
                    harry.setPhonenumber(password);
                    splashappandlogin.addContact(harry);
                    int affectedRows = splashappandlogin.updateContact(harry);
                    List<contact> allcontact = splashappandlogin.getallcontacts();
/*
                    // for (contact contact : allcontact) {

        /*                Log.d("dbharry",
                                "\n"  +contact.getId()+ "\n" +
                                        "phone number" + contact.getPhonenumber() + "\n" +
                                        "Username" + contact.getName() + "\n");

                    }


                }


            }  );
}
*/

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private class signupdata extends AsyncTask<String, String, String> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(register.this);
            pd.setMessage("Please wait...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", username.getText().toString());
            hashMap.put("email", email.getText().toString());
            hashMap.put("password", password.getText().toString());
            hashMap.put("contact", "");
            hashMap.put("gender","male");
            hashMap.put("city","ahmedabad");
            hashMap.put("dob","10/6/21");


            return new MakeServiceCall().MakeServiceCall(Constanturl.URL + "signup.php", MakeServiceCall.POST, hashMap);

        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
            try {
                JSONObject object = new JSONObject(s);
                if (object.getBoolean("Status") == true) {
                    new Common_methods(register.this, "SIGN UP SUCCESSFUL");
                    Toast.makeText(register.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                } else {
                    new Common_methods(register.this, object.getString("Something went wrong"));
                    Toast.makeText(register.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }
}


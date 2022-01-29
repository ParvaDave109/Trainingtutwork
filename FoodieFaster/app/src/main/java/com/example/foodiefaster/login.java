package com.example.foodiefaster;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class login extends AppCompatActivity {
    Button btn;
    EditText username, password;
    SharedPreferences sp;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "passwordKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Sign-In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn = findViewById(R.id.button_for_login);
        username = findViewById(R.id.username2);
        password = findViewById(R.id.password2);
        sp = getSharedPreferences(Constanturl.pref, MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().trim().isEmpty()) {
                    username.setError("Username can't be blank");
                } else if (password.getText().toString().trim().isEmpty()) {
                    password.setError("Password can't be empty");
                } else {
                    if (new ConnectionDetector(login.this).isConnectingToInternet()) {
                        new logindata().execute();
                    } else {
                        new ConnectionDetector(login.this).connectiondetect();
                    }


                }
                //validate(Name.getText().toString(), password.getText().toString());

            }

        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, loginpage.class);
        startActivity(intent);
        finish();

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    private class logindata extends AsyncTask<String, String, String> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(login.this);
            pd.setMessage("Please wait...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("email", username.getText().toString());
            hashMap.put("password", password.getText().toString());

            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Name, username.getText().toString());
            editor.putString(Password, password.getText().toString());
            editor.commit();
            return new MakeServiceCall().MakeServiceCall(Constanturl.URL + "login.php", MakeServiceCall.POST, hashMap);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
            try {
                JSONObject object = new JSONObject(s);
                if (object.getBoolean("Status") == true) {
                    int i;
                    new Common_methods(login.this, object.getString("Message"));
                    new Common_methods(login.this, foodcategory.class);
                    JSONArray array = new JSONArray("response");
                    for (i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        sp.edit().putString(Constanturl.id, jsonObject.getString("id")).commit();
                        sp.edit().putString(Constanturl.name, jsonObject.getString("name")).commit();
                        sp.edit().putString(Constanturl.password, jsonObject.getString("password")).commit();
                        sp.edit().putString(Constanturl.contact, jsonObject.getString("contact")).commit();
                        sp.edit().putString(Constanturl.email, jsonObject.getString("id")).commit();


                        jsonObject.getString("id");
                        jsonObject.getString("name");
                        jsonObject.getString("email");
                        jsonObject.getString("contact");
                        jsonObject.getString("password");


                    }


                } else {
                    new Common_methods(login.this, object.getString("Message"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

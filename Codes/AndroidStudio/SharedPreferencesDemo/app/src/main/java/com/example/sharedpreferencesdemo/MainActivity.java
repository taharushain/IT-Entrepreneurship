package com.example.sharedpreferencesdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String PREF_KEY = "com.my.preference.key";
    private final String KEY_CHECK = "admin_logged";
    private final String KEY_NAME = "admin_name";
    Context context;

    EditText etUserName;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPref = getSharedPreferences(PREF_KEY,Context.MODE_PRIVATE);
        Boolean admin_logged_in = sharedPref.getBoolean(KEY_CHECK,false);

//        Toast.makeText(this, sharedPref.getBoolean(KEY_CHECK, false)+"", Toast.LENGTH_SHORT).show();


        etUserName = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        context = this;
        if(admin_logged_in){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }



    public void login(View iv){


        checkLogin();
    }

    public void checkLogin(){
        if(etUserName.getText().toString().equals("admin")
                && etPassword.getText().toString().equals("1234")){
            SharedPreferences sharedPref = getSharedPreferences(PREF_KEY,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(KEY_CHECK, true);
            editor.putString(KEY_NAME, "John Doe");
            editor.commit();

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else{
            Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show();
        }

    }
}

package com.example.sharedpreferencesdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private final String PREF_KEY = "com.my.preference.key";
    private final String KEY_CHECK = "admin_logged";
    private final String KEY_NAME = "admin_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPref = getSharedPreferences(PREF_KEY,Context.MODE_PRIVATE);
        String admin_name = sharedPref.getString(KEY_NAME,"Nahe Mila");

        TextView textView = (TextView) findViewById(R.id.tv_admin_name);
        textView.setText("Welcome "+admin_name+"!");



    }

    public void removeUser(){
        SharedPreferences sharedPref = getSharedPreferences(PREF_KEY,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(KEY_CHECK, false);

//      Toast.makeText(this, sharedPref.getBoolean(KEY_CHECK, false)+"", Toast.LENGTH_SHORT).show();
        editor.clear();
        editor.commit();
        editor.apply();
    }

    public void logout(View v){
        removeUser();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}

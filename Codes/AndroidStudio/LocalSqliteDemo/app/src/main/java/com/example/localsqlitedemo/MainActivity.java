package com.example.localsqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_Name, et_Age;

    private SqliteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Name = (EditText) findViewById(R.id.et_name);
        et_Age = (EditText) findViewById(R.id.et_age);

        db = new SqliteHandler(getApplicationContext());

    }

    public void create(View v){

        String name = et_Name.getText().toString().trim();
        int age = Integer.parseInt(et_Age.getText().toString().trim());

        db.addUser(name, age);

        et_Name.setText("");
        et_Age.setText("");


    }
    public void retrieve(View v){

        Intent intent = new Intent(MainActivity.this, RecordActivity.class);
        startActivity(intent);

    }
}

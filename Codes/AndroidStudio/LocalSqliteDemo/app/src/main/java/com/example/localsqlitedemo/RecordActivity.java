package com.example.localsqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

import static com.example.localsqlitedemo.SqliteHandler.KEY_AGE;
import static com.example.localsqlitedemo.SqliteHandler.KEY_NAME;

public class RecordActivity extends AppCompatActivity {

    private SqliteHandler db;

    private TextView tv_name, tv_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        db = new SqliteHandler(getApplicationContext());
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_age = (TextView) findViewById(R.id.tv_age);

        HashMap<String, String> hashMap = db.getUserDetails();

        String name = hashMap.get(KEY_NAME);
        int age = Integer.parseInt(hashMap.get(KEY_AGE));

        tv_name.setText(name+"");
        tv_age.setText(age+"");


    }
}

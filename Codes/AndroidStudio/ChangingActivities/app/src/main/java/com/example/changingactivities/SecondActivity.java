package com.example.changingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Intent intent;
    String message;
    TextView tv_display_2;


    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        intent = getIntent();
        Log.d(TAG , "Inside Second Activity");
        Log.d(TAG, "Message: "+intent.getStringExtra("message"));
        message = intent.getStringExtra("message");

        tv_display_2 = (TextView) findViewById(R.id.tv_display_2);

        tv_display_2.setText(message);

//        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
    }
}

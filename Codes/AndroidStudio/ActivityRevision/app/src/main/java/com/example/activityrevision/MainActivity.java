package com.example.activityrevision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_message;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Inside Oncreate");

        Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_LONG).show();

        et_message = (EditText) findViewById(R.id.et_message);
    }

    public void btn_click(View v){

        Log.d(TAG, "Inside btn_click");

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message",et_message.getText().toString());
        startActivity(intent);
//        Toast.makeText(this,"Button was pressed!", Toast.LENGTH_SHORT).show();
    }
}

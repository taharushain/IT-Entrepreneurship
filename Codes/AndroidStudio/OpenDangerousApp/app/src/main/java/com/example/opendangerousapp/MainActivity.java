package com.example.opendangerousapp;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoDangerousApp(View iv){

        Intent intent = new Intent();
        ComponentName cn = new ComponentName("com.example.dangerousapp",
                "com.example.dangerousapp.MainActivity");
        intent.setComponent(cn);
        startActivity(intent);

    }
}

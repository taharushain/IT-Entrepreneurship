package com.example.intentsdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openBrowser(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri data = Uri.parse("https://www.google.com");
        intent.setData(data);
        startActivity(intent);
    }

    public void openMyBrowser(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri data = Uri.parse("https://www.google.com");
        ComponentName cn = new ComponentName("com.example.intentexternalapp",
                "com.example.intentexternalapp.MainActivity");
        intent.setComponent(cn);
        startActivity(intent);

    }
}

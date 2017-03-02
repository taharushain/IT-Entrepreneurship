package com.example.activityrevision;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btn;
    Context apna_context;
    Intent intent;
    TextView tv_paigham;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = (Button) findViewById(R.id.btn_back);
        tv_paigham = (TextView) findViewById(R.id.tv_paigham);

        intent = getIntent();
        String message = intent.getStringExtra("message");

        tv_paigham.setText(message);

        apna_context = this;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kuch_aur = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(kuch_aur);
            }
        });

    }
}

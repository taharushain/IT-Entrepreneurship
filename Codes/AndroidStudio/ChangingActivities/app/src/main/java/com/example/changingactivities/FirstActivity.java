package com.example.changingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    TextView tv_display;
    EditText et_message;
    Button btn_message;
    Button btn_goto_second;

    private static final  String TAG = "FirstActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        tv_display = (TextView) findViewById(R.id.tv_display);
        et_message = (EditText) findViewById(R.id.editText_first_activity);
        btn_message = (Button) findViewById(R.id.btn_message);
        btn_goto_second = (Button) findViewById(R.id.btn_goto_second);

//        btn_message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                tv_display.setText(et_message.getText()+"  :My Message");
//
//            }
//        });


    }

    public void my_button_change_activity(View v){
//        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);

        Log.d(TAG,"Inside my_button");
        Log.d(TAG,"Message: "+et_message.getText());

        intent.putExtra("message",""+et_message.getText());
        startActivity(intent);
    }

    public void my_button_click(View view){
        Toast.makeText(this, "Button Pressed", Toast.LENGTH_LONG).show();
        tv_display.setText(et_message.getText());
    }

}

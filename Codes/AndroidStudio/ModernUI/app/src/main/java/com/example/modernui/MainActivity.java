package com.example.modernui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewOne;
    TextView textViewTwo;
    TextView textViewThree;
    TextView textViewFour;
    TextView textViewFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOne = (TextView) findViewById(R.id.tv_one);
        textViewTwo = (TextView) findViewById(R.id.tv_two);
        textViewThree = (TextView) findViewById(R.id.tv_three);
        textViewFour = (TextView) findViewById(R.id.tv_four);
        textViewFive = (TextView) findViewById(R.id.tv_five);

        textViewOne.setBackgroundColor(getResources().getColor(R.color.textViewOne));
        textViewTwo.setBackgroundColor(getResources().getColor(R.color.textViewTwo));
        textViewThree.setBackgroundColor(getResources().getColor(R.color.textViewThree));
        textViewFour.setBackgroundColor(getResources().getColor(R.color.textViewFour));
        textViewFive.setBackgroundColor(getResources().getColor(R.color.textViewFive));

    }
}

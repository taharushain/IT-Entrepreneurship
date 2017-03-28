package com.example.graphicstransitiondrawable;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TransitionDrawable transition = (TransitionDrawable) getResources()
                .getDrawable(R.drawable.shape_transition);

        transition.setCrossFadeEnabled(true);

        ((ImageView) findViewById(R.id.image_view)).setImageDrawable(transition);

        transition.startTransition(3000);
    }
}

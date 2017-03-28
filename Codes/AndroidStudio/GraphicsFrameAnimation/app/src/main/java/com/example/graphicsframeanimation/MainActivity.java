package com.example.graphicsframeanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable mAnim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.countdown_frame);

        imageView.setBackgroundResource(R.drawable.view_animation);

        mAnim = (AnimationDrawable) imageView.getBackground();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mAnim.isRunning()) {
            mAnim.stop();
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mAnim.start();
        }
    }
}
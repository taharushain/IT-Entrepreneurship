package com.golemtron.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0 ,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(getLayoutInflater().inflate(R.layout.toast_layout, null));

        toast.show();

    }
}

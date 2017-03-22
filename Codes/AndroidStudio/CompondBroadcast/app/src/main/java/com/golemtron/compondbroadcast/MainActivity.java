package com.golemtron.compondbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CUSTOM_INTENT = "com.golemtron.compondbroadcast.show_toast";
    private final Receiver1 receiver1 = new Receiver1();
    private final IntentFilter intentFilter = new IntentFilter(CUSTOM_INTENT);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(receiver1, intentFilter);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUSTOM_INTENT);
                sendBroadcast(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver1);
        super.onDestroy();
    }
}

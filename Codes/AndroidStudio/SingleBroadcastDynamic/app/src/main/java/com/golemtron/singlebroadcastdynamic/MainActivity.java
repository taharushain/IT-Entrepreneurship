package com.golemtron.singlebroadcastdynamic;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CUSTOM_INTENT = "com.golemtron.singlebroadcastdynamic.show_toast";
    private final IntentFilter intentFilter = new IntentFilter(CUSTOM_INTENT);
    private final Receiver receiver = new Receiver();

    private LocalBroadcastManager mBroadcastMgr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBroadcastMgr = LocalBroadcastManager
                .getInstance(getApplicationContext());
        mBroadcastMgr.registerReceiver(receiver, intentFilter);

        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBroadcastMgr.sendBroadcast(new Intent(CUSTOM_INTENT));
            }
        });
    }

    @Override
    protected void onDestroy() {
        mBroadcastMgr.unregisterReceiver(receiver);
        super.onDestroy();
    }
}

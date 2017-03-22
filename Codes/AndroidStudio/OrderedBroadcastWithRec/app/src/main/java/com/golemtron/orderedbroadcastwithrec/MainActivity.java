package com.golemtron.orderedbroadcastwithrec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String CUSTOM_INTENT = "com.golemtron.orderedbroadcastwithrec.show_toast";

    private final Receiver1 mReceiver1 = new Receiver1();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(CUSTOM_INTENT);
        intentFilter.setPriority(3);
        registerReceiver(mReceiver1, intentFilter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrderedBroadcast(new Intent(CUSTOM_INTENT), null,
                        new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context context, Intent intent) {
                                Toast.makeText(context,
                                        "Final Result is " + getResultData(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }, null, 0, null, null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver1);
        super.onDestroy();
    }
}

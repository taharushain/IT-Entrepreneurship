package com.golemtron.orderedbroadcastwithrec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by taharushain on 3/22/17.
 */

public class Receiver3 extends BroadcastReceiver {
    private final String TAG = "Receiver3";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "INTENT RECEIVED by Receiver3");

        String tmp = getResultData() == null ? "" : getResultData();
        setResultData(tmp + ":Receiver 3");
    }

}


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

public class Receiver1 extends BroadcastReceiver {
    private final String TAG = "Receiver1";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "INTENT RECEIVED by Receiver1");



        String tmp = getResultData() == null ? "" : getResultData();
        setResultData(tmp + ":Receiver 1:");

        if (isOrderedBroadcast()) {
            Log.i(TAG, "Calling abortBroadcast()");
            abortBroadcast();
        }
    }

}

package com.example.test.helloworld;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by test on 2017. 7. 12..
 */

public class DongkService extends Service {
    Receiver receiver;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DongkService", "create Service");
        receiver = new Receiver();
        IntentFilter receiverif = new IntentFilter();
        receiverif.addAction("dongk.web.restart");
        receiverif.addAction("dongk.web.restart.google");
        receiverif.addAction("dongk.web.eventcheck");
        receiverif.addAction("dongk.web.noeventcheck");
        registerReceiver(receiver, receiverif);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Dongk Service", "Destroy Service");
        if (receiver != null)
            unregisterReceiver(receiver);
    }

    public class Receiver extends BroadcastReceiver{
        private boolean eventCheck;
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("dongk.web.noeventcheck")){
                Log.d("eventCheck", "No Event Check");
                eventCheck = false;
            }
            if (intent.getAction().equals("dongk.web.eventcheck")){
                Log.d("eventCheck", "On Event Check");
                eventCheck = true;
            }
            if (eventCheck) {
                Log.d("eventCheck", "eventCheck - true");
                if (intent.getAction().equals("dongk.web.restart")) {
                    Log.d("restart", "restart - display");
                    App.getInstance().startDisplay();
                } else if (intent.getAction().equals("dongk.web.restart.google")) {
                    Log.d("restart", "restart - google");
                    App.getInstance().startGoogle();
                }
            }else {
                Log.d("eventCheck", "eventCheck - false");
            }
        }
    }
}

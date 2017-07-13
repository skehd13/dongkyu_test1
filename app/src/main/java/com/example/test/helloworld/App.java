package com.example.test.helloworld;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by test on 2017. 7. 12..
 */

public class App extends Application {
    public static App instance;
    public boolean isWebRunning = false;
    @Override
    public void onCreate() {
        Log.d("helloworld", "create App");
        super.onCreate();
        instance = this;
    }
    private void setWebRunningStatus(boolean status){instance.isWebRunning = status;}
    public static App getInstance(){ return instance;}
    public void startDisplay(){
        Log.d("helloworld", "start - display");
        getApplicationContext().sendBroadcast(new Intent("dongk.web.start"));
    }
    public void startGoogle(){
        Log.d("helloworld", "start - google");
        getApplicationContext().sendBroadcast(new Intent("dongk.web.start.google"));
    }
}

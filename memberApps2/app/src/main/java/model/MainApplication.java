package model;

import android.app.Application;

import helper.RetroClient;

public class MainApplication extends Application {

    public static RetroClient retroClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retroClient = retroClient.getInstance();
    }
}
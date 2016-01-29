package com.sourceit.task2;

import android.app.Application;

/**
 * Created by User on 28.01.2016.
 */
public class App extends Application {
    private static App Instance;
    public static App getApp(){
        return Instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
    }
}

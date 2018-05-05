package com.pince.demo;

import android.app.Application;

import com.pince.network.RetrofitManager;


public class MainApplication extends Application {

    public static final String TAG = "HttpLog";

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitManager.okHttpBuilder()
                .setLogEnable(true)
                .retrofitBuilder("http://www.weather.com.cn/")
                .build();



    }
}

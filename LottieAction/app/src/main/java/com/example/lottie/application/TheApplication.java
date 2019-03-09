package com.example.lottie.application;

import android.app.Application;
import android.util.Log;

import com.tencent.mmkv.MMKV;

/**
 * autour: bobbylu
 * date: 2019/3/9 on 15:51
 */
public class TheApplication extends Application {

    private static final String TAG = "TheApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        String root = MMKV.initialize(getApplicationContext());
        Log.d(TAG,"root:"+root);
    }
}

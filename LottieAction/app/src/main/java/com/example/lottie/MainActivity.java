package com.example.lottie;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.lottie.utils.SharedPreferencesUtils;
import com.tencent.mmkv.MMKV;

public class MainActivity extends Activity {

    private  static final String TAG = "MainActivity";

    private LottieAnimationView animationView;
    private MMKV mMMKV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLottieAnimation();

        initMMKV();

        printData();

        useMMKVimportSp();
    }


    private void initLottieAnimation(){
        animationView = (LottieAnimationView)findViewById(R.id.animation_view);
//        animationView.setAnimation("lottie_data_origin.json");
        animationView.setAnimation("btn.json");
        animationView.setImageAssetsFolder("images");
        animationView.loop(true);

        animationView.playAnimation();
        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取消动画使用cancelAnimation
                animationView.cancelAnimation();
            }
        });
    }

    private void initMMKV(){
        mMMKV = MMKV.defaultMMKV();
        mMMKV.encode("label",true);
        mMMKV.encode("later",4);
        mMMKV.encode("go","str");


        SharedPreferencesUtils.setAddStatus(this,5);
        SharedPreferencesUtils.setStatus(this,true);
    }

    private void printData(){
        Log.d(TAG,"label:"+mMMKV.getBoolean("lable",false));
        Log.d(TAG,"label:"+mMMKV.getInt("later",0));
        Log.d(TAG,"label:"+mMMKV.getString("go","hello"));
        Log.d(TAG,"add:"+SharedPreferencesUtils.getAddStatus(this));
    }

    private void  useMMKVimportSp(){
        Log.d(TAG,"use the mmkv to show sp data.");
        MMKV mmkv = MMKV.mmkvWithID(SharedPreferencesUtils.PreferencesName);

        // 做数据迁移
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferencesUtils.PreferencesName,Context.MODE_PRIVATE);
        mmkv.importFromSharedPreferences(sharedPreferences);
        sharedPreferences.edit().clear().commit();

        // 打印迁移之后的数据
        Log.d(TAG,"add::"+mmkv.getInt(SharedPreferencesUtils.KEY_ADD,0));
        Log.d(TAG,"status::"+mmkv.getBoolean(SharedPreferencesUtils.KEY_STATUS,false));

    }
}

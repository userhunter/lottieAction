package com.example.lottie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
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
    }

    private void printData(){
        Log.d(TAG,"label:"+mMMKV.getBoolean("lable",false));
        Log.d(TAG,"label:"+mMMKV.getInt("later",0));
        Log.d(TAG,"label:"+mMMKV.getString("go","hello"));
    }
}

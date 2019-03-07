package com.example.lottie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends Activity {

    private  static final String TAG = "MainActivity";

    private LottieAnimationView animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLottieAnimation();
    }


    private void initLottieAnimation(){
        animationView = (LottieAnimationView)findViewById(R.id.animation_view);
//        animationView.setAnimation("bubble_1.json");
        animationView.setAnimation("lottie_data_origin.json");
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
}

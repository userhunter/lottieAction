# lottieAction
简单的Lottie使用

当前比较稳定的Lottie version是：2.6.0-beta19

1） 在dependencies中添加如下代码
 implementation 'com.airbnb.android:lottie:2.6.0-beta19'

2） 在Java代码中添加如下代码
 animationView = (LottieAnimationView)findViewById(R.id.animation_view);
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

3） 动画的取消是使用cancelAnimation(),而不是clearAnimation()

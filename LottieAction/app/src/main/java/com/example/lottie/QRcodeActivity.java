package com.example.lottie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.lottie.utils.QRUtils;

/**
 * autour: bobbylu
 * date: 2019/4/2 on 21:23
 */
public class QRcodeActivity extends Activity {

    private ImageView mQrcode;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        initViews();
    }

    private void initViews(){
        mQrcode = (ImageView)findViewById(R.id.qrcode);
        Bitmap mBitmap = QRUtils.createQRCodeBitmap("https://www.baidu.com", 480, 480);
        mQrcode.setImageBitmap(mBitmap);
    }
}

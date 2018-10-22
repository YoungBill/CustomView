package com.baina.customview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.baina.customview.widget.OmnipotentProgressView;

/**
 * Created by baina on 18-1-25.
 */

public class OmnipotentProgressViewActivity extends Activity {

    private OmnipotentProgressView mProgressLeft;
    private OmnipotentProgressView mProgressTop;
    private OmnipotentProgressView mProgressRight;
    private OmnipotentProgressView mProgressBottom;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mProgressLeft.setProgress(msg.what);
            mProgressTop.setProgress(msg.what);
            mProgressRight.setProgress(msg.what);
            mProgressBottom.setProgress(msg.what);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omnipotentprogressview);

        mProgressLeft = findViewById(R.id.left_progress);
        mProgressTop = findViewById(R.id.top_progress);
        mProgressRight = findViewById(R.id.right_progress);
        mProgressBottom = findViewById(R.id.bottom_progress);
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 1; i <= 100; i++) {
                    mHandler.sendEmptyMessage(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 100)
                        i = 1;
                }
            }
        }.start();
    }
}

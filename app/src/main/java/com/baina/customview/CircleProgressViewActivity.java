package com.baina.customview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.baina.customview.widget.CircleProgressView;

/**
 * Created by baina on 18-1-25.
 */

public class CircleProgressViewActivity extends Activity {

    private CircleProgressView mCircleProgressView;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCircleProgressView.setProgress(msg.what);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circleprogressview);

        mCircleProgressView = findViewById(R.id.circleProgressView);
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

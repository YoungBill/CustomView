package com.baina.customview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

public class MainActivity extends Activity {

    private OmnipotentProgressView mProgressLeft;
    private OmnipotentProgressView mProgressTop;
    private OmnipotentProgressView mProgressRight;
    private OmnipotentProgressView mProgressBottom;
    private CircleProgressView mCircleProgressView;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mProgressLeft.setProgress(msg.what);
            mProgressTop.setProgress(msg.what);
            mProgressRight.setProgress(msg.what);
            mProgressBottom.setProgress(msg.what);
            mCircleProgressView.setProgress(msg.what);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressLeft = findViewById(R.id.left_progress);
        mProgressTop = findViewById(R.id.top_progress);
        mProgressRight = findViewById(R.id.right_progress);
        mProgressBottom = findViewById(R.id.bottom_progress);
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

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.testCoordinateBt:
                startActivity(new Intent(MainActivity.this, CoordinateActivity.class));
                break;
            case R.id.testInflaterBt:
                startActivity(new Intent(MainActivity.this, InflaterActivity.class));
                break;
        }
    }
}

package com.baina.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public class CoordinateActivity extends Activity {

    private RelativeLayout mMainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        mMainView = findViewById(R.id.mainView);
        TestCoordinateView testCoordinateView = new TestCoordinateView(CoordinateActivity.this);
//        mMainView.addView(testCoordinateView);
//        LayoutInflater.from(CoordinateActivity.this).inflate(R.layout.layout_testcoordinate,mMainView,true);
//        LayoutInflater.from(CoordinateActivity.this).inflate(R.layout.layout_testcoordinate,mMainView);
//        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(CoordinateActivity.this).inflate(R.layout.layout_testcoordinate, mMainView, false);
//        mMainView.addView(relativeLayout);
        RelativeLayout relativeLayout1 = (RelativeLayout) LayoutInflater.from(CoordinateActivity.this).inflate(R.layout.layout_testcoordinate, null, true);
        mMainView.addView(relativeLayout1);
    }
}

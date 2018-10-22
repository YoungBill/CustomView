package com.baina.customview;

import android.app.Activity;
import android.os.Bundle;

import com.baina.customview.widget.SimpleSurfaceView;

/**
 * Created by baina on 18-1-25.
 */

public class SurfaceViewActivity extends Activity {

    private SimpleSurfaceView mSimpleSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfaceview);

        mSimpleSurfaceView = findViewById(R.id.surfaceView);
        mSimpleSurfaceView.setFps(30);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSimpleSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSimpleSurfaceView.onPause();
    }
}

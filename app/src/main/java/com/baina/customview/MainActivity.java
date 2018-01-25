package com.baina.customview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.omnipotentProgressViewBt:
                startActivity(new Intent(MainActivity.this, OmnipotentProgressViewActivity.class));
                break;
            case R.id.circleProgressViewBt:
                startActivity(new Intent(MainActivity.this, CircleProgressViewActivity.class));
                break;
            case R.id.testCoordinateBt:
                startActivity(new Intent(MainActivity.this, CoordinateActivity.class));
                break;
            case R.id.testInflaterBt:
                startActivity(new Intent(MainActivity.this, InflaterActivity.class));
                break;
            case R.id.pieChartBt:
                startActivity(new Intent(MainActivity.this, PieChartActivity.class));
                break;
        }
    }
}

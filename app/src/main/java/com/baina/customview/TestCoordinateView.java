package com.baina.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by baina on 18-1-18.
 */

public class TestCoordinateView extends LinearLayout {

    public TestCoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = getRootView();
        Log.d("aa", view.getId() == R.id.mainView ? "true" : "false");
        LayoutInflater.from(getContext()).inflate(R.layout.layout_testcoordinate, this, true);
    }
}

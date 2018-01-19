package com.baina.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by baina on 18-1-18.
 */

public class TestCoordinateView extends LinearLayout {

    public TestCoordinateView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_testcoordinate, this, true);
    }

    public TestCoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_testcoordinate, this, true);
    }
}

package com.baina.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 测试inflate方法的类
 */
public class InflaterActivity extends Activity {

    private LinearLayout mMainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);
        mMainView = findViewById(R.id.mainView);
        /**
         * LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testcoordinate, mMainView);
         * LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testcoordinate, mMainView, true);
         * 效果一样，attachToRoot默认是true
         */
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testinflater, mMainView, true);
//        LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testinflater, mMainView);
        /**
         * RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testcoordinate, mMainView, false);
         * LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testinflater, mMainView, true);
         * 因为都有父布局mMainView，所以layout根结点属性有效
         * 而attachToRoot是true的时候，layout会被添加到mMainView中，所以返回的view类型是父布局的根结点类型
         * 而attachToRoot是false的时候，layout没有被添加到mMainView中，所以返回的view类型是layout的根结点类型
         */
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testinflater, mMainView, false);
        mMainView.addView(relativeLayout);
        /**
         * RelativeLayout relativeLayout1 = (RelativeLayout) LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testinflater, null, false);
         * 因为没有父布局，所以layout根结点无效
         * 而attachToRoot无论是true还是false的时候，layout没有被添加到mMainView中，所以返回的view类型是layout的根结点类型
         */
        RelativeLayout relativeLayout1 = (RelativeLayout) LayoutInflater.from(InflaterActivity.this).inflate(R.layout.layout_testinflater, null, false);
        mMainView.addView(relativeLayout1);
    }
}

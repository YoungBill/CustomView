package com.baina.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chentao on 2018/1/18.
 */

public class CircleProgressView extends View {

    private static final float DEFAULT_WIDTH = 200;
    private static final float DEFAULT_HEIGHT = 200;

    private int mBorderColor;
    private int mBorderWidth;
    private int mSweepColor;
    private int mMaskColor;

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgress);
        //边缘色
        mBorderColor = typedArray.getColor(R.styleable.CircleProgress_border_color, 0);
        //边缘宽度
        mBorderWidth = typedArray.getInteger(R.styleable.CircleProgress_border_width, 0);
        //进度色
        mSweepColor = typedArray.getInteger(R.styleable.CircleProgress_sweep_color, 0);
        //填充色
        mMaskColor = typedArray.getInteger(R.styleable.CircleProgress_mask_color, 100);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        //因为绘制的是圆，所以判断一下高度或者宽度中的一个就可以。
        switch (wMode) {
            case MeasureSpec.AT_MOST://android:layout_width="warp_content"
                // 获取屏幕像素
                float density = getResources().getDisplayMetrics().density;
                wSize = (int) (DEFAULT_WIDTH * density);
                hSize = (int) (DEFAULT_HEIGHT * density);
                break;
            //当在xml中指定控件的宽高为match_parent或者指定数值的宽高时，回调以下代码
            case MeasureSpec.EXACTLY://android:layout_width="match_parent" android:layout_width="40dp"
                wSize = hSize = Math.min(wSize, hSize);
                break;
        }
        setMeasuredDimension(wSize, hSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        // 绘制外层的圆框
        mPaint.setColor(mBorderColor);
        mPaint.setStrokeWidth(mBorderWidth);
        mPaint.setStyle(Paint.Style.STROKE);//设置圆形为空心的圆
        // 这里我们得到控件的Height和Width，根据Heigh和Width来确定圆心的位置，来绘制外层圆
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - mBorderWidth / 2, mPaint);
        invalidate();//请求重新绘制view
//        // 绘制内部的扇形
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
}

package com.baina.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by baina on 18-1-16.
 * 万能的进度条View
 */

public class OmnipotentProgressView extends View {

    private static final String TAG = "CustomProgressView";

    private int mBgResId;
    private int mProgressResId;
    private int mOrientation;
    private int mMaxProgress;
    private Bitmap mBgBitmap;
    private Bitmap mProgressBitmap;
    private int mWidth;
    private int mHeight;
    private int mProgress;

    public OmnipotentProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyProgress);
        //背景图片
        mBgResId = typedArray.getResourceId(R.styleable.MyProgress_bg_drawable, 0);
        //进度图片
        mProgressResId = typedArray.getResourceId(R.styleable.MyProgress_progress_drawable, 0);
        //方向
        mOrientation = typedArray.getInteger(R.styleable.MyProgress_orientation, 0);
        //最大进度
        mMaxProgress = typedArray.getInteger(R.styleable.MyProgress_max_progress, 100);
        typedArray.recycle();
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBgBitmap, 0, 0, null);
        ImageCrop(canvas, mProgressBitmap, mProgress * 1.0f / mMaxProgress);
    }

    public void setProgress(int progress) {
        mProgress = progress;
        invalidate();
    }

    private void ImageCrop(Canvas canvas, Bitmap bitmap, float progress) {
        int w = bitmap.getWidth(); // 得到图片的宽，高
        int h = bitmap.getHeight();
        int x = 0;
        int y = 0;
        switch (mOrientation) {
            case 0:
                //left
                w = (int) (w * progress);
                break;
            case 1:
                //top
                h = (int) (h * progress);
                break;
            case 2:
                //right
                x = (int) (w - w * progress);
                w = (int) (w * progress);
                break;
            case 3:
                //bottom
                y = (int) (h - h * progress);
                h = (int) (h * progress);
                break;
        }
        //下面这句是关键
        try {
            Bitmap tempBitmap = Bitmap.createBitmap(bitmap, x, y, w, h, null, false);
            canvas.drawBitmap(tempBitmap, x, y, null);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }

    private void init() {
        //进度图的bitmap
        if (mProgressResId != 0) {
            mProgressBitmap = BitmapFactory.decodeResource(getResources(), mProgressResId);
        } else {
            mProgressBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.blue);
        }
        //背景图的bitmap
        if (mBgResId != 0) {
            mBgBitmap = BitmapFactory.decodeResource(getResources(), mBgResId);
        } else {
            mBgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.white);
        }
        //图片宽
        mWidth = mProgressBitmap.getWidth();
        //图片高
        mHeight = mProgressBitmap.getHeight();
    }
}

package com.baina.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CoordinateActivity extends Activity {

    private static final String TAG = CoordinateActivity.class.getSimpleName();

    private Button testBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        testBt = findViewById(R.id.testBt);
    }

    //此时layout才渲染完毕
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            /**
             * View并未发生移动的时候，即translationX或者translation==0的时候
             * getX()=getLeft()
             */
            Log.d(TAG, "getLeft:" + testBt.getLeft() + " getX:" + testBt.getX() + " getTranslationX:" + testBt.getTranslationX());
        }
    }

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.testBt:
                /**
                 * View发生移动的时候，即translationX或者translation!=0的时候
                 * getX()=getLeft()+getTranslationX()
                 */
                ObjectAnimator translationXAnimator1 = ObjectAnimator.ofFloat(testBt, "translationX", 0, 100).setDuration(2000);
                ObjectAnimator translationXAnimator2 = ObjectAnimator.ofFloat(testBt, "translationX", 100, 0).setDuration(2000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(translationXAnimator1, translationXAnimator2);
                translationXAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.d(TAG, "getLeft:" + testBt.getLeft() + " getX:" + testBt.getX() + " getTranslationX:" + testBt.getTranslationX());
                    }
                });
                translationXAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.d(TAG, "getLeft:" + testBt.getLeft() + " getX:" + testBt.getX() + " getTranslationX:" + testBt.getTranslationX());
                    }
                });
                animatorSet.start();
                break;
        }
    }
}

package br.com.androidrio.legendarymaterialtransitions;

import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class HeroTransition {
    private int drawingStartLocationTop, drawingStartLocationLeft, imageWidth, imageHeight,
            mLeftDelta, mTopDelta;

    private float mWidthScale, mHeightScale;
    private View mToView;
    private AnimatorListenerAdapter mListenerAdapter;
    private Interpolator mInterpolator;

    public HeroTransition(View toView, int drawingStartLocationTop, int drawingStartLocationLeft, int imageWidth, int imageHeight, int mLeftDelta, int mTopDelta, float mWidthScale, float mHeightScale) {
        this.drawingStartLocationTop = drawingStartLocationTop;
        this.drawingStartLocationLeft = drawingStartLocationLeft;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.mLeftDelta = mLeftDelta;
        this.mTopDelta = mTopDelta;
        this.mWidthScale = mWidthScale;
        this.mHeightScale = mHeightScale;
        mToView = toView;
    }

    public HeroTransition withListener(AnimatorListenerAdapter listener){
        mListenerAdapter = listener;
        return this;
    }

    public HeroTransition withInterpolator(Interpolator interpolator){
        mInterpolator = interpolator;
        return this;
    }

    public void start(){
        mToView.setPivotX(0);
        mToView.setPivotY(0);
        mToView.setScaleX(mWidthScale);
        mToView.setScaleY(mHeightScale);
        mToView.setTranslationX(mLeftDelta);
        mToView.setTranslationY(mTopDelta);

        mToView.animate().scaleX(1).scaleY(1).translationX(0).translationY(0).setListener(mListenerAdapter).setInterpolator(mInterpolator).start();
    }

    public void reset(@Nullable AnimatorListenerAdapter listener){
        mToView.animate().scaleX(mWidthScale).scaleY(mHeightScale).translationX(mLeftDelta).translationY(mTopDelta).setListener(listener);
    }

    public void reset(){
        reset(null);
    }

}

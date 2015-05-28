package br.com.androidrio.legendarymaterialtransitions.transition;

import android.animation.AnimatorListenerAdapter;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class HeroTransition extends BaseTransition{
    private int mLeftDelta, mTopDelta;

    private float mWidthScale, mHeightScale;
    private View mToView;
    private AnimatorListenerAdapter mListenerAdapter;
    private Interpolator mInterpolator;

    public HeroTransition(View toView, int leftDelta, int topDelta, float
            widthScale, float heightScale) {
        this.mLeftDelta = leftDelta;
        this.mTopDelta = topDelta;
        this.mWidthScale = widthScale;
        this.mHeightScale = heightScale;
        mToView = toView;
    }

    @Override
    public HeroTransition withListener(AnimatorListenerAdapter listener) {
        mListenerAdapter = listener;
        return this;
    }

    @Override
    public HeroTransition withInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        return this;
    }

    @Override
    public HeroTransition setDuration(int duration) {
        mDuration = duration;
        return this;
    }

    @Override
    public void start() {
        mToView.setPivotX(0);
        mToView.setPivotY(0);
        mToView.setScaleX(mWidthScale);
        mToView.setScaleY(mHeightScale);
        mToView.setTranslationX(mLeftDelta);
        mToView.setTranslationY(mTopDelta);

        mToView.animate().scaleX(1).scaleY(1).translationX(0).translationY(0).setDuration(mDuration).setListener(mListenerAdapter).setInterpolator(mInterpolator).start();
    }

    @Override
    public void reset(@Nullable AnimatorListenerAdapter listener) {
        mToView.animate().scaleX(mWidthScale).scaleY(mHeightScale).translationX(mLeftDelta).translationY(mTopDelta).setDuration(mDuration).setListener(listener);
    }


}

package br.com.androidrio.legendarymaterialtransitions.transition;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;

import br.com.androidrio.legendarymaterialtransitions.internal.AlphaSatColorMatrixEvaluator;
import br.com.androidrio.legendarymaterialtransitions.internal.AnimateColorMatrixColorFilter;

/**
 * Created by leona_000 on 27/05/2015.
 */
public class ImageLoadingTransition extends BaseTransition{
    private BitmapDrawable mBitmapDrawable;

    public ImageLoadingTransition(BitmapDrawable bitmapDrawable) {
        mBitmapDrawable = bitmapDrawable;
    }


    @Override
    public ImageLoadingTransition withListener(AnimatorListenerAdapter listener) {
        mListener = listener;
        return this;
    }

    @Override
    public ImageLoadingTransition withInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        return this;
    }

    @Override
    public ImageLoadingTransition setDuration(int duration) {
        mDuration = duration;
        return this;
    }

    @Override
    public void start() {
        AlphaSatColorMatrixEvaluator evaluator = new AlphaSatColorMatrixEvaluator();
        final AnimateColorMatrixColorFilter filter = new AnimateColorMatrixColorFilter(evaluator
                .getColorMatrix());
        mBitmapDrawable.setColorFilter(filter.getColorFilter());

        ObjectAnimator animator = ObjectAnimator.ofObject(filter, "colorMatrix", evaluator,
                evaluator.getColorMatrix());

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mBitmapDrawable.setColorFilter(filter.getColorFilter());
            }
        });

        animator.setDuration(mDuration);
        animator.setInterpolator(mInterpolator);
        if(mListener != null)
            animator.addListener(mListener);
        animator.start();
    }

    @Override
    public void reset(@Nullable AnimatorListenerAdapter listenerAdapter) {

    }
}

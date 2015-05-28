package br.com.androidrio.legendarymaterialtransitions.transition;

import android.animation.AnimatorListenerAdapter;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;

import br.com.androidrio.legendarymaterialtransitions.Constants;

/**
 * Created by AndroidRio on 27/05/2015.
 */
public abstract class BaseTransition<T> {
    protected int mDuration = Constants.ANIMATION_DURATION;
    protected AnimatorListenerAdapter mListener;
    protected Interpolator mInterpolator;

    public abstract T withListener(AnimatorListenerAdapter listener);

    public abstract T withInterpolator(Interpolator interporlator);

    public abstract T setDuration(int duration);

    public abstract void start();

    public abstract void reset(@Nullable AnimatorListenerAdapter listenerAdapter);

    public void reset(){
        reset(null);
    }
}

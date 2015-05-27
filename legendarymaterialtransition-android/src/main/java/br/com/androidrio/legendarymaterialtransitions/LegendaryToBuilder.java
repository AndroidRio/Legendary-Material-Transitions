package br.com.androidrio.legendarymaterialtransitions;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class LegendaryToBuilder {
    private Activity mActivity;
    private View mToView;
    private HeroTransition mHeroTransition;
    private AnimatorListenerAdapter mListener;

    public LegendaryToBuilder(Activity activity, View toView){
        mActivity = activity;
        mToView = toView;
    }

    public HeroTransition withData(Intent intent){
        mHeroTransition = TransitionFactory.createHeroTransition(intent.getExtras(), mToView, mListener);

        return mHeroTransition;
    }
}

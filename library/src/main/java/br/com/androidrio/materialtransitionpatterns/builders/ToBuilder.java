package br.com.androidrio.materialtransitionpatterns.builders;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

import br.com.androidrio.materialtransitionpatterns.factory.TransitionFactory;
import br.com.androidrio.materialtransitionpatterns.transition.HeroTransition;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class ToBuilder {
    private Activity mActivity;
    private View mToView;
    private HeroTransition mHeroTransition;
    private AnimatorListenerAdapter mListener;

    public ToBuilder(Activity activity, View toView) {
        mActivity = activity;
        mToView = toView;
    }

    public HeroTransition withData(Intent intent) {
        mHeroTransition = TransitionFactory.createHeroTransition(intent.getExtras(), mToView,
                mListener);

        return mHeroTransition;
    }


}

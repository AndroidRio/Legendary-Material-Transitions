package br.com.androidrio.materialtransitionpatterns.builders;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import br.com.androidrio.materialtransitionpatterns.factory.TransitionFactory;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class FromBuilder {
    private Activity mActivity;
    private View mFromView;

    public FromBuilder(Activity activity, View fromView){
        mActivity = activity;
        mFromView = fromView;
    }

    public void with(Intent intent){
        intent.putExtras(TransitionFactory.createHeroBundle(mFromView));
        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(0,0);
    }
}

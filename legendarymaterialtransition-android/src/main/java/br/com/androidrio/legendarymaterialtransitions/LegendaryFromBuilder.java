package br.com.androidrio.legendarymaterialtransitions;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class LegendaryFromBuilder {
    private Activity mActivity;
    private View mFromView;

    public LegendaryFromBuilder(Activity activity, View fromView){
        mActivity = activity;
        mFromView = fromView;
    }

    public void with(Intent intent){
        intent.putExtras(TransitionFactory.createHeroBundle(mFromView));
        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(0,0);
    }
}

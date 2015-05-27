package br.com.androidrio.legendarymaterialtransitions;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class Legendary {
    private Activity mActivity;

    private Legendary(Activity activity){
        mActivity = activity;
    }

    public static Legendary getInstance(Fragment fragment){
       return getInstance(fragment.getActivity());
    }

    public static Legendary getInstance(Activity activity){
        return new Legendary(activity);
    }

    public LegendaryFromBuilder from(View fromView){
        LegendaryFromBuilder legendaryFromBuilder = new LegendaryFromBuilder(mActivity, fromView);
        return legendaryFromBuilder;
    }

    public LegendaryToBuilder to(View toView){
        LegendaryToBuilder legendaryToBuilder = new LegendaryToBuilder(mActivity, toView);
        return legendaryToBuilder;
    }






}

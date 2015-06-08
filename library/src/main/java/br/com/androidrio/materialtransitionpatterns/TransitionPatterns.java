package br.com.androidrio.materialtransitionpatterns;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import br.com.androidrio.materialtransitionpatterns.builders.FromBuilder;
import br.com.androidrio.materialtransitionpatterns.builders.ImageLoadingBuilder;
import br.com.androidrio.materialtransitionpatterns.builders.ToBuilder;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class TransitionPatterns {
    private Activity mActivity;

    private TransitionPatterns(Activity activity){
        mActivity = activity;
    }

    public static TransitionPatterns getInstance(android.app.Fragment fragment){
        return getInstance(fragment.getActivity());
    }

    public static TransitionPatterns getInstance(Fragment fragment){
       return getInstance(fragment.getActivity());
    }

    public static TransitionPatterns getInstance(Activity activity){
        return new TransitionPatterns(activity);
    }

    public FromBuilder from(View fromView){
        FromBuilder fromBuilder = new FromBuilder(mActivity, fromView);
        return fromBuilder;
    }

    public ToBuilder to(View toView){
        ToBuilder toBuilder = new ToBuilder(mActivity, toView);
        return toBuilder;
    }

    public ImageLoadingBuilder load(ImageView imageView){
        ImageLoadingBuilder imageLoadingBuilder = new ImageLoadingBuilder(mActivity, imageView);
        return imageLoadingBuilder;
    }




}

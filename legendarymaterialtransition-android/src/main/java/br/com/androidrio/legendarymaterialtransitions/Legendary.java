package br.com.androidrio.legendarymaterialtransitions;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import br.com.androidrio.legendarymaterialtransitions.builders.FromBuilder;
import br.com.androidrio.legendarymaterialtransitions.builders.ImageLoadingBuilder;
import br.com.androidrio.legendarymaterialtransitions.builders.ToBuilder;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class Legendary {
    private Activity mActivity;

    private Legendary(Activity activity){
        mActivity = activity;
    }

    public static Legendary getInstance(android.app.Fragment fragment){
        return getInstance(fragment.getActivity());
    }

    public static Legendary getInstance(Fragment fragment){
       return getInstance(fragment.getActivity());
    }

    public static Legendary getInstance(Activity activity){
        return new Legendary(activity);
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

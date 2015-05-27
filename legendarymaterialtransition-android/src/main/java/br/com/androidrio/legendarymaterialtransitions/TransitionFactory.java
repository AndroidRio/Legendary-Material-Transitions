package br.com.androidrio.legendarymaterialtransitions;

import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class TransitionFactory {
    public static final String ARG_DRAWING_START_LOCATION_TOP = "arg_drawing_start_location_top";
    public static final String ARG_DRAWING_START_LOCATION_LEFT = "arg_drawing_start_location_left";
    public static final String ARG_IMAGE_WIDTH = "arg_image_width";
    public static final String ARG_IMAGE_HEIGHT = "arg_image_height";

    public static Bundle createHeroBundle(View fromView){

        Bundle bundle = new Bundle();
        if(fromView != null) {
            bundle.putInt(ARG_DRAWING_START_LOCATION_TOP, fromView.getTop());
            bundle.putInt(ARG_DRAWING_START_LOCATION_LEFT, fromView.getLeft());

            bundle.putInt(ARG_IMAGE_WIDTH, fromView.getWidth());
            bundle.putInt(ARG_IMAGE_HEIGHT, fromView.getHeight());
        }

        return bundle;
    }

    public static HeroTransition createHeroTransition(Bundle bundle, View toView, AnimatorListenerAdapter listener){
        int[] screenLocation = new int[2];
        toView.getLocationOnScreen(screenLocation);

        int drawingStartLocationTop = bundle.getInt(ARG_DRAWING_START_LOCATION_TOP, 0);
        int drawingStartLocationLeft = bundle.getInt(ARG_DRAWING_START_LOCATION_LEFT, 0);
        int mLeftDelta = drawingStartLocationLeft - screenLocation[0];
        int mTopDelta = drawingStartLocationTop - screenLocation[1];
        int imageWidth = bundle.getInt(ARG_IMAGE_WIDTH, 0);
        int imageHeight = bundle.getInt(ARG_IMAGE_HEIGHT, 0);

        float mWidthScale = (float) imageWidth / toView.getWidth();
        float mHeightScale = (float) imageHeight / toView.getHeight();

        HeroTransition heroTransition = new HeroTransition(toView, drawingStartLocationTop, drawingStartLocationLeft, imageWidth, imageHeight, mLeftDelta, mTopDelta, mWidthScale, mHeightScale);
        heroTransition.withListener(listener);

        return heroTransition;
    }


}

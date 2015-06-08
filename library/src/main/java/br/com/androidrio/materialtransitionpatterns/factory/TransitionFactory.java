package br.com.androidrio.materialtransitionpatterns.factory;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import br.com.androidrio.materialtransitionpatterns.transition.HeroTransition;
import br.com.androidrio.materialtransitionpatterns.transition.ImageLoadingTransition;

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

    public static HeroTransition createHeroTransition(Bundle bundle, View toView){

        int drawingStartLocationTop = bundle.getInt(ARG_DRAWING_START_LOCATION_TOP, 0);
        int drawingStartLocationLeft = bundle.getInt(ARG_DRAWING_START_LOCATION_LEFT, 0);
        int mLeftDelta = drawingStartLocationLeft - toView.getLeft();
        int mTopDelta = drawingStartLocationTop - toView.getTop();
        int imageWidth = bundle.getInt(ARG_IMAGE_WIDTH, 0);
        int imageHeight = bundle.getInt(ARG_IMAGE_HEIGHT, 0);

        float mWidthScale = (float) imageWidth / toView.getWidth();
        float mHeightScale = (float) imageHeight / toView.getHeight();

        HeroTransition heroTransition = new HeroTransition(toView, mLeftDelta, mTopDelta, mWidthScale, mHeightScale);

        return heroTransition;
    }

    public static ImageLoadingTransition createImageLoadingTransition(Context context, ImageView imageView, Bitmap bitmap){
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        imageView.setImageDrawable(bitmapDrawable);

        ImageLoadingTransition imageLoadingTransition = new ImageLoadingTransition(bitmapDrawable);
        return imageLoadingTransition;
    }


}

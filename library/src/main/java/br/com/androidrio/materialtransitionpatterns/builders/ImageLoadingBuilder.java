package br.com.androidrio.materialtransitionpatterns.builders;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import br.com.androidrio.materialtransitionpatterns.factory.TransitionFactory;
import br.com.androidrio.materialtransitionpatterns.transition.ImageLoadingTransition;

/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class ImageLoadingBuilder {
    private Activity mActivity;
    private ImageView mImageView;
    private ImageLoadingTransition mImageLoadingTransition;

    public ImageLoadingBuilder(Activity activity, ImageView imageView){
        mActivity = activity;
        mImageView = imageView;
    }

    public ImageLoadingTransition withImage(Bitmap bitmap){
        mImageLoadingTransition = TransitionFactory.createImageLoadingTransition(mActivity, mImageView, bitmap);
        return mImageLoadingTransition;
    }

    public ImageLoadingTransition withImage(int resId){
        Bitmap bitmap = BitmapFactory.decodeResource(mActivity.getResources(), resId);
        return withImage(bitmap);
    }
}

package br.com.androidrio.legendarymaterialtransitions.internal;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;

/**
 * Created by leona_000 on 27/05/2015.
 */
public class AnimateColorMatrixColorFilter {
    private ColorMatrixColorFilter mFilter;
    private ColorMatrix mMatrix;

    public AnimateColorMatrixColorFilter(ColorMatrix matrix) {
        setColorMatrix(matrix);
    }

    public ColorMatrixColorFilter getColorFilter() {
        return mFilter;
    }

    public void setColorMatrix(ColorMatrix matrix) {
        mMatrix = matrix;
        mFilter = new ColorMatrixColorFilter(matrix);
    }

    public ColorMatrix getColorMatrix() {
        return mMatrix;
    }
}

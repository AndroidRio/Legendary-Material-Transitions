package br.com.androidrio.sample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import br.com.androidrio.materialtransitionpatterns.TransitionPatterns;
import br.com.androidrio.materialtransitionpatterns.transition.HeroTransition;
import butterknife.ButterKnife;
import butterknife.InjectView;
/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class SubActivity extends AppCompatActivity {

    @InjectView(R.id.image)
    ImageView mImage;

    private HeroTransition mHeroTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ButterKnife.inject(this);
        mHeroTransition = TransitionPatterns.getInstance(this).to(mImage).withData(getIntent()).setDuration(1000).withInterpolator(new FastOutLinearInInterpolator());
        mHeroTransition.start();
    }

    @Override
    public void onBackPressed() {

        mHeroTransition.reset(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                SubActivity.super.onBackPressed();
                overridePendingTransition(0, 0);
            }
        });

    }

}

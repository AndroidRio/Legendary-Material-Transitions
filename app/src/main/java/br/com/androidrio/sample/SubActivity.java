package br.com.androidrio.sample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;

import br.com.androidrio.legendarymaterialtransitions.Legendary;
import br.com.androidrio.legendarymaterialtransitions.transition.HeroTransition;

public class SubActivity extends AppCompatActivity {

    private HeroTransition mHeroTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        final View square = findViewById(R.id.square);
        final View contentRoot = findViewById(R.id.contentRoot);
        contentRoot.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver
                .OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                contentRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                mHeroTransition = Legendary.getInstance(SubActivity.this).to(square).withData(getIntent()).setDuration(1000).withInterpolator(new FastOutLinearInInterpolator());
                mHeroTransition.start();
                return true;
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHeroTransition.reset(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        finish();
                        overridePendingTransition(0,0);
                    }
                });
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

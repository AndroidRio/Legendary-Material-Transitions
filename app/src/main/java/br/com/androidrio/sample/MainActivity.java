package br.com.androidrio.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import br.com.androidrio.materialtransitionpatterns.TransitionPatterns;
import butterknife.ButterKnife;
import butterknife.InjectView;
/**
 * Created by leonardo.santos on 27/05/2015.
 */
public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.image)
    ImageView mImage;
    @InjectView(R.id.btn_load)
    Button mLoadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                TransitionPatterns.getInstance(MainActivity.this).from(mImage).with(intent);
            }
        });

        mLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionPatterns.getInstance(MainActivity.this).load(mImage).withImage(R.drawable.beach).setDuration(2000).start();
            }
        });

    }
}

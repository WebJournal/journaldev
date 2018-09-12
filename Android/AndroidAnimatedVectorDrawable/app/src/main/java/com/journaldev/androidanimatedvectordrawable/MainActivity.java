package com.journaldev.androidanimatedvectordrawable;

import android.graphics.drawable.Animatable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AnimatedVectorDrawable tickToCross, crossToTick;
    private boolean isTick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabSync = findViewById(R.id.fabSync);
        FloatingActionButton fabTickCross = findViewById(R.id.fabTickCross);

        tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick2cross);
        crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross2tick);


        ImageView imgSettings = findViewById(R.id.imgSettings);
        ImageView imgJD = findViewById(R.id.imgJD);
        imgSettings.setOnClickListener(this);
        imgJD.setOnClickListener(this);

        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_sync);
        fabSync.setImageDrawable(animatedVectorDrawableCompat);
        fabSync.setOnClickListener(this);
        fabTickCross.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgSettings:
                Animatable animatable = (Animatable) ((ImageView) view).getDrawable();
                if (animatable.isRunning())
                    animatable.stop();
                else
                    animatable.start();
                break;


            case R.id.imgJD:
                animatable = (Animatable) ((ImageView) view).getDrawable();
                if (animatable.isRunning())
                    animatable.stop();
                else
                    animatable.start();
                break;


            case R.id.fabSync:
                animatable = (Animatable) ((FloatingActionButton) view).getDrawable();
                if (animatable.isRunning())
                    animatable.stop();
                else
                    animatable.start();
                break;

            case R.id.fabTickCross:
                AnimatedVectorDrawable drawable = isTick ? tickToCross : crossToTick;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    drawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
                        @Override
                        public void onAnimationStart(Drawable drawable) {
                            super.onAnimationStart(drawable);
                        }

                        @Override
                        public void onAnimationEnd(Drawable drawable) {
                            super.onAnimationEnd(drawable);
                        }
                    });
                }
                FloatingActionButton fab = ((FloatingActionButton) view);
                fab.setImageDrawable(drawable);
                drawable.start();
                isTick = !isTick;
                break;

        }
    }
}

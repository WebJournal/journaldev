package com.journaldev.androidconstraintcircles;

import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ImageView imgPointer, imgClock;
    ValueAnimator clockAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPointer = findViewById(R.id.imgPointer);
        imgClock = findViewById(R.id.imgClock);

        clockAnimator = animatePointer(TimeUnit.SECONDS.toMillis(60));


        imgClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (clockAnimator.isPaused()) {
                    clockAnimator.resume();
                    Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
                } else if (clockAnimator.isRunning()) {
                    Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
                    clockAnimator.pause();
                } else
                    clockAnimator.start();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (clockAnimator != null) {
            if (clockAnimator.isPaused()) {
                clockAnimator.resume();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (clockAnimator.isRunning()) {
            clockAnimator.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (clockAnimator.isRunning()) {
            clockAnimator.cancel();
        }
    }

    private ValueAnimator animatePointer(long orbitDuration) {
        ValueAnimator anim = ValueAnimator.ofInt(0, 359);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imgPointer.getLayoutParams();
                layoutParams.circleAngle = val;
                imgPointer.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(orbitDuration);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);

        return anim;
    }
}

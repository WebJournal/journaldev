package com.journaldev.viewflipper;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


    private ViewFlipper mViewFlipper;
    private Context mContext;
    private float initialX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;
        mViewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewFlipper.setAutoStart(true);
                mViewFlipper.setFlipInterval(1000);
                mViewFlipper.startFlipping();
                Snackbar.make(view, "Automatic view flipping has started", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewFlipper.stopFlipping();

                Snackbar.make(view, "Automatic view flipping has stopped", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = touchevent.getX();
                if (initialX < finalX) {
                    if (mViewFlipper.getDisplayedChild() == 1)
                        break;

                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.in_from_left));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.out_from_left));

                    mViewFlipper.showNext();
                } else {
                    if (mViewFlipper.getDisplayedChild() == 0)
                        break;

                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.in_from_right));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.out_from_right));

                    mViewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }
}

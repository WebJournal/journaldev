package com.journaldev.androidspringanimations;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SpringAnimation xAnimation;
    private SpringAnimation yAnimation;
    ImageView imageView;

    private float dX;
    private float dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageViewDragSpringAnimation();
        chainedSpringAnimation();

        final FloatingActionButton fab = findViewById(R.id.fab);
        final FloatingActionButton fab2 = findViewById(R.id.fab2);
        final FloatingActionButton fab3 = findViewById(R.id.fab3);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpringAnimation springAnim = new SpringAnimation(fab, SpringAnimation.TRANSLATION_Y);
                SpringForce springForce = new SpringForce();
                springForce.setFinalPosition(-200f);
                springForce.setStiffness(SpringForce.STIFFNESS_LOW);
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                springAnim.setSpring(springForce);
                springAnim.start();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SpringAnimation springAnim = new SpringAnimation(fab2, SpringAnimation.TRANSLATION_Y);
                SpringForce springForce = new SpringForce();
                springForce.setFinalPosition(-200f);
                springForce.setStiffness(SpringForce.STIFFNESS_HIGH);
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
                springAnim.setSpring(springForce);
                springAnim.start();
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SpringAnimation springAnim = new SpringAnimation(fab3, SpringAnimation.TRANSLATION_X);
                SpringForce springForce = new SpringForce();
                springForce.setFinalPosition(-200f);
                springForce.setStiffness(SpringForce.STIFFNESS_MEDIUM);
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY);
                springAnim.setSpring(springForce);
                springAnim.start();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void imageViewDragSpringAnimation() {

        imageView = findViewById(R.id.imageView);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
        imageView.setOnTouchListener(touchListener);
    }

    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            xAnimation = createSpringAnimation(imageView, SpringAnimation.X, imageView.getX(),
                    SpringForce.STIFFNESS_MEDIUM, SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
            yAnimation = createSpringAnimation(imageView, SpringAnimation.Y, imageView.getY(),
                    SpringForce.STIFFNESS_MEDIUM, SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        }
    };

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    // capture the difference between view's top left corner and touch point
                    dX = v.getX() - event.getRawX();
                    dY = v.getY() - event.getRawY();
                    // cancel animations
                    xAnimation.cancel();
                    yAnimation.cancel();
                    break;
                case MotionEvent.ACTION_MOVE:
                    //  a different approach would be to change the view's LayoutParams.
                    imageView.animate()
                            .x(event.getRawX() + dX)
                            .y(event.getRawY() + dY)
                            .setDuration(0)
                            .start();
                    break;
                case MotionEvent.ACTION_UP:
                    xAnimation.start();
                    yAnimation.start();
                    break;
            }
            return true;
        }
    };

    public SpringAnimation createSpringAnimation(View view,
                                                 DynamicAnimation.ViewProperty property,
                                                 float finalPosition,
                                                 float stiffness,
                                                 float dampingRatio) {
        SpringAnimation animation = new SpringAnimation(view, property);
        SpringForce springForce = new SpringForce(finalPosition);
        springForce.setStiffness(stiffness);
        springForce.setDampingRatio(dampingRatio);
        animation.setSpring(springForce);
        return animation;
    }


    public SpringAnimation createSpringAnimation(View view,
                                                 DynamicAnimation.ViewProperty property,
                                                 float stiffness,
                                                 float dampingRatio) {
        SpringAnimation animation = new SpringAnimation(view, property);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(stiffness);
        springForce.setDampingRatio(dampingRatio);
        animation.setSpring(springForce);
        return animation;
    }


    private void chainedSpringAnimation() {

        final FloatingActionButton fab4 = findViewById(R.id.fab4);
        final FloatingActionButton fab5 = findViewById(R.id.fab5);
        final FloatingActionButton fab6 = findViewById(R.id.fab6);

        final SpringAnimation firstXAnim = createSpringAnimation(fab5, DynamicAnimation.X, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        final SpringAnimation firstYAnim = createSpringAnimation(fab5, DynamicAnimation.Y, SpringForce.STIFFNESS_MEDIUM, SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        final SpringAnimation secondXAnim = createSpringAnimation(fab6, DynamicAnimation.X, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        final SpringAnimation secondYAnim = createSpringAnimation(fab6, DynamicAnimation.Y, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_HIGH_BOUNCY);


        final ViewGroup.MarginLayoutParams fab5Params = (ViewGroup.MarginLayoutParams) fab5.getLayoutParams();
        final ViewGroup.MarginLayoutParams fab6Params = (ViewGroup.MarginLayoutParams) fab6.getLayoutParams();


        firstXAnim.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float v, float v1) {

                secondXAnim.animateToFinalPosition(v + ((fab5.getWidth() -
                        fab6.getWidth()) / 2));

            }
        });

        firstYAnim.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float v, float v1) {
                secondYAnim.animateToFinalPosition(v + fab5.getHeight() +
                        fab6Params.topMargin);
            }
        });


        fab4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - motionEvent.getRawX();
                        dY = view.getY() - motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:

                        float newX = motionEvent.getRawX() + dX;
                        float newY = motionEvent.getRawY() + dY;

                        view.animate().x(newX).y(newY).setDuration(0).start();
                        firstXAnim.animateToFinalPosition(newX + ((fab4.getWidth() -
                                fab5.getWidth()) / 2));
                        firstYAnim.animateToFinalPosition(newY + fab4.getHeight() +
                                fab5Params.topMargin);

                        break;
                }
                return true;
            }
        });

    }
}

package com.journaldev.androidconstraintanimation;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    boolean show = false;
    ConstraintLayout cc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cc1 = findViewById(R.id.cc1);

        imageView = findViewById(R.id.backgroundImage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show)
                    revertAnimation();
                else
                    showAnimation();
            }
        });

    }

    private void showAnimation() {
        show = true;

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_main_animation);

        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateInterpolator(1.0f));
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(cc1, transition);
        constraintSet.applyTo(cc1);
    }

    private void revertAnimation() {
        show = false;

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_main);

        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateInterpolator(1.0f));
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(cc1, transition);
        constraintSet.applyTo(cc1);

    }

}

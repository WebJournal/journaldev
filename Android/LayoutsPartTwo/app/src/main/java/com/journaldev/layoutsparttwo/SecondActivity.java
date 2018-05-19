package com.journaldev.layoutsparttwo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by anupamchugh on 23/10/15.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
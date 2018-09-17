package com.journaldev.androidadapterviewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    AdapterViewFlipper adapterViewFlipper;
    ArrayList<AndroidVersion> androidVersions = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        populateData();

        adapterViewFlipper = findViewById(R.id.adapterViewFlipper);
        button = findViewById(R.id.button);

        adapterViewFlipper.setAdapter(new AdapterViewFlipperAdapter(this, androidVersions));
        adapterViewFlipper.setFlipInterval(500);
        adapterViewFlipper.startFlipping();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapterViewFlipper.isFlipping())
                    adapterViewFlipper.stopFlipping();
                else
                    adapterViewFlipper.startFlipping();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapterViewFlipper != null && !adapterViewFlipper.isFlipping())
            adapterViewFlipper.startFlipping();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adapterViewFlipper != null && adapterViewFlipper.isFlipping())
            adapterViewFlipper.stopFlipping();
    }

    private void populateData() {
        androidVersions.add(new AndroidVersion(R.drawable.android_e, "Android Eclair"));
        androidVersions.add(new AndroidVersion(R.drawable.android_g, "Android Gingerbread"));
        androidVersions.add(new AndroidVersion(R.drawable.android_j, "Android Jellybean"));
        androidVersions.add(new AndroidVersion(R.drawable.android_k, "Android Kitkat"));
        androidVersions.add(new AndroidVersion(R.drawable.android_l, "Android Lollipop"));
        androidVersions.add(new AndroidVersion(R.drawable.android_m, "Android Marshmallow"));
        androidVersions.add(new AndroidVersion(R.drawable.android_n, "Android Nougat"));
        androidVersions.add(new AndroidVersion(R.drawable.android_o, "Android Oreo"));
    }
}


class AndroidVersion {

    int drawableInt;
    String versionName;


    AndroidVersion(int d, String v) {
        drawableInt = d;
        versionName = v;
    }
}

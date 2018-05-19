package com.journaldev.imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting image resource from drawable
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.balloon);

        imageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Clicked Second Image",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked Image Button",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.balloon);
// Resize the bitmap to 150x100 (width x height)
        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 350, 300, true);
// Loads the resized Bitmap into an ImageView
        ImageView image = (ImageView) findViewById(R.id.imageView5);
        image.setImageBitmap(bMapScaled);

    }
}
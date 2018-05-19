package com.journaldev.picassotutorial;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    int i = 0;
    Button btnDrawableImage, btnUrlImage, btnErrorImage, btnPlaceholderImage, btnCallback, btnResizeImage, btnRotateImage, btnScaleImage, btnTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        imageView = (ImageView) findViewById(R.id.imageView);
        btnDrawableImage = (Button) findViewById(R.id.btnDrawable);
        btnUrlImage = (Button) findViewById(R.id.btnUrl);
        btnPlaceholderImage = (Button) findViewById(R.id.btnPlaceholder);
        btnErrorImage = (Button) findViewById(R.id.btnError);
        btnCallback = (Button) findViewById(R.id.btnCallBack);
        btnResizeImage = (Button) findViewById(R.id.btnResize);
        btnRotateImage = (Button) findViewById(R.id.btnRotate);
        btnScaleImage = (Button) findViewById(R.id.btnScale);
        btnTarget = (Button) findViewById(R.id.btnTarget);

        btnDrawableImage.setOnClickListener(this);
        btnPlaceholderImage.setOnClickListener(this);
        btnUrlImage.setOnClickListener(this);
        btnCallback.setOnClickListener(this);
        btnResizeImage.setOnClickListener(this);
        btnErrorImage.setOnClickListener(this);
        btnRotateImage.setOnClickListener(this);
        btnScaleImage.setOnClickListener(this);
        btnTarget.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDrawable:
                Picasso.with(this).load(R.drawable.image).into(imageView);
                break;
            case R.id.btnPlaceholder:
                Picasso.with(this).load("www.journaldev.com").placeholder(R.drawable.placeholder).into(imageView);
                break;
            case R.id.btnUrl:
                Picasso.with(this).load("http://cdn.journaldev.com/wp-content/uploads/2017/01/android-constraint-layout-sdk-tool-install.png").placeholder(R.drawable.placeholder).into(imageView);
                break;
            case R.id.btnError:
                Picasso.with(this).load("www.journaldev.com").placeholder(R.drawable.placeholder).error(R.drawable.error).into(imageView);
                break;
            case R.id.btnCallBack:
                Picasso.with(this).load("www.journaldev.com").error(R.mipmap.ic_launcher).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btnResize:
                Picasso.with(this).load(R.drawable.image).resize(200, 200).into(imageView);
                break;
            case R.id.btnRotate:
                Picasso.with(this).load(R.drawable.image).rotate(90f).into(imageView);
                break;
            case R.id.btnScale:

                if (i == 3)
                    i = 0;

                else {
                    if (i == 0) {
                        Picasso.with(this).load(R.drawable.image).fit().into(imageView);
                        Toast.makeText(getApplicationContext(), "Fit", Toast.LENGTH_SHORT).show();
                    } else if (i == 1) {
                        Picasso.with(this).load(R.drawable.image).resize(200, 200).centerCrop().into(imageView);
                        Toast.makeText(getApplicationContext(), "Center Crop", Toast.LENGTH_SHORT).show();
                    } else if (i == 2) {
                        Picasso.with(this).load(R.drawable.image).resize(200, 200).centerInside().into(imageView);
                        Toast.makeText(getApplicationContext(), "Center Inside", Toast.LENGTH_SHORT).show();
                    }
                    i++;
                }
                break;

            case R.id.btnTarget:
                Picasso.with(this).load("http://cdn.journaldev.com/wp-content/uploads/2017/01/android-constraint-layout-sdk-tool-install.png").placeholder(R.drawable.placeholder).error(R.drawable.error).into(target);
                break;
        }
    }

    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

            imageView.setImageBitmap(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            imageView.setImageDrawable(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            imageView.setImageDrawable(placeHolderDrawable);
        }
    };
}

package com.journaldev.androidpictureinpicture;

import android.app.PictureInPictureParams;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Rational;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PiPActivity extends AppCompatActivity {


    VideoView videoView;
    FloatingActionButton fab;
    PictureInPictureParams.Builder pictureInPictureParamsBuilder = new PictureInPictureParams.Builder();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pip);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        videoView = findViewById(R.id.videoView);
        fab = findViewById(R.id.fab);

        final MediaController mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);

        String videoUrl = getIntent().getStringExtra("videoUrl");

        videoView.setMediaController(mediacontroller);
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.requestFocus();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPictureInPictureFeature();
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        videoView.setMediaController(mediacontroller);
                        mediacontroller.setAnchorView(videoView);

                    }
                });
            }
        });
    }

    private void startPictureInPictureFeature() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Rational aspectRatio = new Rational(videoView.getWidth(), videoView.getHeight());
            pictureInPictureParamsBuilder.setAspectRatio(aspectRatio).build();
            enterPictureInPictureMode(pictureInPictureParamsBuilder.build());
        }
    }

    @Override
    public void onUserLeaveHint() {
        if (!isInPictureInPictureMode()) {
            Rational aspectRatio = new Rational(videoView.getWidth(), videoView.getHeight());
            pictureInPictureParamsBuilder.setAspectRatio(aspectRatio).build();
            enterPictureInPictureMode(pictureInPictureParamsBuilder.build());
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode,
                                              Configuration newConfig) {
        if (isInPictureInPictureMode) {
            fab.setVisibility(View.GONE);
            toolbar.setVisibility(View.GONE);
        } else {
            fab.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNewIntent(Intent i) {
        updateVideoView(i);
    }

    private void updateVideoView(Intent i) {
        String videoUrl = i.getStringExtra("videoUrl");

        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.requestFocus();
    }

}

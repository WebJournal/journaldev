package com.journaldev.androidgooglemapstreetview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

public class MainActivity extends AppCompatActivity
        implements OnStreetViewPanoramaReadyCallback {

    private StreetViewPanorama mStreetViewPanorama;
    private boolean secondLocation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportStreetViewPanoramaFragment streetViewFragment =
                (SupportStreetViewPanoramaFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.googleMapStreetView);
        streetViewFragment.getStreetViewPanoramaAsync(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondLocation = !secondLocation;
                onStreetViewPanoramaReady(mStreetViewPanorama);
            }
        });

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        mStreetViewPanorama = streetViewPanorama;

        if (secondLocation) {
            streetViewPanorama.setPosition(new LatLng(51.52887, -0.1726073), StreetViewSource.OUTDOOR);
        } else {
            streetViewPanorama.setPosition(new LatLng(51.52887, -0.1726073));
        }
        streetViewPanorama.setStreetNamesEnabled(true);
        streetViewPanorama.setPanningGesturesEnabled(true);
        streetViewPanorama.setZoomGesturesEnabled(true);
        streetViewPanorama.setUserNavigationEnabled(true);
        streetViewPanorama.animateTo(
                new StreetViewPanoramaCamera.Builder().
                        orientation(new StreetViewPanoramaOrientation(20, 20))
                        .zoom(streetViewPanorama.getPanoramaCamera().zoom)
                        .build(), 2000);

        streetViewPanorama.setOnStreetViewPanoramaChangeListener(panoramaChangeListener);


    }

    private StreetViewPanorama.OnStreetViewPanoramaChangeListener panoramaChangeListener =
            new StreetViewPanorama.OnStreetViewPanoramaChangeListener() {
                @Override
                public void onStreetViewPanoramaChange(
                        StreetViewPanoramaLocation streetViewPanoramaLocation) {


                    Toast.makeText(getApplicationContext(), "Lat: " + streetViewPanoramaLocation.position.latitude + " Lng: " + streetViewPanoramaLocation.position.longitude, Toast.LENGTH_SHORT).show();

                }
            };
}
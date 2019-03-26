package com.journaldev.androidqsettingspanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInternet, btnVolume, btnNFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInternet = findViewById(R.id.btnInternet);
        btnVolume = findViewById(R.id.btnVolume);
        btnNFC = findViewById(R.id.btnNFC);

        btnInternet.setOnClickListener(this);
        btnVolume.setOnClickListener(this);
        btnNFC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnInternet:
                showInternetSettings();
                break;
            case R.id.btnVolume:
                showVolumeSettings();
                break;
            case R.id.btnNFC:
                showNFCSettings();
                break;
        }
    }

    private void showInternetSettings() {
        startActivity(new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY));
    }

    private void showVolumeSettings() {
        startActivity(new Intent(Settings.Panel.ACTION_VOLUME));
    }

    private void showNFCSettings() {
        startActivity(new Intent(Settings.Panel.ACTION_NFC));
    }
}

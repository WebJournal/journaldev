package com.journaldev.androidquicksettingstitle;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Icon;
import android.preference.PreferenceManager;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;
import android.widget.Toast;

public class MyTileService extends TileService {


    SharedPreferences mSharedPreferences;

    @Override
    public void onClick() {
        super.onClick();

        Tile tile = getQsTile();

        boolean isActive = (tile.getState() == Tile.STATE_ACTIVE);
        if (isActive) {
            tile.setState(Tile.STATE_INACTIVE);
            startActivityAndCollapse(new Intent(this, MainActivity.class));
            tile.setLabel("Disabled");
            tile.setContentDescription("Test App");
            tile.setIcon(Icon.createWithResource(this, android.R.drawable.ic_media_play));
        } else {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            int counter = mSharedPreferences.getInt("counter", 0);
            tile.setState(Tile.STATE_ACTIVE);
            tile.setIcon(Icon.createWithResource(this, android.R.drawable.ic_media_pause));
            tile.setLabel("Count " + counter);
        }
        tile.updateTile();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();


        Tile tile = getQsTile();
        tile.setState(Tile.STATE_ACTIVE);


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int counter = mSharedPreferences.getInt("counter", 0);

        tile.setLabel("Count " + counter);

        tile.setIcon(Icon.createWithResource(this, android.R.drawable.ic_media_pause));
        tile.updateTile();

        Toast.makeText(getApplicationContext(), "tile added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();

        Tile tile = getQsTile();

        if (tile.getState() == Tile.STATE_ACTIVE) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            int counter = mSharedPreferences.getInt("counter", 0);

            mSharedPreferences.edit().putInt("counter", ++counter).apply();
            tile.setLabel("Count " + counter);
        }

        tile.updateTile();

    }


    @Override
    public void onStopListening() {
        super.onStopListening();
    }


}

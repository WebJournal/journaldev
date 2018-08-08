package com.journaldev.androidquicksettingstitle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        int counter = sharedPreferences.getInt("counter", 0);
        textView.setText("You have opened the quick settings " + counter + " times.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        int counter = sharedPreferences.getInt("counter", 0);
        textView.setText("You have opened the quick settings " + counter + " times.");
    }


}

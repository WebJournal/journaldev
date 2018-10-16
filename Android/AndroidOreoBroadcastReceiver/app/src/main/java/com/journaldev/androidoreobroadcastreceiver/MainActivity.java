package com.journaldev.androidoreobroadcastreceiver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnExplicitBroadcast;

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExplicitBroadcast = findViewById(R.id.btnExplicitBroadcast);
        btnExplicitBroadcast.setOnClickListener(this);
        myReceiver= new MyReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");


        registerReceiver(myReceiver, filter);
    }

    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.setAction("com.journaldev.AN_INTENT");
        intent.setComponent(new ComponentName(getPackageName(),"com.journaldev.androidoreobroadcastreceiver.MyReceiver"));
        getApplicationContext().sendBroadcast(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnExplicitBroadcast:
                broadcastIntent();
                break;
        }
    }
}

package com.journaldev.androidcustomchrometabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://www.journaldev.com";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                builder.addDefaultShareMenuItem();

                CustomTabsIntent anotherCustomTab = new CustomTabsIntent.Builder().build();


                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_android);
                int requestCode = 100;
                Intent intent = anotherCustomTab.intent;
                intent.setData(Uri.parse("http://www.journaldev.com/author/anupam"));

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                        requestCode,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setActionButton(bitmap, "Android", pendingIntent, true);
                builder.setShowTitle(true);


                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
            }
        });
    }
}

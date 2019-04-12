package com.journaldev.androidqbubbles;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBubble, btnBubble2;

    NotificationManager notificationManager;
    Notification.Builder builder;
    NotificationChannel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBubble = findViewById(R.id.btnBubble);
        btnBubble2 = findViewById(R.id.btnBubble2);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        CharSequence name = "My Channel";
        String description = "xyz";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);
        channel.setAllowBubbles(true);


        btnBubble.setOnClickListener(this);
        btnBubble2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnBubble:
                Intent target = new Intent(MainActivity.this, BubbleActivity.class);
                PendingIntent bubbleIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, target, PendingIntent.FLAG_UPDATE_CURRENT /* flags */);

                // Create bubble metadata
                Notification.BubbleMetadata bubbleData =
                        new Notification.BubbleMetadata.Builder()
                                .setDesiredHeight(600)
                                .setIcon(Icon.createWithResource(MainActivity.this, R.mipmap.ic_launcher))
                                .setIntent(bubbleIntent)
                                .build();


                builder = new Notification.Builder(MainActivity.this, channel.getId())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setBubbleMetadata(bubbleData);


                notificationManager.createNotificationChannel(channel);
                notificationManager.notify(1, builder.build());
                break;
            case R.id.btnBubble2:
                target = new Intent(MainActivity.this, BubbleActivity.class);
                target.putExtra("key","This is the second bubble");
                bubbleIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, target, PendingIntent.FLAG_UPDATE_CURRENT);

                // Create bubble metadata
                bubbleData = new Notification.BubbleMetadata.Builder()
                                .setDesiredHeight(600)
                                .setIcon(Icon.createWithResource(MainActivity.this, R.mipmap.ic_launcher))
                                .setIntent(bubbleIntent)
                                .build();


                builder = new Notification.Builder(MainActivity.this, channel.getId())
                        .setContentTitle("Second Bubble")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setBubbleMetadata(bubbleData);


                notificationManager.createNotificationChannel(channel);
                notificationManager.notify(2, builder.build());

                break;
        }

    }
}

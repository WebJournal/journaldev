package com.journaldev.androidpnotifications;

import android.app.Notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    NotificationManager notificationManager;
    Notification.Builder builder;
    NotificationChannel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSimpleNotification = findViewById(R.id.btnSimpleNotification);
        Button btnNotificationIcon = findViewById(R.id.btnNotificationIcon);
        Button btnNotificationImage = findViewById(R.id.btnNotificationImage);
        Button btnNotificationWithGroupConvo = findViewById(R.id.btnNotificationWithGroupConvo);

        btnSimpleNotification.setOnClickListener(this);
        btnNotificationIcon.setOnClickListener(this);
        btnNotificationImage.setOnClickListener(this);
        btnNotificationWithGroupConvo.setOnClickListener(this);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence name = "My Notification";
        String description = "yadda yadda";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);

        builder =
                new Notification.Builder(MainActivity.this, channel.getId())
                        .setSmallIcon(R.mipmap.ic_launcher);


        notificationManager.createNotificationChannel(channel);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSimpleNotification:
                simpleNotification();
                break;
            case R.id.btnNotificationIcon:
                notificationWithIcon();
                break;
            case R.id.btnNotificationImage:
                notificationWithImage();
                break;

            case R.id.btnNotificationWithGroupConvo:
                notificationWithGroupConvo();
                break;

        }
    }

    private void simpleNotification() {
        Person jd = new Person.Builder()
                .setName("JournalDev")
                .setImportant(true)
                .build();

        new Notification.MessagingStyle(jd)
                .addMessage("Check me out", new Date().getTime(), jd)
                .setBuilder(builder);


        notificationManager.notify(1, builder.build());
    }

    private void notificationWithIcon() {
        Person anupam = new Person.Builder()
                .setName("Anupam")
                .setIcon(Icon.createWithResource(this, R.drawable.sample_photo))
                .setImportant(true)
                .build();

        new Notification.MessagingStyle(anupam)
                .addMessage("Check out my latest article!", new Date().getTime(), anupam)
                .setBuilder(builder);


        notificationManager.notify(2, builder.build());
    }

    private void notificationWithImage() {
        Person bot = new Person.Builder()
                .setName("Bot")
                .setImportant(true)
                .setBot(true)
                .build();


        Uri uri = Uri.parse("android.resource://com.journaldev.androidpnotifications/drawable/"+R.drawable.sample_bg);

        Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message("Check out my latest article!", new Date().getTime(), bot);
        message.setData("image/*",uri);


        new Notification.MessagingStyle(bot)
                .addMessage(message)
                .setGroupConversation(true)
                .setBuilder(builder);


        notificationManager.notify(3, builder.build());
    }

    private void notificationWithGroupConvo()
    {

        Person jd = new Person.Builder()
                .setName("JournalDev")
                .build();

        Person anupam = new Person.Builder()
                .setName("Anupam")
                .setIcon(Icon.createWithResource(this, R.drawable.sample_photo))
                .setImportant(true)
                .build();


        Person bot = new Person.Builder()
                .setName("Bot")
                .setBot(true)
                .build();


        Uri uri = Uri.parse("android.resource://com.journaldev.androidpnotifications/drawable/"+R.drawable.sample_bg);

        Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message("", new Date().getTime(), bot);
        message.setData("image/*",uri);


        new Notification.MessagingStyle(bot)
                .addMessage("Hi. How are you?", new Date().getTime(), anupam)
                .addMessage(message)
                .addMessage("Does this image look good?", new Date().getTime(), bot)
                .addMessage("Looks good!", new Date().getTime(), jd)
                .setGroupConversation(true)
                .setConversationTitle("Sample Conversation")
                .setBuilder(builder);


        notificationManager.notify(4, builder.build());

    }

}

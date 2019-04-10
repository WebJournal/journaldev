package com.journaldev.androidpnotifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    NotificationChannel channel;

    CharSequence charSequence = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSimpleNotification = findViewById(R.id.btnSimpleNotification);
        Button btnNotificationIcon = findViewById(R.id.btnNotificationIcon);
        Button btnNotificationImage = findViewById(R.id.btnNotificationImage);
        Button btnNotificationWithGroupConvo = findViewById(R.id.btnNotificationWithGroupConvo);
        Button btnNotificationSemantic = findViewById(R.id.btnNotificationSemantic);

        charSequence = btnNotificationIcon.getText();


        btnSimpleNotification.setOnClickListener(this);
        btnNotificationIcon.setOnClickListener(this);
        btnNotificationImage.setOnClickListener(this);
        btnNotificationWithGroupConvo.setOnClickListener(this);
        btnNotificationSemantic.setOnClickListener(this);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence name = "My Notification";
        String description = "yadda yadda";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);

        builder = new NotificationCompat.Builder(MainActivity.this, channel.getId())
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

            case R.id.btnNotificationSemantic:
                notificationSemantic();
                break;

        }
    }

    private void simpleNotification() {
        Person jd = new Person.Builder()
                .setName("JournalDev")
                .setImportant(true)
                .build();

        new NotificationCompat.MessagingStyle(jd)
                .addMessage("Check me out", new Date().getTime(), jd)
                .setBuilder(builder);


        notificationManager.notify(1, builder.build());
    }

    private void notificationWithIcon() {
        Person anupam = new Person.Builder()
                .setName("Anupam")
                .setIcon(IconCompat.createWithResource(this, R.drawable.sample_photo))
                .setImportant(true)
                .build();

        new NotificationCompat.MessagingStyle(anupam)
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

        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message("Check out my latest article!", new Date().getTime(), bot);
        message.setData("image/*",uri);


        new NotificationCompat.MessagingStyle(bot)
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
                .setIcon(IconCompat.createWithResource(this, R.drawable.sample_photo))
                .setImportant(true)
                .build();


        Person bot = new Person.Builder()
                .setName("Bot")
                .setBot(true)
                .build();


        Uri uri = Uri.parse("android.resource://com.journaldev.androidpnotifications/drawable/"+R.drawable.sample_bg);

        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message("", new Date().getTime(), bot);
        message.setData("image/*",uri);





        new NotificationCompat.MessagingStyle(bot)
                .addMessage("Hi. How are you?", new Date().getTime(), anupam)
                .addMessage(message)
                .addMessage("Does this image look good?", new Date().getTime(), bot)
                .addMessage("Looks good!", new Date().getTime(), jd)
                .setGroupConversation(true)
                .setConversationTitle("Sample Conversation")
                .setBuilder(builder);


        notificationManager.notify(4, builder.build());

    }

    private void notificationSemantic()
    {

        Person jd = new Person.Builder()
                .setName("JournalDev")
                .build();

        Person anupam = new Person.Builder()
                .setName("Anupam")
                .setIcon(IconCompat.createWithResource(this, R.drawable.sample_photo))
                .setImportant(true)
                .build();


        Person bot = new Person.Builder()
                .setName("Bot")
                .setBot(true)
                .build();


        Uri uri = Uri.parse("android.resource://com.journaldev.androidpnotifications/drawable/"+R.drawable.sample_bg);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("hi","Notifications were read");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);



        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message("", new Date().getTime(), bot);
        message.setData("image/*",uri);

        NotificationCompat.Action replyAction =
                new NotificationCompat.Action.Builder(
                        R.drawable.sample_bg,
                        "MARK READ",
                        pendingIntent)
                        .setSemanticAction(NotificationCompat.Action.SEMANTIC_ACTION_MARK_AS_READ)
                        .build();




        NotificationCompat.Builder separateBuilder = builder;
        separateBuilder.addAction(replyAction);

        new NotificationCompat.MessagingStyle(bot)
                .addMessage("Hi. How are you?", new Date().getTime(), anupam)
                .addMessage(message)
                .addMessage("Does this image look good?", new Date().getTime(), bot)
                .addMessage("Looks good!", new Date().getTime(), jd)
                .setGroupConversation(true)
                .setConversationTitle("Sample Conversation")
                .setBuilder(separateBuilder);


        notificationManager.notify(5, separateBuilder.build());

    }




    @Override
    protected void onResume() {
        super.onResume();

        if(getIntent()!=null && getIntent().getExtras()!=null)
        {
            String value = getIntent().getStringExtra("hi");
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
        }
    }
}

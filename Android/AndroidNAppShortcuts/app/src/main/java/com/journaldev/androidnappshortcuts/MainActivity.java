package com.journaldev.androidnappshortcuts;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDynamicShortcut, btnRemoveShortcut, btnNext;

    String ACTION_KEY = "anything.any";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDynamicShortcut = findViewById(R.id.btnDynamicShortcut);
        btnRemoveShortcut = findViewById(R.id.btnRemoveShortcut);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(this);
        btnDynamicShortcut.setOnClickListener(this);
        btnRemoveShortcut.setOnClickListener(this);

        if (ACTION_KEY.equals(getIntent().getAction())){
            Toast.makeText(getApplicationContext(),"First Dynamic Shortcut clicked",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnNext:
                startActivity(new Intent(MainActivity.this, StaticShortcutActivity.class));
                break;
            case R.id.btnDynamicShortcut:
                createSimpleDynamicShortcut();
                break;
            case R.id.btnRemoveShortcut:
                removeShortcuts();
                break;
        }
    }

    private void createSimpleDynamicShortcut() {



        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        intent1.setAction(ACTION_KEY);

        ShortcutInfo shortcut1 = new ShortcutInfo.Builder(this, "dShortcut1")
                .setIntent(intent1)
                .setRank(1)
                .setLongLabel("Dynamic Shortcut 1")
                .setShortLabel("This is the shortcut 1")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_home_black_24dp))
                .build();


        ShortcutInfo shortcut2 = new ShortcutInfo.Builder(this, "web_link")
                .setRank(0)
                .setShortLabel("Journaldev.com")
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.journaldev.com")))
                .build();


        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut1, shortcut2));

        //shortcutManager.disableShortcuts(Arrays.asList(shortcut1.getId()));

    }

    private void removeShortcuts() {
        ShortcutManager manager = getSystemService(ShortcutManager.class);
        manager.removeAllDynamicShortcuts();

    }
}

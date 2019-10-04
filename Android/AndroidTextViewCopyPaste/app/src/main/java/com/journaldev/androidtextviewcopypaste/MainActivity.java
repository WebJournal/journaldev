package com.journaldev.androidtextviewcopypaste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView tvCopy, tvPaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCopy = findViewById(R.id.tvCopy);
        tvPaste = findViewById(R.id.tvPaste);

        registerForContextMenu(tvCopy);
        registerForContextMenu(tvPaste);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Options");
        switch (v.getId()) {
            case R.id.tvCopy:
                menu.add(0, v.getId(), 0, "Copy");
                TextView textView = (TextView) v;
                ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", textView.getText());
                if (manager != null) {
                    manager.setPrimaryClip(clipData);
                }

                break;
            case R.id.tvPaste:
                menu.add(0, v.getId(), 0, "Paste");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.tvCopy:
                Toast.makeText(getApplicationContext(), "Copy Clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.tvPaste:
                ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                if (manager != null && manager.getPrimaryClip() != null && manager.getPrimaryClip().getItemCount() > 0) {
                    tvPaste.setText(manager.getPrimaryClip().getItemAt(0).getText().toString());
                }

                break;
        }


        return super.onContextItemSelected(item);


    }
}

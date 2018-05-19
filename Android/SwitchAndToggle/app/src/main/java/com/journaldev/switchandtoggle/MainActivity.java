package com.journaldev.switchandtoggle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb1, tb2;
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder result = new StringBuilder();
                result.append("ToggleButton1 : ").append(tb1.getText());
                result.append("\nToggleButton2 : ").append(tb2.getText());

               Snackbar snackbar= Snackbar.make(view, result.toString(), Snackbar.LENGTH_LONG)
                        .setAction("SWITCH ENABLE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                switchCompat.setChecked(true);
                            }
                        });

                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
            }
        });

        tb1= (ToggleButton)findViewById(R.id.tb1);
        tb2=(ToggleButton)findViewById(R.id.tb2);
        switchCompat=(SwitchCompat)findViewById(R.id.switchButton);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Snackbar.make(buttonView, "Switch state checked "+isChecked, Snackbar.LENGTH_LONG)
                        .setAction("ACTION",null).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

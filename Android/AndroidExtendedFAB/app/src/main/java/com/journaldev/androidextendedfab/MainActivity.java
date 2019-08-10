package com.journaldev.androidextendedfab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ExtendedFloatingActionButton extendedFAB;
    ExtendedFloatingActionButton extendedFAB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extendedFAB = findViewById(R.id.extFab);
        extendedFAB2 = findViewById(R.id.extFab2);

        extendedFAB2.setOnClickListener(this);
        extendedFAB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.extFab:
                if(extendedFAB.isExtended())
                {
                    extendedFAB.shrink(true);
                }
                else{
                    extendedFAB.extend(true);
                }
                break;
            case R.id.extFab2:
                if(extendedFAB.isShown())
                extendedFAB.hide(true);
                else {
                    extendedFAB.show(true);
                }
                break;
        }

    }
}

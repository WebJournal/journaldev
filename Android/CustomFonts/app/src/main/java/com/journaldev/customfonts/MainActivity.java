package com.journaldev.customfonts;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //TextView ambleBold, ambleLight, ambleRegular, openSansItalic, openSansRegular;

    Button btn;

    /*private String A_BOLD= "Amble-Bold.ttf";
    private String A_LIGHT="Amble-Light.ttf";
    private String A_REGULAR= "Amble-Regular.ttf";
    private String O_ITALIC= "OpenSans-Italic.ttf";
    private String O_REGULAR="OpenSans-Regular.ttf";*/
    private String P_REGULAR="Pacifico.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fonts);

        /*ambleBold=(TextView)findViewById(R.id.ambleBold);
        ambleLight=(TextView)findViewById(R.id.ambleLight);
        ambleRegular=(TextView)findViewById(R.id.ambleRegular);
        openSansRegular=(TextView)findViewById(R.id.opRegular);
        openSansItalic=(TextView)findViewById(R.id.opItalic);*/
        btn=(Button)findViewById(R.id.pacifico);

        /*ambleBold.setTypeface(Typeface.createFromAsset(getAssets(), A_BOLD));
        ambleLight.setTypeface(Typeface.createFromAsset(getAssets(), A_LIGHT));
        ambleRegular.setTypeface(Typeface.createFromAsset(getAssets(), A_REGULAR));
        openSansRegular.setTypeface(Typeface.createFromAsset(getAssets(), O_REGULAR));
        openSansItalic.setTypeface(Typeface.createFromAsset(getAssets(), O_ITALIC));*/
        btn.setTypeface(Typeface.createFromAsset(getAssets(), P_REGULAR));


    }
}

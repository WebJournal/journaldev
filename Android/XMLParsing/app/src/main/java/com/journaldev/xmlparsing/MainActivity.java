package com.journaldev.xmlparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView)findViewById(R.id.text);

        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("sample.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            ArrayList<Country> countries=  parseXML(parser);

            String text="";

            for(Country country:countries)
            {

                text+= "id : "+country.getId()+" name : "+country.getName()+" capital : "+country.getCapital()+"\n";
            }

            textView.setText(text);



        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private ArrayList<Country> parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        ArrayList<Country> countries = null;
        int eventType = parser.getEventType();
        Country country = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    countries = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("country")){
                        country = new Country();
                        country.id=parser.getAttributeValue(null,"id");
                    } else if (country != null){
                        if (name.equals("name")){
                            country.name = parser.nextText();
                        } else if (name.equals("capital")){
                            country.capital = parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("country") && country != null){
                        countries.add(country);
                    }
                    }
            eventType = parser.next();
        }

        return countries;

        }
}

package com.journaldev.staticmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.pkmmte.view.CircularImageView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private String STATIC_MAP_API_ENDPOINT = "http://maps.googleapis.com/maps/api/staticmap?size=230x200&path=";
    String path;


    CircularImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iv=(CircularImageView)findViewById(R.id.img_map_route);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        try {

            String marker_me = "color:orange|label:1|Brisbane";
            String marker_dest = "color:orange|label:7|San Francisco,USA";
            marker_me = URLEncoder.encode(marker_me, "UTF-8");

            marker_dest = URLEncoder.encode(marker_dest, "UTF-8");
            path = "weight:3|color:blue|geodesic:true|Brisbane,Australia|Hong Kong|Moscow,Russia|London,UK|Reyjavik,Iceland|New York,USA|San Francisco,USA";
            path = URLEncoder.encode(path, "UTF-8");


            STATIC_MAP_API_ENDPOINT = STATIC_MAP_API_ENDPOINT + path + "&markers=" + marker_me + "&markers=" + marker_dest;

            Log.d("STATICMAPS", STATIC_MAP_API_ENDPOINT);



            AsyncTask<Void, Void, Bitmap> setImageFromUrl = new AsyncTask<Void, Void, Bitmap>(){
                @Override
                protected Bitmap doInBackground(Void... params) {
                    Bitmap bmp = null;
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet request = new HttpGet(STATIC_MAP_API_ENDPOINT);

                    InputStream in = null;
                    try {
                        HttpResponse response = httpclient.execute(request);
                        in = response.getEntity().getContent();
                        bmp = BitmapFactory.decodeStream(in);
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return bmp;
                }
                protected void onPostExecute(Bitmap bmp) {
                    if (bmp!=null) {

                        iv.setImageBitmap(bmp);

                    }

                }
            };

            setImageFromUrl.execute();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
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

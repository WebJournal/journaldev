package com.journaldev.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    String json_string = "{\n" +
            "  \"title\":\"JSONParserTutorial\",\n" +
            "  \"array\":[\n" +
            "    {\n" +
            "    \"company\":\"Google\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"company\":\"Facebook\"\n" +
            "    },\n" +
            "    {\n" +
            "    \"company\":\"LinkedIn\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"company\" : \"Microsoft\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"company\": \"Apple\"\n" +
            "    }\n" +
            "    ],\n" +
            "    \"nested\":{\n" +
            "    \"flag\": true,\n" +
            "    \"random_number\":1\n" +
            "    }\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            ListView listView = (ListView) findViewById(R.id.list_view);
            
            List<String> items = new ArrayList<>();
            JSONObject root = new JSONObject(json_string);

            JSONArray array= root.getJSONArray("array");

            this.setTitle(root.getString("title"));

            for(int i=0;i<array.length();i++)
            {
                JSONObject object= array.getJSONObject(i);
                items.add(object.getString("company"));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
            }

            JSONObject nested= root.getJSONObject("nested");
            Log.d("TAG","flag value "+nested.getBoolean("flag"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

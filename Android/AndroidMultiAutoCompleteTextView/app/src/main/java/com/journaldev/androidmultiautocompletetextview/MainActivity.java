package com.journaldev.androidmultiautocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {


    MultiAutoCompleteTextView multiAutoCompleteTextView, multiAutoCompleteTextViewCustom;

    String[] randomSuggestions = {"a", "aa", "ab", "aab", "abc", "abcd", "abcde", "abcdef"};
    String[] tags = {"Java", "JavaScript", "Spring", "Java EE", "Java 8", "Java 9", "Java 10", "SQL", "SQLite"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextViewCustom = findViewById(R.id.multiAutoCompleteTextViewCustom);

        ArrayAdapter<String> randomArray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, randomSuggestions);
        multiAutoCompleteTextView.setAdapter(randomArray);
        multiAutoCompleteTextView.setThreshold(1);

        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        ArrayAdapter<String> tagArray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tags);
        multiAutoCompleteTextViewCustom.setAdapter(tagArray);
        multiAutoCompleteTextViewCustom.setThreshold(2);

        multiAutoCompleteTextViewCustom.setTokenizer(new SpaceTokenizer());

    }
}

package com.journaldev.androidwebscrapingretrofit;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton fab;
    HashMap<String, Integer> occurrences = new HashMap<>();
    WordsAdapter wordsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.wordList);

        fab = findViewById(R.id.fab);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://www.journaldev.com/")
                .client(okHttpClient).build();


        final ApiService apiService = retrofit.create(ApiService.class);


        Call<String> stringCall = apiService.getStringResponse();
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                    String responseString = response.body();
                    Document doc = Jsoup.parse(responseString);
                    responseString = doc.text();
                    createHashMap(responseString);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                occurrences = sortByValueDesc(occurrences);

                wordsAdapter = new WordsAdapter(MainActivity.this, occurrences);
                recyclerView.setAdapter(wordsAdapter);


            }
        });

    }

    private void createHashMap(String responseString) {


        responseString = responseString.replaceAll("[^a-zA-Z0-9]", " ");

        String[] splitWords = responseString.split(" +");

        for (String word : splitWords) {

            if (StringUtil.isNumeric(word)) {
                continue;
            }

            Integer oldCount = occurrences.get(word);
            if (oldCount == null) {
                oldCount = 0;
            }
            occurrences.put(word, oldCount + 1);
        }

        wordsAdapter = new WordsAdapter(this, occurrences);
        recyclerView.setAdapter(wordsAdapter);
    }

    public static HashMap<String, Integer> sortByValueDesc(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}

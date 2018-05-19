package com.journaldev.dagger2retrofitrecyclerview.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.journaldev.dagger2retrofitrecyclerview.MyApplication;
import com.journaldev.dagger2retrofitrecyclerview.R;
import com.journaldev.dagger2retrofitrecyclerview.di.component.ApplicationComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.component.DaggerDetailActivityComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.component.DetailActivityComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ApplicationContext;
import com.journaldev.dagger2retrofitrecyclerview.pojo.Film;
import com.journaldev.dagger2retrofitrecyclerview.retrofit.APIInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    DetailActivityComponent detailActivityComponent;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.textView);

        String url = getIntent().getStringExtra("url");

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

        detailActivityComponent.inject(this);

        apiInterface.getFilmData(url, "json").enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film films = response.body();
                String text = "Film name:\n" + films.title + "\nDirector:\n" + films.director;
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}

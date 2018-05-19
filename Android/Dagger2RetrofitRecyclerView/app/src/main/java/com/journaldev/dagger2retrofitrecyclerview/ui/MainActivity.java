package com.journaldev.dagger2retrofitrecyclerview.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.journaldev.dagger2retrofitrecyclerview.MyApplication;
import com.journaldev.dagger2retrofitrecyclerview.R;
import com.journaldev.dagger2retrofitrecyclerview.adapter.RecyclerViewAdapter;
import com.journaldev.dagger2retrofitrecyclerview.di.component.ApplicationComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.component.DaggerMainActivityComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.component.MainActivityComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.module.MainActivityContextModule;
import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ActivityContext;
import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ApplicationContext;
import com.journaldev.dagger2retrofitrecyclerview.pojo.StarWars;
import com.journaldev.dagger2retrofitrecyclerview.retrofit.APIInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        apiInterface.getPeople("json").enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                populateRecyclerView(response.body().results);
            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {

            }
        });
    }

    private void populateRecyclerView(List<StarWars.People> response) {
        recyclerViewAdapter.setData(response);
    }


    @Override
    public void launchIntent(String url) {
        Toast.makeText(mContext, "RecyclerView Row selected", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(activityContext, DetailActivity.class).putExtra("url", url));
    }
}

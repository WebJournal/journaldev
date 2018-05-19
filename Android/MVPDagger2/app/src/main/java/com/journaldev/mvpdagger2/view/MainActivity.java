package com.journaldev.mvpdagger2.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.mvpdagger2.InitApplication;
import com.journaldev.mvpdagger2.MainContract;
import com.journaldev.mvpdagger2.R;
import com.journaldev.mvpdagger2.di.component.DaggerActivityComponent;
import com.journaldev.mvpdagger2.di.module.MvpModule;

import javax.inject.Inject;

import static android.view.View.GONE;


public class MainActivity extends AppCompatActivity implements MainContract.ViewCallBack {


    @Inject
    MainContract.PresenterCallBack presenterCallBack;

    @Inject
    Context mContext;

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerActivityComponent.builder()
                .appComponent(InitApplication.get(this).component())
                .mvpModule(new MvpModule(this))
                .build()
                .inject(this);


        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterCallBack.onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCallBack.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
        Toast.makeText(mContext, "Quote Updated", Toast.LENGTH_SHORT).show();
    }
}

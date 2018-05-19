package com.journaldev.androidmvvmbasics.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.journaldev.androidmvvmbasics.R;
import com.journaldev.androidmvvmbasics.databinding.ActivityMainBinding;
import com.journaldev.androidmvvmbasics.interfaces.LoginResultCallback;
import com.journaldev.androidmvvmbasics.viewmodels.LoginViewModel;
import com.journaldev.androidmvvmbasics.viewmodels.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this)).get(LoginViewModel.class));

    }

    @Override
    public void onSuccess(String s) {
        Toasty.success(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String s) {
        Toasty.error(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}

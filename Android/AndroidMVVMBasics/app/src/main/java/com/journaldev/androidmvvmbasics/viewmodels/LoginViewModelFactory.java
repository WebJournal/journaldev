package com.journaldev.androidmvvmbasics.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.journaldev.androidmvvmbasics.interfaces.LoginResultCallback;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginResultCallback mLoginResultCallback;


    public LoginViewModelFactory(LoginResultCallback loginResultCallback) {
        mLoginResultCallback = loginResultCallback;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new LoginViewModel(mLoginResultCallback);
    }
}

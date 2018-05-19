package com.journaldev.androidmvvmbasics.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.journaldev.androidmvvmbasics.interfaces.LoginResultCallback;
import com.journaldev.androidmvvmbasics.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallback mDataListener;

    LoginViewModel(@NonNull final LoginResultCallback loginDataListener) {
        mDataListener = loginDataListener;
        user = new User("", "");
    }


    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setEmail(editable.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setPassword(editable.toString());
            }
        };
    }


    public void onLoginClicked(@NonNull final View view) {
        checkDataValidity();
    }

    private void checkDataValidity() {
        if (user.isInputDataValid())
            mDataListener.onSuccess("Login was successful");
        else {
            mDataListener.onError("Email or Password not valid");
        }
    }
}
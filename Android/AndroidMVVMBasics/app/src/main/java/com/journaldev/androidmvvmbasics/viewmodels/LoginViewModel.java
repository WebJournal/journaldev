package com.journaldev.androidmvvmbasics.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.journaldev.androidmvvmbasics.model.User;

public class LoginViewModel extends BaseObservable {
    private User user;


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
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
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
}
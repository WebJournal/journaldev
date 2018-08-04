package com.journaldev.androidmvvmbasics.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

public class User {
    @NonNull
    private String mEmail;
    @NonNull
    private String mPassword;

    public User(@NonNull final String email, @NonNull final String password) {
        mEmail = email;
        mPassword = password;
    }

    @NonNull
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(@NonNull final String email) {
        mEmail = email;
    }

    @NonNull
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(@NonNull final String password) {
        mPassword = password;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() && getPassword().length() > 5;
    }
}
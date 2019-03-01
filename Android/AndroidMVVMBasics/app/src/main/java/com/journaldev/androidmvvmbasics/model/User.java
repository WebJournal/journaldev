package com.journaldev.androidmvvmbasics.model;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;


public class User extends BaseObservable {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }


}
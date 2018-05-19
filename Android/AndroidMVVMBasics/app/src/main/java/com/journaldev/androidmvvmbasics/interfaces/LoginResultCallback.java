package com.journaldev.androidmvvmbasics.interfaces;

public interface LoginResultCallback {
    void onSuccess(String s);
    void onError(String s);
}
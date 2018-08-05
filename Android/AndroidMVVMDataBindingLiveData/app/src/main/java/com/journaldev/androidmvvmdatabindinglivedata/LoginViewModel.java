package com.journaldev.androidmvvmdatabindinglivedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;


public class LoginViewModel extends ViewModel {


    public MutableLiveData<String> errorPassword = new MutableLiveData<>();
    public MutableLiveData<String> errorEmail = new MutableLiveData<>();

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Integer> busy;

    public MutableLiveData<Integer> getBusy() {

        if (busy == null) {
            busy = new MutableLiveData<>();
            busy.setValue(8);
        }

        return busy;
    }


    public LoginViewModel() {

    }

    private MutableLiveData<User> userMutableLiveData;

    LiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }

        return userMutableLiveData;
    }


    public void onLoginClicked() {

        getBusy().setValue(0); //View.VISIBLE
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                User user = new User(email.getValue(), password.getValue());

                if (!user.isEmailValid()) {
                    errorEmail.setValue("Enter a valid email address");
                } else {
                    errorEmail.setValue(null);
                }

                if (!user.isPasswordLengthGreaterThan5())
                    errorPassword.setValue("Password Length should be greater than 5");
                else {
                    errorPassword.setValue(null);
                }

                userMutableLiveData.setValue(user);
                busy.setValue(8); //8 == View.GONE

            }
        }, 3000);
    }
}
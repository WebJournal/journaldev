package com.journaldev.androidmvvmbasics.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
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

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
}
package com.journaldev.mvpdagger2retroiftrxjava;

import android.app.Activity;
import android.app.Application;

import com.journaldev.mvpdagger2retroiftrxjava.di.component.ApplicationComponent;
import com.journaldev.mvpdagger2retroiftrxjava.di.component.DaggerApplicationComponent;
import com.journaldev.mvpdagger2retroiftrxjava.di.module.ContextModule;


public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}


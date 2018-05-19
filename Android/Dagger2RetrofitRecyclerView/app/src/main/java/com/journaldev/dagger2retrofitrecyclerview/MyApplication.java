package com.journaldev.dagger2retrofitrecyclerview;

import android.app.Activity;
import android.app.Application;

import com.journaldev.dagger2retrofitrecyclerview.di.component.ApplicationComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.component.DaggerApplicationComponent;
import com.journaldev.dagger2retrofitrecyclerview.di.module.ContextModule;

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


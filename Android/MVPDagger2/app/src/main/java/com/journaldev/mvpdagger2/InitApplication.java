package com.journaldev.mvpdagger2;

import android.app.Application;
import android.content.Context;
import com.journaldev.mvpdagger2.di.component.AppComponent;
import com.journaldev.mvpdagger2.di.component.DaggerAppComponent;
import com.journaldev.mvpdagger2.di.module.AppModule;
import com.journaldev.mvpdagger2.di.module.ContextModule;
import com.journaldev.mvpdagger2.di.module.DataModule;


public class InitApplication extends Application {

    private AppComponent component;

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public AppComponent component() {
        return component;
    }
}
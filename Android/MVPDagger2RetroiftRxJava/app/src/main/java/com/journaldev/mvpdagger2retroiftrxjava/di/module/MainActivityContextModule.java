package com.journaldev.mvpdagger2retroiftrxjava.di.module;

import android.content.Context;


import com.journaldev.mvpdagger2retroiftrxjava.MainActivity;
import com.journaldev.mvpdagger2retroiftrxjava.di.qualifier.ActivityContext;
import com.journaldev.mvpdagger2retroiftrxjava.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}

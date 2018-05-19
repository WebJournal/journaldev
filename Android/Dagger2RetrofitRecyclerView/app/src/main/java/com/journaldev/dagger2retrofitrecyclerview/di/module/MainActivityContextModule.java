package com.journaldev.dagger2retrofitrecyclerview.di.module;

import android.content.Context;

import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ActivityContext;
import com.journaldev.dagger2retrofitrecyclerview.di.scopes.ActivityScope;
import com.journaldev.dagger2retrofitrecyclerview.ui.MainActivity;

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

package com.journaldev.mvpdagger2retroiftrxjava.di.module;

import com.journaldev.mvpdagger2retroiftrxjava.di.scopes.ActivityScope;
import com.journaldev.mvpdagger2retroiftrxjava.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }


}

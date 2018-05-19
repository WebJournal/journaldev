package com.journaldev.mvpdagger2retroiftrxjava.di.component;

import android.content.Context;

import com.journaldev.mvpdagger2retroiftrxjava.MainActivity;
import com.journaldev.mvpdagger2retroiftrxjava.di.module.AdapterModule;
import com.journaldev.mvpdagger2retroiftrxjava.di.module.MainActivityMvpModule;
import com.journaldev.mvpdagger2retroiftrxjava.di.qualifier.ActivityContext;
import com.journaldev.mvpdagger2retroiftrxjava.di.scopes.ActivityScope;
import dagger.Component;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}

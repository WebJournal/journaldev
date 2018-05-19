package com.journaldev.dagger2retrofitrecyclerview.di.component;

import android.content.Context;


import com.journaldev.dagger2retrofitrecyclerview.di.module.AdapterModule;
import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ActivityContext;
import com.journaldev.dagger2retrofitrecyclerview.di.scopes.ActivityScope;
import com.journaldev.dagger2retrofitrecyclerview.ui.MainActivity;

import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(MainActivity mainActivity);
}

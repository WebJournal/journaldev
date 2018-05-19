package com.journaldev.mvpdagger2.di.component;

import android.app.Application;
import android.content.Context;

import com.journaldev.mvpdagger2.InitApplication;
import com.journaldev.mvpdagger2.di.module.AppModule;
import com.journaldev.mvpdagger2.di.module.ContextModule;
import com.journaldev.mvpdagger2.di.module.DataModule;
import com.journaldev.mvpdagger2.model.Model;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Context getContext();

    Model getFindItemsInteractor();

    Application getApplication();
}

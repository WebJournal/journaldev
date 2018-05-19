package com.journaldev.mvpdagger2.di.module;

import com.journaldev.mvpdagger2.model.Model;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public Model provideModelClass() {
        return new Model();
    }
}

package com.journaldev.dagger2retrofitrecyclerview.di.module;

import android.content.Context;


import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ApplicationContext;
import com.journaldev.dagger2retrofitrecyclerview.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}

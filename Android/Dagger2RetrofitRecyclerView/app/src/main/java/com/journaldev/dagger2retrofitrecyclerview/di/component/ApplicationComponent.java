package com.journaldev.dagger2retrofitrecyclerview.di.component;

import android.content.Context;

import com.journaldev.dagger2retrofitrecyclerview.MyApplication;
import com.journaldev.dagger2retrofitrecyclerview.di.module.ContextModule;
import com.journaldev.dagger2retrofitrecyclerview.di.module.RetrofitModule;
import com.journaldev.dagger2retrofitrecyclerview.di.qualifier.ApplicationContext;
import com.journaldev.dagger2retrofitrecyclerview.di.scopes.ApplicationScope;
import com.journaldev.dagger2retrofitrecyclerview.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);
}

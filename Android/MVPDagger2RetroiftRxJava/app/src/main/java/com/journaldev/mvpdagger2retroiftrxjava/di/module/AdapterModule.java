package com.journaldev.mvpdagger2retroiftrxjava.di.module;

import com.journaldev.mvpdagger2retroiftrxjava.MainActivity;
import com.journaldev.mvpdagger2retroiftrxjava.RecyclerViewAdapter;
import com.journaldev.mvpdagger2retroiftrxjava.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}

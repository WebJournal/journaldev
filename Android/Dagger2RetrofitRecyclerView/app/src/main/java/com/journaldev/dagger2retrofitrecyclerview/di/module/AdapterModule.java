package com.journaldev.dagger2retrofitrecyclerview.di.module;


import com.journaldev.dagger2retrofitrecyclerview.adapter.RecyclerViewAdapter;
import com.journaldev.dagger2retrofitrecyclerview.di.scopes.ActivityScope;
import com.journaldev.dagger2retrofitrecyclerview.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleLIst(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}

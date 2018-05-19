package com.journaldev.dagger2retrofitrecyclerview.di.component;

import com.journaldev.dagger2retrofitrecyclerview.di.scopes.ActivityScope;
import com.journaldev.dagger2retrofitrecyclerview.ui.DetailActivity;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {

    void inject(DetailActivity detailActivity);
}

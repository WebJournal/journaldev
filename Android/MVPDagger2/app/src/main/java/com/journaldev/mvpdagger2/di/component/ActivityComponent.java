package com.journaldev.mvpdagger2.di.component;

import com.journaldev.mvpdagger2.MainContract;
import com.journaldev.mvpdagger2.di.module.MvpModule;
import com.journaldev.mvpdagger2.di.scope.ActivityScope;
import com.journaldev.mvpdagger2.view.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MvpModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    MainContract.PresenterCallBack getMainPresenter();
}

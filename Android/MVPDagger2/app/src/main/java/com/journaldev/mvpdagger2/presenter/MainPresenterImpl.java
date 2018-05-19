package com.journaldev.mvpdagger2.presenter;

import com.journaldev.mvpdagger2.MainContract;
import com.journaldev.mvpdagger2.model.Model;


public class MainPresenterImpl implements MainContract.PresenterCallBack, MainContract.ModelCallBack.OnFinishedListener {

    private MainContract.ViewCallBack mainView;
    private Model model;


    public MainPresenterImpl(MainContract.ViewCallBack mainView, Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setQuote(string);
            mainView.hideProgress();
        }
    }
}
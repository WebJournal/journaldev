package com.journaldev.mvpdagger2;

/**
 * Created by anupamchugh on 11/08/17.
 */

public interface MainContract {

    interface ViewCallBack {
        void showProgress();

        void hideProgress();

        void setQuote(String string);
    }

    interface ModelCallBack {
        interface OnFinishedListener {
            void onFinished(String string);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    interface PresenterCallBack {
        void onButtonClick();

        void onDestroy();
    }
}

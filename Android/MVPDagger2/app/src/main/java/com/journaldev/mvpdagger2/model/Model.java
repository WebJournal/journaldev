package com.journaldev.mvpdagger2.model;

import android.os.Handler;

import com.journaldev.mvpdagger2.MainContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements MainContract.ModelCallBack {

    @Override
    public void getNextQuote(final MainContract.ModelCallBack.OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getRandomQuote());
            }
        }, 1200);
    }

    private List<String> arrayList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    private String getRandomQuote() {

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}

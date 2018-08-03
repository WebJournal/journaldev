package com.journaldev.androidrxbinding;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {


    Button button, button2, button3;
    FloatingActionButton fab;
    TextView txtBelowEditText, txtBelowButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        fab = findViewById(R.id.fab);
        txtBelowEditText = findViewById(R.id.txtBelowEditText);
        txtBelowButton = findViewById(R.id.txtBelowButton);
        editText = findViewById(R.id.editText);


        Observable<Object> observable1 = RxView.clicks(button2).map(o -> button2);
        Observable<Object> observable2 = RxView.clicks(fab).map(o -> fab);


        Disposable d1 = Observable.merge(observable1, observable2).throttleFirst(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread()).
                        subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object o) {
                                Toast.makeText(getApplicationContext(), "Avoid multiple clicks using throttleFirst", Toast.LENGTH_SHORT).show();
                                if (o instanceof Button) {
                                    txtBelowButton.setText(((Button) o).getText().toString() + " clicked");
                                } else if (o instanceof FloatingActionButton) {
                                    txtBelowButton.setText("Fab clicked");
                                }
                            }
                        });


        Disposable d = RxView.clicks(button).debounce(5, TimeUnit.SECONDS).
                observeOn(AndroidSchedulers.mainThread()).
                map(o -> button.getText().toString()).
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        txtBelowButton.setText(o + " was clicked");
                    }
                });


        Disposable d2 = RxTextView.textChanges(editText)
                .filter(s -> s.toString().length() > 6)
                .debounce(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) throws Exception {

                        txtBelowEditText.setText(charSequence);
                    }
                });


        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Observable<Button> clickObservable = RxView.clicks(button3).map(o -> button3).share();

        Disposable buttonShowToast =
                clickObservable.subscribe(new Consumer<Button>() {
                    @Override
                    public void accept(Button o) throws Exception {
                        Toast.makeText(getApplicationContext(), "Show toast", Toast.LENGTH_SHORT).show();

                    }
                });
        compositeDisposable.add(buttonShowToast);

        Disposable changeButtonText =
                clickObservable.subscribe(new Consumer<Button>() {
                    @Override
                    public void accept(Button o) throws Exception {

                        o.setText("New text");
                    }
                });
        compositeDisposable.add(changeButtonText);


        //Clearing the listeners below
        /*CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(d1);
        compositeDisposable.add(d2);
        compositeDisposable.add(d);

        compositeDisposable.clear();*/


    }


}

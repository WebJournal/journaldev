package com.journaldev.androidmultiasynctasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnParallelExecution, btnSerialExecution;
    ProgressBar progressBar1, progressBar2, progressBar3, progressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        btnSerialExecution = findViewById(R.id.btnSerialExecution);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        btnParallelExecution = findViewById(R.id.btnParallelExecution);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);

        btnSerialExecution.setOnClickListener(this);
        btnParallelExecution.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSerialExecution:

                MyObject myObject = new MyObject(progressBar1, 2);

                MyAsyncTask aTask1 = new MyAsyncTask();
                aTask1.execute(myObject);

                myObject = new MyObject(progressBar2, 3);

                MyAsyncTask aTask2 = new MyAsyncTask();
                aTask2.execute(myObject);
                break;

            case R.id.btnParallelExecution:

                myObject = new MyObject(progressBar3, 2);

                MyAsyncTask aTask3 = new MyAsyncTask();
                aTask3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, myObject);

                myObject = new MyObject(progressBar4, 3);

                MyAsyncTask aTask4 = new MyAsyncTask();
                aTask4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, myObject);
                break;
        }

    }

    private static class MyAsyncTask extends AsyncTask<MyObject, Integer, Void> {

        private WeakReference<MyObject> myObjectWeakReference;

        @Override
        protected Void doInBackground(MyObject... params) {
            this.myObjectWeakReference = new WeakReference<>(params[0]);
            for (int i = 0; i <= 10; i++) {
                publishProgress(i);

                try {
                    Thread.sleep(myObjectWeakReference.get().interval * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            myObjectWeakReference.get().progressBar.setProgress(values[0]);
        }
    }

    private class MyObject {
        private ProgressBar progressBar;
        private int interval;

        MyObject(ProgressBar progressBar, int interval) {
            this.progressBar = progressBar;
            this.interval = interval;
        }
    }
}

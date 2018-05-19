package com.journaldev.advanceddatabinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


import com.journaldev.advanceddatabinding.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        DataModel dataModel = new DataModel(R.drawable.marsh, "Android MarshMallow", "Android 6.0");
        binding.setData(dataModel);


        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (i == 0) {
                            DataModel dataModel = new DataModel(R.drawable.lollipop, "Android Lollipop", "Android 5.0");
                            binding.setData(dataModel);
                            i = 1;

                        } else {
                            i = 0;
                            DataModel dataModel = new DataModel(R.drawable.marsh, "Android MarshMallow", "Android 6.0");
                            binding.setData(dataModel);

                        }
                    }
                });
            }
        }, 3000, 3000); // End of your timer code.




    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }


}

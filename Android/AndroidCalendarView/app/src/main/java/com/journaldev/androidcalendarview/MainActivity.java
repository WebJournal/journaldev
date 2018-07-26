package com.journaldev.androidcalendarview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Calendar calendar;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calendar = Calendar.getInstance();


        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2012);


        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.YEAR, 1);


        calendarView = findViewById(R.id.calendarView);

        Button btnRange = findViewById(R.id.btnRange);
        btnRange.setOnClickListener(this);

        Button btnWithoutAnim = findViewById(R.id.btnWithoutAnim);
        btnWithoutAnim.setOnClickListener(this);

        Button btnWithAnim = findViewById(R.id.btnWithAnim);
        btnWithAnim.setOnClickListener(this);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                String msg = "Selected date Day: " + i2 + " Month : " + (i1 + 1) + " Year " + i;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnWithAnim:
                calendarView.setDate(calendar.getTimeInMillis(), true, true);
                break;

            case R.id.btnWithoutAnim:
                calendar.set(Calendar.DAY_OF_MONTH, 12);
                calendar.set(Calendar.YEAR, 2016);
                calendar.add(Calendar.MONTH, Calendar.MARCH);
                calendarView.setDate(calendar.getTimeInMillis(), false, false);
                break;

            case R.id.btnRange:

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
                long endOfMonth = calendar.getTimeInMillis();
                calendar = Calendar.getInstance();
                calendar.set(Calendar.DATE, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                long startOfMonth = calendar.getTimeInMillis();
                calendarView.setMaxDate(endOfMonth);
                calendarView.setMinDate(startOfMonth);


                String minDateString = new SimpleDateFormat("MM/dd/yyyy").format(new Date(calendarView.getMinDate()));
                String maxDateString = new SimpleDateFormat("MM/dd/yyyy").format(new Date(calendarView.getMaxDate()));

                Toast.makeText(getApplicationContext(), "MMDDYYYY Min date - " + minDateString + " Max Date is " + maxDateString, Toast.LENGTH_LONG).show();

                break;


        }
    }
}

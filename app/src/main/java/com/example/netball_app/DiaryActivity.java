package com.example.netball_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class DiaryActivity extends AppCompatActivity {


    CalendarView schedule;
    TextView calendarr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);


        schedule = (CalendarView)
                findViewById(R.id.schedule);
        calendarr = (TextView)
                findViewById(R.id.calendarr);

        schedule
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                calendarr.setText(Date);
                            }
                        });
    }
}
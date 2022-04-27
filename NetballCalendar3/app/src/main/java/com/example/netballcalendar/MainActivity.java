package com.example.netballcalendar;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    CalendarView schedule;
    TextView calendarr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
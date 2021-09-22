package com.michaelmagdy.daterangepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CalendarPickerView calendarPickerView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);
        calendarPickerView = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        calendarPickerView.init(lastYear.getTime(), tomorrow)
                .withSelectedDate(today)
                .inMode(CalendarPickerView.SelectionMode.RANGE);
        //calendar.highlightDates(getHolidays());
        Log.d("today", String.valueOf(today.getYear()));
        Log.d("today", String.valueOf(today.getMonth()));
        Log.d("today", String.valueOf(today.getDay()));

        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        //sdf.format(today);
        Log.d("newFormatDate", sdf.format(today));

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Date> selectedDates = (ArrayList<Date>)calendarPickerView
                        .getSelectedDates();
                Log.d("newFormatDate", sdf.format(selectedDates.get(0)));
                Log.d("newFormatDate", sdf.format(selectedDates.get(selectedDates.size()-1)));
                Toast.makeText(MainActivity.this, selectedDates.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }


}
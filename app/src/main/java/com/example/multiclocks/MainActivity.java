package com.example.multiclocks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Spinner spnTimeZone1 = findViewById(R.id.spnTimeZone1);
        Spinner spnTimeZone2 = findViewById(R.id.spnTimeZone2);
        Spinner spnTimeZone3 = findViewById(R.id.spnTimeZone3);
        Spinner spnTimeZone4 = findViewById(R.id.spnTimeZone4);
        Spinner spnTimeZone5 = findViewById(R.id.spnTimeZone5);
        String[] listTimeZones = new String[]{"(UTC-12:00) International Date Line West", "(UTC-11:00) Coordinated Universal Time-11",
                "(UTC-10:00) Hawaii", "(UTC-09:30) Midway Island", "(UTC-09:00) Alaska", "(UTC-08:00) Pacific Time (US and Canada)",
                "(UTC-07:00) Mountain Time (US and Canada)", "(UTC-06:00) Central Time (US and Canada)", "(UTC-05:00) Eastern Time (US and Canada)",
                "(UTC-04:00) Atlantic Time (Canada)", "(UTC-03:30) Newfoundland", "(UTC-03:00) Buenos Aires", "(UTC-02:00) Coordinated Universal Time-2",
                "(UTC-01:00) Azores", "(UTC+00:00) Coordinated Universal Time", "(UTC+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna",
                "(UTC+02:00) Athens, Bucharest, Istanbul", "(UTC+03:00) Kuwait, Riyadh", "(UTC+03:30) Tehran", "(UTC+04:00) Moscow, St. Petersburg, Volgograd",
                "(UTC+04:30) Kabul", "(UTC+05:00) Islamabad, Karachi", "(UTC+05:30) Chennai, Kolkata, Mumbai, New Delhi",
                "(UTC+05:45) Kathmandu", "(UTC+06:00) Astana, Dhaka, Yekaterinburg", "(UTC+06:30) Yangon", "(UTC+07:00) Bangkok, Hanoi, Jakarta",
                "(UTC+08:00) Beijing, Chongqing, Hong Kong, Urumqi", "(UTC+08:45) Australia Eastern Time", "(UTC+09:00) Seoul, Osaka, Sapporo, Tokyo",
                "(UTC+09:30) Adelaide", "(UTC+10:00) Canberra, Melbourne, Sydney", "(UTC+10:30) New South Wales", "(UTC+11:00) Vladivostok",
                "(UTC+12:00) Coordinated Universal Time+12", "(UTC+12:45) Chatham Islands", "(UTC+13:00) Nuku'alofa, Samoa", "(UTC+14:00) Kiritimati"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        TextView textClock1 = findViewById(R.id.textTime1);
        TextView textClock2 = findViewById(R.id.textTime2);
        TextView textClock3 = findViewById(R.id.textTime3);
        TextView textClock4 = findViewById(R.id.textTime4);
        TextView textClock5 = findViewById(R.id.textTime5);
        TextView setAlarmRedirectText = findViewById(R.id.setAlarmRedirectText);
        spnTimeZone1.setAdapter(adapter1);
        spnTimeZone2.setAdapter(adapter2);
        spnTimeZone3.setAdapter(adapter3);
        spnTimeZone4.setAdapter(adapter4);
        spnTimeZone5.setAdapter(adapter5);
        spnTimeZone1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String timeZone = listTimeZones[i];
                String strZoneOffset = timeZone.substring(4,10);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                ZoneOffset zoneOffset = ZoneOffset.of(strZoneOffset);
                OffsetDateTime now = OffsetDateTime.now(zoneOffset);
                String formattedTime = now.format(formatter);
                textClock1.setText(formattedTime);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnTimeZone2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String timeZone = listTimeZones[i];
                String strZoneOffset = timeZone.substring(4,10);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                ZoneOffset zoneOffset = ZoneOffset.of(strZoneOffset);
                OffsetDateTime now = OffsetDateTime.now(zoneOffset);
                String formattedTime = now.format(formatter);
                textClock2.setText(formattedTime);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnTimeZone3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String timeZone = listTimeZones[i];
                ZoneOffset zoneOffset = ZoneOffset.of(timeZone.substring(4,10));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                OffsetDateTime now = OffsetDateTime.now(zoneOffset);
                String formattedTime = now.format(formatter);
                textClock3.setText(formattedTime);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnTimeZone4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String timeZone = listTimeZones[i];
                ZoneOffset zoneOffset = ZoneOffset.of(timeZone.substring(4,10));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                OffsetDateTime now = OffsetDateTime.now(zoneOffset);
                String formattedTime = now.format(formatter);
                textClock4.setText(formattedTime);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnTimeZone5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String timeZone = listTimeZones[i];
                ZoneOffset zoneOffset = ZoneOffset.of(timeZone.substring(4,10));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                OffsetDateTime now = OffsetDateTime.now(zoneOffset);
                String formattedTime = now.format(formatter);
                textClock5.setText(formattedTime);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        setAlarmRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SetAlarmActivity.class);
            startActivity(intent);
        });
    }

}
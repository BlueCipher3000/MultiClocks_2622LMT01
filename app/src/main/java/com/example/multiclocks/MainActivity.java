package com.example.multiclocks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {
    Spinner spnTimeZone1;
    Spinner spnTimeZone2;
    Spinner spnTimeZone3;
    Spinner spnTimeZone4;
    Spinner spnTimeZone5;
    TextView textClock1, textClock2, textClock3,
            textClock4, textClock5, setAlarmRedirectText;
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
    private int getSpinnerPosition(ArrayAdapter<String> adapter, String item) {
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).equals(item)) {
                return i;
            }
        }
        return 0; // Default to the first position if not found
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textClock1 = findViewById(R.id.textTime1);
        textClock2 = findViewById(R.id.textTime2);
        textClock3 = findViewById(R.id.textTime3);
        textClock4 = findViewById(R.id.textTime4);
        textClock5 = findViewById(R.id.textTime5);

        spnTimeZone1 = findViewById(R.id.spnTimeZone1);
        spnTimeZone2 = findViewById(R.id.spnTimeZone2);
        spnTimeZone3 = findViewById(R.id.spnTimeZone3);
        spnTimeZone4 = findViewById(R.id.spnTimeZone4);
        spnTimeZone5 = findViewById(R.id.spnTimeZone5);
        setAlarmRedirectText = findViewById(R.id.setAlarmRedirectText);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTimeZones);
        spnTimeZone1.setAdapter(adapter1);
        spnTimeZone2.setAdapter(adapter2);
        spnTimeZone3.setAdapter(adapter3);
        spnTimeZone4.setAdapter(adapter4);
        spnTimeZone5.setAdapter(adapter5);
        if (savedInstanceState != null) {
            String savedTimeZone1 = savedInstanceState.getString("spnTimeZone1");
            String savedTimeZone2 = savedInstanceState.getString("spnTimeZone2");
            String savedTimeZone3 = savedInstanceState.getString("spnTimeZone3");
            String savedTimeZone4 = savedInstanceState.getString("spnTimeZone4");
            String savedTimeZone5 = savedInstanceState.getString("spnTimeZone5");

            int position1 = getSpinnerPosition(adapter1, savedTimeZone1);
            spnTimeZone1.setSelection(position1);

            int position2 = getSpinnerPosition(adapter2, savedTimeZone2);
            spnTimeZone2.setSelection(position2);

            int position3 = getSpinnerPosition(adapter3, savedTimeZone3);
            spnTimeZone3.setSelection(position3);

            int position4 = getSpinnerPosition(adapter4, savedTimeZone4);
            spnTimeZone4.setSelection(position4);

            int position5 = getSpinnerPosition(adapter5, savedTimeZone5);
            spnTimeZone5.setSelection(position5);
        }

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
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("spnTimeZone1", spnTimeZone1.getSelectedItem().toString());
        outState.putString("spnTimeZone2", spnTimeZone2.getSelectedItem().toString());
        outState.putString("spnTimeZone3", spnTimeZone3.getSelectedItem().toString());
        outState.putString("spnTimeZone4", spnTimeZone4.getSelectedItem().toString());
        outState.putString("spnTimeZone5", spnTimeZone5.getSelectedItem().toString());
    }

}
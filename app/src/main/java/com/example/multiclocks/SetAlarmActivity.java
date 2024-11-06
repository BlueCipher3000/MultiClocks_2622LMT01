package com.example.multiclocks;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class SetAlarmActivity extends AppCompatActivity {
    private MaterialTimePicker timePicker;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_set_alarm);
        TextView worldTimeRedirectTextView = findViewById(R.id.worldTimeRedirectText);
        TextView selectTime = findViewById(R.id.selectTime);
        Button setAlarm = findViewById(R.id.setAlarm);
        Button cancelAlarm = findViewById(R.id.cancelAlarm);
        timePicker = new MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12).setMinute(0).setTitleText("Thiết lập thời gian").build();
        selectTime.setOnClickListener(view -> timePicker.show(getSupportFragmentManager(), "alarm"));

        timePicker.addOnPositiveButtonClickListener(v -> selectTime.setText(timePicker.getHour() + ":" + timePicker.getMinute()));

        setAlarm.setOnClickListener(view -> {
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(SetAlarmActivity.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(SetAlarmActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, timePicker.getHour(), timePicker.getMinute(), pendingIntent);
            Toast.makeText(SetAlarmActivity.this, "Đặt báo thức thành công", Toast.LENGTH_SHORT).show();
        });

        cancelAlarm.setOnClickListener(view -> {
            Intent intent = new Intent(SetAlarmActivity.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(SetAlarmActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            if (alarmManager == null) {
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            }
            alarmManager.cancel(pendingIntent);
            Toast.makeText(SetAlarmActivity.this, "Hủy báo thức thành công", Toast.LENGTH_SHORT).show();
        });



        worldTimeRedirectTextView.setOnClickListener(v -> {
            Intent intent = new Intent(SetAlarmActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

}

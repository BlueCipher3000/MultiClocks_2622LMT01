package com.example.multiclocks;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
    private void createNotificationChannel(){
        CharSequence name = "alarm-channel";
        String desc = "Channel for Alarm Manager";
        int imp = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel("multi-clocks", name, imp);
        channel.setDescription(desc);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}

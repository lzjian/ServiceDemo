package com.lzjian.servicedemo.demo2;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.lzjian.servicedemo.R;
import com.lzjian.servicedemo.demo1.MainActivity;

public class ForegroundService extends Service {

    public ForegroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent notificationIntent = new Intent(this, ForegroundActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Notification notification = new Notification.Builder(this)
                .setContentTitle("This is title")
                .setContentText("This is content")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .getNotification();
        startForeground(1, notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

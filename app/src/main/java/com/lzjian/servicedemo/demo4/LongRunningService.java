package com.lzjian.servicedemo.demo4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

public class LongRunningService extends Service {

    private final String TAG = getClass().getSimpleName();

    public LongRunningService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "execute at "+new Date().toString());
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerAtTime = SystemClock.elapsedRealtime() + 2 * 1000;
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

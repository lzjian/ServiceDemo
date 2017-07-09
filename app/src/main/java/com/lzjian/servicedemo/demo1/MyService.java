package com.lzjian.servicedemo.demo1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @Description:
 */

public class MyService extends Service{

    private final String TAG = getClass().getSimpleName();

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder{

        public void startDownload(){
            Log.i(TAG, "startDownload");
        }

        public int getProgress(){
            Log.i(TAG, "getProgress");
            return 0;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

}

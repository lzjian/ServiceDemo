package com.lzjian.servicedemo.demo3;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

/**
 * @Description:
 */

public class MyIntentService extends IntentService{

    private final String TAG = getClass().getSimpleName();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    // 这个方法是在子线程中运行的
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Thread id is "+ Thread.currentThread().getId());
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}

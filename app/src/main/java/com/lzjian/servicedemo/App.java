package com.lzjian.servicedemo;

import android.app.Application;
import android.util.Log;

/**
 * @Description:
 */

public class App extends Application {

    private final String TAG = getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }
}

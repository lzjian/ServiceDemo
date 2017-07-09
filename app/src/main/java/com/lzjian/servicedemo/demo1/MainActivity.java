package com.lzjian.servicedemo.demo1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lzjian.servicedemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();

    private Button btn_start_service,btn_stop_service,btn_bind_service,btn_unbind_service,btn_bind_service_do_something;

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: "+name.toString());
            downloadBinder = (MyService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: "+name.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_service = (Button) findViewById(R.id.btn_start_service);
        btn_stop_service = (Button) findViewById(R.id.btn_stop_service);
        btn_bind_service = (Button) findViewById(R.id.btn_bind_service);
        btn_unbind_service = (Button) findViewById(R.id.btn_unbind_service);
        btn_bind_service_do_something = (Button) findViewById(R.id.btn_bind_service_do_something);
        btn_start_service.setOnClickListener(this);
        btn_stop_service.setOnClickListener(this);
        btn_bind_service.setOnClickListener(this);
        btn_unbind_service.setOnClickListener(this);
        btn_bind_service_do_something.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_service:
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.btn_stop_service:
                Intent intent2 = new Intent(this, MyService.class);
                stopService(intent2);
                break;
            case R.id.btn_bind_service:
                Intent intent3 = new Intent(this, MyService.class);
                bindService(intent3, connection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                if (downloadBinder != null){
                    unbindService(connection);
                    downloadBinder = null;
                }
                break;
            case R.id.btn_bind_service_do_something:
                if (downloadBinder != null){
                    downloadBinder.startDownload();
                    downloadBinder.getProgress();
                }
                break;
        }
    }
}

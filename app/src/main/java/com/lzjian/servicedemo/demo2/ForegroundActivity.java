package com.lzjian.servicedemo.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lzjian.servicedemo.R;

public class ForegroundActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();

    private Button btn_start_foreground,btn_stop_foreground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        btn_start_foreground = (Button) findViewById(R.id.btn_start_foreground);
        btn_stop_foreground = (Button) findViewById(R.id.btn_stop_foreground);
        btn_start_foreground.setOnClickListener(this);
        btn_stop_foreground .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_foreground:
                Intent intent4 = new Intent(this, ForegroundService.class);
                startService(intent4);
                break;
            case R.id.btn_stop_foreground:
                Intent intent5 = new Intent(this, ForegroundService.class);
                stopService(intent5);
                break;
        }
    }
}

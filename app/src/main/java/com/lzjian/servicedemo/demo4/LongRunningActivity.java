package com.lzjian.servicedemo.demo4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lzjian.servicedemo.R;
import com.lzjian.servicedemo.demo3.MyIntentService;

public class LongRunningActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_start_long_running_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_running);

        btn_start_long_running_service = (Button) findViewById(R.id.btn_start_long_running_service);
        btn_start_long_running_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_long_running_service:
                Intent intent = new Intent(this, LongRunningService.class);
                startService(intent);
                break;
        }
    }
}

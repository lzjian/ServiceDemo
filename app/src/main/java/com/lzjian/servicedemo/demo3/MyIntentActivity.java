package com.lzjian.servicedemo.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lzjian.servicedemo.R;

public class MyIntentActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();

    private Button btn_start_intent_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent);

        btn_start_intent_service = (Button) findViewById(R.id.btn_start_intent_service);
        btn_start_intent_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_intent_service:
                Log.i(TAG, "Thread id is "+Thread.currentThread().getId());
                Intent intent6 = new Intent(this, MyIntentService.class);
                startService(intent6);
                break;
        }
    }
}

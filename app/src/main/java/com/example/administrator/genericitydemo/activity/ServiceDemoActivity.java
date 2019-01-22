package com.example.administrator.genericitydemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.genericitydemo.R;

public class ServiceDemoActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_start_service;
    Button btn_stop_service;
    Button btn_bind_service;
    Button btn_unbind_service;
    ServiceConnection serviceConnection=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        btn_start_service=findViewById(R.id.btn_start_service);
        btn_stop_service=findViewById(R.id.btn_stop_service);
        btn_bind_service=findViewById(R.id.btn_bind_service);
        btn_unbind_service=findViewById(R.id.btn_unbind_service);
        btn_start_service.setOnClickListener(this);
        btn_stop_service.setOnClickListener(this);
        btn_bind_service.setOnClickListener(this);
        btn_unbind_service.setOnClickListener(this);
        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                System.out.println("onServiceConnected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {//取消绑定时，不会调用onServiceDisconnected
                System.out.println("onServiceDisconnected");
            }
        };
    }

    @Override
    public void onClick(View v) {
        Intent it=new Intent(this, SimpleService.class);
        switch (v.getId()){
            case R.id.btn_start_service:
                startService(it);
                break;
            case R.id.btn_stop_service:
                stopService(it);
                break;
            case R.id.btn_bind_service:
                bindService(it,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(serviceConnection);
                break;
        }

    }
}

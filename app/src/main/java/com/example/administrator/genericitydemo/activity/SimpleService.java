package com.example.administrator.genericitydemo.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by jian.shui on 2018/12/18
 */
public class SimpleService extends Service {
    public class LocalBinder extends Binder {
       public  SimpleService getService(){
            return  SimpleService.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind invoke");
        return new LocalBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind invoke");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        System.out.println("onCreate invoke");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand invoke");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy invoke");
        super.onDestroy();
    }
}

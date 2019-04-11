package com.example.administrator.genericitydemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import io.realm.Realm;

/**
 * Created by jian.shui on 2019/1/22
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Utils.init(this);

    }
}

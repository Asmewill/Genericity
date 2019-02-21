package com.example.administrator.genericitydemo.utils;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jian.shui on 2019/1/22
 */
public class MyRelam {
    public static  final String USER="user";

    private static Realm realm;
    public static Realm  getRealm(){
        // Realm.init(this);在app里面有初始化
        RealmConfiguration config=new RealmConfiguration.Builder().
                name(USER).
                deleteRealmIfMigrationNeeded().
                build();
        realm=Realm.getInstance(config);
        return  realm;
    }
}

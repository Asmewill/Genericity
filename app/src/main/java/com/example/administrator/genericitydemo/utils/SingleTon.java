package com.example.administrator.genericitydemo.utils;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/hupp/p/4487521.html
 */
public class SingleTon {
    private static SingleTon instance;
    public static int i = 0;
    private SingleTon(){
        System.out.println("init SingleTon");
    }
    static{
        instance=new SingleTon();
    }

    public static  SingleTon getInstance(){
        return instance;
    }
}

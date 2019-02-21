package com.example.administrator.genericitydemo.bean;

import io.realm.RealmObject;

/**
 * Created by jian.shui on 2019/1/22
 */
public class Dog extends RealmObject {
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    public Dog() {

    }
    public Dog(String nick) {
        this.nick = nick;
    }
}

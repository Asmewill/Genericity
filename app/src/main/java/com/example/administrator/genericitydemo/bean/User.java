package com.example.administrator.genericitydemo.bean;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by gavin on 16/12/4.
 */
public class User extends RealmObject {
    @Required
    private String id;
    private String username;
    private RealmList<Dog> dogs;//Dog不能卸载内部做嵌套使用

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(RealmList<Dog> dogs) {
        this.dogs = dogs;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}

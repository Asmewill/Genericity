package com.example.administrator.genericitydemo.utils;

import com.example.administrator.genericitydemo.bean.Dog;
import com.example.administrator.genericitydemo.bean.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

/**
 * Created by jian.shui on 2019/1/22
 */
public class DataUtils {
      public static List<User> getUserList(){
          List<User> listUser=new ArrayList<>();
          for(int i=0;i<6;i++){
              User user=new User();
              user.setId(i+"");
              if(i<3){
                  user.setUsername("Tom"+i);
              }else{
                  user.setUsername("kim"+i);
              }
              RealmList<Dog> dogList=new RealmList<>();
              for(int m=0;m<2;m++){
                  Dog dog=new Dog();
                  dog.setNick("二哈"+i+m);
                  dogList.add(dog);
              }
              user.setDogs(dogList);
              listUser.add(user);
          }
          return listUser;
      }



}

package com.example.administrator.genericitydemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.genericitydemo.R;
import com.example.administrator.genericitydemo.adapter.RealmAdapter;
import com.example.administrator.genericitydemo.bean.Dog;
import com.example.administrator.genericitydemo.bean.User;
import com.example.administrator.genericitydemo.utils.DataUtils;
import com.example.administrator.genericitydemo.utils.MyRelam;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_add;
    Button btn_update;
    Button btn_del;
    Button btn_query;
    Realm mRealm;
    RecyclerView rv_content;
    RealmAdapter realmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        btn_add=findViewById(R.id.btn_add);
        btn_update=findViewById(R.id.btn_update);
        btn_del=findViewById(R.id.btn_del);
        btn_query=findViewById(R.id.btn_query);
        rv_content=findViewById(R.id.rv_content);
        btn_add.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        rv_content.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        realmAdapter=new RealmAdapter();
        rv_content.setAdapter(realmAdapter);
        mRealm= MyRelam.getRealm();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(User.class);//删除User表
                realm.copyToRealm(DataUtils.getUserList());//初始化插入6条数据
            }
        });

        refreshList();
    }

    private void refreshList() {
        List<User> userList=mRealm.where(User.class).findAll();//查询所有的user
        realmAdapter.setNewData(userList);//初始化recycle列表
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                final User user6=new User();
                user6.setId(6+"");
                user6.setUsername("Kim6");
                RealmList<Dog> dogs=new RealmList<>();
                dogs.add(new Dog("藏獒1"));
                dogs.add(new Dog("藏獒2"));
                user6.setDogs(dogs);
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(user6);//初始化插入单条数据
                    }
                });
                refreshList();
                break;
            case R.id.btn_del:
                final RealmResults<User> users=mRealm.where(User.class).findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        if(users!=null&&users.size()>=6){
                            users.deleteFromRealm(5);
                        }else{
                            Toast.makeText(RealmActivity.this,"请先增加数据，然后在删除...",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                refreshList();
                break;
            case R.id.btn_update:
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Toast.makeText(RealmActivity.this,"修改第一行数据的名字为Richa.",Toast.LENGTH_LONG).show();
                        User user=mRealm.where(User.class).findFirst();
                        user.setUsername("Richa");
                    }
                });
                refreshList();
                break;
            case R.id.btn_query:
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Toast.makeText(RealmActivity.this,"查询用户名以Tom开头的所有数据",Toast.LENGTH_LONG).show();
                        //先查找后得到User对象
                        RealmResults<User> users = mRealm.where(User.class).beginsWith("username","Tom").findAll();
                        realmAdapter.setNewData(users);
//                        //查找第一个
//                        User user2 = mRealm.where(User.class).findFirst();
//                        //根据条件查找
//                        RealmResults<User> user3 = mRealm.where(User.class).equalTo("name", "Gavin").findAll();
//                        //根据dog找user
//                        RealmResults<User> user4 = mRealm.where(User.class).equalTo("dogs.name", "二哈").findAll();
//                        //先找到名叫Gavin的user，再从中找出名叫二哈的user
//                        RealmResults<User> user5 = mRealm.where(User.class).equalTo("name", "Gavin").findAll();
//                        RealmResults<User> user6 = user5.where().equalTo("dogs.name", "二哈").findAll();
//                        //还可以这么写
//                        RealmResults<User> user7 = mRealm.where(User.class)
//                                .equalTo("name", "Gavin")
//                                .equalTo("dogs.name", "二哈")
//                                .findAll();
//
//                        //or的使用
//                        RealmQuery<User> query = mRealm.where(User.class);
//                        query.equalTo("name", "Gavin");
//                        query.or().equalTo("name", "Eric");
//                        RealmResults<User> user8 = query.findAll();
//                        //还可以这样
//                        RealmResults<User> user9 = mRealm.where(User.class)
//                                .equalTo("name", "Gavin")
//                                .or().equalTo("name", "Eric")
//                                .findAll();
                    }
                });
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mRealm!=null){
            mRealm.close();
        }
    }
}

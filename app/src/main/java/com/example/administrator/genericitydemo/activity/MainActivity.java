package com.example.administrator.genericitydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.genericitydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_service;
    Button btn_xml;
    Button btn_sqlite;
    Button btn_realm;
    @BindView(R.id.btn_circle_progress_bar)
    Button btn_circle_progress_bar;
    @BindView(R.id.btn_flowlayout)
    Button btn_flowlayout;
    @BindView(R.id.btn_aoto)
    Button btn_aoto;
    @BindView(R.id.btn_ballview)
    Button btn_ballview;
    @BindView(R.id.btn_kotlin)
    Button btn_kotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn_service=findViewById(R.id.btn_service);
        btn_xml=findViewById(R.id.btn_xml);
        btn_sqlite=findViewById(R.id.btn_sqlite);
        btn_realm=findViewById(R.id.btn_realm);
        btn_service.setOnClickListener(this);
        btn_xml.setOnClickListener(this);
        btn_sqlite.setOnClickListener(this);
        btn_realm.setOnClickListener(this);
        btn_circle_progress_bar.setOnClickListener(this);
        btn_flowlayout.setOnClickListener(this);
        btn_aoto.setOnClickListener(this);
        btn_ballview.setOnClickListener(this);
        btn_kotlin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_service:
                startActivity(new Intent(this,ServiceDemoActivity.class));
                break;
            case R.id.btn_xml:
                startActivity(new Intent(this,XmlParseDemoActivity.class));
                break;
            case R.id.btn_sqlite:
                startActivity(new Intent(this,SQLiteDemoActivity.class));
                break;
            case R.id.btn_realm:
                startActivity(new Intent(this,RealmActivity.class));
                break;
            case R.id.btn_circle_progress_bar:
                startActivity(new Intent(this,CircleProgressBarActivity.class));
                break;
            case R.id.btn_flowlayout:
                startActivity(new Intent(this,FlowLayoutActivity.class));
                break;
            case R.id.btn_aoto:
                startActivity(new Intent(this,AotoActivity.class));
                break;
            case R.id.btn_ballview:
                startActivity(new Intent(this,BallViewActivity.class));
                break;
            case R.id.btn_kotlin:
                startActivity(new Intent(this,KotlinTestActivity.class));
                break;
        }

    }
}

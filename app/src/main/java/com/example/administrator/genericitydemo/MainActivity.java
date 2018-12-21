package com.example.administrator.genericitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_service;
    Button btn_xml;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  
        btn_service=findViewById(R.id.btn_service);
        btn_xml=findViewById(R.id.btn_xml);
        btn_service.setOnClickListener(this);
        btn_xml.setOnClickListener(this);
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

        }

    }
}

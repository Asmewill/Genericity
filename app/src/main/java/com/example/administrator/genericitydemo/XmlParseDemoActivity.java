package com.example.administrator.genericitydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.genericitydemo.bean.Student;
import com.example.administrator.genericitydemo.utils.XmlUtils;

import java.util.List;

public class XmlParseDemoActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_pull;
    Button btn_sax;
    Button btn_dom;
    private String TAG="XmlParseDemoActivity";
    private XmlUtils xmlUtils;
    private List<Student> students;
    TextView tv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parse_demo);
        btn_pull=findViewById(R.id.btn_pull);
        btn_dom=findViewById(R.id.btn_dom);
        btn_sax=findViewById(R.id.btn_sax);
        tv_content=findViewById(R.id.tv_content);
        btn_pull.setOnClickListener(this);
        btn_sax.setOnClickListener(this);
        btn_dom.setOnClickListener(this);
        xmlUtils=new XmlUtils();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sax:
                try {
                    students = xmlUtils.sax2xml(getResources().getAssets().open("student.xml"));
                    tv_content.setText(students.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_dom:
                try {
                    students = xmlUtils.dom2xml(getResources().getAssets().open("student.xml"));
                    tv_content.setText(students.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_pull:
                try {
                    students = xmlUtils.pull2xml(getResources().getAssets().open("student.xml"));
                    tv_content.setText(students.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}

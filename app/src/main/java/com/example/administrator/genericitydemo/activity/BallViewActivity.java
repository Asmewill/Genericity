package com.example.administrator.genericitydemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.genericitydemo.R;
import com.example.administrator.genericitydemo.view.DingWeiBallView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BallViewActivity extends AppCompatActivity {
    @BindView(R.id.ll_dingwei_ball)
     DingWeiBallView dingWeiBallView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_view);
        ButterKnife.bind(this);

        dingWeiBallView.setOnclickImp(new DingWeiBallView.BetClickImp() {
            @Override
            public void call(View v, int position) {
                Toast.makeText(BallViewActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

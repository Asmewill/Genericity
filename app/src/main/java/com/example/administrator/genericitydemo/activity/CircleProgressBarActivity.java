package com.example.administrator.genericitydemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.genericitydemo.R;
import com.example.administrator.genericitydemo.view.CircleProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleProgressBarActivity extends AppCompatActivity {

    @BindView(R.id.view_bar)
    CircleProgressBar circlebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress_bar);
        ButterKnife.bind(this);
    }
    public void showYuanHuan(View view){
        circlebar.setStyle(0);
        circlebar.setRoundColor(getResources().getColor(R.color.borrow_bar_min));
        circlebar.setRoundProgressColor(getResources().getColor(R.color.colorAccent));
        circlebar.setRoundWidth(6);
        circlebar.setMax(100);
        circlebar.setProgress(60);
    }

    public void showYuanHu(View view){
        circlebar.setStyle(1);
        circlebar.setRoundColor(getResources().getColor(R.color.borrow_bar_min));
        circlebar.setRoundProgressColor(getResources().getColor(R.color.borrow_bar_min));
        circlebar.setRoundWidth(6);
        circlebar.setMax(100);
        circlebar.setProgress(60);
    }

}

package com.example.administrator.genericitydemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.genericitydemo.R;

import java.util.ArrayList;

/**
 * Created by jsxiaoshui on 2019/4/26
 */
public class DingWeiBallView extends LinearLayout {
    private ImageView mImageView;
    private int mImageSrc;
    private ArrayList<CheckBox> mViews = new ArrayList<>();
    private String mBallName;
    private String firstBall = "firstBall";
    private String secondBall = "secondBall";
    private String threeBall = "threeBall";
    public DingWeiBallView(Context context) {
        this(context,null);
    }

    public DingWeiBallView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DingWeiBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.dingWeiBallView);
        mImageSrc = mTypedArray.getResourceId(R.styleable.dingWeiBallView_ivBackgroundSrc, 0);
        mBallName = mTypedArray.getString(R.styleable.dingWeiBallView_ballName);
        //获取资源后要及时回收
        mTypedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        //方式一
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bet_ball_dingwei, this);
        //方式二
    //    View.inflate(context,R.layout.bet_ball_dingwei,this);
        mImageView = (ImageView) findViewById(R.id.iv_dingwei_ball);
        mImageView.setImageResource(mImageSrc);
        CheckBox cb_first_0 = (CheckBox) findViewById(R.id.cb_first_0);
        CheckBox cb_first_1 = (CheckBox) findViewById(R.id.cb_first_1);
        CheckBox cb_first_2 = (CheckBox) findViewById(R.id.cb_first_2);
        CheckBox cb_first_3 = (CheckBox) findViewById(R.id.cb_first_3);
        CheckBox cb_first_4 = (CheckBox) findViewById(R.id.cb_first_4);
        CheckBox cb_first_5 = (CheckBox) findViewById(R.id.cb_first_5);
        CheckBox cb_first_6 = (CheckBox) findViewById(R.id.cb_first_6);
        CheckBox cb_first_7 = (CheckBox) findViewById(R.id.cb_first_7);
        CheckBox cb_first_8 = (CheckBox) findViewById(R.id.cb_first_8);
        CheckBox cb_first_9 = (CheckBox) findViewById(R.id.cb_first_9);

        CheckBox cb_first_big = (CheckBox) findViewById(R.id.cb_first_big);
        CheckBox cb_first_small = (CheckBox) findViewById(R.id.cb_first_small);
        CheckBox cb_first_max = (CheckBox) findViewById(R.id.cb_first_max);
        CheckBox cb_first_min = (CheckBox) findViewById(R.id.cb_first_min);
        CheckBox cb_first_long_and_hu_he = (CheckBox) findViewById(R.id.cb_first_long_and_hu_he);

        mViews.add(cb_first_0);
        mViews.add(cb_first_1);
        mViews.add(cb_first_2);
        mViews.add(cb_first_3);
        mViews.add(cb_first_4);
        mViews.add(cb_first_5);
        mViews.add(cb_first_6);
        mViews.add(cb_first_7);
        mViews.add(cb_first_8);
        mViews.add(cb_first_9);
        mViews.add(cb_first_big);
        mViews.add(cb_first_small);
        mViews.add(cb_first_max);
        mViews.add(cb_first_min);
        mViews.add(cb_first_long_and_hu_he);
        for (int i=0;i<mViews.size();i++) {
            CheckBox checkBox=mViews.get(i);
            final int finalI = i;
            checkBox.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onclickImp != null) {
                        onclickImp.call(v, finalI);
                    }
                }
            });
        }
    }

    BetClickImp onclickImp;

    public void setOnclickImp(BetClickImp onclickImp) {
        this.onclickImp = onclickImp;
    }

    public interface BetClickImp {
        void call(View v,int position);
    }
}

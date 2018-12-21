package com.example.administrator.genericitydemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by jsxiaoshui on 2018/12/8
 */
public class MyLinearLayout extends LinearLayout {
    private float downX;
    private float downY;
    private float endY;
    private float endX;
    boolean result=false;
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
//        @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                downX=ev.getX();
//                downY=ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                endX= (int) ev.getX();
//                endY=ev.getY();
//                float distanceX=Math.abs(endX-downX);
//                float distanceY=Math.abs(endY-downY);
//                if(distanceX>distanceY&&distanceX>10){
//                    result=true;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        Log.i("TAG","onInterceptTouchEvent:"+result);
//        return super.onInterceptTouchEvent(ev);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}

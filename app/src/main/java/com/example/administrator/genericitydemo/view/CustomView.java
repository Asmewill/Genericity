package com.example.administrator.genericitydemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jsxiaoshui on 2019/4/11
 */
public class CustomView extends View {
    private static  final  int DEFAULT_VIEW_WIDTH=100;
    private static  final  int DEFAULT_VIEW_HEIGHT=100;
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width= measureDimension(DEFAULT_VIEW_WIDTH,widthMeasureSpec);
        int height=measureDimension(DEFAULT_VIEW_HEIGHT,heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    private int  measureDimension(int defaultSize,int measureSpec) {
        int result=defaultSize;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        //1. layout给出了确定的值，比如：100dp
        //2. layout使用的是match_parent，但父控件的size已经可以确定了，比如设置的是具体的值或者match_parent
        if(specMode==MeasureSpec.EXACTLY){
            result=specSize;
         //1. layout使用的是wrap_content
         //2. layout使用的是match_parent,但父控件使用的是确定的值或者wrap_content
        }else if(specMode==MeasureSpec.AT_MOST){
            result=Math.min(defaultSize,specSize);
            //UNSPECIFIED,没有任何限制，所以可以设置任何大小
            //多半出现在自定义的父控件的情况下，期望由自控件自行决定大小
        }else{
            result=defaultSize;
        }
        return result;
    }


}

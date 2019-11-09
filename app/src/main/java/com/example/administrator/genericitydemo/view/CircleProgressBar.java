package com.example.administrator.genericitydemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.genericitydemo.R;


/**
 * Created by shuij on 2017/5/31 0031.
 */

public class CircleProgressBar extends View {

    /***
     * 圆环颜色
     */
    private  int roundColor;
    /****
     * 圆环进度颜色
     */
    private  int roundProgressColor;
    /***
     * 圆环的宽度
     */
    private  float roundWidth;

    /***
     *中间字体大小
     */
    private  float textSize;

    /***
     *中间字体颜色
     */
    private  int textColor;

    /***
     *最大进度
     */
    private  int  max;
    /***
     *是否中间允许文字绘制
     */
    private  boolean textIsDisplayable;
    /***
     *绘制风格
     */
    private  int style;
    private final int STROKE=0;//空心

    private final int FILL=1;//实心
    /***
     * 绘制內圆
     */
    private Paint mInnerPaint;
    /***
     * 绘制文字画笔
     */
    private Paint mTextPaint;
    /****
     * 绘制圆狐的画笔
     */
    private Paint mProgressPaint;
    /***
     * 当前进度
     */
    private int progress=0;
    private String destine_time;


    public CircleProgressBar(Context context) {
        this(context,null);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        this(context,attrs,0);//一定不能 this(context,null,0),否则包空异常
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray mTypeArrayArray=context.obtainStyledAttributes(attrs,R.styleable.CircleProgressBar);
        roundColor=mTypeArrayArray.getColor(R.styleable.CircleProgressBar_roundColor,getResources().getColor(R.color.borrow_bar_0));
        roundProgressColor=mTypeArrayArray.getColor(R.styleable.CircleProgressBar_roundProgressColor,getResources().getColor(R.color.borrow_bar_0));
        textColor=mTypeArrayArray.getColor(R.styleable.CircleProgressBar_textColor,getResources().getColor(R.color.borrow_bar_min));
        roundWidth=mTypeArrayArray.getDimension(R.styleable.CircleProgressBar_roundWidth,3);
        textSize=mTypeArrayArray.getDimension(R.styleable.CircleProgressBar_textSize,30);
        max=mTypeArrayArray.getColor(R.styleable.CircleProgressBar_max,100);
        textIsDisplayable=mTypeArrayArray.getBoolean(R.styleable.CircleProgressBar_textIsDisplayable,true);
        style=mTypeArrayArray.getInt(R.styleable.CircleProgressBar_style,0);
        mTypeArrayArray.recycle();
        /**
         * 初始化内圆画笔
         */
        mInnerPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerPaint.setStyle(Paint.Style.STROKE);//设置圆环为空心,不填充//这里Paint.Style.STROKE空心不填充和Paint.Style.FILL去除画笔宽度之后，进行颜色填充
        mInnerPaint.setColor(roundColor);//设置圆环颜色
        mInnerPaint.setStrokeWidth(roundWidth);//设置圆环的宽度
        /**
         * 初始化文字画笔
         */
        mTextPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setColor(textColor);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setStrokeWidth(0);

        /**
         * 初始化圆弧的画笔
         */
        mProgressPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setColor(textColor);
        mProgressPaint.setStrokeWidth(roundWidth);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /***
         * 画外层的大圆
         */
        int center=getWidth()/2;//圆心坐标
        int radius= (int) (center-roundWidth/2);//半径
        canvas.drawCircle(center,center,radius,mInnerPaint);
        /***
         * 绘制中间文字
         */
        if(progress>=0){
            int percent=(int)(progress*max/100);
            float textWidth=mTextPaint.measureText(percent+"%");
            float textX=center-textWidth/2;//文字的x坐标
            //Ascent：字符顶部到baseLine的距离  Descent：字符底部到baseLine的距离
            float textY=center+(Math.abs((mTextPaint.ascent()+mTextPaint.descent())/2));//文字的Y轴坐标
            if(textIsDisplayable&&style==STROKE){
                canvas.drawText(percent+"%",textX,textY,mTextPaint);
            }
            /****
             * 画圆弧进度
             */
            RectF oval=new RectF(center-radius,center-radius,center+radius,center+radius);
            switch (style){
                case STROKE://圆弧
                    canvas.drawArc(oval,270,360*progress/max,false,mProgressPaint);
                    break;
                case FILL://扇形
                    mProgressPaint.setStyle(Paint.Style.STROKE);
                    canvas.drawArc(oval,270,360*progress/max,true,mProgressPaint);
                    break;
            }
        }else{
            //预告标 内容为预告时间
            float textWidth = mTextPaint.measureText(destine_time);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
            canvas.drawText(
                    destine_time,
                    center - textWidth / 2,
                    center
                            + (Math.abs(mTextPaint.ascent()
                            + mTextPaint.descent()) / 2), mTextPaint); // 画出预告时间
        }


    }


    /**
     * 设置进度的最大值
     * @param max
     */
    public synchronized void setMax(int max) {
        if(max < 0){
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = max;
    }

    /**
     * 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步
     * 刷新界面调用postInvalidate()能在非UI线程刷新
     * @param progress
     */
    public synchronized void setProgress(int progress) {
        if(progress < 0){
            throw new IllegalArgumentException("progress not less than 0");
        }
        if(progress > max){
            progress = max;
        }
        if(progress <= max){
            this.progress = progress;
            postInvalidate();
        }

    }

    /****
     * 设置圆环颜色
     * @param roundColor
     */
    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
        mInnerPaint.setColor(roundColor);
        invalidate();
    }

    /****
     * 设置圆环进度条的颜色
     * @param roundProgressColor
     */
    public void setRoundProgressColor(int roundProgressColor) {
        this.roundProgressColor = roundProgressColor;
        mProgressPaint.setColor(roundProgressColor);
        invalidate();
    }


    /**
     * 设置文字颜色
     * @param textColor
     */
    public void setTextColor(int textColor) {
        this.textColor = textColor;
        mTextPaint.setColor(textColor);
        invalidate();
    }

    /***
     * 设置文字大小
     * @param textSize
     */

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        mTextPaint.setTextSize(textSize);
        invalidate();
    }
    /***
     * 设置 圆环宽度
     * @param
     */
    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
        mInnerPaint.setStrokeWidth(roundWidth);
        mProgressPaint.setStrokeWidth(roundWidth);
        invalidate();
    }

    /***
     * 进度为0时设置显示的文本
     * @param destine_time
     */
    public void setDestine_time(String destine_time) {
        this.destine_time = destine_time;
    }

    /*****
     * 设置样式
     * @param style
     * 0圆弧
     * 1圆环
     */
    public void setStyle(int style) {
        this.style = style;
    }
  
}

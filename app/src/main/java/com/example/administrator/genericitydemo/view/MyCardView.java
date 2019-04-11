package com.example.administrator.genericitydemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.administrator.genericitydemo.R;

/**
 * Created by jsxiaoshui on 2019/4/11
 */
public class MyCardView extends LinearLayout {
    private int gap=8;
    private int radius=8;
    private Paint paint;
    public MyCardView(Context context) {
        super(context);
        init();
    }
    public MyCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.white));
        paint.setStrokeWidth(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
    }

    /***
     * 自定义的ViewGroup绘制自身
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circleNum=getWidth()/((gap+radius)*2);
        for(int i=1;i<=circleNum;i++){
            int cx=(gap+radius)*(2*i-1);
            canvas.drawCircle(cx,0,radius,paint);
            canvas.drawCircle(cx,getHeight(),radius,paint);
        }
    }
}

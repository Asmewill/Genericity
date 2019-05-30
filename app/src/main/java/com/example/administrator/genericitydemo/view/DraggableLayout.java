package com.example.administrator.genericitydemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.ScreenUtils;
import com.example.administrator.genericitydemo.R;

/**
 * Created by Owen on 2019/5/30
 */
public class DraggableLayout extends RelativeLayout {

    private static final String Tag ="DraggableLayout" ;
    private ViewDragHelper mDragHelper;
    private int statusType = 0;//0无 随便移动   1靠左  2靠右 0靠左右
    private float showPercent = 1;//自身显示的百分比
    private int finalLeft = -1;
    private int finalTop = -1;
    private int screenWidth;
    Context context;

    public DraggableLayout(Context context) {
       this(context,null);
    }
    public DraggableLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DraggableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.DraggableLayout);
        statusType = typedArray.getInt(R.styleable.DraggableLayout_direction, 0);
        showPercent = typedArray.getFloat(R.styleable.DraggableLayout_showPercent, 1);
        typedArray.recycle();
        init();
    }
    public void init(){
        screenWidth= ScreenUtils.getScreenWidth();
        mDragHelper=  ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
             //   Log.i(Tag,"DraggableLayout--->tryCaptureView");
                return true;
            }

            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
              //  Log.i(Tag,"DraggableLayout--->onViewReleased");
                int viewWidth = releasedChild.getWidth();
                int viewHeight = releasedChild.getHeight();
                int curLeft = releasedChild.getLeft();
                int curTop = releasedChild.getTop();

                finalTop = curTop < 0 ? 0 : curTop;
                finalLeft = curLeft < 0 ? 0 : curLeft;
                if ((finalTop + viewHeight) > getHeight()) {
                    finalTop = getHeight() - viewHeight;
                }

                if ((finalLeft + viewWidth) > getWidth()) {
                    finalLeft = getWidth() - viewWidth;
                }
                switch (statusType) {
                    case 0://无
                        break;
                    case 1://左
                        finalLeft = -(int) (viewWidth * (1 - showPercent));
                        break;
                    case 2://右
                        finalLeft = screenWidth - (int) (viewWidth * showPercent);
                        break;
                    case 3://左右
                        finalLeft = -(int) (viewWidth * (1 - showPercent));
                        if ((curLeft + viewWidth / 2) > screenWidth / 2) {
                            finalLeft = screenWidth - (int) (viewWidth * showPercent);
                        }
                        break;
                }
//                if (onViewReleasedListener != null) {
//                    onViewReleasedListener.onViewReleased(finalLeft);
//                }
//                if (finalTop < SizeUtils.dp2px(90)) {
//                    finalTop = SizeUtils.dp2px(90);
//                }
                boolean flag=mDragHelper.settleCapturedViewAt(finalLeft, finalTop);
                //超出规定的边界值，当lag=true，会重新计算边界位置，触发computeScroll，从新invalidate
                Log.i(Tag,"DraggableLayout--->onViewReleased return :"+ flag);
                invalidate();
            }

            @Override
            public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);
               // Log.i(Tag,"DraggableLayout--->onViewPositionChanged");
            }

            @Override
            public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
                super.onViewCaptured(capturedChild, activePointerId);
                //Log.i(Tag,"DraggableLayout--->onViewCaptured");
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                //Log.i(Tag,"DraggableLayout--->clampViewPositionHorizontal");
                return left;
            }

            @Override
            public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
              //  Log.i(Tag,"DraggableLayout--->clampViewPositionVertical");
                return top;
            }

            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
               // Log.i(Tag,"DraggableLayout--->getViewHorizontalDragRange");
                return getMeasuredWidth()-child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(@NonNull View child) {
             //   Log.i(Tag,"DraggableLayout--->getViewVerticalDragRange");
                return getMeasuredHeight()-child.getMeasuredHeight();
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return isChildViewTouched(event);
    }

    /***
     * 边界计算
     * 计算滑动
     */
    @Override
    public void computeScroll() {
        if (mDragHelper != null && mDragHelper.continueSettling(true)) {
            Log.i(Tag,"computeScroll");
            invalidate();
        }
    }

    /***
     * ChildView是否消费当前事件
     * @param event
     * @return
     */
    public boolean isChildViewTouched(MotionEvent event){
        Rect rect=new Rect();
        if(this.getChildCount()>0){
            for(int i=0;i<this.getChildCount();i++){
                View view=this.getChildAt(i);
                rect.set(view.getLeft(),view.getTop(),view.getLeft()+view.getMeasuredWidth(),view.getTop()+view.getMeasuredHeight());
                if(rect.contains((int)event.getX(),(int)event.getY())){
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ImageView imageView=this.findViewById(R.id.iv_icon);
        if(imageView!=null){
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

package com.pan.viewsample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author:Pan
 * Time:2016/6/23 16:04
 * Description:
 */
public class RectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.GREEN;

    public RectView(Context context) {
        super(context);
        init();
    }

    public RectView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
        init();
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mColor = typedArray.getColor(R.styleable.RectView_rect_color, Color.RED);
        typedArray.recycle();
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //处理padding
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        Rect rect = new Rect(paddingLeft + 0, paddingTop + 0, paddingLeft + width, paddingTop + height);
        canvas.drawRect(rect, mPaint);
    }
}

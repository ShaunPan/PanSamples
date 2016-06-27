package com.pan.viewsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author:Pan
 * Time:2016/6/24 11:44
 * Description:
 */
public class DialView extends View {

    private Bitmap dialBitmap;
    private Bitmap pointerBitmap;
    private float mCurrentProgress;
    private int x;
    private int y;
    private Bitmap finalDialBitmap;
    private Bitmap finalPointerBitmap;

    public DialView(Context context) {
        super(context);
        init(context);
    }

    public DialView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DialView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        dialBitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.load_icon_dial2x));
        pointerBitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.load_icon_pointer2x));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    /**
     * 确定View的最终宽度
     * @param widthMeasureSpec
     * @return 宽度结果
     */
    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        //测量大小
        int size = MeasureSpec.getSize(widthMeasureSpec);
        //测量模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        //当测量模式为EXACTLY时，其代表父容器已经检测出View所需的精确大小，这个时候View的最终大小就是SpecSize所指定的值；
        //它对应match_parent和具体的数值这两种情况
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            //该情况对应wrap_content，取测量大小和View大小两者的最小值为View的最终宽度,没有最大值
            result = pointerBitmap.getWidth();
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, size);
            }
        }
        return result;
    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int size = MeasureSpec.getSize(heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = pointerBitmap.getHeight();
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, size);
            }
        }
        return result;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        x = w;
        y = h;
        finalDialBitmap = Bitmap.createScaledBitmap(dialBitmap, x, y, true);
        finalPointerBitmap = Bitmap.createScaledBitmap(pointerBitmap, x, y, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(finalDialBitmap, 0, 0, null);
        canvas.rotate(mCurrentProgress * 2.7f, x / 2, y / 2);
        canvas.drawBitmap(finalPointerBitmap, 0, 0, null);
    }

    public void setCurrentProgress(float progress) {
        mCurrentProgress = progress;
        invalidate();
    }

}

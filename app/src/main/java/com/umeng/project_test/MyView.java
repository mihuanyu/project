package com.umeng.project_test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private String text;
    private String coler;
    private int size;
    Paint paint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.test);
        text = typedArray.getString(R.styleable.test_text);
        coler = typedArray.getString(R.styleable.test_textcoler);
        size = typedArray.getInteger(R.styleable.test_textsize, 0);
        paint = new Paint();
        paint.setColor(Color.parseColor(coler));
        paint.setTextSize(size);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,0,0,paint);
    }
}

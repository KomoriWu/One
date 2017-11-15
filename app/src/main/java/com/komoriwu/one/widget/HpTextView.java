package com.komoriwu.one.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class HpTextView extends TextView {
    private static final int TITLE= 0;
    private static final int LIGHT = 1;

    public HpTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public HpTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public HpTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }



    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        if (isInEditMode()) return;
        String fontName = "hp_title.ttf";
        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                "fonts/" + fontName), defStyleAttr);
    }
}

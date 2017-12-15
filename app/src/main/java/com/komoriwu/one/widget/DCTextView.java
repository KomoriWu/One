package com.komoriwu.one.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.komoriwu.one.R;

@SuppressLint("AppCompatCustomView")
public class DCTextView extends TextView {

    public DCTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public DCTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DCTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        if (isInEditMode()) return;

        String fontName = "dc_bold.ttf";
        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                "fonts/" + fontName), defStyleAttr);
    }
}

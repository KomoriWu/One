package com.komoriwu.one.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.komoriwu.one.R;

@SuppressLint("AppCompatCustomView")
public class FZTextView extends TextView {

    public FZTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public FZTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public FZTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        if (isInEditMode()) return;

        boolean isBold = false;
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().
                    obtainStyledAttributes(attrs, R.styleable.FZTVStay, defStyleAttr, 0);
            int n = typedArray.getIndexCount();
            for (int i = 0; i < n; i++) {
                int attr = typedArray.getIndex(i);
                if (attr == R.styleable.FZTVStay_isBold) {
                    isBold = typedArray.getBoolean(attr, false);
                }
            }
            typedArray.recycle();
        }

        String fontName = isBold ? "fz_bold.ttf" : "fz_light.ttf";

        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                "fonts/" + fontName), defStyleAttr);
    }
}

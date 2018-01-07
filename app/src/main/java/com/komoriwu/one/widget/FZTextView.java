package com.komoriwu.one.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.VideoCardActivity;
import com.trello.rxlifecycle2.RxLifecycle;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("AppCompatCustomView")
public class FZTextView extends TextView {
    public static final int UPDATE_DELAY = 10;
    private int mIndex;

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

    public void startTypeWriter(VideoCardActivity activity, final String text) {
        final int length = text.length();
        mIndex = length / 2;
        int speed = 1000 / length;
        Flowable.interval(UPDATE_DELAY, speed, TimeUnit.MILLISECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return mIndex <= length;
                    }
                })
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return text.substring(0, mIndex);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.<String>bindToLifecycle())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String str) throws Exception {
                        mIndex++;
                        setText(str);
                    }
                });
    }

}

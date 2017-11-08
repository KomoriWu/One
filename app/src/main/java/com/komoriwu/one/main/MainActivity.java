package com.komoriwu.one.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.all.AllFragment;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.main.mvp.MainContract;
import com.komoriwu.one.main.mvp.MainPresenter;
import com.komoriwu.one.me.MeFragment;
import com.komoriwu.one.one.OneFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpBaseActivity<MainPresenter> implements MainContract.View, RadioGroup.
        OnCheckedChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.frame_content)
    FrameLayout frameContent;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.rb_one)
    RadioButton rbOne;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    private Fragment mCurrentFragment;
    private OneFragment mOneFragment;
    private AllFragment mAllFragment;
    private MeFragment mMeFragment;
    private boolean mRadioChanged;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initToolbar();
        mCurrentFragment = new OneFragment();
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.rb_one);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        mRadioChanged = true;
        presenter.switchNavView(i);
    }

    @Override
    public void switchOneView() {
        if (mOneFragment == null) {
            mOneFragment = new OneFragment();
        }
        switchContent(mCurrentFragment, mOneFragment);
    }

    @Override
    public void switchAllView() {
        if (mAllFragment == null) {
            mAllFragment = new AllFragment();
        }
        switchContent(mCurrentFragment, mAllFragment);
    }

    @Override
    public void switchMeView() {
        if (mMeFragment == null) {
            mMeFragment = new MeFragment();
        }
        switchContent(mCurrentFragment, mMeFragment);
    }

    public void switchContent(Fragment from, Fragment to) {
        if (mCurrentFragment != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                transaction.hide(from).add(R.id.frame_content, to).commit();
            } else {
                // 隐藏当前的fragment，显示下一个
                transaction.hide(from).show(to).commit();
            }
        }
    }

    @Override
    public void showErrorMsg(String msg) {
        Log.d(TAG, msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.rb_one, R.id.rb_all, R.id.rb_me})
    public void onViewClicked(View view) {
        if (!mRadioChanged) {
            switch (view.getId()) {
                case R.id.rb_one:
                    mOneFragment.scrollToTop();
                    break;
                case R.id.rb_all:
                    break;
                case R.id.rb_me:
                    break;
            }
        }
        mRadioChanged = false;
    }

}

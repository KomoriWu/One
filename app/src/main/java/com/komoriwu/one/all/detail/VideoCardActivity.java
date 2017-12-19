package com.komoriwu.one.all.detail;

import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.VideoCardPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;

public class VideoCardActivity extends MvpBaseActivity<VideoCardPresenter> {
    private FindBean.ItemListBeanX mItemListBeanX;
    @Override
    public void setInject() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_video_card;
    }

    @Override
    public void init() {
        mItemListBeanX= (FindBean.ItemListBeanX) getIntent().getSerializableExtra(Constants.
                ITEM_LIST_BEAN_X);
        Toast.makeText(this, mItemListBeanX.getId()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg(String msg) {

    }


}

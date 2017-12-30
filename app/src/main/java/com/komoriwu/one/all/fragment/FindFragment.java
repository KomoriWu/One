package com.komoriwu.one.all.fragment;

import android.content.Intent;

import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.fragment.adapter.CommonAdapter;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class FindFragment extends CommonBaseFragment<FindPresenter> implements OnItemClickListener {

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onLoadList() {
        presenter.loadList();
    }

    @Override
    public void onLoadMoreList() {

    }


}

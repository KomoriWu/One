package com.komoriwu.one.me;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.komoriwu.one.R;
import com.komoriwu.one.all.AllFragment;
import com.komoriwu.one.all.mvp.AllContract;
import com.komoriwu.one.all.mvp.AllPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.me.mvp.MeContract;
import com.komoriwu.one.me.mvp.MePresenter;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.HpTextView;
import com.komoriwu.one.widget.listener.HidingScrollBottomListener;
import com.komoriwu.one.widget.refresh.RefreshLayout;
import com.komoriwu.one.widget.refresh.SwipeRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class MeFragment extends MvpBaseFragment<MePresenter> implements MeContract.View,
        RefreshLayout.OnRefreshListener, MeAdapter.OnItemClickListener {
    private static final String TAG = AllFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_hp_title)
    HpTextView tvHpTitle;
    private MeAdapter mMeAdapter;
    private LinearLayoutManager mLayoutManager;
    private String mNextPageUrl;
    private boolean mIsFirst;
    private List<VideoBean.ItemListBeanX> mOldItemList;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, null);
    }

    @Override
    public void init() {
        tvHpTitle.setVisibility(View.VISIBLE);
        tvHpTitle.setText(R.string.subscription);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.main_text_color, R.color.tv_hint,
                R.color.line_color);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        mMeAdapter = new MeAdapter(getActivity(), this);
        mMeAdapter.openLoadAnimation();
        mMeAdapter.isFirstOnly(false);
        recyclerView.setAdapter(mMeAdapter);
        onRefresh(SwipeRefreshLayoutDirection.TOP);

        initListener();
    }

    private void initListener() {
        recyclerView.addOnScrollListener(new HidingScrollBottomListener(getActivity()) {
            @Override
            public void onHide() {
                ((MainActivity) getActivity()).changeRadioGState(false);
//                ((MainActivity) getActivity()).setToolBarWeatherState(false);
            }

            @Override
            public void onShow() {
                ((MainActivity) getActivity()).changeRadioGState(true);
//                ((MainActivity) getActivity()).setToolBarWeatherState(true);
            }

            @Override
            public void onUpdateDate() {
            }


        });
    }

    public void scrollToTop() {
        mLayoutManager.scrollToPositionWithOffset(0, 0);
        mLayoutManager.setStackFromEnd(true);
    }

    @Override
    public void showErrorMsg(String msg) {
        Log.d(TAG, msg);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh(SwipeRefreshLayoutDirection direction) {
        if (direction == SwipeRefreshLayoutDirection.TOP) {
            refreshLayout.setDirection(SwipeRefreshLayoutDirection.BOTH);
            presenter.loadVideoData();
            mIsFirst = true;
        } else {
            //1512349200000&num=2&page=2",
            if (!TextUtils.isEmpty(mNextPageUrl)) {
                presenter.loadVideoData(Utils.formatUrl(mNextPageUrl).split("&")[0],
                        Utils.formatUrl(mNextPageUrl).split("&")[1].split("=")[1],
                        Utils.formatUrl(mNextPageUrl).split("&")[2].split("=")[1]);
            }
            mIsFirst = false;
        }
    }

    @Override
    public void refreshVideoData(VideoBean videoBean) {
        Log.d(TAG, videoBean.toString());
        mOldItemList = new ArrayList<>();
        mOldItemList.addAll(videoBean.getItemList());
        mNextPageUrl = videoBean.getNextPageUrl();
        if (TextUtils.isEmpty(mNextPageUrl)) {
            Toast.makeText(getActivity(), R.string.end_hint, Toast.LENGTH_SHORT).show();
            refreshLayout.setDirection(SwipeRefreshLayoutDirection.TOP);
        }

        for (int i = 0; i < mOldItemList.size(); i++) {
            String type = mOldItemList.get(i).getType();
            String dataType = mOldItemList.get(i).getData().getDataType();
            if (!type.equals(Constants.VIDEO_TYPE) && !dataType.equals(Constants.
                    VIDEO_DATA_TYPE)) {
                videoBean.getItemList().remove(mOldItemList.get(i));
            }
        }
        mMeAdapter.addVideoListData(videoBean.getItemList(), mIsFirst);
    }

    @Override
    public void showRefresh() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void hideRefresh() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onItemClick(VideoBean.ItemListBeanX itemListBeanX) {
        ((MainActivity) getActivity()).showPopup(itemListBeanX, tvHpTitle);
    }

}
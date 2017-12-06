package com.komoriwu.one.all;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.all.mvp.AllContract;
import com.komoriwu.one.all.mvp.AllPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.listener.HidingScrollBottomListener;
import com.komoriwu.one.widget.refresh.RefreshLayout;
import com.komoriwu.one.widget.refresh.SwipeRefreshLayoutDirection;

import org.reactivestreams.Publisher;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class AllFragment extends MvpBaseFragment<AllPresenter> implements AllContract.View, RefreshLayout.OnRefreshListener {
    private static final String TAG = AllFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;
    private AllAdapter mAllAdapter;
    private LinearLayoutManager mLayoutManager;
    private String mNextPageUrl;
    private boolean mIsFirst;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all, null);
    }

    @Override
    public void init() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.main_text_color, R.color.tv_hint,
                R.color.line_color);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        mAllAdapter = new AllAdapter(getActivity());
        recyclerView.setAdapter(mAllAdapter);
        onRefresh(SwipeRefreshLayoutDirection.TOP);

        initListener();
    }

    private void initListener() {
        recyclerView.addOnScrollListener(new HidingScrollBottomListener() {
            @Override
            public void onHide() {
                ((MainActivity) getActivity()).changeRadioGState(false);
                ((MainActivity) getActivity()).setToolBarWeatherState(false);
            }

            @Override
            public void onShow() {
                ((MainActivity) getActivity()).changeRadioGState(true);
                ((MainActivity) getActivity()).setToolBarWeatherState(true);
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
            mIsFirst=true;
        } else {
            //1512349200000&num=2&page=2",
            if (!TextUtils.isEmpty(mNextPageUrl)) {
                presenter.loadVideoData(Utils.formatUrl(mNextPageUrl).split("&")[0],
                        Utils.formatUrl(mNextPageUrl).split("&")[1].split("=")[1],
                        Utils.formatUrl(mNextPageUrl).split("&")[2].split("=")[1]);
            }
            mIsFirst=false;
        }
    }

    @Override
    public void refreshVideoData(VideoBean videoBean) {
        Log.d(TAG, videoBean.toString());
        mNextPageUrl = videoBean.getNextPageUrl();
        if (TextUtils.isEmpty(mNextPageUrl)) {
            Toast.makeText(getActivity(), R.string.end_hint, Toast.LENGTH_SHORT).show();
            refreshLayout.setDirection(SwipeRefreshLayoutDirection.TOP);
        }
        mAllAdapter.addVideoListData(videoBean.getItemList(),mIsFirst);
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

}

package com.komoriwu.one.one;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.one.mvp.OneContract;
import com.komoriwu.one.one.mvp.OnePresenter;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class OneFragment extends MvpBaseFragment<OnePresenter> {
    public static final String TAG = OneFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private OneAdapter mOneAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, null);
    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getOneList(new OneContract.LoadOneListData() {
            @Override
            public void onSuccess(OneListBean oneListBean) {
                mOneAdapter=new OneAdapter(oneListBean,getActivity());
                recyclerView.setAdapter(mOneAdapter);
            }
        });
    }

    @Override
    public void showErrorMsg(String msg) {
        Log.d(TAG, msg);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}

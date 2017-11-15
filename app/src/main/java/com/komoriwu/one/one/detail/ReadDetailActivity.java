package com.komoriwu.one.one.detail;

import android.graphics.Bitmap;

import com.komoriwu.one.R;
import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.ContentListBean;
import com.komoriwu.one.one.detail.mvp.ReadDetailContract;
import com.komoriwu.one.one.detail.mvp.ReadDetailPresenter;
import com.komoriwu.one.utils.Constants;

import java.io.IOException;

import butterknife.BindView;
import cn.droidlover.xrichtext.ImageLoader;
import cn.droidlover.xrichtext.XRichText;

public class ReadDetailActivity extends MvpBaseActivity<ReadDetailPresenter> implements
        ReadDetailContract.View {
    @BindView(R.id.rich_text)
    XRichText richText;
    private ContentListBean mContentListBean;
    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_read_detail;
    }


    @Override
    public void init() {
//        presenter.loadReadDetail(0);
        mContentListBean= (ContentListBean) getIntent().getSerializableExtra(Constants.
                ONE_LIST_BEAN);
        presenter.loadDetail(mContentListBean);
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    Bitmap bitmap;

    @Override
    public void showContent(String content) {

        richText.callback(new XRichText.BaseClickCallback() {
            @Override
            public void onFix(XRichText.ImageHolder holder) {
                super.onFix(holder);
                //设置宽高
                holder.setWidth(richText.getWidth());
                int height = bitmap.getHeight() * (richText.getWidth() / bitmap.getWidth());
                holder.setHeight(height < 800 ? 800 : height);
            }
        })
                .imageDownloader(new ImageLoader() {
                    @Override
                    public Bitmap getBitmap(String url) throws IOException {
                        bitmap = MyApplication.getImageLoader(ReadDetailActivity.this).
                                loadImageSync(url);
                        return bitmap;
                    }
                })
                .text(content);
    }
}

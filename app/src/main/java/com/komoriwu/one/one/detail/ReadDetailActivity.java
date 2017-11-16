package com.komoriwu.one.one.detail;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.AuthorBean;
import com.komoriwu.one.model.bean.CommentBean;
import com.komoriwu.one.model.bean.ContentListBean;
import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.one.detail.mvp.ReadDetailContract;
import com.komoriwu.one.one.detail.mvp.ReadDetailPresenter;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.io.IOException;

import butterknife.BindView;
import cn.droidlover.xrichtext.ImageLoader;
import cn.droidlover.xrichtext.XRichText;

public class ReadDetailActivity extends MvpBaseActivity<ReadDetailPresenter> implements
        ReadDetailContract.View {
    @BindView(R.id.rich_text)
    XRichText richText;
    @BindView(R.id.tv_detail_title)
    TextView tvDetailTitle;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.iv_author)
    ImageView ivAuthor;
    @BindView(R.id.tv_hp_author)
    TextView tvHpAuthor;
    @BindView(R.id.tv_auth_it)
    TextView tvAuthIt;
    @BindView(R.id.tv_recommend)
    TextView tvRecommend;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ContentListBean mContentListBean;
    private Bitmap mBitmap;
    private CommentAdapter mCommentAdapter;

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
        initToolbar();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mContentListBean = (ContentListBean) getIntent().getSerializableExtra(Constants.
                ONE_LIST_BEAN);
        tvTitle.setText(mContentListBean.getShareList().getWx().getTitle().split("\\|")[0].
                trim());
        tvDetailTitle.setText(mContentListBean.getTitle());
        tvUserName.setText(mContentListBean.getShareList().getWx().getDesc().split(" ")
                [0].trim());
        presenter.loadDetail(mContentListBean);
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showReadData(ReadDetailBean readDetailBean) {
        richText.callback(new XRichText.BaseClickCallback() {
            @Override
            public void onFix(XRichText.ImageHolder holder) {
                super.onFix(holder);
                //设置宽高
                holder.setWidth(richText.getWidth());
                int height = mBitmap.getHeight() * (richText.getWidth() / mBitmap.getWidth());
                holder.setHeight(height < 800 ? 800 : height);
            }
        })
                .imageDownloader(new ImageLoader() {
                    @Override
                    public Bitmap getBitmap(String url) throws IOException {
                        mBitmap = MyApplication.getImageLoader(ReadDetailActivity.this).
                                loadImageSync(url);
                        return mBitmap;
                    }
                })
                .text(readDetailBean.getHpContent().split("</head>")[1].replace(
                        "\\s",""));
        tvIntroduce.setText(readDetailBean.getHpAuthorIntroduce() + " " + readDetailBean.
                getEditorEmail());
        AuthorBean authorBean = readDetailBean.getAuthor().get(0);
        Utils.displayImage(this, authorBean.getWebUrl(), ivAuthor, Utils.getImageOptions(
                R.mipmap.ic_launcher_round, 360));
        tvHpAuthor.setText(authorBean.getUserName() + " " + authorBean.getWbName());
        tvAuthIt.setText(authorBean.getDesc());
    }

    @Override
    public void showMovieData(MovieDetailBean readDetailBean) {

    }

    @Override
    public void showMusicData(MusicDetailBean musicDetailBean) {

    }

    @Override
    public void showReadCommend(CommentBean commentBean) {
        mCommentAdapter = new CommentAdapter(this, commentBean);
        recyclerView.setAdapter(mCommentAdapter);
    }
}

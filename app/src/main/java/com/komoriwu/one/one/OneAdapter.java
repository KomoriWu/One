package com.komoriwu.one.one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.ContentListBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-11-06.
 */

public class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OneListBean mOneListBean;
    private ContentListBean mContentListBean;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private enum ITEM_TYPE {
        CATEGORY_COMMON,
        CATEGORY_REPORTER,
        CATEGORY_MUSIC,
        CATEGORY_MOVIE,
        CATEGORY_ADVERTISE,
        CATEGORY_RADIO
    }

    public OneAdapter(Context mContext, OnItemClickListener mOnItemClickListener) {
        this.mContext = mContext;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void addOneListData(OneListBean oneListBean, boolean isFirst) {
        if (isFirst) {
            this.mOneListBean = oneListBean;
        } else {
            this.mOneListBean.getContentList().addAll(oneListBean.getContentList());
        }
//        notifyDataSetChanged();
        //局部刷新
        for (int i = getItemCount(); i < mOneListBean.getContentList().size(); i++) {
            notifyItemInserted(i);
        }

    }

    public List<ContentListBean> getContentList() {
        return mOneListBean.getContentList();
    }

    public String getDate(int position) {
        return Utils.formatDate(mOneListBean.getContentList().get(position).getPostDate());
    }

    @Override
    public int getItemViewType(int position) {
        mContentListBean = mOneListBean.getContentList().get(position);
        int type;
        switch (Integer.parseInt(mContentListBean.getCategory())) {
            case Constants.CATEGORY_REPORTER:
                type = ITEM_TYPE.CATEGORY_REPORTER.ordinal();
                break;
            case Constants.CATEGORY_MUSIC:
                type = ITEM_TYPE.CATEGORY_MUSIC.ordinal();
                break;
            case Constants.CATEGORY_MOVIE:
                type = ITEM_TYPE.CATEGORY_MOVIE.ordinal();
                break;
            case Constants.CATEGORY_ADVERTISE:
                type = ITEM_TYPE.CATEGORY_ADVERTISE.ordinal();
                break;
            case Constants.CATEGORY_RADIO:
                type = ITEM_TYPE.CATEGORY_RADIO.ordinal();
                break;
            default:
                type = ITEM_TYPE.CATEGORY_COMMON.ordinal();
                break;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (viewType == ITEM_TYPE.CATEGORY_REPORTER.ordinal()) {
            return new OneReportedViewHolder(layoutInflater.inflate(R.layout.item_one_reported, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_MUSIC.ordinal()) {
            return new OneMusicViewHolder(layoutInflater.inflate(R.layout.item_one_music, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_MOVIE.ordinal()) {
            return new OneMovieViewHolder(layoutInflater.inflate(R.layout.item_one_movie, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_ADVERTISE.ordinal()) {
            if (TextUtils.isEmpty(mContentListBean.getAuthor().getUserId())) {
                return new OneAdvertiseViewHolder(layoutInflater.inflate(R.layout.item_one_advertise,
                        parent, false));
            } else {
                return new OneViewHolder(layoutInflater.inflate(R.layout.item_one_common, parent,
                        false));
            }
        } else if (viewType == ITEM_TYPE.CATEGORY_RADIO.ordinal()) {
            return new OneRadioViewHolder(layoutInflater.inflate(R.layout.item_one_radio, parent,
                    false));
        } else {
            return new OneViewHolder(layoutInflater.inflate(R.layout.item_one_common, parent,
                    false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof OneAdvertiseViewHolder) {
            Utils.displayImage(mContext, mContentListBean.getImgUrl(), ((OneAdvertiseViewHolder)
                    viewHolder).ivAdvertise);
        } else if (viewHolder instanceof OneRadioViewHolder) {
            radioHolder(((OneRadioViewHolder) viewHolder));
        } else {
            otherHolder(viewHolder, position);
        }
    }

    private void radioHolder(OneRadioViewHolder holder) {
        if (TextUtils.isEmpty(mContentListBean.getAuthor().getUserName())) {
            holder.ivLogo.setVisibility(View.GONE);
            holder.layoutRadio.setVisibility(View.GONE);
            holder.ivCoverBg.setVisibility(View.GONE);
            holder.ivVoice.setVisibility(View.VISIBLE);
            holder.ivAuthor.setImageResource(0);
            holder.tvTitle2.setText(mContentListBean.getTitle());
            holder.tvLikeNum.setText(String.valueOf(mContentListBean.getLikeCount()));
            Utils.displayImage(mContext, mContentListBean.getImgUrl(), holder.ivCover);
        } else {
            holder.ivVoice.setVisibility(View.GONE);
            holder.ivLogo.setVisibility(View.VISIBLE);
            holder.layoutRadio.setVisibility(View.VISIBLE);
            holder.ivCoverBg.setVisibility(View.VISIBLE);
            holder.tvVolume.setText(mContentListBean.getVolume());
            holder.tvTitle.setText(mContentListBean.getTitle());
            holder.tvTitle2.setText("");
            holder.tvLikeNum.setText(String.valueOf(mContentListBean.getLikeCount()));
            holder.tvUserName.setText(mContentListBean.getAuthor().getUserName());
            Utils.displayImage(mContext, mContentListBean.getImgUrl(), holder.ivCover);
            Utils.displayImage(mContext, mContentListBean.getAuthor().getWebUrl(), holder.ivAuthor,
                    Utils.getImageOptions(R.mipmap.ic_launcher_round, 360));
        }
    }

    @SuppressLint("SetTextI18n")
    private void otherHolder(RecyclerView.ViewHolder viewHolder, int position) {
        OneViewHolder holder = ((OneViewHolder) viewHolder);
        if (getItemViewType(position) == ITEM_TYPE.CATEGORY_MUSIC.ordinal()) {
            ((OneMusicViewHolder) holder).tvMusicInfo.setText(mContentListBean.getMusicName() +
                    " · " + mContentListBean.getAudioAuthor() + " | " + mContentListBean.
                    getAudioAlbum());
            Utils.displayImage(mContext, mContentListBean.getImgUrl(), holder.ivCover, Utils.
                    getImageOptions(R.mipmap.ic_launcher_round, 360));
        } else {
            Utils.displayImage(mContext, mContentListBean.getImgUrl(), holder.ivCover);
        }

        if (getItemViewType(position) == ITEM_TYPE.CATEGORY_REPORTER.ordinal()) {
            if (mContentListBean.getTitle().equals(Constants.ILLUSTRATION)) {
                ((OneReportedViewHolder) holder).ivCoverIllustration.setVisibility(View.VISIBLE);
                holder.ivCover.setVisibility(View.GONE);
                Utils.displayImage(mContext, mContentListBean.getImgUrl(), ((
                        OneReportedViewHolder) holder).ivCoverIllustration);
            } else {
                ((OneReportedViewHolder) holder).ivCoverIllustration.setVisibility(View.GONE);
                holder.ivCover.setVisibility(View.VISIBLE);
                Utils.displayImage(mContext, mContentListBean.getImgUrl(), holder.ivCover);
            }
            holder.tvCategory.setText(mContentListBean.getTitle() + " | " + mContentListBean.
                    getPicInfo());
            holder.tvUserName.setText(mContentListBean.getWords_info().trim());
            //是否显示head的分割线
            ((OneReportedViewHolder) holder).viewLine.setVisibility(position == 0 ? View.GONE :
                    View.VISIBLE);
        } else {
            if (getItemViewType(position) == ITEM_TYPE.CATEGORY_ADVERTISE.ordinal()) {
                //是COMMON 类型的广告
                holder.tvCategory.setText(String.format(mContext.getString(R.string.category),
                        mContentListBean.getTagList().get(0).getTitle().trim()));
            } else {
                holder.tvCategory.setText(String.format(mContext.getString(R.string.category),
                        mContentListBean.getShareList().getWx().getTitle().split("\\|")[0].
                                trim()));
            }
            holder.tvUserName.setText(mContentListBean.getAnswerer() == null ?
                    mContentListBean.getShareList().getWx().getDesc().split(" ")[0].
                            trim() : String.format(mContext.getString(R.string.answerer),
                    mContentListBean.getAnswerer().getUserName()));
            holder.tvPostDate.setText(Utils.showDate(mContext, mContentListBean.getPostDate()));
        }

        if (getItemViewType(position) == ITEM_TYPE.CATEGORY_MOVIE.ordinal()) {
            ((OneMovieViewHolder) holder).tvSubtitle.setText(String.format(mContext.getString(R.
                            string.subtitle),
                    mContentListBean.getSubtitle()));
        }

        holder.tvTitle.setText(mContentListBean.getTitle());
        holder.tvForward.setText(mContentListBean.getForward());
        holder.tvLikeNum.setText(String.valueOf(mContentListBean.getLikeCount()));
    }

    @Override
    public int getItemCount() {
        return mOneListBean == null ? 0 : mOneListBean.getContentList().size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_forward)
        TextView tvForward;
        @BindView(R.id.tv_post_date)
        TextView tvPostDate;
        @BindView(R.id.iv_share)
        ImageView ivShare;
        @BindView(R.id.iv_like)
        ImageView ivLike;
        @BindView(R.id.tv_like_num)
        TextView tvLikeNum;


        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    class OneMusicViewHolder extends OneViewHolder {
        @BindView(R.id.tv_music_info)
        TextView tvMusicInfo;
        @BindView(R.id.iv_play)
        ImageView ivPlay;

        public OneMusicViewHolder(View itemView) {
            super(itemView);
        }
    }

    class OneMovieViewHolder extends OneViewHolder {
        @BindView(R.id.tv_subtitle)
        TextView tvSubtitle;

        public OneMovieViewHolder(View itemView) {
            super(itemView);
        }
    }

    class OneReportedViewHolder extends OneViewHolder {
        @BindView(R.id.iv_cover_illustration)
        ImageView ivCoverIllustration;
        @BindView(R.id.view_line)
        View viewLine;

        public OneReportedViewHolder(View itemView) {
            super(itemView);
        }
    }

    class OneAdvertiseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_advertise)
        ImageView ivAdvertise;

        public OneAdvertiseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class OneRadioViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_play)
        ImageView ivPlay;
        @BindView(R.id.tv_volume)
        TextView tvVolume;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.view_line)
        View viewLine;
        @BindView(R.id.iv_author)
        ImageView ivAuthor;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.iv_share)
        ImageView ivShare;
        @BindView(R.id.iv_like)
        ImageView ivLike;
        @BindView(R.id.tv_like_num)
        TextView tvLikeNum;
        @BindView(R.id.layout_bottom)
        RelativeLayout layoutBottom;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.iv_logo)
        ImageView ivLogo;
        @BindView(R.id.layout_radio)
        RelativeLayout layoutRadio;
        @BindView(R.id.iv_cover_bg)
        ImageView ivCoverBg;
        @BindView(R.id.iv_voice)
        ImageView ivVoice;
        @BindView(R.id.tv_title2)
        TextView tvTitle2;

        public OneRadioViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

package com.komoriwu.one.model.bean;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-11-14.
 */

public class ContentListBean implements Serializable {
    private String id;
    private String category;
    private int display_category;
    private String item_id;
    private String title;
    private String forward;
    private String img_url;
    private int like_count;
    private String post_date;
    private String last_update_date;
    private AuthorBean author;
    private String video_url;
    private String audio_url;
    private int audio_platform;
    private String start_video;
    private int has_reading;
    private String volume;
    private String pic_info;
    private String words_info;
    private String subtitle;
    private int number;
    private int serial_id;
    private int movie_story_id;
    private int ad_id;
    private int ad_type;
    private String ad_pvurl;
    private String ad_linkurl;
    private String ad_makettime;
    private String ad_closetime;
    private String ad_share_cnt;
    private String ad_pvurl_vendor;
    private String content_id;
    private String content_type;
    private String content_bgcolor;
    private String share_url;
    private ShareInfoBean share_info;
    private ShareListBean share_list;
    private String orientation;
    private AnswererBean answerer;
    private String music_name;
    private String audio_author;
    private String audio_album;
    private String cover;
    private String bg_color;
    private List<?> serial_list;
    private List<TagBean> tag_list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDisplay_category() {
        return display_category;
    }

    public void setDisplay_category(int display_category) {
        this.display_category = display_category;
    }

    public String getItemId() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getLikeCount() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getPostDate() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public int getAudio_platform() {
        return audio_platform;
    }

    public void setAudio_platform(int audio_platform) {
        this.audio_platform = audio_platform;
    }

    public String getStart_video() {
        return start_video;
    }

    public void setStart_video(String start_video) {
        this.start_video = start_video;
    }

    public int getHas_reading() {
        return has_reading;
    }

    public void setHas_reading(int has_reading) {
        this.has_reading = has_reading;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPic_info() {
        return pic_info;
    }

    public void setPic_info(String pic_info) {
        this.pic_info = pic_info;
    }

    public String getWords_info() {
        return words_info;
    }

    public void setWords_info(String words_info) {
        this.words_info = words_info;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(int serial_id) {
        this.serial_id = serial_id;
    }

    public int getMovie_story_id() {
        return movie_story_id;
    }

    public void setMovie_story_id(int movie_story_id) {
        this.movie_story_id = movie_story_id;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public int getAd_type() {
        return ad_type;
    }

    public void setAd_type(int ad_type) {
        this.ad_type = ad_type;
    }

    public String getAd_pvurl() {
        return ad_pvurl;
    }

    public void setAd_pvurl(String ad_pvurl) {
        this.ad_pvurl = ad_pvurl;
    }

    public String getAd_linkurl() {
        return ad_linkurl;
    }

    public void setAd_linkurl(String ad_linkurl) {
        this.ad_linkurl = ad_linkurl;
    }

    public String getAd_makettime() {
        return ad_makettime;
    }

    public void setAd_makettime(String ad_makettime) {
        this.ad_makettime = ad_makettime;
    }

    public String getAd_closetime() {
        return ad_closetime;
    }

    public void setAd_closetime(String ad_closetime) {
        this.ad_closetime = ad_closetime;
    }

    public String getAd_share_cnt() {
        return ad_share_cnt;
    }

    public void setAd_share_cnt(String ad_share_cnt) {
        this.ad_share_cnt = ad_share_cnt;
    }

    public String getAd_pvurl_vendor() {
        return ad_pvurl_vendor;
    }

    public void setAd_pvurl_vendor(String ad_pvurl_vendor) {
        this.ad_pvurl_vendor = ad_pvurl_vendor;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getContent_bgcolor() {
        return content_bgcolor;
    }

    public void setContent_bgcolor(String content_bgcolor) {
        this.content_bgcolor = content_bgcolor;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public ShareListBean getShareList() {
        return share_list;
    }

    public void setShare_list(ShareListBean share_list) {
        this.share_list = share_list;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public AnswererBean getAnswerer() {
        return answerer;
    }

    public void setAnswerer(AnswererBean answerer) {
        this.answerer = answerer;
    }

    public String getMusicName() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getAudioAuthor() {
        return audio_author;
    }

    public void setAudio_author(String audio_author) {
        this.audio_author = audio_author;
    }

    public String getAudioAlbum() {
        return audio_album;
    }

    public void setAudio_album(String audio_album) {
        this.audio_album = audio_album;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public List<?> getSerial_list() {
        return serial_list;
    }

    public void setSerial_list(List<?> serial_list) {
        this.serial_list = serial_list;
    }

    public List<TagBean> getTagList() {
        return tag_list;
    }

    public void setTag_list(List<TagBean> tag_list) {
        this.tag_list = tag_list;
    }


    public static class TagBean implements Serializable{
        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class ShareInfoBean implements Serializable{
        /**
         * url : http://m.wufazhuce.com/one/1886
         * image : http://image.wufazhuce.com/Fgaeu-9Rbz06EOUiGjMT-kEgkkSX
         * title : VOL.1857
         * content : “喜欢过，分开了”，原因过程都不问，只要还有一句“不后悔” ，那便已经是一段完美关系了。
         */

        private String url;
        private String image;
        private String title;
        private String content;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


    public static class AnswererBean implements Serializable{
        /**
         * user_id : 8528207
         * user_name : 所长
         * desc : 所长，17岁获首届新概念作文大赛一等奖；22岁时当上记者；31岁时成为一个混血小美男的妈。如今是一枚热爱研究育儿、健身、买买买、回春术和撒娇的阿姨。欢迎你们来女神事务所找我玩耍，在变得更温柔，更强大，更美丽的道路上前进。公众号：女神事务所（ID:ladyrichrich）。
         * wb_name :
         * is_settled : 0
         * settled_type : 0
         * summary : 所长，公众号：女神事务所。
         * fans_total : 114
         * web_url : http://image.wufazhuce.com/FpZzWPVMyzOL0Z8lD9f9EEZm1NkH
         */

        private String user_id;
        private String user_name;
        private String desc;
        private String wb_name;
        private String is_settled;
        private String settled_type;
        private String summary;
        private String fans_total;
        private String web_url;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUserName() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getWb_name() {
            return wb_name;
        }

        public void setWb_name(String wb_name) {
            this.wb_name = wb_name;
        }

        public String getIs_settled() {
            return is_settled;
        }

        public void setIs_settled(String is_settled) {
            this.is_settled = is_settled;
        }

        public String getSettled_type() {
            return settled_type;
        }

        public void setSettled_type(String settled_type) {
            this.settled_type = settled_type;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getFans_total() {
            return fans_total;
        }

        public void setFans_total(String fans_total) {
            this.fans_total = fans_total;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
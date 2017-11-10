package com.komoriwu.one.model.bean;

/**
 * Created by KomoriWu
 * on 2017-11-10.
 */

public  class ShareListBean {
    private WxBean wx;
    private WxTimelineBean wx_timeline;
    private WeiboBean weibo;
    private QqBean qq;

    public WxBean getWx() {
        return wx;
    }

    public void setWx(WxBean wx) {
        this.wx = wx;
    }

    public WxTimelineBean getWx_timeline() {
        return wx_timeline;
    }

    public void setWx_timeline(WxTimelineBean wx_timeline) {
        this.wx_timeline = wx_timeline;
    }

    public WeiboBean getWeibo() {
        return weibo;
    }

    public void setWeibo(WeiboBean weibo) {
        this.weibo = weibo;
    }

    public QqBean getQq() {
        return qq;
    }

    public void setQq(QqBean qq) {
        this.qq = qq;
    }

    public static class WxBean {
        /**
         * title : ONE STORY | 月光落在哪只手上
         * desc : 文/胡不归 每天有亿万个念头在城市上空交汇，念头与念头之间又开辟了无数的岔路。
         * link : http://m.wufazhuce.com/article/2897?channel=singlemessage
         * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
         * audio :
         */

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
    }

    public static class WxTimelineBean {
        /**
         * title : ONE STORY | 月光落在哪只手上
         * desc : 文/胡不归 每天有亿万个念头在城市上空交汇，念头与念头之间又开辟了无数的岔路。
         * link : http://m.wufazhuce.com/article/2897?channel=timeline
         * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
         * audio :
         */

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
    }

    public static class WeiboBean {
        /**
         * title : ONE一个《ONE STORY | 月光落在哪只手上》 文/胡不归： 每天有亿万个念头在城市上空交汇，念头与念头之间又开辟了无数的岔路。 阅读全文：http://m.wufazhuce.com/article/2897?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874
         * desc :
         * link : http://m.wufazhuce.com/article/2897?channel=weibo
         * imgUrl :
         * audio :
         */

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
    }

    public static class QqBean {
        /**
         * title : 月光落在哪只手上
         * desc : 每天有亿万个念头在城市上空交汇，念头与念头之间又开辟了无数的岔路。
         * link : http://m.wufazhuce.com/article/2897?channel=qq
         * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
         * audio :
         */

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
    }
}
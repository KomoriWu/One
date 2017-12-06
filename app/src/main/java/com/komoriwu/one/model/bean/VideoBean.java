package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-06.
 */

public class VideoBean {
    private int count;
    private int total;
    private String nextPageUrl;
    private boolean adExist;
    private long date;
    private long nextPublishTime;
    private Object dialog;
    private Object topIssue;
    private int refreshCount;
    private int lastStartId;
    private List<ItemListBeanX> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public boolean isAdExist() {
        return adExist;
    }

    public void setAdExist(boolean adExist) {
        this.adExist = adExist;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public Object getTopIssue() {
        return topIssue;
    }

    public void setTopIssue(Object topIssue) {
        this.topIssue = topIssue;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(int refreshCount) {
        this.refreshCount = refreshCount;
    }

    public int getLastStartId() {
        return lastStartId;
    }

    public void setLastStartId(int lastStartId) {
        this.lastStartId = lastStartId;
    }

    public List<ItemListBeanX> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBeanX {
        /**
         * type : video
         * data : {"dataType":"VideoBeanForClient","id":64537,"title":"特条 |「公牛历险记」定档预告","slogan":"2018 开年首部好莱坞动画欢脱来袭","description":"由好莱坞著名动画制作团队蓝天工作室倾力打造的「公牛历险记」定档 2018 年 1 月 19 日。影片根据 1936 年出版的西班牙经典故事改编，1938 年曾被迪士尼制作成动画短片，获当年奥斯卡最佳动画短片奖。公牛「费迪南」生性温柔善良，不喜角斗，却因一场意外被误解成凶恶的野兽，被送往他乡成为「斗牛」。为了重返家园过平静日子，费迪南踏上一场意外的冒险旅程。","provider":{"name":"投稿","alias":"PGC2","icon":""},"category":"预告","author":{"id":2173,"icon":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","name":"开眼预告精选","description":"电影、剧集、戏剧抢先看","link":"","latestReleaseTime":1512537084000,"videoNum":403,"adTrack":null,"follow":{"itemType":"author","itemId":2173,"followed":false},"shield":{"itemType":"author","itemId":2173,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true},"cover":{"feed":"http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/aa404baf0a9c15dc1e57e9db7b8f41ee.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=default&source=aliyun","thumbPlayUrl":"","duration":155,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=64537","forWeibo":"http://www.eyepetizer.net/detail.html?vid=64537"},"releaseTime":1512534291000,"library":"DAILY","playInfo":[{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun","size":30570169},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=qcloud","size":30570169},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=ucloud","size":30570169}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun"}],"consumption":{"collectionCount":101,"shareCount":181,"replyCount":7},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":154,"name":"喜剧","actionUrl":"eyepetizer://tag/154/?title=%E5%96%9C%E5%89%A7","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/c3076dda6eeb73de6227e3af243b0561.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/c3076dda6eeb73de6227e3af243b0561.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"},{"id":136,"name":"温情","actionUrl":"eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/0bc1dc78c631eae017ee69418303adc5.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/0bc1dc78c631eae017ee69418303adc5.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"},{"id":456,"name":"蓝天工作室","actionUrl":"eyepetizer://tag/456/?title=%E8%93%9D%E5%A4%A9%E5%B7%A5%E4%BD%9C%E5%AE%A4","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/b8a73ef30f4ec518398bcee80a5051df.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/b8a73ef30f4ec518398bcee80a5051df.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL"},{"id":182,"name":"冒险","actionUrl":"eyepetizer://tag/182/?title=%E5%86%92%E9%99%A9","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/5ceee13e43098e32880cb76112e0a45b.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/5ceee13e43098e32880cb76112e0a45b.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL"},{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/c4e5c0f76d21abbd23c9626af3c9f481.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/88da8548d31005032c37df4889d2104c.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"}],"type":"NORMAL","titlePgc":"","descriptionPgc":"","remark":null,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1512522000000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"由好莱坞著名动画制作团队蓝天工作室倾力打造的「公牛历险记」定档 2018 年 1 月 19 日。影片根据 1936 年出版的西班牙经典故事改编，1938 年曾被迪士尼制作成动画短片，获当年奥斯卡最佳动画短片奖。公牛「费迪南」生性温柔善良，不喜角斗，却因一场意外被误解成凶恶的野兽，被送往他乡成为「斗牛」。为了重返家园过平静日子，费迪南踏上一场意外的冒险旅程。","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null}
         * tag : 0
         * id : 0
         */

        private String type;
        private DataBean data;
        private String tag;
        private int id;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static class DataBean {
            /**
             * dataType : VideoBeanForClient
             * id : 64537
             * title : 特条 |「公牛历险记」定档预告
             * slogan : 2018 开年首部好莱坞动画欢脱来袭
             * description : 由好莱坞著名动画制作团队蓝天工作室倾力打造的「公牛历险记」定档 2018 年 1 月 19 日。影片根据 1936 年出版的西班牙经典故事改编，1938 年曾被迪士尼制作成动画短片，获当年奥斯卡最佳动画短片奖。公牛「费迪南」生性温柔善良，不喜角斗，却因一场意外被误解成凶恶的野兽，被送往他乡成为「斗牛」。为了重返家园过平静日子，费迪南踏上一场意外的冒险旅程。
             * provider : {"name":"投稿","alias":"PGC2","icon":""}
             * category : 预告
             * author : {"id":2173,"icon":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","name":"开眼预告精选","description":"电影、剧集、戏剧抢先看","link":"","latestReleaseTime":1512537084000,"videoNum":403,"adTrack":null,"follow":{"itemType":"author","itemId":2173,"followed":false},"shield":{"itemType":"author","itemId":2173,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true}
             * cover : {"feed":"http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/aa404baf0a9c15dc1e57e9db7b8f41ee.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
             * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=default&source=aliyun
             * thumbPlayUrl :
             * duration : 155
             * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=64537","forWeibo":"http://www.eyepetizer.net/detail.html?vid=64537"}
             * releaseTime : 1512534291000
             * library : DAILY
             * playInfo : [{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun","size":30570169},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=qcloud","size":30570169},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=ucloud","size":30570169}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun"}]
             * consumption : {"collectionCount":101,"shareCount":181,"replyCount":7}
             * campaign : null
             * waterMarks : null
             * adTrack : null
             * tags : [{"id":154,"name":"喜剧","actionUrl":"eyepetizer://tag/154/?title=%E5%96%9C%E5%89%A7","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/c3076dda6eeb73de6227e3af243b0561.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/c3076dda6eeb73de6227e3af243b0561.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"},{"id":136,"name":"温情","actionUrl":"eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/0bc1dc78c631eae017ee69418303adc5.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/0bc1dc78c631eae017ee69418303adc5.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"},{"id":456,"name":"蓝天工作室","actionUrl":"eyepetizer://tag/456/?title=%E8%93%9D%E5%A4%A9%E5%B7%A5%E4%BD%9C%E5%AE%A4","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/b8a73ef30f4ec518398bcee80a5051df.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/b8a73ef30f4ec518398bcee80a5051df.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL"},{"id":182,"name":"冒险","actionUrl":"eyepetizer://tag/182/?title=%E5%86%92%E9%99%A9","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/5ceee13e43098e32880cb76112e0a45b.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/5ceee13e43098e32880cb76112e0a45b.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL"},{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/c4e5c0f76d21abbd23c9626af3c9f481.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/88da8548d31005032c37df4889d2104c.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"}]
             * type : NORMAL
             * titlePgc :
             * descriptionPgc :
             * remark : null
             * idx : 0
             * shareAdTrack : null
             * favoriteAdTrack : null
             * webAdTrack : null
             * date : 1512522000000
             * promotion : null
             * label : null
             * labelList : []
             * descriptionEditor : 由好莱坞著名动画制作团队蓝天工作室倾力打造的「公牛历险记」定档 2018 年 1 月 19 日。影片根据 1936 年出版的西班牙经典故事改编，1938 年曾被迪士尼制作成动画短片，获当年奥斯卡最佳动画短片奖。公牛「费迪南」生性温柔善良，不喜角斗，却因一场意外被误解成凶恶的野兽，被送往他乡成为「斗牛」。为了重返家园过平静日子，费迪南踏上一场意外的冒险旅程。
             * collected : false
             * played : false
             * subtitles : []
             * lastViewTime : null
             * playlists : null
             */

            private String dataType;
            private int id;
            private String title;
            private String slogan;
            private String description;
            private ProviderBean provider;
            private String category;
            private AuthorBean author;
            private CoverBean cover;
            private String playUrl;
            private String thumbPlayUrl;
            private int duration;
            private WebUrlBean webUrl;
            private long releaseTime;
            private String library;
            private ConsumptionBean consumption;
            private Object campaign;
            private Object waterMarks;
            private Object adTrack;
            private String type;
            private String titlePgc;
            private String descriptionPgc;
            private Object remark;
            private int idx;
            private Object shareAdTrack;
            private Object favoriteAdTrack;
            private Object webAdTrack;
            private long date;
            private Object promotion;
            private Object label;
            private String descriptionEditor;
            private boolean collected;
            private boolean played;
            private Object lastViewTime;
            private Object playlists;
            private List<PlayInfoBean> playInfo;
            private List<TagsBean> tags;
            private List<?> labelList;
            private List<?> subtitles;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public ProviderBean getProvider() {
                return provider;
            }

            public void setProvider(ProviderBean provider) {
                this.provider = provider;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public String getThumbPlayUrl() {
                return thumbPlayUrl;
            }

            public void setThumbPlayUrl(String thumbPlayUrl) {
                this.thumbPlayUrl = thumbPlayUrl;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public WebUrlBean getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(WebUrlBean webUrl) {
                this.webUrl = webUrl;
            }

            public long getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
            }

            public String getLibrary() {
                return library;
            }

            public void setLibrary(String library) {
                this.library = library;
            }

            public ConsumptionBean getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBean consumption) {
                this.consumption = consumption;
            }

            public Object getCampaign() {
                return campaign;
            }

            public void setCampaign(Object campaign) {
                this.campaign = campaign;
            }

            public Object getWaterMarks() {
                return waterMarks;
            }

            public void setWaterMarks(Object waterMarks) {
                this.waterMarks = waterMarks;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitlePgc() {
                return titlePgc;
            }

            public void setTitlePgc(String titlePgc) {
                this.titlePgc = titlePgc;
            }

            public String getDescriptionPgc() {
                return descriptionPgc;
            }

            public void setDescriptionPgc(String descriptionPgc) {
                this.descriptionPgc = descriptionPgc;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public Object getShareAdTrack() {
                return shareAdTrack;
            }

            public void setShareAdTrack(Object shareAdTrack) {
                this.shareAdTrack = shareAdTrack;
            }

            public Object getFavoriteAdTrack() {
                return favoriteAdTrack;
            }

            public void setFavoriteAdTrack(Object favoriteAdTrack) {
                this.favoriteAdTrack = favoriteAdTrack;
            }

            public Object getWebAdTrack() {
                return webAdTrack;
            }

            public void setWebAdTrack(Object webAdTrack) {
                this.webAdTrack = webAdTrack;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public Object getPromotion() {
                return promotion;
            }

            public void setPromotion(Object promotion) {
                this.promotion = promotion;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getDescriptionEditor() {
                return descriptionEditor;
            }

            public void setDescriptionEditor(String descriptionEditor) {
                this.descriptionEditor = descriptionEditor;
            }

            public boolean isCollected() {
                return collected;
            }

            public void setCollected(boolean collected) {
                this.collected = collected;
            }

            public boolean isPlayed() {
                return played;
            }

            public void setPlayed(boolean played) {
                this.played = played;
            }

            public Object getLastViewTime() {
                return lastViewTime;
            }

            public void setLastViewTime(Object lastViewTime) {
                this.lastViewTime = lastViewTime;
            }

            public Object getPlaylists() {
                return playlists;
            }

            public void setPlaylists(Object playlists) {
                this.playlists = playlists;
            }

            public List<PlayInfoBean> getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(List<PlayInfoBean> playInfo) {
                this.playInfo = playInfo;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public List<?> getLabelList() {
                return labelList;
            }

            public void setLabelList(List<?> labelList) {
                this.labelList = labelList;
            }

            public List<?> getSubtitles() {
                return subtitles;
            }

            public void setSubtitles(List<?> subtitles) {
                this.subtitles = subtitles;
            }

            public static class ProviderBean {
                /**
                 * name : 投稿
                 * alias : PGC2
                 * icon :
                 */

                private String name;
                private String alias;
                private String icon;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAlias() {
                    return alias;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }
            }

            public static class AuthorBean {
                /**
                 * id : 2173
                 * icon : http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg
                 * name : 开眼预告精选
                 * description : 电影、剧集、戏剧抢先看
                 * link :
                 * latestReleaseTime : 1512537084000
                 * videoNum : 403
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":2173,"followed":false}
                 * shield : {"itemType":"author","itemId":2173,"shielded":false}
                 * approvedNotReadyVideoCount : 0
                 * ifPgc : true
                 */

                private int id;
                private String icon;
                private String name;
                private String description;
                private String link;
                private long latestReleaseTime;
                private int videoNum;
                private Object adTrack;
                private FollowBean follow;
                private ShieldBean shield;
                private int approvedNotReadyVideoCount;
                private boolean ifPgc;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public long getLatestReleaseTime() {
                    return latestReleaseTime;
                }

                public void setLatestReleaseTime(long latestReleaseTime) {
                    this.latestReleaseTime = latestReleaseTime;
                }

                public int getVideoNum() {
                    return videoNum;
                }

                public void setVideoNum(int videoNum) {
                    this.videoNum = videoNum;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public FollowBean getFollow() {
                    return follow;
                }

                public void setFollow(FollowBean follow) {
                    this.follow = follow;
                }

                public ShieldBean getShield() {
                    return shield;
                }

                public void setShield(ShieldBean shield) {
                    this.shield = shield;
                }

                public int getApprovedNotReadyVideoCount() {
                    return approvedNotReadyVideoCount;
                }

                public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                    this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                }

                public boolean isIfPgc() {
                    return ifPgc;
                }

                public void setIfPgc(boolean ifPgc) {
                    this.ifPgc = ifPgc;
                }

                public static class FollowBean {
                    /**
                     * itemType : author
                     * itemId : 2173
                     * followed : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean followed;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isFollowed() {
                        return followed;
                    }

                    public void setFollowed(boolean followed) {
                        this.followed = followed;
                    }
                }

                public static class ShieldBean {
                    /**
                     * itemType : author
                     * itemId : 2173
                     * shielded : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean shielded;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isShielded() {
                        return shielded;
                    }

                    public void setShielded(boolean shielded) {
                        this.shielded = shielded;
                    }
                }
            }

            public static class CoverBean {
                /**
                 * feed : http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageMogr2/quality/60/format/jpg
                 * detail : http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageMogr2/quality/60/format/jpg
                 * blurred : http://img.kaiyanapp.com/aa404baf0a9c15dc1e57e9db7b8f41ee.jpeg?imageMogr2/quality/60/format/jpg
                 * sharing : null
                 * homepage : http://img.kaiyanapp.com/aa797a76e52fd21e779783f501b8e545.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                 */

                private String feed;
                private String detail;
                private String blurred;
                private Object sharing;
                private String homepage;

                public String getFeed() {
                    return feed;
                }

                public void setFeed(String feed) {
                    this.feed = feed;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getBlurred() {
                    return blurred;
                }

                public void setBlurred(String blurred) {
                    this.blurred = blurred;
                }

                public Object getSharing() {
                    return sharing;
                }

                public void setSharing(Object sharing) {
                    this.sharing = sharing;
                }

                public String getHomepage() {
                    return homepage;
                }

                public void setHomepage(String homepage) {
                    this.homepage = homepage;
                }
            }

            public static class WebUrlBean {
                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=64537
                 * forWeibo : http://www.eyepetizer.net/detail.html?vid=64537
                 */

                private String raw;
                private String forWeibo;

                public String getRaw() {
                    return raw;
                }

                public void setRaw(String raw) {
                    this.raw = raw;
                }

                public String getForWeibo() {
                    return forWeibo;
                }

                public void setForWeibo(String forWeibo) {
                    this.forWeibo = forWeibo;
                }
            }

            public static class ConsumptionBean {
                /**
                 * collectionCount : 101
                 * shareCount : 181
                 * replyCount : 7
                 */

                private int collectionCount;
                private int shareCount;
                private int replyCount;

                public int getCollectionCount() {
                    return collectionCount;
                }

                public void setCollectionCount(int collectionCount) {
                    this.collectionCount = collectionCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }

            public static class PlayInfoBean {
                /**
                 * height : 720
                 * width : 1280
                 * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun","size":30570169},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=qcloud","size":30570169},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=ucloud","size":30570169}]
                 * name : 高清
                 * type : high
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun
                 */

                private int height;
                private int width;
                private String name;
                private String type;
                private String url;
                private List<UrlListBean> urlList;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<UrlListBean> getUrlList() {
                    return urlList;
                }

                public void setUrlList(List<UrlListBean> urlList) {
                    this.urlList = urlList;
                }

                public static class UrlListBean {
                    /**
                     * name : aliyun
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=64537&editionType=high&source=aliyun
                     * size : 30570169
                     */

                    private String name;
                    private String url;
                    private int size;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }
                }
            }

            public static class TagsBean {
                /**
                 * id : 154
                 * name : 喜剧
                 * actionUrl : eyepetizer://tag/154/?title=%E5%96%9C%E5%89%A7
                 * adTrack : null
                 * desc : null
                 * bgPicture : http://img.kaiyanapp.com/c3076dda6eeb73de6227e3af243b0561.jpeg?imageMogr2/quality/100
                 * headerImage : http://img.kaiyanapp.com/c3076dda6eeb73de6227e3af243b0561.jpeg?imageMogr2/quality/100
                 * tagRecType : NORMAL
                 */

                private int id;
                private String name;
                private String actionUrl;
                private Object adTrack;
                private Object desc;
                private String bgPicture;
                private String headerImage;
                private String tagRecType;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public Object getDesc() {
                    return desc;
                }

                public void setDesc(Object desc) {
                    this.desc = desc;
                }

                public String getBgPicture() {
                    return bgPicture;
                }

                public void setBgPicture(String bgPicture) {
                    this.bgPicture = bgPicture;
                }

                public String getHeaderImage() {
                    return headerImage;
                }

                public void setHeaderImage(String headerImage) {
                    this.headerImage = headerImage;
                }

                public String getTagRecType() {
                    return tagRecType;
                }

                public void setTagRecType(String tagRecType) {
                    this.tagRecType = tagRecType;
                }
            }
        }
    }
}

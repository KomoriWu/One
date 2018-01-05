package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2018-01-05.
 */

public class AuthorDetailBean {
    private TabInfoBean tabInfo;
    private PgcInfoBean pgcInfo;

    public TabInfoBean getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfoBean tabInfo) {
        this.tabInfo = tabInfo;
    }

    public PgcInfoBean getPgcInfo() {
        return pgcInfo;
    }

    public void setPgcInfo(PgcInfoBean pgcInfo) {
        this.pgcInfo = pgcInfo;
    }

    public static class TabInfoBean {
        /**
         * tabList : [{"id":0,"name":"首页","apiUrl":"http://baobab.kaiyanapp.com/api/v5/userInfo/tab/index?id=2172&userType=PGC"},{"id":1,"name":"视频","apiUrl":"http://baobab.kaiyanapp.com/api/v4/pgcs/videoList?id=2172"},{"id":3,"name":"动态","apiUrl":"http://baobab.kaiyanapp.com/api/v5/userInfo/tab/dynamics?id=2172&userType=PGC"}]
         * defaultIdx : 0
         */

        private int defaultIdx;
        private List<TabListBean> tabList;

        public int getDefaultIdx() {
            return defaultIdx;
        }

        public void setDefaultIdx(int defaultIdx) {
            this.defaultIdx = defaultIdx;
        }

        public List<TabListBean> getTabList() {
            return tabList;
        }

        public void setTabList(List<TabListBean> tabList) {
            this.tabList = tabList;
        }

        public static class TabListBean {
            /**
             * id : 0
             * name : 首页
             * apiUrl : http://baobab.kaiyanapp.com/api/v5/userInfo/tab/index?id=2172&userType=PGC
             */

            private int id;
            private String name;
            private String apiUrl;

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

            public String getApiUrl() {
                return apiUrl;
            }

            public void setApiUrl(String apiUrl) {
                this.apiUrl = apiUrl;
            }
        }
    }

    public static class PgcInfoBean {
        /**
         * dataType : PgcInfo
         * id : 2172
         * icon : http://img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg
         * name : 开眼剧情精选
         * brief : 396 个视频  /  1194821 次收藏  /  1123278 次分享
         * description : 用一个好故事，描绘生活的不可思议
         * actionUrl : eyepetizer://pgc/detail/2172/?title=%E5%BC%80%E7%9C%BC%E5%89%A7%E6%83%85%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=0
         * area :
         * gender :
         * registDate : -1
         * followCount : 7971
         * follow : {"itemType":"author","itemId":2172,"followed":false}
         * self : false
         * cover : http://img.kaiyanapp.com/30954626dd53df5747f18b782a13adbb.png
         * videoCount : 396
         * shareCount : 1123278
         * collectCount : 1194821
         * shield : {"itemType":"author","itemId":2172,"shielded":false}
         */

        private String dataType;
        private int id;
        private String icon;
        private String name;
        private String brief;
        private String description;
        private String actionUrl;
        private String area;
        private String gender;
        private int registDate;
        private int followCount;
        private FollowBean follow;
        private boolean self;
        private String cover;
        private int videoCount;
        private int shareCount;
        private int collectCount;
        private ShieldBean shield;

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

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getRegistDate() {
            return registDate;
        }

        public void setRegistDate(int registDate) {
            this.registDate = registDate;
        }

        public int getFollowCount() {
            return followCount;
        }

        public void setFollowCount(int followCount) {
            this.followCount = followCount;
        }

        public FollowBean getFollow() {
            return follow;
        }

        public void setFollow(FollowBean follow) {
            this.follow = follow;
        }

        public boolean isSelf() {
            return self;
        }

        public void setSelf(boolean self) {
            this.self = self;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public ShieldBean getShield() {
            return shield;
        }

        public void setShield(ShieldBean shield) {
            this.shield = shield;
        }

        public static class FollowBean {
            /**
             * itemType : author
             * itemId : 2172
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
             * itemId : 2172
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
}

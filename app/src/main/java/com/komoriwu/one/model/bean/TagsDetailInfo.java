package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2018-01-05.
 */

public class TagsDetailInfo {
    private TabInfoBean tabInfo;
    private TagInfoBean tagInfo;

    public TabInfoBean getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfoBean tabInfo) {
        this.tabInfo = tabInfo;
    }

    public TagInfoBean getTagInfo() {
        return tagInfo;
    }

    public void setTagInfo(TagInfoBean tagInfo) {
        this.tagInfo = tagInfo;
    }

    public static class TabInfoBean {
        /**
         * tabList : [{"id":0,"name":"视频","apiUrl":"http://baobab.kaiyanapp.com/api/v1/tag/videos?id=460"},{"id":1,"name":"动态","apiUrl":"http://baobab.kaiyanapp.com/api/v1/tag/dynamics?id=460"}]
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
             * name : 视频
             * apiUrl : http://baobab.kaiyanapp.com/api/v1/tag/videos?id=460
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

    public static class TagInfoBean {
        /**
         * dataType : TagInfo
         * id : 460
         * name : 复仇者联盟
         * description : null
         * headerImage : http://img.kaiyanapp.com/9623d26752a5897f4e8fc7beab673da0.jpeg?imageMogr2/quality/100
         * bgPicture : http://img.kaiyanapp.com/9623d26752a5897f4e8fc7beab673da0.jpeg?imageMogr2/quality/100
         * actionUrl : null
         * recType : 0
         * follow : {"itemType":"tag","itemId":460,"followed":false}
         * tagFollowCount : 121
         * tagVideoCount : 17
         * tagDynamicCount : 180
         */

        private String dataType;
        private int id;
        private String name;
        private Object description;
        private String headerImage;
        private String bgPicture;
        private Object actionUrl;
        private int recType;
        private FollowBean follow;
        private int tagFollowCount;
        private int tagVideoCount;
        private int tagDynamicCount;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getHeaderImage() {
            return headerImage;
        }

        public void setHeaderImage(String headerImage) {
            this.headerImage = headerImage;
        }

        public String getBgPicture() {
            return bgPicture;
        }

        public void setBgPicture(String bgPicture) {
            this.bgPicture = bgPicture;
        }

        public Object getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(Object actionUrl) {
            this.actionUrl = actionUrl;
        }

        public int getRecType() {
            return recType;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public FollowBean getFollow() {
            return follow;
        }

        public void setFollow(FollowBean follow) {
            this.follow = follow;
        }

        public int getTagFollowCount() {
            return tagFollowCount;
        }

        public void setTagFollowCount(int tagFollowCount) {
            this.tagFollowCount = tagFollowCount;
        }

        public int getTagVideoCount() {
            return tagVideoCount;
        }

        public void setTagVideoCount(int tagVideoCount) {
            this.tagVideoCount = tagVideoCount;
        }

        public int getTagDynamicCount() {
            return tagDynamicCount;
        }

        public void setTagDynamicCount(int tagDynamicCount) {
            this.tagDynamicCount = tagDynamicCount;
        }

        public static class FollowBean {
            /**
             * itemType : tag
             * itemId : 460
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
    }
}

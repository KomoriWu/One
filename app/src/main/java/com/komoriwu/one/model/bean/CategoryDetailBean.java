package com.komoriwu.one.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */

public class CategoryDetailBean implements Serializable {

    private CategoryInfoBean categoryInfo;
    private TabInfoBean tabInfo;

    public CategoryInfoBean getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfoBean categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public TabInfoBean getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfoBean tabInfo) {
        this.tabInfo = tabInfo;
    }

    public static class CategoryInfoBean {
        /**
         * dataType : CategoryInfo
         * id : 24
         * name : 时尚
         * description : 优雅地行走在潮流尖端
         * headerImage : http://img.kaiyanapp.com/c9b19c2f0a2a40f4c45564dd8ea766d3.png
         * actionUrl : eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A
         * follow : {"itemType":"category","itemId":24,"followed":false}
         */

        private String dataType;
        private int id;
        private String name;
        private String description;
        private String headerImage;
        private String actionUrl;
        private FollowBean follow;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getHeaderImage() {
            return headerImage;
        }

        public void setHeaderImage(String headerImage) {
            this.headerImage = headerImage;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public FollowBean getFollow() {
            return follow;
        }

        public void setFollow(FollowBean follow) {
            this.follow = follow;
        }

        public static class FollowBean {
            /**
             * itemType : category
             * itemId : 24
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

    public static class TabInfoBean {
        /**
         * tabList : [{"id":0,"name":"首页","apiUrl":"http://baobab.kaiyanapp.com/api/v4/categories/detail/index?id=24"},{"id":1,"name":"全部","apiUrl":"http://baobab.kaiyanapp.com/api/v4/categories/videoList?id=24"},{"id":2,"name":"作者","apiUrl":"http://baobab.kaiyanapp.com/api/v4/categories/detail/pgcs?id=24"},{"id":3,"name":"专辑","apiUrl":"http://baobab.kaiyanapp.com/api/v4/categories/detail/playlist?id=24"}]
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
             * apiUrl : http://baobab.kaiyanapp.com/api/v4/categories/detail/index?id=24
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
}

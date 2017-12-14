package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-14.
 */

public class FindBean {
    private int count;
    private int total;
    private String nextPageUrl;
    private boolean adExist;
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

    public List<ItemListBeanX> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBeanX {
        /**
         * type : horizontalScrollCard
         * data : {"dataType":"HorizontalScrollCard","itemList":[{"type":"banner","data":{"dataType":"Banner","id":559,"title":"还在熬夜吗？这些短片助你入眠","description":"还在熬夜吗？这些短片助你入眠","image":"http://img.kaiyanapp.com/21f7f5adddff077b683e32217b636975.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E8%BF%98%E5%9C%A8%E7%86%AC%E5%A4%9C%E5%90%97%EF%BC%9F%E8%BF%99%E4%BA%9B%E7%9F%AD%E7%89%87%E5%8A%A9%E4%BD%A0%E5%85%A5%E7%9C%A0&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D227%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1}],"count":1}
         * tag : null
         * id : 0
         * adIndex : -1
         */

        private String type;
        private DataBeanX data;
        private Object tag;
        private int id;
        private int adIndex;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBeanX getData() {
            return data;
        }

        public void setData(DataBeanX data) {
            this.data = data;
        }

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public static class DataBeanX {
            /**
             * dataType : HorizontalScrollCard
             * itemList : [{"type":"banner","data":{"dataType":"Banner","id":559,"title":"还在熬夜吗？这些短片助你入眠","description":"还在熬夜吗？这些短片助你入眠","image":"http://img.kaiyanapp.com/21f7f5adddff077b683e32217b636975.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E8%BF%98%E5%9C%A8%E7%86%AC%E5%A4%9C%E5%90%97%EF%BC%9F%E8%BF%99%E4%BA%9B%E7%9F%AD%E7%89%87%E5%8A%A9%E4%BD%A0%E5%85%A5%E7%9C%A0&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D227%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1}]
             * count : 1
             */

            private String dataType;
            private String icon;
            private String title;
            private String description;
            private String actionUrl;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            private int count;
            private List<ItemListBean> itemList;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }


        }
    }
}

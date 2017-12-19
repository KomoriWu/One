package com.komoriwu.one.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-14.
 */

public class FindBean  implements Serializable{
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

    public static class ItemListBeanX implements Serializable{
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

        public static class DataBeanX  implements Serializable{
            private String icon;
            private String actionUrl;
            private String text;
            private HeaderBean header;
            private ContentBean content;
            private String dataType;
            private int id;
            private String title;
            private String slogan;
            private String description;
            private ContentBean.DataBean.ProviderBean provider;
            private String category;
            private ContentBean.DataBean.AuthorBean author;
            private ContentBean.DataBean.CoverBean cover;
            private String playUrl;
            private Object thumbPlayUrl;
            private int duration;
            private ContentBean.DataBean.WebUrlBean webUrl;
            private long releaseTime;
            private String library;
            private ContentBean.DataBean.ConsumptionBean consumption;
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
            private Object src;
            private List<ContentBean.DataBean.PlayInfoBean> playInfo;
            private List<ContentBean.DataBean.TagsBean> tags;
            private List<?> labelList;
            private List<?> subtitles;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public ContentBean.DataBean.ProviderBean getProvider() {
                return provider;
            }

            public void setProvider(ContentBean.DataBean.ProviderBean provider) {
                this.provider = provider;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public ContentBean.DataBean.AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(ContentBean.DataBean.AuthorBean author) {
                this.author = author;
            }

            public ContentBean.DataBean.CoverBean getCover() {
                return cover;
            }

            public void setCover(ContentBean.DataBean.CoverBean cover) {
                this.cover = cover;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public Object getThumbPlayUrl() {
                return thumbPlayUrl;
            }

            public void setThumbPlayUrl(Object thumbPlayUrl) {
                this.thumbPlayUrl = thumbPlayUrl;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public ContentBean.DataBean.WebUrlBean getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(ContentBean.DataBean.WebUrlBean webUrl) {
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

            public ContentBean.DataBean.ConsumptionBean getConsumption() {
                return consumption;
            }

            public void setConsumption(ContentBean.DataBean.ConsumptionBean consumption) {
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

            public Object getSrc() {
                return src;
            }

            public void setSrc(Object src) {
                this.src = src;
            }

            public List<ContentBean.DataBean.PlayInfoBean> getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(List<ContentBean.DataBean.PlayInfoBean> playInfo) {
                this.playInfo = playInfo;
            }

            public List<ContentBean.DataBean.TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<ContentBean.DataBean.TagsBean> tags) {
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

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

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

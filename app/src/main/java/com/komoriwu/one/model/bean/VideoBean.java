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
        private String type;
        private DataBeanX data;
        private String tag;
        private int id;

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

        public static class DataBeanX {
            /**
             * dataType : HorizontalScrollCard
             * itemList : [{"type":"banner2","data":{"dataType":"Banner","id":639,"title":"","description":"","image":"http://img.kaiyanapp.com/9225e35ff2f4b936f8c35d748b12da69.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"http://e.cn.miaozhen.com/r/k=2064309&p=7AW5y&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&tr=__REQUESTID__&ro=sm&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&vo=3ee3f6a66&vr=2&o=http%3A%2F%2Faudi-future.digitplus.cn%2Fmobile","adTrack":null,"shade":false,"label":{"text":"广告","card":"广告","detail":null},"labelList":[{"text":"广告","actionUrl":null}],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0}]
             * count : 1
             */

            private String dataType;
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

            public static class ItemListBean {
                /**
                 * type : banner2
                 * data : {"dataType":"Banner","id":639,"title":"","description":"","image":"http://img.kaiyanapp.com/9225e35ff2f4b936f8c35d748b12da69.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"http://e.cn.miaozhen.com/r/k=2064309&p=7AW5y&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&tr=__REQUESTID__&ro=sm&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&vo=3ee3f6a66&vr=2&o=http%3A%2F%2Faudi-future.digitplus.cn%2Fmobile","adTrack":null,"shade":false,"label":{"text":"广告","card":"广告","detail":null},"labelList":[{"text":"广告","actionUrl":null}],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}}
                 * tag : null
                 * id : 0
                 */

                private String type;
                private DataBean data;
                private Object tag;
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

                public static class DataBean {
                    /**
                     * dataType : Banner
                     * id : 639
                     * title :
                     * description :
                     * image : http://img.kaiyanapp.com/9225e35ff2f4b936f8c35d748b12da69.jpeg?imageMogr2/quality/60/format/jpg
                     * actionUrl : http://e.cn.miaozhen.com/r/k=2064309&p=7AW5y&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&tr=__REQUESTID__&ro=sm&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&vo=3ee3f6a66&vr=2&o=http%3A%2F%2Faudi-future.digitplus.cn%2Fmobile
                     * adTrack : null
                     * shade : false
                     * label : {"text":"广告","card":"广告","detail":null}
                     * labelList : [{"text":"广告","actionUrl":null}]
                     * header : {"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}
                     */

                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    private String image;
                    private String actionUrl;
                    private Object adTrack;
                    private boolean shade;
                    private LabelBean label;
                    private HeaderBean header;
                    private List<LabelListBean> labelList;

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

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
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

                    public boolean isShade() {
                        return shade;
                    }

                    public void setShade(boolean shade) {
                        this.shade = shade;
                    }

                    public LabelBean getLabel() {
                        return label;
                    }

                    public void setLabel(LabelBean label) {
                        this.label = label;
                    }

                    public HeaderBean getHeader() {
                        return header;
                    }

                    public void setHeader(HeaderBean header) {
                        this.header = header;
                    }

                    public List<LabelListBean> getLabelList() {
                        return labelList;
                    }

                    public void setLabelList(List<LabelListBean> labelList) {
                        this.labelList = labelList;
                    }

                    public static class LabelBean {
                        /**
                         * text : 广告
                         * card : 广告
                         * detail : null
                         */

                        private String text;
                        private String card;
                        private Object detail;

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCard() {
                            return card;
                        }

                        public void setCard(String card) {
                            this.card = card;
                        }

                        public Object getDetail() {
                            return detail;
                        }

                        public void setDetail(Object detail) {
                            this.detail = detail;
                        }
                    }

                    public static class HeaderBean {
                        /**
                         * id : 0
                         * title : null
                         * font : null
                         * subTitle : null
                         * subTitleFont : null
                         * textAlign : left
                         * cover : null
                         * label : null
                         * actionUrl : null
                         * labelList : null
                         * icon : null
                         * description : null
                         */

                        private int id;
                        private Object title;
                        private Object font;
                        private Object subTitle;
                        private Object subTitleFont;
                        private String textAlign;
                        private Object cover;
                        private Object label;
                        private Object actionUrl;
                        private Object labelList;
                        private Object icon;
                        private Object description;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public Object getTitle() {
                            return title;
                        }

                        public void setTitle(Object title) {
                            this.title = title;
                        }

                        public Object getFont() {
                            return font;
                        }

                        public void setFont(Object font) {
                            this.font = font;
                        }

                        public Object getSubTitle() {
                            return subTitle;
                        }

                        public void setSubTitle(Object subTitle) {
                            this.subTitle = subTitle;
                        }

                        public Object getSubTitleFont() {
                            return subTitleFont;
                        }

                        public void setSubTitleFont(Object subTitleFont) {
                            this.subTitleFont = subTitleFont;
                        }

                        public String getTextAlign() {
                            return textAlign;
                        }

                        public void setTextAlign(String textAlign) {
                            this.textAlign = textAlign;
                        }

                        public Object getCover() {
                            return cover;
                        }

                        public void setCover(Object cover) {
                            this.cover = cover;
                        }

                        public Object getLabel() {
                            return label;
                        }

                        public void setLabel(Object label) {
                            this.label = label;
                        }

                        public Object getActionUrl() {
                            return actionUrl;
                        }

                        public void setActionUrl(Object actionUrl) {
                            this.actionUrl = actionUrl;
                        }

                        public Object getLabelList() {
                            return labelList;
                        }

                        public void setLabelList(Object labelList) {
                            this.labelList = labelList;
                        }

                        public Object getIcon() {
                            return icon;
                        }

                        public void setIcon(Object icon) {
                            this.icon = icon;
                        }

                        public Object getDescription() {
                            return description;
                        }

                        public void setDescription(Object description) {
                            this.description = description;
                        }
                    }

                    public static class LabelListBean {
                        /**
                         * text : 广告
                         * actionUrl : null
                         */

                        private String text;
                        private Object actionUrl;

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public Object getActionUrl() {
                            return actionUrl;
                        }

                        public void setActionUrl(Object actionUrl) {
                            this.actionUrl = actionUrl;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "count=" + count +
                ", total=" + total +
                ", nextPageUrl='" + nextPageUrl + '\'' +
                ", adExist=" + adExist +
                ", date=" + date +
                ", nextPublishTime=" + nextPublishTime +
                ", dialog=" + dialog +
                ", topIssue=" + topIssue +
                ", refreshCount=" + refreshCount +
                ", lastStartId=" + lastStartId +
                ", itemList=" + itemList +
                '}';
    }
}

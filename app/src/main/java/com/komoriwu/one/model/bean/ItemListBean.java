package com.komoriwu.one.model.bean;

import java.util.List;

public class ItemListBean {
    /**
     * type : banner
     * data : {"dataType":"Banner","id":559,"title":"还在熬夜吗？这些短片助你入眠","description":"还在熬夜吗？这些短片助你入眠","image":"http://img.kaiyanapp.com/21f7f5adddff077b683e32217b636975.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E8%BF%98%E5%9C%A8%E7%86%AC%E5%A4%9C%E5%90%97%EF%BC%9F%E8%BF%99%E4%BA%9B%E7%9F%AD%E7%89%87%E5%8A%A9%E4%BD%A0%E5%85%A5%E7%9C%A0&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D227%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}}
     * tag : null
     * id : 0
     * adIndex : -1
     */

    private String type;
    private DataBean data;
    private Object tag;
    private int id;
    private int adIndex;

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

    public int getAdIndex() {
        return adIndex;
    }

    public void setAdIndex(int adIndex) {
        this.adIndex = adIndex;
    }

}
package com.komoriwu.one.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-15.
 */

public class HeaderBean  implements Serializable {
    private int id;
    private String title;
    private Object font;
    private Object subTitle;
    private Object subTitleFont;
    private String textAlign;
    private Object cover;
    private Object label;
    private String actionUrl;
    private Object labelList;
    private String icon;
    private String iconType;
    private String description;
    private long time;
    private boolean showHateVideo;

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

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Object getLabelList() {
        return labelList;
    }

    public void setLabelList(Object labelList) {
        this.labelList = labelList;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isShowHateVideo() {
        return showHateVideo;
    }

    public void setShowHateVideo(boolean showHateVideo) {
        this.showHateVideo = showHateVideo;
    }
}

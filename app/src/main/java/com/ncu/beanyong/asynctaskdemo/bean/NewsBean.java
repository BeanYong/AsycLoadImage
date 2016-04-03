package com.ncu.beanyong.asynctaskdemo.bean;

/**
 * Created by BeanYong on 2015/8/23.
 */
public class NewsBean {
    private String iconUrl;
    private String title;
    private String desc;

    public NewsBean(String iconUrl, String title, String desc) {
        this.iconUrl = iconUrl;
        this.title = title;
        this.desc = desc;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

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
}

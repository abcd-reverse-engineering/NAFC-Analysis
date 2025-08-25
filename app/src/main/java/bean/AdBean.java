package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class AdBean extends BaseBean {
    private String imageUrl;
    private String name;
    private int openType;
    private String openUrl;
    private int showTime;
    private String title;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public int getOpenType() {
        return this.openType;
    }

    public String getOpenUrl() {
        return this.openUrl;
    }

    public int getShowTime() {
        return this.showTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpenType(int i2) {
        this.openType = i2;
    }

    public void setOpenUrl(String str) {
        this.openUrl = str;
    }

    public void setShowTime(int i2) {
        this.showTime = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}

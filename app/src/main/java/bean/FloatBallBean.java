package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class FloatBallBean extends BaseBean {
    private String imgPath;
    private int openType;
    private String title;
    private String url;

    public String getImgPath() {
        return this.imgPath;
    }

    public int getOpenType() {
        return this.openType;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImgPath(String str) {
        this.imgPath = str;
    }

    public void setOpenType(int i2) {
        this.openType = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}

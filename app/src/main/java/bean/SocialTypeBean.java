package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SocialTypeBean extends BaseBean {
    private String createTime;
    private long id;
    private boolean isShow;
    private int sort;
    private String text;
    private String updateTime;

    public SocialTypeBean() {
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public long getId() {
        return this.id;
    }

    public int getSort() {
        return this.sort;
    }

    public String getText() {
        return this.text;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public boolean isIsShow() {
        return this.isShow;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setIsShow(boolean z) {
        this.isShow = z;
    }

    public void setSort(int i2) {
        this.sort = i2;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public SocialTypeBean(String str) {
        this.text = str;
    }
}

package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class FeedbackTagBean extends BaseBean {
    private int code;
    private int sort;
    private String text;

    public FeedbackTagBean() {
    }

    public int getCode() {
        return this.code;
    }

    public int getSort() {
        return this.sort;
    }

    public String getText() {
        return this.text;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setSort(int i2) {
        this.sort = i2;
    }

    public void setText(String str) {
        this.text = str;
    }

    public FeedbackTagBean(String str, int i2) {
        this.text = str;
        this.code = i2;
    }
}

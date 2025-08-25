package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CheckTimeBean extends BaseBean {
    public static final int CHECK_TIME_CODE_1 = 1;
    public static final int CHECK_TIME_CODE_2 = 2;
    public static final int CHECK_TIME_CODE_3 = 3;
    private int code;
    private String content;
    private boolean select;

    public CheckTimeBean() {
        this.code = 0;
        this.select = false;
    }

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isSelect() {
        return this.select;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setSelect(boolean z) {
        this.select = z;
    }

    public CheckTimeBean(String str, int i2) {
        this.code = 0;
        this.select = false;
        this.content = str;
        this.code = i2;
    }
}

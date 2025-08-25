package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CallWarnBean extends BaseBean {
    private String count;
    private int source;
    private String tabText;
    private String telNumber;

    public String getCount() {
        return this.count;
    }

    public int getSource() {
        return this.source;
    }

    public String getTabText() {
        return this.tabText;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setSource(int i2) {
        this.source = i2;
    }

    public void setTabText(String str) {
        this.tabText = str;
    }

    public void setTelNumber(String str) {
        this.telNumber = str;
    }
}

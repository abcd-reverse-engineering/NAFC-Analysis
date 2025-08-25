package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SmsTypeBean extends BaseBean {
    private int smsType;
    private String smsTypeText;

    public SmsTypeBean() {
    }

    public int getSmsType() {
        return this.smsType;
    }

    public String getSmsTypeText() {
        return this.smsTypeText;
    }

    public void setSmsType(int i2) {
        this.smsType = i2;
    }

    public void setSmsTypeText(String str) {
        this.smsTypeText = str;
    }

    public SmsTypeBean(int i2, String str) {
        this.smsType = i2;
        this.smsTypeText = str;
    }
}

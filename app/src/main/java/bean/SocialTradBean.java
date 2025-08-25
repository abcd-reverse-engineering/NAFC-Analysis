package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SocialTradBean extends BaseBean {
    private String account;
    private String accountType;
    private String occurTime;
    private String paymentType;

    public String getAccount() {
        return this.account;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getOccurTime() {
        return this.occurTime;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setOccurTime(String str) {
        this.occurTime = str;
    }

    public void setPaymentType(String str) {
        this.paymentType = str;
    }
}

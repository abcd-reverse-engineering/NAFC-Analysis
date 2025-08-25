package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SocialAccBean extends BaseBean {
    private String accountName;
    private String accountNum;
    private String accountOtherName;
    private String accountOtherTips;
    private String id;
    private String suspectInfoID;

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountNum() {
        return this.accountNum;
    }

    public String getAccountOtherName() {
        return this.accountOtherName;
    }

    public String getAccountOtherTips() {
        return this.accountOtherTips;
    }

    public String getId() {
        return this.id;
    }

    public String getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAccountNum(String str) {
        this.accountNum = str;
    }

    public void setAccountOtherName(String str) {
        this.accountOtherName = str;
    }

    public void setAccountOtherTips(String str) {
        this.accountOtherTips = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSuspectInfoID(String str) {
        this.suspectInfoID = str;
    }
}

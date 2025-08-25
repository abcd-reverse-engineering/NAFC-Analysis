package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SocialCriminalBean extends BaseBean {
    private String account;
    private String accountTypeName;
    private String id;
    private long suspectInfoID;

    public String getAccount() {
        return this.account;
    }

    public String getAccountTypeName() {
        return this.accountTypeName;
    }

    public String getId() {
        return this.id;
    }

    public long getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAccountTypeName(String str) {
        this.accountTypeName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSuspectInfoID(long j2) {
        this.suspectInfoID = j2;
    }
}

package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class RelationBean extends BaseBean {
    private String caseInfoID;
    private String linkTelInfoID;
    private String platform;
    private String platformText;
    private String suspectMobile;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getLinkTelInfoID() {
        return this.linkTelInfoID;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlatformText() {
        return this.platformText;
    }

    public String getSuspectMobile() {
        return this.suspectMobile;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setLinkTelInfoID(String str) {
        this.linkTelInfoID = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlatformText(String str) {
        this.platformText = str;
    }

    public void setSuspectMobile(String str) {
        this.suspectMobile = str;
    }
}

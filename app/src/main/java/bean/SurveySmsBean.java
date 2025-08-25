package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SurveySmsBean extends BaseBean {
    private String caseInfoID;
    private String content;
    private String id;
    private String mobileNumber;
    private String receivedTime;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getContent() {
        return this.content;
    }

    public String getId() {
        return this.id;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getReceivedTime() {
        return this.receivedTime;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setReceivedTime(String str) {
        this.receivedTime = str;
    }
}

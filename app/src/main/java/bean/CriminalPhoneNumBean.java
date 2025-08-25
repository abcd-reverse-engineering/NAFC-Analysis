package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CriminalPhoneNumBean extends BaseBean {
    private int callTelCount;
    private String caseInfoID;
    private int chargeTelCount;
    private int linkTelCount;
    private int mailingTelCount;

    public int getCallTelCount() {
        return this.callTelCount;
    }

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public int getChargeTelCount() {
        return this.chargeTelCount;
    }

    public int getLinkTelCount() {
        return this.linkTelCount;
    }

    public int getMailingTelCount() {
        return this.mailingTelCount;
    }

    public void setCallTelCount(int i2) {
        this.callTelCount = i2;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setChargeTelCount(int i2) {
        this.chargeTelCount = i2;
    }

    public void setLinkTelCount(int i2) {
        this.linkTelCount = i2;
    }

    public void setMailingTelCount(int i2) {
        this.mailingTelCount = i2;
    }
}

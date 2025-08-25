package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class RechargeBean extends BaseBean {
    private String amount;
    private String caseInfoID;
    private String chargeTelInfoID;
    private String chargeTime;
    private int ex;
    private String platform;
    private String platformText;
    private String suspectMobile;

    public String getAmount() {
        return this.amount;
    }

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getChargeTelInfoID() {
        return this.chargeTelInfoID;
    }

    public String getChargeTime() {
        return this.chargeTime;
    }

    public int getEx() {
        return this.ex;
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

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setChargeTelInfoID(String str) {
        this.chargeTelInfoID = str;
    }

    public void setChargeTime(String str) {
        this.chargeTime = str;
    }

    public void setEx(int i2) {
        this.ex = i2;
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

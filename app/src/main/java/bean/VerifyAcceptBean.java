package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class VerifyAcceptBean extends BaseBean {
    private String deadline;
    private String initiatorName;
    private String intivedMobile;
    private int isLookover;
    private String launchTime;
    private String verificationLogID;

    public String getDeadline() {
        return this.deadline;
    }

    public String getInitiatorName() {
        return this.initiatorName;
    }

    public String getIntivedMobile() {
        return this.intivedMobile;
    }

    public int getIsLookover() {
        return this.isLookover;
    }

    public String getLaunchTime() {
        return this.launchTime;
    }

    public String getVerificationLogID() {
        return this.verificationLogID;
    }

    public void setDeadline(String str) {
        this.deadline = str;
    }

    public void setInitiatorName(String str) {
        this.initiatorName = str;
    }

    public void setIntivedMobile(String str) {
        this.intivedMobile = str;
    }

    public void setIsLookover(int i2) {
        this.isLookover = i2;
    }

    public void setLaunchTime(String str) {
        this.launchTime = str;
    }

    public void setVerificationLogID(String str) {
        this.verificationLogID = str;
    }
}

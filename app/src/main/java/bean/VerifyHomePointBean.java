package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class VerifyHomePointBean extends BaseBean {
    private int pendingVerificationCount;
    private int toVerificationCount;
    private String verificationPath;

    public int getPendingVerificationCount() {
        return this.pendingVerificationCount;
    }

    public int getToVerificationCount() {
        return this.toVerificationCount;
    }

    public String getVerificationPath() {
        return this.verificationPath;
    }

    public void setPendingVerificationCount(int i2) {
        this.pendingVerificationCount = i2;
    }

    public void setToVerificationCount(int i2) {
        this.toVerificationCount = i2;
    }

    public void setVerificationPath(String str) {
        this.verificationPath = str;
    }
}

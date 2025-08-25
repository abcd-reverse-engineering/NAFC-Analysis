package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class PolicBean extends BaseBean {
    private String id;
    private String policeName;
    private String policeNumber;
    private String policeToken;
    private String policeUserPCode;
    private String telNumber;

    public String getId() {
        return this.id;
    }

    public String getPoliceName() {
        return this.policeName;
    }

    public String getPoliceNumber() {
        return this.policeNumber;
    }

    public String getPoliceToken() {
        return this.policeToken;
    }

    public String getPoliceUserPCode() {
        return this.policeUserPCode;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPoliceName(String str) {
        this.policeName = str;
    }

    public void setPoliceNumber(String str) {
        this.policeNumber = str;
    }

    public void setPoliceToken(String str) {
        this.policeToken = str;
    }

    public void setPoliceUserPCode(String str) {
        this.policeUserPCode = str;
    }

    public void setTelNumber(String str) {
        this.telNumber = str;
    }
}

package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CheckUserBean extends BaseBean {
    private String auditMessage;
    private int auditStatus;
    private String backImg;
    private String documentType;
    private String frontImg;
    private String idNumber;
    private String name;
    private String telnumber;
    private String userId;

    public String getAuditMessage() {
        return this.auditMessage;
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public String getBackImg() {
        return this.backImg;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public String getFrontImg() {
        return this.frontImg;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getTelnumber() {
        return this.telnumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAuditMessage(String str) {
        this.auditMessage = str;
    }

    public void setAuditStatus(int i2) {
        this.auditStatus = i2;
    }

    public void setBackImg(String str) {
        this.backImg = str;
    }

    public void setDocumentType(String str) {
        this.documentType = str;
    }

    public void setFrontImg(String str) {
        this.frontImg = str;
    }

    public void setIdNumber(String str) {
        this.idNumber = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTelnumber(String str) {
        this.telnumber = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}

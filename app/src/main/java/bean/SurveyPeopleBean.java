package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SurveyPeopleBean extends BaseBean {
    private String caseInfoID;
    private String createTime;
    private String documentNumber;
    private String documentType;
    private String documentTypeText;
    private String mobileNumber;
    private String name;
    private String persionnelType1;
    private String updateTime;
    private String victimInfoID;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDocumentName() {
        return this.documentTypeText;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public String getPeopleName() {
        return this.name;
    }

    public String getPeoplePhone() {
        return this.mobileNumber;
    }

    public String getType() {
        return this.persionnelType1;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getVictimInfoID() {
        return this.victimInfoID;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDocumentName(String str) {
        this.documentTypeText = str;
    }

    public void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public void setDocumentType(String str) {
        this.documentType = str;
    }

    public void setPeopleName(String str) {
        this.name = str;
    }

    public void setPeoplePhone(String str) {
        this.mobileNumber = str;
    }

    public void setType(String str) {
        this.persionnelType1 = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setVictimInfoID(String str) {
        this.victimInfoID = str;
    }
}

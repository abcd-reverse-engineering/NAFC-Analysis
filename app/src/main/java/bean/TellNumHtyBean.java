package bean;

import network.account.APIresult;

/* loaded from: classes.dex */
public class TellNumHtyBean extends APIresult {
    private String carrieroperator;
    private int caseCategory;
    private String caseCategoryText;
    private String createTime;
    private String id;
    private String number;
    private String submitTime;
    private String submitterID;
    private String updateTime;

    public String getCarrieroperator() {
        return this.carrieroperator;
    }

    public int getCaseCategory() {
        return this.caseCategory;
    }

    public String getCaseCategoryText() {
        return this.caseCategoryText;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public String getSubmitTime() {
        return this.submitTime;
    }

    public String getSubmitterID() {
        return this.submitterID;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCarrieroperator(String str) {
        this.carrieroperator = str;
    }

    public void setCaseCategory(int i2) {
        this.caseCategory = i2;
    }

    public void setCaseCategoryText(String str) {
        this.caseCategoryText = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setSubmitTime(String str) {
        this.submitTime = str;
    }

    public void setSubmitterID(String str) {
        this.submitterID = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}

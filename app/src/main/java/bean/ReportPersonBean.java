package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ReportPersonBean extends BaseBean {
    private String caseDis;
    private String caseId;
    private int defraudType;
    private String dupery;
    private boolean isMine;
    private String phoneNum;
    private String reportAdd;
    private String reportDic;
    private String reportPer;
    private String sfzNum;

    public String getCaseDis() {
        return this.caseDis;
    }

    public String getCaseId() {
        return this.caseId;
    }

    public int getDefraudType() {
        return this.defraudType;
    }

    public String getDupery() {
        return this.dupery;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getReportAdd() {
        return this.reportAdd;
    }

    public String getReportDic() {
        return this.reportDic;
    }

    public String getReportPer() {
        return this.reportPer;
    }

    public String getSfzNum() {
        return this.sfzNum;
    }

    public boolean isMine() {
        return this.isMine;
    }

    public void setCaseDis(String str) {
        this.caseDis = str;
    }

    public void setCaseId(String str) {
        this.caseId = str;
    }

    public void setDefraudType(int i2) {
        this.defraudType = i2;
    }

    public void setDupery(String str) {
        this.dupery = str;
    }

    public void setMine(boolean z) {
        this.isMine = z;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public void setReportAdd(String str) {
        this.reportAdd = str;
    }

    public void setReportDic(String str) {
        this.reportDic = str;
    }

    public void setReportPer(String str) {
        this.reportPer = str;
    }

    public void setSfzNum(String str) {
        this.sfzNum = str;
    }
}

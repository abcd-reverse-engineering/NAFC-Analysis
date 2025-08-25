package network.request;

import manager.AccountManager;
import network.BaseBean;
import util.v1;

/* loaded from: classes2.dex */
public class ReportCaseInfo extends BaseBean {
    private int caseCategory;
    private String caseCategoryText;
    private String caseDescription;
    private String caseNumber;
    private String id;
    private boolean isSelf;
    private String region;
    private String reporterIdNumber;
    private String reporterName;
    private String reporterPhoneNumber;
    private String submitTime;
    private String submitterID;

    public int getCaseCategory() {
        return this.caseCategory;
    }

    public String getCaseCategoryText() {
        return this.caseCategoryText;
    }

    public String getCaseDescription() {
        return this.caseDescription;
    }

    public String getCaseNumber() {
        return this.caseNumber;
    }

    public String getId() {
        return this.id;
    }

    public String getRegion() {
        return this.region;
    }

    public String getReporterIdNumber() {
        return this.reporterIdNumber;
    }

    public String getReporterName() {
        return this.reporterName;
    }

    public String getReporterPhoneNumber() {
        return this.reporterPhoneNumber;
    }

    public String getSubmitTime() {
        return this.submitTime;
    }

    public String getSubmitterID() {
        return this.submitterID;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setCaseCategory(int i2) {
        this.caseCategory = i2;
    }

    public void setCaseCategoryText(String str) {
        this.caseCategoryText = str;
    }

    public void setCaseDescription(String str) {
        this.caseDescription = str;
    }

    public void setCaseNumber(String str) {
        this.caseNumber = str;
    }

    public void setCommonParams() {
        this.submitterID = AccountManager.getAccountId();
        this.submitTime = v1.d();
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setReporterIdNumber(String str) {
        this.reporterIdNumber = str;
    }

    public void setReporterName(String str) {
        this.reporterName = str;
    }

    public void setReporterPhoneNumber(String str) {
        this.reporterPhoneNumber = str;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public void setSubmitTime(String str) {
        this.submitTime = str;
    }

    public void setSubmitterID(String str) {
        this.submitterID = str;
    }
}

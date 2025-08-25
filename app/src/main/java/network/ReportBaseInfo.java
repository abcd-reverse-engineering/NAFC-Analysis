package network;

import java.util.List;

/* loaded from: classes2.dex */
public class ReportBaseInfo extends BaseInfo {
    private List<ReportAppInfo> appReportDetails;
    private int caseCategory;
    private String caseDescription;
    private String region;
    private List<ReportAppInfo> reportDetails;
    private List<ReportSmsInfo> smsReportDetails;
    private List<ReportCallInfo> telReportDetails;
    private List<ReportSmsInfo> websiteReportDtails;

    public ReportBaseInfo() {
        setCommonParams();
    }

    public List<ReportAppInfo> getAppReportDetails() {
        return this.appReportDetails;
    }

    public int getCaseCategory() {
        return this.caseCategory;
    }

    public String getCaseDescription() {
        return this.caseDescription;
    }

    public String getRegion() {
        return this.region;
    }

    public List<ReportAppInfo> getReportDetails() {
        return this.reportDetails;
    }

    public List<ReportSmsInfo> getSmsReportDetails() {
        return this.smsReportDetails;
    }

    public List<ReportCallInfo> getTelReportDetails() {
        return this.telReportDetails;
    }

    public List<ReportSmsInfo> getWebsiteReportDtails() {
        return this.websiteReportDtails;
    }

    public void setAppReportDetails(List<ReportAppInfo> list) {
        this.appReportDetails = list;
    }

    public void setCaseCategory(int i2) {
        this.caseCategory = i2;
    }

    public void setCaseDescription(String str) {
        this.caseDescription = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setReportDetails(List<ReportAppInfo> list) {
        this.reportDetails = list;
    }

    public void setSmsReportDetails(List<ReportSmsInfo> list) {
        this.smsReportDetails = list;
    }

    public void setTelReportDetails(List<ReportCallInfo> list) {
        this.telReportDetails = list;
    }

    public void setWebsiteReportDtails(List<ReportSmsInfo> list) {
        this.websiteReportDtails = list;
    }
}

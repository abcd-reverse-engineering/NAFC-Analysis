package network.request;

import bean.SocialTradBean;
import java.util.List;
import network.BaseInfo;
import network.ReportCallInfo;
import network.ReportSmsInfo;

/* loaded from: classes2.dex */
public class EvidenceCommInfo extends BaseInfo {
    private String[] appFileIDs;
    private ReportCaseInfo caseInfo;
    private String[] fileIDs;
    private List<SocialTradBean> paymentReportDetails;
    private List<ReportSmsInfo> smsReportDetails;
    private List<SocialTradBean> socialReportDetails;
    private List<ReportCallInfo> telReportDetails;
    private List<ReportSmsInfo> websiteReportDetails;

    public EvidenceCommInfo() {
        setCommonParams();
    }

    public String[] getAppFileIDs() {
        return this.appFileIDs;
    }

    public String[] getFileIDs() {
        return this.fileIDs;
    }

    public List<SocialTradBean> getPaymentReportDetails() {
        return this.paymentReportDetails;
    }

    public ReportCaseInfo getReportCaseInfos() {
        return this.caseInfo;
    }

    public List<ReportSmsInfo> getSmsReportDetails() {
        return this.smsReportDetails;
    }

    public List<SocialTradBean> getSocialReportDetails() {
        return this.socialReportDetails;
    }

    public List<ReportCallInfo> getTelReportDetails() {
        return this.telReportDetails;
    }

    public List<ReportSmsInfo> getWebsiteReportDtails() {
        return this.websiteReportDetails;
    }

    public void setAppFileIDs(String[] strArr) {
        this.appFileIDs = strArr;
    }

    public void setFileIDs(String[] strArr) {
        this.fileIDs = strArr;
    }

    public void setPaymentReportDetails(List<SocialTradBean> list) {
        this.paymentReportDetails = list;
    }

    public void setReportCaseInfos(ReportCaseInfo reportCaseInfo) {
        this.caseInfo = reportCaseInfo;
    }

    public void setSmsReportDetails(List<ReportSmsInfo> list) {
        this.smsReportDetails = list;
    }

    public void setSocialReportDetails(List<SocialTradBean> list) {
        this.socialReportDetails = list;
    }

    public void setTelReportDetails(List<ReportCallInfo> list) {
        this.telReportDetails = list;
    }

    public void setWebsiteReportDtails(List<ReportSmsInfo> list) {
        this.websiteReportDetails = list;
    }
}

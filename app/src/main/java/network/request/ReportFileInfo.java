package network.request;

import network.BaseBean;
import network.ReportAppInfo;

/* loaded from: classes2.dex */
public class ReportFileInfo extends BaseBean {
    private ReportAppInfo appReportDetail;
    private ReportCaseInfo caseinfo;
    private ReportAppInfo reportDetail;

    public ReportAppInfo getAppReportDetail() {
        return this.appReportDetail;
    }

    public ReportCaseInfo getCaseinfo() {
        return this.caseinfo;
    }

    public ReportAppInfo getReportDetail() {
        return this.reportDetail;
    }

    public void setAppReportDetail(ReportAppInfo reportAppInfo) {
        this.appReportDetail = reportAppInfo;
    }

    public void setCaseinfo(ReportCaseInfo reportCaseInfo) {
        this.caseinfo = reportCaseInfo;
    }

    public void setReportDetail(ReportAppInfo reportAppInfo) {
        this.reportDetail = reportAppInfo;
    }
}

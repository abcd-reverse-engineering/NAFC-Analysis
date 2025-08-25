package network.request;

import bean.SnapCardSuspectBean;
import bean.SocialTradBean;
import java.util.List;
import network.BaseBean;
import network.ReportCallInfo;

/* loaded from: classes2.dex */
public class SnapCardCommInfo extends BaseBean {
    private SnapCardSuspectBean caseInfo;
    private List<SocialTradBean> paymentReportDetails;
    private List<SocialTradBean> socialReportDetails;
    private List<ReportCallInfo> telReportDetails;

    public SnapCardSuspectBean getCaseInfo() {
        return this.caseInfo;
    }

    public List<SocialTradBean> getPaymentReportDetails() {
        return this.paymentReportDetails;
    }

    public List<SocialTradBean> getSocialReportDetails() {
        return this.socialReportDetails;
    }

    public List<ReportCallInfo> getTelReportDetails() {
        return this.telReportDetails;
    }

    public void setCaseInfo(SnapCardSuspectBean snapCardSuspectBean) {
        this.caseInfo = snapCardSuspectBean;
    }

    public void setPaymentReportDetails(List<SocialTradBean> list) {
        this.paymentReportDetails = list;
    }

    public void setSocialReportDetails(List<SocialTradBean> list) {
        this.socialReportDetails = list;
    }

    public void setTelReportDetails(List<ReportCallInfo> list) {
        this.telReportDetails = list;
    }
}

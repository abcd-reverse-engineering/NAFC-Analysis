package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ReportResultBean extends BaseBean {
    private String appReportDetailId;
    private String id;
    private String reportDetailId;

    public String getAppReportDetailId() {
        return this.appReportDetailId;
    }

    public String getId() {
        return this.id;
    }

    public String getReportDetailId() {
        return this.reportDetailId;
    }

    public void setAppReportDetailId(String str) {
        this.appReportDetailId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setReportDetailId(String str) {
        this.reportDetailId = str;
    }
}

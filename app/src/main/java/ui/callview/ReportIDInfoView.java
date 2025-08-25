package ui.callview;

import bean.ReportIDInfoBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ReportIDInfoView extends BaseView {
    void ReportIDInfoBean(ReportIDInfoBean reportIDInfoBean);

    void onSuccessCaseNum(int i2);

    void onfailCaseNum();

    void onsuccessReportID();
}

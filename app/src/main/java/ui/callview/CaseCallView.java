package ui.callview;

import bean.CaseHistoryBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CaseCallView extends BaseView {
    void onCreateSuccessRequest(String str, String str2, String str3, String str4);

    void onDeleteSuccessRequest(CaseHistoryBean.Rows rows);

    void onHistorySuccessRequest(CaseHistoryBean caseHistoryBean, int i2);

    void onStatusSuccessRequest(boolean z);
}

package ui.callview;

import bean.ReportResultBean;
import network.account.APIresult;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface AudioCallView extends BaseView {
    void onErrorRequest();

    void onNextRequest(APIresult<ReportResultBean> aPIresult);

    void onStartRequest();

    void onSuccessRequest(APIresult aPIresult);

    void onfailRequest();
}

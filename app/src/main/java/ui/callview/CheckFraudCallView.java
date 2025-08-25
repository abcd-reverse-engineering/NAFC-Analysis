package ui.callview;

import bean.APIH5Bean;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import network.account.APIresult;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CheckFraudCallView extends BaseView {
    void onSuccessRequest(APIresult<CheckFraudBean> aPIresult);

    void onSuccessRequestCount(CheckFraudCountBean checkFraudCountBean);

    void onSuccessShareConfig(APIH5Bean aPIH5Bean);

    void onfailRequest();
}

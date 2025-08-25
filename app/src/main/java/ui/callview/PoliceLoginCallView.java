package ui.callview;

import bean.PolicBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface PoliceLoginCallView extends BaseView {
    void onSendFailRequest();

    void onSendSuccessRequest();

    void onVerifySuccessRequest(PolicBean policBean);
}

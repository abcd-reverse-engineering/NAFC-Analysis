package ui.callview;

import bean.AdBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface WelcomeCallView extends BaseView {
    void onAdRequest(AdBean adBean, long j2);

    void onSuccessRequest();

    void onfailRequest();
}

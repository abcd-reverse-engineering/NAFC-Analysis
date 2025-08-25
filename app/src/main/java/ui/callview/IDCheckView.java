package ui.callview;

import bean.VerifyHomePointBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface IDCheckView extends BaseView {
    void onSuccCreateCheckRequest();

    void onSuccCreateRequest(VerifyHomePointBean verifyHomePointBean);
}

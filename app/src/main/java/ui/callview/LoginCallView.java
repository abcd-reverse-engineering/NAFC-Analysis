package ui.callview;

import network.account.APIresult;
import network.account.AccountInfo;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface LoginCallView extends BaseView {
    void onLoginSuccRequest(APIresult<AccountInfo> aPIresult);

    void onOathfail();

    void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str);

    void onfail();
}

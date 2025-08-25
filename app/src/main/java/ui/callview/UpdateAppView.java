package ui.callview;

import interfaces.IBaseBeanCall;
import network.DownloadInfo;
import network.account.APIresult;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface UpdateAppView extends BaseView {
    void onSuccRequest(APIresult<DownloadInfo> aPIresult, IBaseBeanCall iBaseBeanCall);
}

package ui.callview;

import network.HistoryListInfo;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface HistoryReportEvdCallView extends BaseView {
    void onSuccessRequest(HistoryListInfo historyListInfo);

    void onfailRequest();
}

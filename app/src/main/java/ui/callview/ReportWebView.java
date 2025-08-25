package ui.callview;

import bean.ReportWebsitBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ReportWebView extends BaseView {
    void onItemDelet(int i2);

    void onSuccessHandle(int i2, List<ReportWebsitBean> list);
}

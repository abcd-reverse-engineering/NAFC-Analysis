package ui.callview;

import bean.ReplyBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ReportRecordsReplyCallview extends BaseView {
    void onSuccessRequest(List<ReplyBean> list);

    void onfailRequest();
}

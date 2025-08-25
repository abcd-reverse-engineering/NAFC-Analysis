package ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import bean.SocialAccBean;
import java.util.ArrayList;
import network.HistoryListInfo;
import ui.callview.ChatFraudView;
import ui.callview.ReportCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ChatFraudPresenter extends ModelPresent<ChatFraudView> {

    class a implements ReportCallView {
        a() {
        }

        @Override // ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            w1.a("举报成功");
            ChatFraudPresenter.this.mActivity.finish();
        }

        @Override // ui.callview.ReportCallView
        public void onfailRequest() {
            w1.a("举报失败，稍后再试");
        }
    }

    public ChatFraudPresenter(Activity activity, ChatFraudView chatFraudView) {
        super(activity, chatFraudView);
    }

    public void oneKeyReportTrad(SocialAccBean socialAccBean, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(socialAccBean);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new a());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, null, arrayList, null, reportPersonBean);
    }
}

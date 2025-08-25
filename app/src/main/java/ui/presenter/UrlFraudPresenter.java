package ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import java.util.ArrayList;
import network.HistoryListInfo;
import ui.basemvp.BaseView;
import ui.callview.ReportCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class UrlFraudPresenter extends ModelPresent {

    class a implements ReportCallView {
        a() {
        }

        @Override // ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            w1.a("举报成功");
            UrlFraudPresenter.this.mActivity.finish();
        }

        @Override // ui.callview.ReportCallView
        public void onfailRequest() {
            w1.a("举报失败，稍后再试");
        }
    }

    public UrlFraudPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    public void oneKeyReportUrl(String str, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new a());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, arrayList, null, null, reportPersonBean);
    }
}

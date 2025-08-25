package ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.HistoryReportEvdCallView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class HistoryReportEvdPresenter extends ModelPresent<HistoryReportEvdCallView> {
    private Activity mActivity;

    class a extends MiddleSubscriber<APIresult<HistoryListInfo>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HistoryListInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HistoryReportEvdCallView) HistoryReportEvdPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryListInfo> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((HistoryReportEvdCallView) HistoryReportEvdPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public HistoryReportEvdPresenter(Activity activity, HistoryReportEvdCallView historyReportEvdCallView) {
        super(activity, historyReportEvdCallView);
    }

    public void getReportList(int i2, int i3) {
        HashMap<String, String> map = new HashMap<>();
        map.put("submitterID", AccountManager.getAccountId());
        map.put("objectType", "0");
        map.put("page", i2 + "");
        map.put("rows", i3 + "");
        uploadParam(map, d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.U), new a());
    }

    public void uploadParam(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<HistoryListInfo>> middleSubscriber) {
        getReportHistorys(map, str, middleSubscriber);
    }
}

package ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.HistoryDetailInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.HistoryDetailCallView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class HistoryDetaPresenter extends ModelPresent<HistoryDetailCallView> {

    class a extends MiddleSubscriber<APIresult<HistoryDetailInfo>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HistoryDetailInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HistoryDetailCallView) HistoryDetaPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryDetailInfo> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((HistoryDetailCallView) HistoryDetaPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public HistoryDetaPresenter(Activity activity, HistoryDetailCallView historyDetailCallView) {
        super(activity, historyDetailCallView);
    }

    public void getDetail(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        uploadParam(map, d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.V), new a());
    }

    public void uploadParam(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<HistoryDetailInfo>> middleSubscriber) {
        getReportdetail(map, str, middleSubscriber);
    }
}

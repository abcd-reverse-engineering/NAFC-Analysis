package ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.HistoryDetailInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.HistoryDetailCallView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class HistoryDKDetaPresenter extends ModelPresent<HistoryDetailCallView> {

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
            ((HistoryDetailCallView) HistoryDKDetaPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryDetailInfo> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((HistoryDetailCallView) HistoryDKDetaPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
        }
    }

    public HistoryDKDetaPresenter(Activity activity, HistoryDetailCallView historyDetailCallView) {
        super(activity, historyDetailCallView);
    }

    public void getDetail(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        uploadParam(map, "url", new a());
    }

    public void uploadParam(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<HistoryDetailInfo>> middleSubscriber) {
        getReportdetail(map, str, middleSubscriber);
    }
}

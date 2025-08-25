package network.http;

import android.app.Activity;
import android.content.res.Resources;
import bean.module.ModuelConfig;
import d.a;
import e.b;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.ReportNewActivity;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ReportNumHttp extends ModelPresent {
    private static ReportNumHttp mHttp;

    public interface Callback {
        void onNumSuccess();
    }

    private ReportNumHttp() {
        super((Activity) null, (BaseView) null);
    }

    public static ReportNumHttp getInstance() {
        if (mHttp == null) {
            mHttp = new ReportNumHttp();
        }
        return mHttp;
    }

    public void principalHttp(final Callback callback) {
        String strA = a.a(ModuelConfig.MODEL_REPORT, 5, b.e0);
        HashMap<String, String> map = new HashMap<>();
        map.put("submitterID", AccountManager.getAccountId());
        getReportNum(strA, map, new MiddleSubscriber<APIresult<Integer>>() { // from class: network.http.ReportNumHttp.1
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return Integer.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
                super.onErrorMiddle(aPIException);
                w1.e(aPIException.getMessage());
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<Integer> aPIresult) throws Resources.NotFoundException {
                super.onNextMiddle(aPIresult);
                if (aPIresult == null) {
                    onErrorMiddle(APIException.getApiExcept());
                    return;
                }
                if (aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                    return;
                }
                int iIntValue = aPIresult.getData().intValue();
                if (iIntValue <= 0) {
                    w1.a("今日举报数量超限，请明日再试");
                } else {
                    ReportNewActivity.REPORTNUM = iIntValue;
                    callback.onNumSuccess();
                }
            }
        });
    }
}

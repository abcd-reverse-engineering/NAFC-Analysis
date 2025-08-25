package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.module.ModuelConfig;
import java.util.HashMap;
import java.util.Map;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ReportCommitView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class SignCommitPresenter extends ModelPresent<ReportCommitView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportCommitView) SignCommitPresenter.this.mvpView).onSuccessHandle();
            }
        }
    }

    public SignCommitPresenter(Activity activity, ReportCommitView reportCommitView) {
        super(activity, reportCommitView);
    }

    public void comitCaseInfo(String str) {
        HashMap map = new HashMap();
        map.put("id", str);
        comitCaseInfoHttp(map);
    }

    public void comitCaseInfoHttp(Map<String, String> map) {
        reportConfirm(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.c2), map, new a());
    }
}

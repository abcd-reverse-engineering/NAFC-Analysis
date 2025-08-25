package ui.presenter;

import android.app.Activity;
import bean.CheckUserBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ManualView;
import ui.model.ModelPresent;
import util.b1;

/* loaded from: classes2.dex */
public class ManualPresenter extends ModelPresent<ManualView> {

    class a extends MiddleSubscriber<APIresult<CheckUserBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckUserBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            ((ManualView) ManualPresenter.this.mvpView).onfail("");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ManualView) ManualPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public ManualPresenter(Activity activity, ManualView manualView) {
        super(activity, manualView);
    }

    public void getAuditinfoHttp(HashMap<String, String> map) {
        getAuditinfo(d.a.a(ModuelConfig.MODEL_MANUAL, 8, e.b.E0), map, new a());
    }

    public void getCheckInfo(String str) {
        b1.a("查询中...", true, this.mActivity);
        HashMap<String, String> map = new HashMap<>();
        map.put("number", str);
        getAuditinfoHttp(map);
    }
}

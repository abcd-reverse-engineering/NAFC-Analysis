package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.APIH5Bean;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CheckFraudCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CheckFraudPresenter extends ModelPresent<CheckFraudCallView> {

    class a extends MiddleSubscriber<APIresult<APIH5Bean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<APIH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                return;
            }
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessShareConfig(aPIresult.getData());
        }
    }

    class b extends MiddleSubscriber<APIresult<CheckFraudBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null) {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequest(aPIresult);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<CheckFraudBean>> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            super.onErrorMiddle(aPIException);
            w1.e(aPIException.getMessage());
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudBean> aPIresult) throws Resources.NotFoundException {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null) {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequest(aPIresult);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<CheckFraudBean>> {
        d() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null) {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequest(aPIresult);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    class e extends MiddleSubscriber<APIresult<CheckFraudCountBean>> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudCountBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudCountBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequestCount(aPIresult.getData());
            }
        }
    }

    public CheckFraudPresenter(Activity activity, CheckFraudCallView checkFraudCallView) {
        super(activity, checkFraudCallView);
    }

    private void checkFraudIpUrlHttp(HashMap<String, String> map) {
        checkFraudIpUrl(map, d.a.a(ModuelConfig.MODEL_FRAUDCHECK, 7, e.b.z0), new c());
    }

    public void checkFraud(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_FRAUDCHECK, 7, e.b.w0);
        HashMap<String, String> map = new HashMap<>();
        map.put("CardNumber", str);
        requestCheckFraud(strA, map, new b());
    }

    public void checkFraudChat(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_FRAUDCHECK, 7, e.b.y0);
        HashMap<String, String> map = new HashMap<>();
        map.put("accountNumber", str);
        requestCheckFraud(strA, map, new d());
    }

    public void checkFraudCount(int i2) {
        requestCheckFraudCount(i2 == 1 ? d.a.a(ModuelConfig.MODEL_FRAUDCHECK, 7, e.b.A0) : i2 == 2 ? d.a.a(ModuelConfig.MODEL_FRAUDCHECK, 7, e.b.B0) : d.a.a(ModuelConfig.MODEL_FRAUDCHECK, 7, e.b.x0), new e());
    }

    public void checkFraudIpUrl(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("content", str);
        checkFraudIpUrlHttp(map);
    }

    public void requestShareConfig() {
        String str = d.a.f13517c + e.b.f13573k;
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykey", "CheckShare");
        requestAppConfig(map, str, new a());
    }
}

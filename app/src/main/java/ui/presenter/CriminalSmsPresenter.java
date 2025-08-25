package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.CriminalSmsBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalSmsCallView;
import ui.model.OSSModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CriminalSmsPresenter extends OSSModelPresent<CriminalSmsCallView> {

    class a extends MiddleSubscriber<APIresult<List<CriminalSmsBean>>> {

        /* renamed from: ui.presenter.CriminalSmsPresenter$a$a, reason: collision with other inner class name */
        class C0295a extends com.google.gson.d0.a<List<CriminalSmsBean>> {
            C0295a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0295a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalSmsBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((CriminalSmsCallView) ((OSSModelPresent) CriminalSmsPresenter.this).mvpView).onSuccess(aPIresult.getData());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19850a;

        b(int i2) {
            this.f19850a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((CriminalSmsCallView) ((OSSModelPresent) CriminalSmsPresenter.this).mvpView).onSuccessDelete(this.f19850a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public CriminalSmsPresenter(Activity activity, CriminalSmsCallView criminalSmsCallView) {
        super(activity, criminalSmsCallView);
    }

    public void deleteHttp(CriminalSmsBean criminalSmsBean, int i2) {
        String caseInfoID = criminalSmsBean.getCaseInfoID();
        String smsInfoID = criminalSmsBean.getSmsInfoID();
        if (TextUtils.isEmpty(caseInfoID) || TextUtils.isEmpty(smsInfoID)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", caseInfoID);
        map.put("smsInfoID", smsInfoID);
        postOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.R1), map, new b(i2));
    }

    public void http(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        smsList(map, d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.P1), new a());
    }
}

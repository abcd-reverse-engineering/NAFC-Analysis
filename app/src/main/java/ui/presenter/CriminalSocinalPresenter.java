package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.CriminalSocialBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalSocialCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CriminalSocinalPresenter extends ModelPresent<CriminalSocialCallView> {

    class a extends MiddleSubscriber<APIresult<List<CriminalSocialBean>>> {

        /* renamed from: ui.presenter.CriminalSocinalPresenter$a$a, reason: collision with other inner class name */
        class C0297a extends com.google.gson.d0.a<List<CriminalSocialBean>> {
            C0297a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0297a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalSocialBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CriminalSocialCallView) CriminalSocinalPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19862a;

        b(int i2) {
            this.f19862a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CriminalSocialCallView) CriminalSocinalPresenter.this.mvpView).onSuccessDelete(this.f19862a);
            }
        }
    }

    public CriminalSocinalPresenter(Activity activity, CriminalSocialCallView criminalSocialCallView) {
        super(activity, criminalSocialCallView);
    }

    public void socialDeleteHttp(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.V1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("netAccountInfoID", str2);
        postOperation(strA, map, new b(i2));
    }

    public void socialHttp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.U1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        socialList(strA, map, new a());
    }
}

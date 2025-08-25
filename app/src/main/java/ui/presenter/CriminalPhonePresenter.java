package ui.presenter;

import android.app.Activity;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import bean.module.ModuelConfig;
import h.q2.t.i0;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalPhoneView;
import ui.model.ModelPresent;
import util.w1;

/* compiled from: CriminalPhonePresenter.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e¨\u0006\u0012"}, d2 = {"Lui/presenter/CriminalPhonePresenter;", "Lui/model/ModelPresent;", "Lui/callview/CriminalPhoneView;", "activity", "Landroid/app/Activity;", "callview", "(Landroid/app/Activity;Lui/callview/CriminalPhoneView;)V", "criminalCallSave", "", "bean", "Lbean/CallBean;", "getCriminakTel", "getCriminalCallList", "caseInfoID", "", "getCriminalCallNum", "removecalltel", "callTelInfoID", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalPhonePresenter extends ModelPresent<CriminalPhoneView> {

    /* compiled from: CriminalPhonePresenter.kt */
    public static final class a extends MiddleSubscriber<APIresult<CallBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            return CallBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.e APIException aPIException) {
            w1.a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.d APIresult<CallBean> aPIresult) {
            i0.f(aPIresult, "result");
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            CallBean data = aPIresult.getData();
            i0.a((Object) data, "result?.data");
            criminalPhoneView.onSuccessSave(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0014¨\u0006\r"}, d2 = {"ui/presenter/CriminalPhonePresenter$getCriminakTel$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "", "", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "e", "Lnetwork/APIException;", "onNextMiddle", "resultInfo", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public static final class b extends MiddleSubscriber<APIresult<List<? extends String>>> {

        /* compiled from: CriminalPhonePresenter.kt */
        public static final class a extends com.google.gson.d0.a<List<? extends String>> {
            a() {
            }
        }

        b() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            Type type = new a().getType();
            i0.a((Object) type, "object : TypeToken<List<String>>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.d APIException aPIException) {
            i0.f(aPIException, "e");
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.d APIresult<List<String>> aPIresult) {
            i0.f(aPIresult, "resultInfo");
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            List<String> data = aPIresult.getData();
            i0.a((Object) data, "resultInfo.data");
            criminalPhoneView.onSuccess(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u001e\u0010\u000b\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0014¨\u0006\r"}, d2 = {"ui/presenter/CriminalPhonePresenter$getCriminalCallList$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "", "Lbean/CallBean;", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "exception", "Lnetwork/APIException;", "onNextMiddle", "result", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public static final class c extends MiddleSubscriber<APIresult<List<? extends CallBean>>> {

        /* compiled from: CriminalPhonePresenter.kt */
        public static final class a extends com.google.gson.d0.a<List<? extends CallBean>> {
            a() {
            }
        }

        c() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            Type type = new a().getType();
            i0.a((Object) type, "object : TypeToken<List<CallBean>>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.e APIException aPIException) {
            w1.a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.e APIresult<List<CallBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            List<CallBean> data = aPIresult.getData();
            i0.a((Object) data, "result?.data");
            criminalPhoneView.onSuccessList(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0018\u0010\n\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¨\u0006\f"}, d2 = {"ui/presenter/CriminalPhonePresenter$getCriminalCallNum$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "Lbean/CriminalPhoneNumBean;", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "exception", "Lnetwork/APIException;", "onNextMiddle", "result", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public static final class d extends MiddleSubscriber<APIresult<CriminalPhoneNumBean>> {

        /* compiled from: CriminalPhonePresenter.kt */
        public static final class a extends com.google.gson.d0.a<CriminalPhoneNumBean> {
            a() {
            }
        }

        d() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            Type type = new a().getType();
            i0.a((Object) type, "object : TypeToken<CriminalPhoneNumBean>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.e APIException aPIException) {
            w1.a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.e APIresult<CriminalPhoneNumBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            CriminalPhoneNumBean data = aPIresult.getData();
            i0.a((Object) data, "result?.data");
            criminalPhoneView.onSuccessPhoneNum(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014¨\u0006\f"}, d2 = {"ui/presenter/CriminalPhonePresenter$removecalltel$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "e", "Lnetwork/APIException;", "onNextMiddle", "resultInfo", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public static final class e extends MiddleSubscriber<APIresult<String>> {

        /* compiled from: CriminalPhonePresenter.kt */
        public static final class a extends com.google.gson.d0.a<List<? extends String>> {
            a() {
            }
        }

        e() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            Type type = new a().getType();
            i0.a((Object) type, "object : TypeToken<List<String>>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.d APIException aPIException) {
            i0.f(aPIException, "e");
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.d APIresult<String> aPIresult) {
            i0.f(aPIresult, "resultInfo");
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((CriminalPhoneView) CriminalPhonePresenter.this.mvpView).onSuccessRemove();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriminalPhonePresenter(@i.c.a.d Activity activity, @i.c.a.d CriminalPhoneView criminalPhoneView) {
        super(activity, criminalPhoneView);
        i0.f(activity, "activity");
        i0.f(criminalPhoneView, "callview");
    }

    public final void criminalCallSave(@i.c.a.d CallBean callBean) {
        i0.f(callBean, "bean");
        criminalCallSave(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.x1), callBean, new a());
    }

    public final void getCriminakTel() {
        getsocialtels(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.z1), new b());
    }

    public final void getCriminalCallList(@i.c.a.d String str) {
        i0.f(str, "caseInfoID");
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getCriminalPhoneList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.w1), map, new c());
    }

    public final void getCriminalCallNum(@i.c.a.d String str) {
        i0.f(str, "caseInfoID");
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getCriminalCallNum(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.v1), map, new d());
    }

    public final void removecalltel(@i.c.a.d String str, @i.c.a.d String str2) {
        i0.f(str, "caseInfoID");
        i0.f(str2, "callTelInfoID");
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("callTelInfoID", str2);
        removecalltel(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.y1), map, new e());
    }
}

package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.RelationBean;
import bean.RelationPlatBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.RelationView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class RelationPresenter extends ModelPresent<RelationView> {

    class a extends MiddleSubscriber<APIresult<List<RelationBean>>> {

        /* renamed from: ui.presenter.RelationPresenter$a$a, reason: collision with other inner class name */
        class C0307a extends com.google.gson.d0.a<List<RelationBean>> {
            C0307a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0307a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<RelationBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20032a;

        b(int i2) {
            this.f20032a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onItemDelet(this.f20032a);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<String>> {

        class a extends com.google.gson.d0.a<String> {
            a() {
            }
        }

        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessSave();
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<List<RelationPlatBean>>> {

        class a extends com.google.gson.d0.a<List<RelationPlatBean>> {
            a() {
            }
        }

        d() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<RelationPlatBean>> aPIresult) throws Resources.NotFoundException {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessPlatList(aPIresult.getData());
            }
        }
    }

    public RelationPresenter(Activity activity, RelationView relationView) {
        super(activity, relationView);
    }

    public void getRelationList(String str) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.E1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getRelationList(strA, map, new a());
    }

    public void getRelationPlatList() {
        getRelationPlatList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.H1), new HashMap<>(), new d());
    }

    public void removeRelationtel(String str, String str2, int i2) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.G1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("linkTelInfoID", str2);
        removeRelationtel(strA, map, new b(i2));
    }

    public void saveRelationTel(RelationBean relationBean) {
        b1.a(this.mActivity, "请稍等...");
        saveRelationTel(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.F1), JNIHandStamp.getInstance().pamramToMap(relationBean), new c());
    }
}

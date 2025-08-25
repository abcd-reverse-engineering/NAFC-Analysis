package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.AccountListBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.Hicore;
import ui.callview.AccountListCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class AccountListPresenter extends ModelPresent<AccountListCallView> {

    class a extends MiddleSubscriber<APIresult<List<AccountListBean>>> {

        /* renamed from: ui.presenter.AccountListPresenter$a$a, reason: collision with other inner class name */
        class C0292a extends com.google.gson.d0.a<List<AccountListBean>> {
            C0292a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0292a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<AccountListBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountListBean f19767a;

        b(AccountListBean accountListBean) {
            this.f19767a = accountListBean;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onDeleteSuccess(this.f19767a);
            } else {
                w1.a(aPIresult.getMsg());
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<List<AccountListBean>>> {

        class a extends com.google.gson.d0.a<List<AccountListBean>> {
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
        protected void onNextMiddle(APIresult<List<AccountListBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public AccountListPresenter(Activity activity, AccountListCallView accountListCallView) {
        super(activity, accountListCallView);
    }

    public void deleteAccount(AccountListBean accountListBean) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", accountListBean.getId());
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.h1), map, new b(accountListBean));
    }

    public void getPayment(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.g1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getPayment(strA, map, new a());
    }

    public void getStopPayment(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.n1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getPayment(strA, map, new c());
    }
}

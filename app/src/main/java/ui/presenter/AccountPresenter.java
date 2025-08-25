package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.AccountBean;
import bean.CaseDivisonBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.AccountCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class AccountPresenter extends ModelPresent<AccountCallView> {

    class a extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* renamed from: ui.presenter.AccountPresenter$a$a, reason: collision with other inner class name */
        class C0293a extends com.google.gson.d0.a<List<CaseDivisonBean>> {
            C0293a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0293a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CaseDivisonBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((AccountCallView) AccountPresenter.this.mvpView).onSuccessAccountType(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            if (aPIresult.getCode() != 0) {
                w1.a(aPIresult.getMsg());
                return;
            }
            String data = aPIresult.getData();
            if (TextUtils.isEmpty(data)) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((AccountCallView) AccountPresenter.this.mvpView).onSuccessSave(data);
            }
        }
    }

    public AccountPresenter(Activity activity, AccountCallView accountCallView) {
        super(activity, accountCallView);
    }

    private void savePaymentHttp(HashMap<String, String> map) {
        savexc(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.k1), map, new b());
    }

    public void accountType() {
        surveyCredentType(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.j1), new a());
    }

    public void savePayment(AccountBean accountBean) {
        savePaymentHttp(JNIHandStamp.getInstance().pamramToMap(accountBean));
    }
}

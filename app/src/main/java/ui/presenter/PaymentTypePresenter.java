package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.CaseDivisonBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.PaymentTypeCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class PaymentTypePresenter extends ModelPresent<PaymentTypeCallView> {

    class a extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* renamed from: ui.presenter.PaymentTypePresenter$a$a, reason: collision with other inner class name */
        class C0305a extends com.google.gson.d0.a<List<CaseDivisonBean>> {
            C0305a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0305a().getType();
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
                ((PaymentTypeCallView) PaymentTypePresenter.this.mvpView).onSuccessPaymentType(aPIresult.getData());
            }
        }
    }

    public PaymentTypePresenter(Activity activity, PaymentTypeCallView paymentTypeCallView) {
        super(activity, paymentTypeCallView);
    }

    public void paymentType() {
        surveyCredentType(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.i1), new a());
    }
}

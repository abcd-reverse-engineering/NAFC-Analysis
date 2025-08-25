package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.module.ModuelConfig;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.PolicInfoView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class PolicInfoPresenter extends ModelPresent<PolicInfoView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                d.b.e();
                PolicInfoPresenter.this.mActivity.finish();
            }
        }
    }

    public PolicInfoPresenter(Activity activity, PolicInfoView policInfoView) {
        super(activity, policInfoView);
    }

    public void policUserLogout() {
        policUserLogout(d.a.a(ModuelConfig.MODEL_CASEXC, 8, e.b.Z0), new a());
    }
}

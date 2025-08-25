package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import bean.AppSignBean;
import bean.AppVirusBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.VirusKillingCallView;
import ui.model.ModelPresent;
import util.r1;
import util.v1;
import util.w1;

/* loaded from: classes2.dex */
public class VirusKillingPresenter extends ModelPresent<VirusKillingCallView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((VirusKillingCallView) VirusKillingPresenter.this.mvpView).onAppealSuccess();
                    return;
                }
                w1.a(aPIresult.getMsg());
            }
            onErrorMiddle(APIException.getApiExcept());
        }
    }

    public VirusKillingPresenter(Activity activity, VirusKillingCallView virusKillingCallView) {
        super(activity, virusKillingCallView);
    }

    private void appealAppHttp(List<AppVirusBean> list) {
        appOperation(d.a.a(ModuelConfig.MODEL_WARN, 5, e.b.j0), list, new a());
    }

    private void setSign(List<AppVirusBean> list) {
        for (AppVirusBean appVirusBean : list) {
            appVirusBean.setUseMobileNumber(v1.j());
            getSignVirus(appVirusBean);
        }
    }

    public void appealApp(List<AppVirusBean> list) {
        for (AppVirusBean appVirusBean : list) {
            appVirusBean.setUseMobileNumber(v1.j());
            getSignVirus(appVirusBean);
        }
        appealAppHttp(list);
    }

    public void getSignVirus(AppVirusBean appVirusBean) {
        AppSignBean appSignBeanD;
        if (appVirusBean == null || (appSignBeanD = r1.d(appVirusBean.getPkgName(), appVirusBean.getFilePath())) == null) {
            return;
        }
        appVirusBean.setSignMD5(appSignBeanD.getSignMD5());
        appVirusBean.setSignSha1(appSignBeanD.getSignSha1());
        appVirusBean.setSignSha256(appSignBeanD.getSignSha256());
    }

    public VirusKillingPresenter(Context context, VirusKillingCallView virusKillingCallView) {
        super(context, virusKillingCallView);
    }
}

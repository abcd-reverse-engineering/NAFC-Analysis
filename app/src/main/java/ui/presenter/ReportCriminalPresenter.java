package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.CriminalRequestBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ReporCriminalView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class ReportCriminalPresenter extends ModelPresent<ReporCriminalView> {

    class a extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20072a;

        a(boolean z) {
            this.f20072a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else if (this.f20072a) {
                ((ReporCriminalView) ReportCriminalPresenter.this.mvpView).onSuccessHandle(2, aPIresult.getData());
            } else {
                ((ReporCriminalView) ReportCriminalPresenter.this.mvpView).onSuccessHandle(3, aPIresult.getData());
            }
        }
    }

    public ReportCriminalPresenter(Activity activity, ReporCriminalView reporCriminalView) {
        super(activity, reporCriminalView);
    }

    private void httpReportCriminalAdd(CriminalRequestBean criminalRequestBean, boolean z) {
        reportCriminalAdd(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.p1), criminalRequestBean, new a(z));
    }

    public void reportCriminalAdd(CriminalRequestBean criminalRequestBean, boolean z) {
        b1.a("请稍后...", true, this.mActivity);
        httpReportCriminalAdd(criminalRequestBean, z);
    }
}

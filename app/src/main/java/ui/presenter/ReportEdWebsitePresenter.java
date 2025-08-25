package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.ReportWebsitBean;
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
public class ReportEdWebsitePresenter extends ModelPresent<ReporCriminalView> {

    class a extends MiddleSubscriber<APIresult<String>> {
        a() {
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
            } else {
                w1.a("提交成功");
                ReportEdWebsitePresenter.this.mActivity.finish();
            }
        }
    }

    public ReportEdWebsitePresenter(Activity activity, ReporCriminalView reporCriminalView) {
        super(activity, reporCriminalView);
    }

    public void surveyAddCaseWebUrl(ReportWebsitBean reportWebsitBean) {
        b1.a("请稍后...", true, this.mActivity);
        reportAddCaseWebUrl(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.Z1), reportWebsitBean, new a());
    }
}

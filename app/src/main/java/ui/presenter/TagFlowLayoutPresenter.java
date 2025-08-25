package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.ReportZPBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.TagFlowLayoutCallView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class TagFlowLayoutPresenter extends ModelPresent<TagFlowLayoutCallView> {

    class a extends MiddleSubscriber<APIresult<List<ReportZPBean>>> {

        /* renamed from: ui.presenter.TagFlowLayoutPresenter$a$a, reason: collision with other inner class name */
        class C0315a extends com.google.gson.d0.a<List<ReportZPBean>> {
            C0315a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0315a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            super.onErrorMiddle(aPIException);
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<ReportZPBean>> aPIresult) throws Resources.NotFoundException {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            List<ReportZPBean> data = aPIresult.getData();
            if (data == null || data.size() <= 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((TagFlowLayoutCallView) TagFlowLayoutPresenter.this.mvpView).onSuccessRequest(data);
            }
        }
    }

    public TagFlowLayoutPresenter(Activity activity, TagFlowLayoutCallView tagFlowLayoutCallView) {
        super(activity, tagFlowLayoutCallView);
    }

    public void getReportMarkData(int i2) {
        b1.a("请稍后...", true, this.mActivity);
        String strA = d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.X);
        if (i2 == 2) {
            strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.W0);
        }
        getReportMarkData(strA, new a());
    }
}

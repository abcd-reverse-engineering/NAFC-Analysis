package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.ReportIDInfoBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.basemvp.BaseView;
import ui.callview.ReportIDInfoView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class SurveyReportPresenter extends ModelPresent {
    private ReportIDInfoView mView;

    class a extends MiddleSubscriber<APIresult<ReportIDInfoBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportIDInfoBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<ReportIDInfoBean> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                SurveyReportPresenter.this.mView.ReportIDInfoBean(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() == 0) {
                SurveyReportPresenter.this.mView.onsuccessReportID();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<Integer>> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            SurveyReportPresenter.this.mView.onfailCaseNum();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() == 0) {
                SurveyReportPresenter.this.mView.onSuccessCaseNum(aPIresult.getData().intValue());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public SurveyReportPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    private void httpCaseInfoById(HashMap<String, String> map) {
        getCaseInfoById(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.a1), map, new a());
    }

    private void httpConfirmCaseInfoById(HashMap<String, String> map) {
        getCaseInfoById(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.b1), map, new b());
    }

    public void ConfirmCaseInfoById(String str) {
        b1.a(this.mActivity, "请稍后...");
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        httpConfirmCaseInfoById(map);
    }

    public void getCaseBankNum() {
        getCaseBankNum(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.e2), new c());
    }

    public void getCaseInfoById(String str) {
        b1.a(this.mActivity, "请求中...");
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        httpCaseInfoById(map);
    }

    public SurveyReportPresenter(Activity activity, ReportIDInfoView reportIDInfoView) {
        super(activity, reportIDInfoView);
        this.mView = reportIDInfoView;
    }
}

package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.QATypeBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.FeedbackHelpCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class FeedbackHelpPresenter extends ModelPresent<FeedbackHelpCallView> {

    class a extends MiddleSubscriber<APIresult<List<QATypeBean>>> {

        /* renamed from: ui.presenter.FeedbackHelpPresenter$a$a, reason: collision with other inner class name */
        class C0300a extends com.google.gson.d0.a<List<QATypeBean>> {
            C0300a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0300a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            super.onErrorMiddle(aPIException);
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<QATypeBean>> aPIresult) throws Resources.NotFoundException {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else if (aPIresult.getData() != null) {
                ((FeedbackHelpCallView) FeedbackHelpPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            } else {
                w1.a("请重试");
            }
        }
    }

    public FeedbackHelpPresenter(Activity activity, FeedbackHelpCallView feedbackHelpCallView) {
        super(activity, feedbackHelpCallView);
    }

    public void getQAList() {
        requestQAList(d.a.a(ModuelConfig.MODEL_FEEDBACK, 8, e.b.J0), new a());
    }
}

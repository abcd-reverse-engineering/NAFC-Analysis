package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.FeedbackDetailCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class FeedbackDetailPresenter extends ModelPresent<FeedbackDetailCallView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            super.onErrorMiddle(aPIException);
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((FeedbackDetailCallView) FeedbackDetailPresenter.this.mvpView).onSuccessRequestt();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public FeedbackDetailPresenter(Activity activity, FeedbackDetailCallView feedbackDetailCallView) {
        super(activity, feedbackDetailCallView);
    }

    public void getSolve(String str, boolean z) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        map.put("isSolve", Boolean.valueOf(z));
        getSolve(map);
    }

    public void getSolve(HashMap<String, Object> map) {
        requestSolve(d.a.a(ModuelConfig.MODEL_FEEDBACK, 8, e.b.K0), map, new a());
    }
}

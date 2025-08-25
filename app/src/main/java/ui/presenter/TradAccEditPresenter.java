package ui.presenter;

import android.app.Activity;
import bean.SocialTypeBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.SocialTagsCallView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class TradAccEditPresenter extends ModelPresent<SocialTagsCallView> {

    class a extends MiddleSubscriber<APIresult<List<SocialTypeBean>>> {

        /* renamed from: ui.presenter.TradAccEditPresenter$a$a, reason: collision with other inner class name */
        class C0316a extends com.google.gson.d0.a<List<SocialTypeBean>> {
            C0316a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0316a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((SocialTagsCallView) TradAccEditPresenter.this.mvpView).onErrorRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SocialTypeBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((SocialTagsCallView) TradAccEditPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public TradAccEditPresenter(Activity activity, SocialTagsCallView socialTagsCallView) {
        super(activity, socialTagsCallView);
    }

    public void getSocialTags() {
        getSocialTags(d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.Z), new a());
    }
}

package ui.presenter;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import bean.GuideBean;
import bean.module.ModuelConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.WarnPrimessCallView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class WarnPrimessPresenter extends ModelPresent<WarnPrimessCallView> {

    class a extends MiddleSubscriber<APIresult<List<GuideBean>>> {

        /* renamed from: ui.presenter.WarnPrimessPresenter$a$a, reason: collision with other inner class name */
        class C0318a extends com.google.gson.d0.a<List<GuideBean>> {
            C0318a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0318a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((WarnPrimessCallView) WarnPrimessPresenter.this.mvpView).onSuccessRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<GuideBean>> aPIresult) {
            List<GuideBean> data;
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null || (data = aPIresult.getData()) == null || data.size() <= 0) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            HashMap<String, GuideBean> map = new HashMap<>();
            for (GuideBean guideBean : data) {
                String content = guideBean.getContent();
                if (!TextUtils.isEmpty(content)) {
                    guideBean.setContent(content.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "\n"));
                }
                map.put(guideBean.getCode() + "", guideBean);
            }
            ((WarnPrimessCallView) WarnPrimessPresenter.this.mvpView).onSuccessRequest(map);
        }
    }

    public WarnPrimessPresenter(Activity activity, WarnPrimessCallView warnPrimessCallView) {
        super(activity, warnPrimessCallView);
    }

    public void requestGuideConfig() {
        String str = Build.BRAND;
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.MODEL;
        HashMap<String, String> map = new HashMap<>();
        map.put("brand", str);
        map.put("version", str2);
        map.put("phonemodel", str3);
        requestGuideConfig(map);
    }

    public void requestGuideConfig(HashMap<String, String> map) {
        requestGuideConfig(d.a.a(ModuelConfig.MODEL_WARN, 8, e.b.g0), map, new a());
    }
}

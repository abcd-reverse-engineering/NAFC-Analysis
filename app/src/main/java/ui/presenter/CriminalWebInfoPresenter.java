package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.WebInfoNumBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.WebInfoCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CriminalWebInfoPresenter extends ModelPresent<WebInfoCallView> {

    class a extends MiddleSubscriber<APIresult<WebInfoNumBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return WebInfoNumBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<WebInfoNumBean> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((WebInfoCallView) CriminalWebInfoPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public CriminalWebInfoPresenter(Activity activity, WebInfoCallView webInfoCallView) {
        super(activity, webInfoCallView);
    }

    public void getWebNum(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.T1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getCriminalWebInfoNum(strA, map, new a());
    }
}

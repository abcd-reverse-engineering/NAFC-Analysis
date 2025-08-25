package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.callview.ResetPwdView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ResetPwdPresenter extends ModelPresent<ResetPwdView> {

    class a extends MiddleSubscriber<APIresult<Integer>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                w1.a("验证码已发送，请查收");
                ((ResetPwdView) ResetPwdPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            }
        }
    }

    public ResetPwdPresenter(Activity activity, ResetPwdView resetPwdView) {
        super(activity, resetPwdView);
    }

    private void verificationHttp(HashMap<String, String> map) {
        requestPhoneCodeTime(d.a.f13517c + e.b.C, map, new a());
    }

    public void verificationSubmit(int i2, String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", i2 + "");
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(map);
    }
}

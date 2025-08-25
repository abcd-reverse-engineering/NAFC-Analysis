package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.MinePersonalAddView;
import ui.model.ModelPresent;
import util.b1;
import util.n1;
import util.w1;

/* loaded from: classes2.dex */
public class MinePersonalAddPresenter extends ModelPresent<MinePersonalAddView> {

    class a extends MiddleSubscriber<APIresult<Double>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19979a;

        a(int i2) {
            this.f19979a = i2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Double.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Double> aPIresult) throws Resources.NotFoundException {
            n1.a("register", "-->onNext");
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            ((MinePersonalAddView) MinePersonalAddPresenter.this.mvpView).onSuccUpdateRequest(this.f19979a);
            if (aPIresult.getData().doubleValue() > 0.0d) {
                w1.a("恭喜，添加成功");
            } else {
                w1.a("修改成功");
            }
        }
    }

    public MinePersonalAddPresenter(Activity activity, MinePersonalAddView minePersonalAddView) {
        super(activity, minePersonalAddView);
    }

    private void timeStampHttp(HashMap<String, String> map, int i2) {
        updateUserHttp(i2, map);
    }

    private void updateUserHttp(int i2, HashMap<String, String> map) {
        String strA = "";
        if (i2 == 1) {
            strA = d.a.a("", 1, e.b.K);
        } else if (i2 == 11) {
            strA = d.a.a("", 1, e.b.L);
        }
        updateUserInfo(map, strA, new a(i2));
    }

    public void updateUserAddres(int i2, String str, String str2) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        b1.a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        if (!TextUtils.isEmpty(str)) {
            map.put("region", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("addr", str2);
        }
        timeStampHttp(map, i2);
    }

    public void updateUserContact(int i2, String str, String str2, String str3) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        b1.a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        map.put("qq", str);
        map.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, str2);
        map.put(NotificationCompat.CATEGORY_EMAIL, str3);
        timeStampHttp(map, i2);
    }

    public void updateUserEmerg(int i2, String str, String str2) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        b1.a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        map.put("urgentContactname", str);
        map.put("urgentContactmob", str2);
        timeStampHttp(map, i2);
    }
}

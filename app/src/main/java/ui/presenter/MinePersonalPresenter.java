package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.CheckUserBean;
import bean.UserInfoBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.MinePersonalView;
import ui.model.ModelPresent;
import util.b1;
import util.n1;
import util.w1;

/* loaded from: classes2.dex */
public class MinePersonalPresenter extends ModelPresent<MinePersonalView> {

    class a extends MiddleSubscriber<APIresult<UserInfoBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return UserInfoBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<UserInfoBean> aPIresult) throws Resources.NotFoundException {
            n1.a("register", "-->onNext");
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((MinePersonalView) MinePersonalPresenter.this.mvpView).onSuccRequest(aPIresult.getData());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            n1.a("register", "-->onSubscribe");
        }
    }

    class b extends MiddleSubscriber<APIresult<CheckUserBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckUserBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((MinePersonalView) MinePersonalPresenter.this.mvpView).onFailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((MinePersonalView) MinePersonalPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public MinePersonalPresenter(Activity activity, MinePersonalView minePersonalView) {
        super(activity, minePersonalView);
    }

    private void accountHttp(HashMap<String, String> map) {
        accountHttp(map, d.a.a("", 1, e.b.J), new a());
    }

    public void checkisverify() {
        checkisverify(d.a.a("", 1, e.b.R), new b());
    }

    public void getUserInfo() {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        b1.a("加载中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        accountHttp(map);
    }
}

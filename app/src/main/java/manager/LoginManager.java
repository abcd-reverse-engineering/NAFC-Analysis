package manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import d.b;
import network.account.AccountInfo;
import ui.Hicore;
import ui.activity.LoginActivity;
import ui.activity.MainActivity;
import ui.activity.PoliceLoginActivity;
import ui.c;
import util.k1;
import util.w1;
import util.y1;

/* loaded from: classes2.dex */
public class LoginManager {
    private static Activity activity;

    private static class SingletonHolder {
        private static final LoginManager managerLogin = new LoginManager();

        private SingletonHolder() {
        }
    }

    private void exitToLoginSimple() {
        c.i().e();
        y1.a((Context) activity, (Class<?>) LoginActivity.class);
        activity.finish();
    }

    public static LoginManager getInstance() {
        activity = c.i().c();
        return SingletonHolder.managerLogin;
    }

    public void cleanLoginMsg() {
        org.greenrobot.eventbus.c.f().c();
        AccountManager.loginOut();
        b.e();
    }

    public void exit() {
        exit("");
    }

    public void exitToLogin() {
        if (AccountManager.isLogin() || !(c.i().c() instanceof LoginActivity)) {
            String visiblePhone = AccountManager.getVisiblePhone();
            cleanLoginMsg();
            AccountManager.saveAccount(new AccountInfo(), visiblePhone);
            exitToLoginSimple();
        }
    }

    public void exitToPoliceLogin() {
        b.e();
        c.i().f();
        Activity activity2 = activity;
        activity2.startActivity(new Intent(activity2, (Class<?>) PoliceLoginActivity.class));
        activity.finish();
    }

    public void exitoLoginNoPhone() {
        if (AccountManager.isLogin() || !(c.i().c() instanceof LoginActivity)) {
            cleanLoginMsg();
            exitToLoginSimple();
        }
    }

    public boolean isLogOut() {
        if (AccountManager.isLogin()) {
            return false;
        }
        w1.a(Hicore.getApp().getResources().getString(R.string.login_exit));
        exitToLoginSimple();
        return true;
    }

    public void turnFocusMainPage() {
        c.i().f();
        Bundle bundle = new Bundle();
        bundle.putInt(k1.f20846d, 480);
        y1.a(activity, (Class<?>) MainActivity.class, bundle);
    }

    private LoginManager() {
    }

    public void exit(String str) {
        if (AccountManager.isLogin() || !(c.i().c() instanceof LoginActivity)) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = Hicore.getApp().getResources().getString(R.string.login_exit);
                }
                w1.a(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            exitToLogin();
        }
    }
}

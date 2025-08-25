package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import ui.callview.ForgetPwdCallView;
import ui.model.ModelPresent;
import ui.view.CodeCutTimeTextView;
import util.b1;
import util.d1;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class ForgetPresenter extends ModelPresent<ForgetPwdCallView> {
    private int fromType;
    private CodeCutTimeTextView mCodeTimer;

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
            if (ForgetPresenter.this.mCodeTimer != null) {
                ForgetPresenter.this.mCodeTimer.setEnabled(true);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            w1.a("验证码已发送，请查收");
            if (ForgetPresenter.this.fromType == k1.J) {
                ForgetPresenter.this.mCodeTimer.a(ForgetPresenter.this.mActivity, aPIresult.getData().intValue());
            } else if (ForgetPresenter.this.fromType == 3) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            } else {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
            if (ForgetPresenter.this.mCodeTimer != null) {
                ForgetPresenter.this.mCodeTimer.setEnabled(false);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<AccountInfo>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<AccountInfo>> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<AccountInfo>> {
        d() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onChangeMobileSuccRequest();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class e extends MiddleSubscriber<APIresult> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccessLoginOut();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccessLoginOut();
        }
    }

    public ForgetPresenter(Activity activity, ForgetPwdCallView forgetPwdCallView) {
        super(activity, forgetPwdCallView);
    }

    private void changeMobileHttp(HashMap<String, String> map, boolean z) {
        requestPhoneCode(d.a.a("", 1, e.b.F), map, new d());
    }

    private void resetPwdHttp(HashMap<String, String> map, boolean z) {
        requestPhoneCode(d.a.f13517c + e.b.o, map, new c());
    }

    private void verificationCodeHttp(HashMap<String, String> map) {
        requestPhoneCode(d.a.f13517c + e.b.G, map, new b());
    }

    private void verificationHttp(HashMap<String, String> map, int i2) {
        String strA;
        if (i2 == 3) {
            strA = d.a.f13517c + e.b.C;
        } else {
            strA = d.a.a("", 2, e.b.C);
        }
        requestPhoneCodeTime(strA, map, new a());
    }

    public void changeMobileSubmit(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", str);
        map.put("smsVerifyCode", str2);
        b1.a("加载中...", true, this.mActivity);
        changeMobileHttp(map, true);
    }

    public void requestLoginOut() {
        b1.a("退出中...", true, this.mActivity);
        requestLoginOut(d.a.a("", 1, e.b.H), new e());
    }

    public void resetPwd(String str, String str2, String str3) {
        if (str3.length() < 6 || str3.length() > 16 || d1.a(str3)) {
            w1.a(this.mActivity.getString(R.string.login_pwd));
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobileNumber", str);
        map.put("smsVerifyCode", str2);
        map.put("newPWD", str3);
        resetPwdHttp(map, true);
    }

    public void verificationCode(String str, String str2) {
        if (str.length() != 11) {
            w1.a("手机号码格式不正确，请重新输入");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            w1.a("请输入验证码");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("code", str2);
        map.put("mobileNumber", str);
        map.put("codeType", "3");
        b1.a("加载中...", true, this.mActivity);
        verificationCodeHttp(map);
    }

    public void verificationResetPhone(String str, int i2) {
        verificationSubmit(str, i2, 4, null);
    }

    public void verificationSubmit(String str, int i2) {
        verificationSubmit(str, i2, 3, null);
    }

    public void verificationSubmit(String str, int i2, int i3, CodeCutTimeTextView codeCutTimeTextView) {
        this.fromType = i2;
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            w1.a("手机号码格式不正确，请重新输入");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", i3 + "");
        map.put("areaCode", AccountManager.getRegisterRegionCode());
        verificationHttp(map, i3);
    }
}

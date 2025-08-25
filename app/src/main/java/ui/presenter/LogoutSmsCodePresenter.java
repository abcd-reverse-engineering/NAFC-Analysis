package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import h.q2.t.i0;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import ui.callview.LogoutSmsCodeView;
import ui.model.ModelPresent;
import ui.view.CodeCutTimeTextView;
import util.b1;
import util.w1;

/* compiled from: LogoutSmsCodePresenter.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lui/presenter/LogoutSmsCodePresenter;", "Lui/model/ModelPresent;", "Lui/callview/LogoutSmsCodeView;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Lui/callview/LogoutSmsCodeView;)V", "mCodeTimer", "Lui/view/CodeCutTimeTextView;", "getMCodeTimer", "()Lui/view/CodeCutTimeTextView;", "setMCodeTimer", "(Lui/view/CodeCutTimeTextView;)V", "verificationCode", "", "phone", "", "code", "codetype", "", "verificationCodeHttp", "map", "Ljava/util/HashMap;", "verificationHttp", "verificationSubmit", "phoneNum", "verificationType", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutSmsCodePresenter extends ModelPresent<LogoutSmsCodeView> {

    @i.c.a.e
    private CodeCutTimeTextView mCodeTimer;

    /* compiled from: LogoutSmsCodePresenter.kt */
    public static final class a extends MiddleSubscriber<APIresult<AccountInfo>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.d APIException aPIException) throws Resources.NotFoundException {
            i0.f(aPIException, "e");
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.d APIresult<AccountInfo> aPIresult) throws Resources.NotFoundException {
            i0.f(aPIresult, "resultInfo");
            if (aPIresult.getCode() == 0) {
                ((LogoutSmsCodeView) LogoutSmsCodePresenter.this.mvpView).onSuccessRequest();
                return;
            }
            APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
            i0.a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
            onErrorMiddle(apiExcept);
        }
    }

    /* compiled from: LogoutSmsCodePresenter.kt */
    public static final class b extends MiddleSubscriber<APIresult<Integer>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        @i.c.a.d
        protected Type getType() {
            return Integer.TYPE;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@i.c.a.d APIException aPIException) {
            i0.f(aPIException, "e");
            w1.a(aPIException.getMessage());
            CodeCutTimeTextView mCodeTimer = LogoutSmsCodePresenter.this.getMCodeTimer();
            if (mCodeTimer == null) {
                i0.f();
            }
            mCodeTimer.setEnabled(true);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@i.c.a.d APIresult<Integer> aPIresult) throws Resources.NotFoundException {
            i0.f(aPIresult, "resultInfo");
            if (aPIresult.getCode() != 0) {
                APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
                i0.a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
                onErrorMiddle(apiExcept);
                return;
            }
            w1.a("验证码已发送，请查收");
            CodeCutTimeTextView mCodeTimer = LogoutSmsCodePresenter.this.getMCodeTimer();
            if (mCodeTimer != null) {
                Activity activity = LogoutSmsCodePresenter.this.mActivity;
                Integer data = aPIresult.getData();
                i0.a((Object) data, "resultInfo.data");
                mCodeTimer.a(activity, data.intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogoutSmsCodePresenter(@i.c.a.d Activity activity, @i.c.a.d LogoutSmsCodeView logoutSmsCodeView) {
        super(activity, logoutSmsCodeView);
        i0.f(activity, "activity");
        i0.f(logoutSmsCodeView, "view");
    }

    private final void verificationCodeHttp(HashMap<String, String> map) {
        requestPhoneCode(d.a.a("", 1, e.b.G), map, new a());
    }

    private final void verificationHttp(HashMap<String, String> map) {
        requestPhoneCodeTime(d.a.a("", 2, e.b.C), map, new b());
    }

    @i.c.a.e
    public final CodeCutTimeTextView getMCodeTimer() {
        return this.mCodeTimer;
    }

    public final void setMCodeTimer(@i.c.a.e CodeCutTimeTextView codeCutTimeTextView) {
        this.mCodeTimer = codeCutTimeTextView;
    }

    public final void verificationCode(@i.c.a.d String str, @i.c.a.d String str2, int i2) {
        i0.f(str, "phone");
        i0.f(str2, "code");
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
        map.put("codeType", String.valueOf(i2));
        b1.a("加载中...", true, this.mActivity);
        verificationCodeHttp(map);
    }

    public final void verificationSubmit(@i.c.a.d String str, int i2, @i.c.a.e CodeCutTimeTextView codeCutTimeTextView) {
        i0.f(str, "phoneNum");
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            w1.a("手机号码格式不正确，请重新输入");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", String.valueOf(i2) + "");
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        i0.a((Object) nodeRegionId, "RegionConfigHttp.getNodeRegionId()");
        map.put("areaCode", nodeRegionId);
        verificationHttp(map);
    }
}

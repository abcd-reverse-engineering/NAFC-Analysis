package c.c.a.c.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.honorid.core.data.HonorAccount;
import com.tencent.connect.common.Constants;
import k.a.a.a.d;

/* compiled from: AccountAuthParamUtil.java */
/* loaded from: classes.dex */
public class a {
    public static Bundle a(SignInOptions signInOptions) {
        String strB = signInOptions.b();
        String strA = d.a(signInOptions.f());
        Bundle bundle = new Bundle();
        bundle.putString("app_id", strB);
        String strC = signInOptions.c();
        if (!TextUtils.isEmpty(strC)) {
            bundle.putInt("login_channel", Integer.parseInt(strC));
        }
        bundle.putString(Constants.PARAM_SCOPE, strA);
        bundle.putBoolean("requireAccessToken", signInOptions.m());
        bundle.putBoolean("reqiureAuthCode", signInOptions.l());
        bundle.putInt("reqClientType", 7);
        return bundle;
    }

    public static SignInAccountInfo a(HonorAccount honorAccount) {
        return SignInAccountInfo.a(honorAccount.m(), "", null, honorAccount.n(), honorAccount.v(), honorAccount.i());
    }
}

package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private AuthAgent f9578a;

    /* renamed from: b, reason: collision with root package name */
    private QQToken f9579b;

    private c(String str, Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f9579b = new QQToken(str);
        this.f9578a = new AuthAgent(this.f9579b);
        com.tencent.connect.a.a.c(context, this.f9579b);
        a(context, Constants.SDK_VERSION);
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("bcb3903995", str);
        editorEdit.apply();
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "reAuth()");
        return this.f9578a.a(activity, str, iUiListener, true, null, false);
    }

    public boolean c() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.f9579b.isSessionValid() ? a.a.u.a.f1253j : a.a.u.a.f1254k);
        SLog.i("openSDK_LOG.QQAuth", sb.toString());
        return this.f9579b.isSessionValid();
    }

    public QQToken b() {
        return this.f9579b;
    }

    public void b(Context context, String str) {
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f9579b.setOpenId(str);
        com.tencent.connect.a.a.d(context, this.f9579b);
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public static c a(String str, Context context) {
        g.a(context.getApplicationContext());
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        c cVar = new c(str, context);
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return cVar;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, "");
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, null, str, iUiListener, "", z);
    }

    public int a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.QQAuth", "login--params");
        return a(activity, (Fragment) null, m.a(map, Constants.KEY_SCOPE, "all"), iUiListener, "", m.a(map, Constants.KEY_QRCODE, false), map);
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, (Fragment) null, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        FragmentActivity activity = fragment.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2, z);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        return a(activity, fragment, str, iUiListener, str2, false);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        return a(activity, fragment, str, iUiListener, str2, z, (Map<String, Object>) null);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z, Map<String, Object> map) {
        try {
            String strA = k.a(activity);
            if (strA != null) {
                String strA2 = com.tencent.open.utils.b.a(new File(strA));
                if (!TextUtils.isEmpty(strA2)) {
                    SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + strA2);
                    return a(activity, str, iUiListener, z, strA2, strA2, "");
                }
            }
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f9578a.doLogin(activity, str, iUiListener, false, fragment, z, map);
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = c.c.a.b.a.a.f3101h;
        }
        if (str3.equals("")) {
            str3 = c.c.a.b.a.a.f3101h;
        }
        if (str4.equals("")) {
            str4 = c.c.a.b.a.a.f3101h;
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f9578a.a(activity, str, iUiListener, false, null, z);
    }

    public void a() {
        this.f9578a.a((IUiListener) null);
    }

    public void a(IUiListener iUiListener) {
        this.f9578a.b(iUiListener);
    }

    public void a(String str, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f9579b.setAccessToken(str, str2);
    }
}

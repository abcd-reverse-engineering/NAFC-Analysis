package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.openapi.SdkListener;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8355a = false;

    /* renamed from: b, reason: collision with root package name */
    private static AuthInfo f8356b;

    public static void a(AuthInfo authInfo, SdkListener sdkListener) {
        if (f8355a) {
            return;
        }
        if (authInfo == null) {
            throw new RuntimeException("authInfo must not be null.");
        }
        f8356b = authInfo;
        f8355a = true;
        if (sdkListener != null) {
            sdkListener.onInitSuccess();
        }
    }

    public static boolean b(Context context) {
        a.C0121a c0121aE;
        return a(context) && (c0121aE = com.sina.weibo.sdk.b.a.e(context)) != null && c0121aE.ah >= 10772;
    }

    public static boolean a(Context context) {
        List<ResolveInfo> listQueryIntentServices;
        String[] strArr = {BuildConfig.APPLICATION_ID, "com.sina.weibog3"};
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !listQueryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static AuthInfo a() {
        if (f8355a) {
            return f8356b;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}

package com.vivo.push.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* compiled from: PushClientSdkAppSp.java */
/* loaded from: classes2.dex */
public final class z extends c {

    /* renamed from: b, reason: collision with root package name */
    private Context f12303b;

    public z(Context context) {
        if (context != null) {
            this.f12303b = context;
            a(this.f12303b);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String b() throws PackageManager.NameNotFoundException {
        String string;
        Context context = this.f12303b;
        String packageName = context.getPackageName();
        Object objA = ag.a(context, packageName, "com.vivo.push.app_id");
        if (objA != null) {
            string = objA.toString();
        } else {
            Object objA2 = ag.a(context, packageName, "app_id");
            string = objA2 != null ? objA2.toString() : "";
        }
        return TextUtils.isEmpty(string) ? b("APP_APPID", "") : string;
    }

    public final String c() throws PackageManager.NameNotFoundException {
        String string;
        Context context = this.f12303b;
        String packageName = context.getPackageName();
        Object objA = ag.a(context, packageName, "com.vivo.push.api_key");
        if (objA != null) {
            string = objA.toString();
        } else {
            Object objA2 = ag.a(context, packageName, "api_key");
            string = objA2 != null ? objA2.toString() : "";
        }
        return TextUtils.isEmpty(string) ? b("APP_APIKEY", "") : string;
    }
}

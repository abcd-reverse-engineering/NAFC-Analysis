package com.umeng.socialize.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: UMAppInfo.java */
/* loaded from: classes2.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    final String f11556a;

    /* renamed from: b, reason: collision with root package name */
    final String f11557b;

    /* renamed from: c, reason: collision with root package name */
    final String f11558c;

    /* renamed from: d, reason: collision with root package name */
    final long f11559d;

    /* renamed from: e, reason: collision with root package name */
    final long f11560e;

    /* renamed from: f, reason: collision with root package name */
    final int f11561f;

    public f(Object obj, Object obj2) {
        String strValueOf;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f11556a = packageInfo.packageName;
        this.f11558c = packageInfo.versionName;
        this.f11559d = packageInfo.firstInstallTime;
        this.f11560e = packageInfo.lastUpdateTime;
        this.f11561f = a(packageInfo);
        try {
            strValueOf = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            strValueOf = "";
        }
        this.f11557b = strValueOf;
    }

    private int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i2 = applicationInfo.flags;
        return ((i2 & 1) == 0 && (i2 & 128) == 0) ? 1 : 0;
    }
}

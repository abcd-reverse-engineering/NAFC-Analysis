package com.umeng.message.proguard;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes2.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    final String f11372a;

    /* renamed from: b, reason: collision with root package name */
    final String f11373b;

    /* renamed from: c, reason: collision with root package name */
    final String f11374c;

    /* renamed from: d, reason: collision with root package name */
    final long f11375d;

    /* renamed from: e, reason: collision with root package name */
    final long f11376e;

    /* renamed from: f, reason: collision with root package name */
    final int f11377f;

    public l(Object obj, Object obj2) {
        String strValueOf;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f11372a = packageInfo.packageName;
        this.f11374c = packageInfo.versionName;
        this.f11375d = packageInfo.firstInstallTime;
        this.f11376e = packageInfo.lastUpdateTime;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        int i2 = 0;
        if (applicationInfo == null) {
            i2 = -1;
        } else {
            int i3 = applicationInfo.flags;
            if ((i3 & 1) == 0 && (i3 & 128) == 0) {
                i2 = 1;
            }
        }
        this.f11377f = i2;
        try {
            strValueOf = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            strValueOf = "";
        }
        this.f11373b = strValueOf;
    }
}

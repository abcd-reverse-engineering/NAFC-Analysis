package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* compiled from: PkgInfoUtil.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, PackageInfo> f11083a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Object f11084b = new Object();

    /* compiled from: PkgInfoUtil.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f11085a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f11085a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i2) {
        PackageInfo packageInfo;
        synchronized (f11084b) {
            packageInfo = null;
            if (f11083a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f11083a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f11083a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    f11083a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                }
            }
        }
        return packageInfo;
    }
}

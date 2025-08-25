package com.umeng.socialize.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* compiled from: Misc.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f11546a;

    /* renamed from: b, reason: collision with root package name */
    public static String f11547b;

    /* renamed from: c, reason: collision with root package name */
    public static String f11548c;

    public static String a() {
        if (TextUtils.isEmpty(f11546a)) {
            f11546a = Build.BRAND;
            if (TextUtils.isEmpty(f11546a)) {
                f11546a = Build.MANUFACTURER;
            }
        }
        return f11546a;
    }

    public static String b() {
        if (TextUtils.isEmpty(f11547b)) {
            f11547b = Build.MODEL;
        }
        return f11547b;
    }

    public static String c() {
        if (TextUtils.isEmpty(f11548c)) {
            f11548c = Build.BOARD;
        }
        return f11548c;
    }

    public static boolean b(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Object a(Object obj, String str, int i2) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i2);
        } catch (Throwable th) {
            if (!a.f11537c) {
                return null;
            }
            UMRTLog.e("MISC", "pkg:" + str + " failed:" + th.getMessage());
            return null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}

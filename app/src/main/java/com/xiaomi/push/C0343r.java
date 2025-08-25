package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;

/* renamed from: com.xiaomi.push.r, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0343r {

    /* renamed from: a, reason: collision with root package name */
    private static Context f13265a;

    /* renamed from: a, reason: collision with other field name */
    private static String f920a;

    public static void a(Context context) {
        f13265a = context.getApplicationContext();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m640b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static String c() {
        String strA = q.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("ColorOS_")) {
            f920a = "ColorOS_" + strA;
        }
        return f920a;
    }

    private static String d() {
        String strA = q.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("FuntouchOS_")) {
            f920a = "FuntouchOS_" + strA;
        }
        return f920a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Context m636a() {
        return f13265a;
    }

    public static int a() {
        try {
            Class<?> clsA = a(null, "miui.os.Build");
            if (clsA.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return clsA.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String b() {
        f920a = q.a("ro.build.version.emui", "");
        return f920a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m639a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m638a() {
        return TextUtils.equals((String) aw.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m637a() {
        String strB;
        if (f920a != null) {
            return f920a;
        }
        String strValueOf = Build.VERSION.INCREMENTAL;
        if (a() <= 0) {
            strB = b();
            if (TextUtils.isEmpty(strB)) {
                strB = c();
                if (TextUtils.isEmpty(strB)) {
                    strB = d();
                    if (TextUtils.isEmpty(strB)) {
                        strValueOf = String.valueOf(q.a(SystemUtils.PRODUCT_BRAND, "Android") + c.c.a.b.a.a.s1 + strValueOf);
                        strB = strValueOf;
                    }
                }
            }
        } else {
            strB = strValueOf;
        }
        f920a = strB;
        return strB;
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        if (str != null && str.trim().length() != 0) {
            boolean z = context != null;
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m50a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }
}

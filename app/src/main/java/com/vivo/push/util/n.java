package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    private static Method f12286f;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f12281a = ag.b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f12282b = b("rom_1.0");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f12283c = b("rom_2.0");

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f12284d = b("rom_2.5");

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f12285e = b("rom_3.0");

    /* renamed from: g, reason: collision with root package name */
    private static String f12287g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f12288h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String strB = ag.b("ro.vivo.rom", "");
        String strB2 = ag.b("ro.vivo.rom.version", "");
        u.d("Device", "ro.vivo.rom = " + strB + " ; ro.vivo.rom.version = " + strB2);
        if (strB == null || !strB.contains(str)) {
            return strB2 != null && strB2.contains(str);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0085 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087 A[Catch: all -> 0x0097, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x000e, B:11:0x0053, B:12:0x005a, B:16:0x0087), top: B:25:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String a() {
        /*
            java.lang.Class<com.vivo.push.util.n> r0 = com.vivo.push.util.n.class
            monitor-enter(r0)
            java.lang.String r1 = com.vivo.push.util.n.f12287g     // Catch: java.lang.Throwable -> L97
            r2 = 0
            if (r1 != 0) goto L5a
            java.lang.String r1 = com.vivo.push.util.n.f12288h     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto L5a
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r3 = "get"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r8 = 1
            r5[r8] = r6     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r5)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            com.vivo.push.util.n.f12286f = r1     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            r1.setAccessible(r8)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.reflect.Method r1 = com.vivo.push.util.n.f12286f     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r5 = "ro.vivo.rom"
            r3[r7] = r5     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r5 = "@><@"
            r3[r8] = r5     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            com.vivo.push.util.n.f12287g = r1     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.reflect.Method r1 = com.vivo.push.util.n.f12286f     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r4 = "ro.vivo.rom.version"
            r3[r7] = r4     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r4 = "@><@"
            r3[r8] = r4     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            com.vivo.push.util.n.f12288h = r1     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L97
            goto L5a
        L53:
            java.lang.String r1 = "Device"
            java.lang.String r3 = "getRomCode error"
            com.vivo.push.util.u.b(r1, r3)     // Catch: java.lang.Throwable -> L97
        L5a:
            java.lang.String r1 = "Device"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = "sRomProperty1 : "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = com.vivo.push.util.n.f12287g     // Catch: java.lang.Throwable -> L97
            r3.append(r4)     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = " ; sRomProperty2 : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = com.vivo.push.util.n.f12288h     // Catch: java.lang.Throwable -> L97
            r3.append(r4)     // Catch: java.lang.Throwable -> L97
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L97
            com.vivo.push.util.u.d(r1, r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = com.vivo.push.util.n.f12287g     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L97
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L97
            if (r3 != 0) goto L87
            monitor-exit(r0)
            return r1
        L87:
            java.lang.String r1 = com.vivo.push.util.n.f12288h     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L97
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L97
            if (r3 != 0) goto L95
            monitor-exit(r0)
            return r1
        L95:
            monitor-exit(r0)
            return r2
        L97:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.n.a():java.lang.String");
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            u.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        u.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith("vivo");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }
}

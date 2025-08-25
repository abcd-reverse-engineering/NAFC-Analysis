package com.heytap.mcssdk.k;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5894a = "file";

    /* renamed from: b, reason: collision with root package name */
    private static final String f5895b = "ro.crypto.type";

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return f5894a.equals(a(f5895b));
    }
}

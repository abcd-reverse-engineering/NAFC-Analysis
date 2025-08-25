package k.a.a.a;

import android.text.TextUtils;

/* compiled from: Checker.java */
/* loaded from: classes2.dex */
public final class a {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(str2));
        }
        return str;
    }
}

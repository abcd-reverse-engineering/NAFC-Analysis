package i.a.a.a.k;

import java.io.UnsupportedEncodingException;

/* compiled from: StringUtils.java */
/* loaded from: classes2.dex */
public class l {
    public static byte[] a(String str) {
        return a(str, i.a.a.a.c.f16729a);
    }

    public static byte[] b(String str) {
        return a(str, i.a.a.a.c.f16730b);
    }

    public static byte[] c(String str) {
        return a(str, i.a.a.a.c.f16731c);
    }

    public static byte[] d(String str) {
        return a(str, i.a.a.a.c.f16732d);
    }

    public static byte[] e(String str) {
        return a(str, i.a.a.a.c.f16733e);
    }

    public static byte[] f(String str) {
        return a(str, "UTF-8");
    }

    public static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw a(str2, e2);
        }
    }

    public static String b(byte[] bArr) {
        return a(bArr, i.a.a.a.c.f16730b);
    }

    public static String c(byte[] bArr) {
        return a(bArr, i.a.a.a.c.f16731c);
    }

    public static String d(byte[] bArr) {
        return a(bArr, i.a.a.a.c.f16732d);
    }

    public static String e(byte[] bArr) {
        return a(bArr, i.a.a.a.c.f16733e);
    }

    public static String f(byte[] bArr) {
        return a(bArr, "UTF-8");
    }

    private static IllegalStateException a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw a(str, e2);
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, i.a.a.a.c.f16729a);
    }
}

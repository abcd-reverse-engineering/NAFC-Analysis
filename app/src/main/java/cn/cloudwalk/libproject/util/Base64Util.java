package cn.cloudwalk.libproject.util;

import android.util.Base64;

/* loaded from: classes.dex */
public class Base64Util {
    private Base64Util() {
    }

    public static byte[] decode(String str) {
        return Base64.decode(str, 2);
    }

    public static String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}

package com.xiaomi.push;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class ba {
    private static String a(byte b2) {
        int i2 = (b2 & h.q2.t.n.f16414b) + (b2 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i2 < 16 ? "0" : "");
        sb.append(Integer.toHexString(i2).toLowerCase());
        return sb.toString();
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }

    public static String a(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b2 : messageDigest.digest()) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m176a(String str) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}

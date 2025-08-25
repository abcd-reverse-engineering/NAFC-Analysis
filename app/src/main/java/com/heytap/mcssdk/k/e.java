package com.heytap.mcssdk.k;

import android.text.TextUtils;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f5896a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f5897b = "Y29tLm5lYXJtZS5tY3M=";

    /* renamed from: c, reason: collision with root package name */
    public static String f5898c = "";

    private static String a() {
        if (TextUtils.isEmpty(f5898c)) {
            f5898c = new String(com.heytap.mcssdk.b.a.d(f5897b));
        }
        byte[] bArrA = a(a(f5898c));
        return bArrA != null ? new String(bArrA, Charset.forName("UTF-8")) : "";
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
        return bArr;
    }

    public static String b(String str) {
        boolean z;
        String strDecrypt = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            strDecrypt = f.a(str, a());
            g.b("sdkDecrypt desDecrypt des data " + strDecrypt);
            z = true;
        } catch (Exception e2) {
            g.b("sdkDecrypt DES excepiton " + e2.toString());
            z = false;
        }
        if (TextUtils.isEmpty(strDecrypt) ? false : z) {
            return strDecrypt;
        }
        try {
            strDecrypt = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            f5896a = "AES";
            h.c().a(f5896a);
            g.b("sdkDecrypt desDecrypt aes data " + strDecrypt);
            return strDecrypt;
        } catch (Exception e3) {
            g.b("sdkDecrypt AES excepiton " + e3.toString());
            return strDecrypt;
        }
    }

    public static String c(String str) {
        boolean z;
        String strA = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            strA = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            g.b("sdkDecrypt aesDecrypt aes data " + strA);
            z = true;
        } catch (Exception e2) {
            g.b("sdkDecrypt AES excepiton " + e2.toString());
            z = false;
        }
        if (TextUtils.isEmpty(strA) ? false : z) {
            return strA;
        }
        try {
            strA = f.a(str, a());
            f5896a = "DES";
            h.c().a(f5896a);
            g.b("sdkDecrypt aesDecrypt des data " + strA);
            return strA;
        } catch (Exception e3) {
            g.b("sdkDecrypt DES excepiton " + e3.toString());
            return strA;
        }
    }

    public static String d(String str) {
        g.b("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(f5896a)) {
            f5896a = h.c().b();
        }
        if ("DES".equals(f5896a)) {
            g.b("sdkDecrypt start DES");
            return b(str);
        }
        g.b("sdkDecrypt start AES");
        return c(str);
    }
}

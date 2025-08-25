package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class SHA {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7477a = "SHA";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7479c = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7478b = "SHA-256";

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f7480d = {f7478b, "SHA-384", "SHA-512"};

    private SHA() {
    }

    private static boolean a(String str) {
        for (String str2 : f7480d) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, f7478b);
    }

    public static String shaEncrypt(String str, String str2) throws UnsupportedEncodingException {
        byte[] bytes;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f7477a, "content or algorithm is null.");
            return "";
        }
        if (!a(str2)) {
            b.b(f7477a, "algorithm is not safe or legal");
            return "";
        }
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = new byte[0];
            b.b(f7477a, "Error in generate SHA UnsupportedEncodingException");
        }
        return HexUtil.byteArray2HexStr(shaEncryptByte(bytes, str2));
    }

    public static byte[] shaEncryptByte(byte[] bArr, String str) throws NoSuchAlgorithmException {
        if (bArr == null || TextUtils.isEmpty(str)) {
            b.b(f7477a, "content or algorithm is null.");
            return new byte[0];
        }
        if (!a(str)) {
            b.b(f7477a, "algorithm is not safe or legal");
            return new byte[0];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            b.b(f7477a, "Error in generate SHA NoSuchAlgorithmException");
            return new byte[0];
        }
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    public static boolean validateSHA256(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }
}

package com.hihonor.honorid.d.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SHA256.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f6222a = {"SHA-256", "SHA-384", "SHA-512"};

    public static String a(String str, String str2) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            k.a.a.a.j.e.d("SHA256", "content or algorithm is null.", true);
            return "";
        }
        if (!a(str2)) {
            k.a.a.a.j.e.d("SHA256", "algorithm is not safe or legal", true);
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes("UTF-8"));
            return com.hihonor.honorid.f.a.a(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            k.a.a.a.j.e.d("SHA256", "Error in generate SHA UnsupportedEncodingException", true);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            k.a.a.a.j.e.d("SHA256", "Error in generate SHA NoSuchAlgorithmException", true);
            return "";
        }
    }

    public static String b(String str) {
        return c(str);
    }

    public static String c(String str) {
        return a(str, "SHA-256");
    }

    private static boolean a(String str) {
        for (String str2 : f6222a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}

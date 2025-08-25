package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class l {
    private static String a(Context context, String str, String str2) {
        int identifier;
        if (TextUtils.isEmpty(str2) || (identifier = context.getResources().getIdentifier(str2, "string", str)) == 0) {
            return null;
        }
        try {
            return context.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        try {
            return a(context, str, str2 + Hex.encodeHexString(a(str3.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            String str4 = "getResources exception:" + e2.getMessage();
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }
}

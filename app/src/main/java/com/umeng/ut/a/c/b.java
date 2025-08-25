package com.umeng.ut.a.c;

import com.umeng.analytics.pro.cw;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f11902a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(String str, String str2) {
        try {
            byte[] bArrA = a(str.getBytes(), str2.getBytes());
            return bArrA != null ? toHexString(bArrA) : "0000000000000000";
        } catch (Exception e2) {
            e.m44a("", e2);
            return "0000000000000000";
        }
    }

    public static String c(String str) {
        return a(c(), str);
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(f11902a[(bArr[i2] & 240) >>> 4]);
            sb.append(f11902a[bArr[i2] & cw.f10303m]);
        }
        return sb.toString();
    }

    private static String c() {
        byte[] bytes = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn".getBytes();
        for (byte b2 = 0; b2 < 32; b2 = (byte) (b2 + 1)) {
            try {
                bytes[b2] = (byte) (bytes[b2] + b2);
            } catch (Exception unused) {
                return null;
            }
        }
        return toHexString(bytes);
    }

    private static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e2) {
            e.a("", e2, new Object[0]);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[64];
        for (int i2 = 0; i2 < 64; i2++) {
            bArr3[i2] = 54;
            bArr4[i2] = 92;
        }
        byte[] bArr5 = new byte[64];
        if (bArr.length > 64) {
            bArr = a(bArr);
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr5[i3] = bArr[i3];
        }
        if (bArr.length < 64) {
            for (int length = bArr.length; length < bArr5.length; length++) {
                bArr5[length] = 0;
            }
        }
        byte[] bArr6 = new byte[64];
        for (int i4 = 0; i4 < 64; i4++) {
            bArr6[i4] = (byte) (bArr5[i4] ^ bArr3[i4]);
        }
        byte[] bArr7 = new byte[bArr6.length + bArr2.length];
        for (int i5 = 0; i5 < bArr6.length; i5++) {
            bArr7[i5] = bArr6[i5];
        }
        for (int i6 = 0; i6 < bArr2.length; i6++) {
            bArr7[bArr5.length + i6] = bArr2[i6];
        }
        byte[] bArrA = a(bArr7);
        byte[] bArr8 = new byte[64];
        for (int i7 = 0; i7 < 64; i7++) {
            bArr8[i7] = (byte) (bArr5[i7] ^ bArr4[i7]);
        }
        byte[] bArr9 = new byte[bArr8.length + bArrA.length];
        for (int i8 = 0; i8 < bArr8.length; i8++) {
            bArr9[i8] = bArr8[i8];
        }
        for (int i9 = 0; i9 < bArrA.length; i9++) {
            bArr9[bArr5.length + i9] = bArrA[i9];
        }
        return a(bArr9);
    }
}

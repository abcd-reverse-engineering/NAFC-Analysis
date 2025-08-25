package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f9411a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f9412b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
        }
        f9411a = bArr2;
        f9412b = bArr3;
    }

    public static boolean a(byte b2, byte b3) {
        return b2 == b3;
    }

    public static boolean a(int i2, int i3) {
        return i2 == i3;
    }

    public static boolean a(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean a(boolean z, boolean z2) {
        return z == z2;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }
}

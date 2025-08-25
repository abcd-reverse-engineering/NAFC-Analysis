package com.xiaomi.push;

import h.f1;

/* loaded from: classes2.dex */
public class y {
    public static int a(byte[] bArr) {
        if (bArr.length != 4) {
            throw new IllegalArgumentException("the length of bytes must be 4");
        }
        return (bArr[3] & f1.f16099c) | 0 | ((bArr[0] & f1.f16099c) << 24) | ((bArr[1] & f1.f16099c) << 16) | ((bArr[2] & f1.f16099c) << 8);
    }

    public static byte[] a(int i2) {
        return new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
    }
}

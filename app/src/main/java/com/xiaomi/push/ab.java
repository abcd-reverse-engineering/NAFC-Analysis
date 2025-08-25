package com.xiaomi.push;

import android.content.Context;
import h.f1;

/* loaded from: classes2.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f12413a = "0123456789ABCDEF".toCharArray();

    public static boolean a(Context context) {
        return aa.f12412a;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i3 * 2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = bArr[i2 + i4] & f1.f16099c;
            sb.append(f12413a[i5 >> 4]);
            sb.append(f12413a[i5 & 15]);
        }
        return sb.toString();
    }
}

package com.vivo.push.util;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: SharePreferenceManager.java */
/* loaded from: classes2.dex */
public final class ad extends c {

    /* renamed from: b, reason: collision with root package name */
    private static ad f12239b;

    public static synchronized ad b() {
        if (f12239b == null) {
            f12239b = new ad();
        }
        return f12239b;
    }

    public final synchronized void a(Context context) {
        if (this.f12260a == null) {
            this.f12260a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] bArrB = b(b("com.vivo.push.secure_cache_iv", ""));
        return (bArrB == null || bArrB.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : bArrB;
    }

    public final byte[] d() {
        byte[] bArrB = b(b("com.vivo.push.secure_cache_key", ""));
        return (bArrB == null || bArrB.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33} : bArrB;
    }

    private static byte[] b(String str) {
        int length;
        byte[] bArr = null;
        try {
            String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (strArrSplit.length > 0) {
                bArr = new byte[strArrSplit.length];
                length = strArrSplit.length;
            } else {
                length = 0;
            }
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = Byte.parseByte(strArrSplit[i2].trim());
            }
        } catch (Exception e2) {
            u.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}

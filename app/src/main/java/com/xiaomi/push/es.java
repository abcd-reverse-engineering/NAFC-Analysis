package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.ev;

/* loaded from: classes2.dex */
class es {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f12786a = Log.isLoggable("BCompressed", 3);

    static byte[] a(er erVar, byte[] bArr) {
        try {
            byte[] bArrA = ev.a.a(bArr);
            if (f12786a) {
                com.xiaomi.channel.commonutils.logger.b.m51a("BCompressed", "decompress " + bArr.length + " to " + bArrA.length + " for " + erVar);
                if (erVar.f462a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("BCompressed", "decompress not support upStream");
                }
            }
            return bArrA;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public class COSPushHelper {

    /* renamed from: a, reason: collision with root package name */
    private static long f12337a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f88a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j2 = f12337a;
            if (j2 <= 0 || j2 + 300000 <= jElapsedRealtime) {
                f12337a = jElapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f88a;
    }

    public static boolean hasNetwork(Context context) {
        return f.m98a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager abstractPushManagerA = e.a(context).a(d.ASSEMBLE_PUSH_COS);
        if (abstractPushManagerA != null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH :  register cos when network change!");
            abstractPushManagerA.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        f88a = z;
    }

    public static void uploadToken(Context context, String str) {
        f.m97a(context, d.ASSEMBLE_PUSH_COS, str);
    }
}

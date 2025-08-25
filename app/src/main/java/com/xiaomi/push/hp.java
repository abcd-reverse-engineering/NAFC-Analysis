package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.hw;
import com.xiaomi.push.ig;

/* loaded from: classes2.dex */
public class hp {
    public static <T extends hq<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new hv(new hw.a()).a(t);
        } catch (hu e2) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }

    public static <T extends hq<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new ht(new ig.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new hu("the message byte is empty.");
    }

    public static short a(Context context, hb hbVar) {
        gs gsVarM529a = hbVar.m529a();
        return m596a(context, hbVar.f724b, (gsVarM529a == null || gsVarM529a.m496a() == null) ? null : gsVarM529a.m496a().get("channel_id"));
    }

    public static short a(Context context, String str) {
        return m596a(context, str, (String) null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static short m596a(Context context, String str, String str2) {
        return (short) (g.a(context, str, false).a() + 0 + (ad.b(context) ? 4 : 0) + (ad.a(context) ? 8 : 0) + (com.xiaomi.push.service.af.m679a(context) ? 16 : 0) + a(context, str, str2));
    }

    private static int a(Context context, String str, String str2) {
        com.xiaomi.push.service.af afVarA;
        NotificationChannel notificationChannelM681a;
        if (Build.VERSION.SDK_INT < 26 || context == null || TextUtils.isEmpty(str) || (afVarA = com.xiaomi.push.service.af.a(context, str)) == null || (notificationChannelM681a = afVarA.m681a(afVarA.m684a(str2))) == null) {
            return 0;
        }
        return notificationChannelM681a.getImportance() != 0 ? 32 : 64;
    }
}

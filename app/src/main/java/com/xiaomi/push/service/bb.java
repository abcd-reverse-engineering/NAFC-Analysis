package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import com.xiaomi.push.dv;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class bb {
    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void c(Context context, String str, int i2, String str2, Notification notification) {
        af afVarA;
        Notification notificationA;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (notificationA = a(notification, i2, str2, (afVarA = af.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (notificationA.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.aw.a((Object) notificationA, "mGroupAlertBehavior", (Object) 1);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = notificationA.extras.getLong("mipush_org_when", 0L);
        int i3 = notificationA.extras.getInt("mipush_n_top_fre", 0);
        int i4 = notificationA.extras.getInt("mipush_n_top_prd", 0);
        if (i4 <= 0 || i4 < i3) {
            return;
        }
        long j3 = (i4 * 1000) + j2;
        int iMin = (j2 >= jCurrentTimeMillis || jCurrentTimeMillis >= j3) ? 0 : i3 > 0 ? (int) Math.min((j3 - jCurrentTimeMillis) / 1000, i3) : i4;
        if (!z) {
            if (iMin > 0) {
                notificationA.when = jCurrentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m50a("update top notification: " + str2);
                afVarA.a(i2, notificationA);
            } else {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, notificationA);
                builderRecoverBuilder.setPriority(0);
                builderRecoverBuilder.setWhen(jCurrentTimeMillis);
                Bundle extras = builderRecoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    builderRecoverBuilder.setExtras(extras);
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("update top notification to common: " + str2);
                afVarA.a(i2, builderRecoverBuilder.build());
            }
        }
        if (iMin > 0) {
            com.xiaomi.channel.commonutils.logger.b.m50a("schedule top notification next update delay: " + iMin);
            com.xiaomi.push.ae.a(context).m131a(b(i2, str2));
            com.xiaomi.push.ae.a(context).b(a(context, str, i2, str2, (Notification) null), iMin);
        }
    }

    static void a(Context context, Map<String, String> map, dv dvVar, long j2) {
        if (map == null || dvVar == null || !com.xiaomi.push.j.m627a(context) || !m714a(map)) {
            return;
        }
        int iA = a(map);
        int iB = b(map);
        if (iA <= 0 || iB > iA) {
            com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + iA + " frequency:" + iB);
            return;
        }
        dvVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j2);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (iB > 0) {
            bundle.putInt("mipush_n_top_fre", iB);
        }
        bundle.putInt("mipush_n_top_prd", iA);
        dvVar.addExtras(bundle);
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.s.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i2, String str) {
        return "n_top_update_" + i2 + c.c.a.b.a.a.s1 + str;
    }

    @TargetApi(19)
    /* renamed from: a, reason: collision with other method in class */
    static void m713a(Context context, String str, int i2, String str2, Notification notification) {
        if (com.xiaomi.push.j.m627a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i2, str2, notification);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m714a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = Boolean.parseBoolean(str);
        com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + z);
        return z;
    }

    private static int a(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.s.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    private static Notification a(Notification notification, int i2, String str, af afVar) {
        if (notification != null) {
            if (str.equals(notification.extras.getString("message_id"))) {
                return notification;
            }
            return null;
        }
        List<StatusBarNotification> listM687b = afVar.m687b();
        if (listM687b == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : listM687b) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i2 == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static ae.a a(final Context context, final String str, final int i2, final String str2, final Notification notification) {
        return new ae.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.ae.a
            /* renamed from: a */
            public String mo183a() {
                return bb.b(i2, str2);
            }

            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                bb.c(context, str, i2, str2, notification);
            }
        };
    }
}

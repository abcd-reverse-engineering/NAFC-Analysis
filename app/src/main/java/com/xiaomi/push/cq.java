package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private static int f12584a;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m249a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, String str, boolean z, long j2, int i2, long j3, int i3, String str2, int i4) {
        SharedPreferences sharedPreferencesM249a = m249a(context);
        long j4 = sharedPreferencesM249a.getLong("start_time_for_day", 0L);
        if (j4 == 0) {
            cn.a("recordDisconnection not initialized");
            return;
        }
        if (j2 - sharedPreferencesM249a.getLong("last_discnt_time", 0L) < com.heytap.mcssdk.constant.a.f5800d) {
            cn.a("recordDisconnection anti-shake");
            return;
        }
        if (j2 - j4 < 86400000) {
            int i5 = sharedPreferencesM249a.getInt("discnt_count_in_day", 0);
            if (i5 > 100) {
                cn.a("recordDisconnection count > 100 in 24H cycle,abandon.");
                return;
            } else {
                sharedPreferencesM249a.edit().putInt("discnt_count_in_day", i5 + 1).apply();
            }
        } else {
            cn.a("recordDisconnection with the current time exceeds 24H cycle, go on.");
        }
        int i6 = sharedPreferencesM249a.getInt("discnt_count", 0);
        if (i6 == sharedPreferencesM249a.getInt("cnt_count", 0)) {
            a(context, str, a(z), j2, i2, j3, i3, str2, i4);
            sharedPreferencesM249a.edit().putLong("last_discnt_time", j2).putInt("discnt_count", i6 + 1).apply();
        }
        cn.a("recordDisconnection complete");
    }

    public static void a(final Context context, final String str, final boolean z, final long j2, final int i2, final long j3, final int i3, final String str2, final int i4) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cq.c(context, str, z, j2, i2, j3, i3, str2, i4);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP onDisconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void a(final Context context, final long j2) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cq.c(context, j2);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP onReconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    private static void b(Context context) {
        cn.a("resetAfterUpload");
        m249a(context).edit().putString(Constants.KEY_HOST, null).putString("network_state", null).putString("reason", null).putString("ping_interval", null).putString(com.umeng.analytics.pro.bh.T, null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    private static void a(Context context, String str, int i2, long j2, int i3, long j3, int i4, String str2, int i5) {
        cn.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), str2, Integer.valueOf(i5)));
        SharedPreferences sharedPreferencesM249a = m249a(context);
        String string = sharedPreferencesM249a.getString(Constants.KEY_HOST, null);
        String string2 = sharedPreferencesM249a.getString("network_state", null);
        String string3 = sharedPreferencesM249a.getString("reason", null);
        String string4 = sharedPreferencesM249a.getString("ping_interval", null);
        String string5 = sharedPreferencesM249a.getString(com.umeng.analytics.pro.bh.T, null);
        String string6 = sharedPreferencesM249a.getString("wifi_digest", null);
        String string7 = sharedPreferencesM249a.getString("connected_network_type", null);
        String string8 = sharedPreferencesM249a.getString("disconnect_time", null);
        String string9 = sharedPreferencesM249a.getString("xmsf_vc", null);
        String string10 = sharedPreferencesM249a.getString("android_vc", null);
        String strA = a(string, str);
        String strA2 = a(string2, i2);
        String strA3 = a(string3, i3);
        String strA4 = a(string4, j3);
        String strA5 = a(string5, i4);
        String strA6 = a(string6, str2);
        String strA7 = a(string7, i5);
        String strA8 = a(string8, j2);
        sharedPreferencesM249a.edit().putString(Constants.KEY_HOST, strA).putString("network_state", strA2).putString("reason", strA3).putString("ping_interval", strA4).putString(com.umeng.analytics.pro.bh.T, strA5).putString("wifi_digest", strA6).putString("connected_network_type", strA7).putString("disconnect_time", strA8).putString("xmsf_vc", a(string9, a(context))).putString("android_vc", a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, long j2) {
        SharedPreferences sharedPreferencesM249a = m249a(context);
        long j3 = sharedPreferencesM249a.getLong("start_time_for_day", 0L);
        if (j3 == 0) {
            sharedPreferencesM249a.edit().putLong("start_time_for_day", j2).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
            return;
        }
        int i2 = sharedPreferencesM249a.getInt("discnt_count", 0);
        int i3 = sharedPreferencesM249a.getInt("cnt_count", 0);
        if (i2 > i3) {
            sharedPreferencesM249a.edit().putInt("cnt_count", i3 + 1).putString("connected_time", a(sharedPreferencesM249a.getString("connected_time", null), j2)).apply();
        }
        if (j2 - j3 >= 86400000) {
            sharedPreferencesM249a.edit().putLong("start_time_for_day", j2).putInt("discnt_count_in_day", 0).apply();
            m251a(context);
        } else if (i2 >= 10) {
            m251a(context);
        }
    }

    private static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = c.c.a.b.a.a.f3101h;
        }
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str + ";" + str2;
    }

    private static String a(String str, int i2) {
        return a(str, String.valueOf(i2));
    }

    private static String a(String str, long j2) {
        return a(str, String.valueOf(j2));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m251a(Context context) {
        cn.a("upload");
        new cp().a(context, m250a(context));
        b(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static List<co> m250a(Context context) {
        SharedPreferences sharedPreferencesM249a = m249a(context);
        String[] strArrA = a(sharedPreferencesM249a.getString(Constants.KEY_HOST, null));
        if (strArrA != null && strArrA.length > 0) {
            String[] strArrA2 = a(sharedPreferencesM249a.getString("network_state", null));
            String[] strArrA3 = a(sharedPreferencesM249a.getString("reason", null));
            String[] strArrA4 = a(sharedPreferencesM249a.getString("ping_interval", null));
            String[] strArrA5 = a(sharedPreferencesM249a.getString(com.umeng.analytics.pro.bh.T, null));
            String[] strArrA6 = a(sharedPreferencesM249a.getString("wifi_digest", null));
            String[] strArrA7 = a(sharedPreferencesM249a.getString("connected_network_type", null));
            String[] strArrA8 = a(sharedPreferencesM249a.getString("disconnect_time", null));
            String[] strArrA9 = a(sharedPreferencesM249a.getString("connected_time", null));
            String[] strArrA10 = a(sharedPreferencesM249a.getString("xmsf_vc", null));
            String[] strArrA11 = a(sharedPreferencesM249a.getString("android_vc", null));
            if (strArrA2 != null && strArrA3 != null && strArrA4 != null && strArrA5 != null && strArrA6 != null && strArrA7 != null && strArrA8 != null && strArrA9 != null && strArrA10 != null && strArrA11 != null && strArrA.length == strArrA2.length && strArrA.length == strArrA3.length && strArrA.length == strArrA4.length && strArrA.length == strArrA5.length && strArrA.length == strArrA6.length && strArrA.length == strArrA7.length && strArrA.length == strArrA8.length && strArrA.length == strArrA9.length && strArrA.length == strArrA10.length && strArrA.length == strArrA11.length) {
                ArrayList arrayList = new ArrayList(strArrA.length);
                int i2 = 0;
                while (i2 < strArrA.length) {
                    co coVar = new co();
                    coVar.a(1);
                    coVar.a(strArrA[i2]);
                    coVar.b(s.a(strArrA2[i2], -1));
                    coVar.c(s.a(strArrA3[i2], -1));
                    String[] strArr = strArrA;
                    String[] strArr2 = strArrA3;
                    coVar.a(s.a(strArrA4[i2], -1L));
                    coVar.d(s.a(strArrA5[i2], -1));
                    coVar.b(strArrA6[i2]);
                    coVar.e(s.a(strArrA7[i2], -1));
                    long jA = s.a(strArrA8[i2], -1L);
                    long jA2 = s.a(strArrA9[i2], -1L);
                    coVar.b(jA2 - jA);
                    coVar.c(jA);
                    coVar.d(jA2);
                    coVar.f(s.a(strArrA10[i2], -1));
                    coVar.g(s.a(strArrA11[i2], -1));
                    arrayList.add(coVar);
                    i2++;
                    strArrA = strArr;
                    strArrA5 = strArrA5;
                    strArrA2 = strArrA2;
                    strArrA3 = strArr2;
                    strArrA4 = strArrA4;
                    strArrA6 = strArrA6;
                }
                return arrayList;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    private static String[] a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    private static int a(Context context) {
        if (f12584a <= 0) {
            f12584a = j.b(context);
        }
        return f12584a;
    }
}

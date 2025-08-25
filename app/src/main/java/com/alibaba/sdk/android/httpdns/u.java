package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.xiaomi.mipush.sdk.Constants;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f4111a = null;

    /* renamed from: a, reason: collision with other field name */
    private static a f39a = a.ENABLE;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f4112d = false;

    /* renamed from: e, reason: collision with root package name */
    private static long f4113e = 0;

    /* renamed from: g, reason: collision with root package name */
    private static volatile int f4114g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f4115h = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f4116l = false;

    enum a {
        ENABLE,
        PRE_DISABLE,
        DISABLE
    }

    static synchronized String a(s sVar) {
        try {
            if (sVar != s.QUERY_HOST && sVar != s.SNIFF_HOST) {
                return (sVar == s.QUERY_SCHEDULE_CENTER || sVar == s.SNIFF_SCHEDULE_CENTER) ? null : null;
            }
            if (f39a != a.ENABLE && f39a != a.PRE_DISABLE) {
                if (sVar == s.QUERY_HOST) {
                    return null;
                }
                return f.f19a[f4114g];
            }
            return f.f19a[f4114g];
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static synchronized void a(Context context) {
        if (!f4112d) {
            synchronized (u.class) {
                if (!f4112d) {
                    if (context != null) {
                        f4111a = context.getSharedPreferences("httpdns_config_cache", 0);
                    }
                    f4116l = f4111a.getBoolean(NotificationCompat.CATEGORY_STATUS, false);
                    f4114g = f4111a.getInt("activiate_ip_index", 0);
                    f4115h = f4114g;
                    f4113e = f4111a.getLong("disable_modified_time", 0L);
                    if (System.currentTimeMillis() - f4113e >= 86400000) {
                        d(false);
                    }
                    f39a = f4116l ? a.DISABLE : a.ENABLE;
                    f4112d = true;
                }
            }
        }
    }

    static synchronized void a(String str, String str2, long j2) {
        try {
            b(str, str2, j2);
            reportHttpDnsSuccess(str, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (f39a != a.ENABLE && str2 != null && str2.equals(f.f19a[f4114g])) {
            StringBuilder sb = new StringBuilder();
            sb.append(f39a == a.DISABLE ? "Disable " : "Pre_disable ");
            sb.append("mode finished. Enter enable mode.");
            i.f(sb.toString());
            f39a = a.ENABLE;
            d(false);
            t.a().g();
            f4115h = f4114g;
        }
    }

    static synchronized void a(String str, String str2, Throwable th) {
        try {
            a(str2, th);
            if (a(th) && str2 != null && str2.equals(f.f19a[f4114g])) {
                h();
                if (f4115h == f4114g) {
                    t.a().c(false);
                    n.a().c();
                }
                if (f39a == a.ENABLE) {
                    f39a = a.PRE_DISABLE;
                    i.f("enter pre_disable mode");
                } else if (f39a == a.PRE_DISABLE) {
                    f39a = a.DISABLE;
                    i.f("enter disable mode");
                    d(true);
                    h(str);
                    t.a().g(str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(String str, Throwable th) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                int iA = com.alibaba.sdk.android.httpdns.d.c.a(th);
                bVarA.a(str, String.valueOf(iA), com.alibaba.sdk.android.httpdns.d.c.m20a(th), com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.net64.a.a().i() ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        if (th instanceof h) {
            h hVar = (h) th;
            if (hVar.getErrorCode() == 403 && hVar.getMessage().equals("ServiceLevelDeny")) {
                return true;
            }
        }
        return false;
    }

    static void b(int i2) {
        if (f4111a == null || i2 < 0 || i2 >= f.f19a.length) {
            return;
        }
        f4114g = i2;
        SharedPreferences.Editor editorEdit = f4111a.edit();
        editorEdit.putInt("activiate_ip_index", i2);
        editorEdit.putLong("activiated_ip_index_modified_time", System.currentTimeMillis());
        editorEdit.commit();
    }

    private static void b(String str, String str2, long j2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.b(str2, j2, com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static synchronized void d(boolean z) {
        if (f4116l != z) {
            f4116l = z;
            if (f4111a != null) {
                SharedPreferences.Editor editorEdit = f4111a.edit();
                editorEdit.putBoolean(NotificationCompat.CATEGORY_STATUS, f4116l);
                editorEdit.putLong("disable_modified_time", System.currentTimeMillis());
                editorEdit.commit();
            }
        }
    }

    static synchronized boolean e() {
        return f4116l;
    }

    private static void h() {
        f4114g = f4114g == f.f19a.length + (-1) ? 0 : f4114g + 1;
        b(f4114g);
    }

    private static void h(String str) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                String strM27d = n.a().m27d();
                int length = f4114g;
                if (length == 0) {
                    length = f.f19a.length;
                }
                int i2 = length - 1;
                int length2 = i2 == 0 ? f.f19a.length - 1 : i2 - 1;
                if (i2 < 0 || i2 >= f.f19a.length || length2 < 0 || length2 >= f.f19a.length) {
                    return;
                }
                String str2 = f.f19a[i2];
                bVarA.b(str, strM27d, f.f19a[length2] + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static void i() {
        b(0);
        f4115h = f4114g;
        t.a().c(true);
    }

    static void j() {
        t.a().c(true);
    }

    public static void reportHttpDnsSuccess(String str, int i2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.a(str, i2, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m9a() ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

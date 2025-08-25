package com.umeng.socialize.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.utils.ContextUtil;

/* compiled from: SharedPrefs.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11550a = "Prefs";

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f11551c;

    /* renamed from: b, reason: collision with root package name */
    private final Context f11552b;

    /* renamed from: d, reason: collision with root package name */
    private final a f11553d = new a("AZX");

    /* compiled from: SharedPrefs.java */
    private class a {

        /* renamed from: b, reason: collision with root package name */
        private final String f11555b;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + c.c.a.b.a.a.s1;
            }
            this.f11555b = str;
        }

        private String b(String str) {
            return this.f11555b + str;
        }

        private String c(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    return b.a().b(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str2;
        }

        private void d(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void a(String str, int i2) {
            d(b(str), String.valueOf(i2));
        }

        public void a(String str, long j2) {
            d(b(str), String.valueOf(j2));
        }

        public int b(String str, int i2) {
            try {
                return Integer.parseInt(c(b(str), String.valueOf(i2)));
            } catch (Exception unused) {
                return i2;
            }
        }

        public void a(String str, float f2) {
            d(b(str), String.valueOf(f2));
        }

        public void a(String str, String str2) {
            d(b(str), String.valueOf(str2));
        }

        public long b(String str, long j2) {
            try {
                return Long.parseLong(c(b(str), String.valueOf(j2)));
            } catch (Exception unused) {
                return j2;
            }
        }

        public void a(String str, boolean z) {
            d(b(str), String.valueOf(z));
        }

        private void c(String str) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void a(String str) {
            c(b(str));
        }

        public float b(String str, float f2) {
            try {
                return Float.parseFloat(c(b(str), String.valueOf(f2)));
            } catch (Exception unused) {
                return f2;
            }
        }

        public boolean b(String str, boolean z) {
            try {
                return Boolean.parseBoolean(c(b(str), String.valueOf(z)));
            } catch (Exception unused) {
                return z;
            }
        }

        public String b(String str, String str2) {
            return c(b(str), str2);
        }
    }

    private e(Context context) {
        this.f11552b = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f11551c == null) {
            synchronized (e.class) {
                if (f11551c == null) {
                    f11551c = new e(context);
                }
            }
        }
        return f11551c;
    }

    public boolean b() {
        return a(com.umeng.socialize.a.a.f11539e);
    }

    public int c() {
        return this.f11553d.b(com.umeng.socialize.a.a.f11540f, 0);
    }

    public long d() {
        return this.f11553d.b(com.umeng.socialize.a.a.f11538d, 0L);
    }

    public void e() {
        if (c.a(this.f11552b)) {
            this.f11553d.a(com.umeng.socialize.a.a.f11538d, d() + 1);
        }
    }

    private void b(String str) {
        this.f11553d.a(str + bh.aX);
        this.f11553d.a(str + "ts");
    }

    public void a(long j2) {
        a(com.umeng.socialize.a.a.f11539e, j2);
    }

    public long a() {
        return this.f11553d.b("smart_ts", 0L);
    }

    public void a(int i2) {
        this.f11553d.a(com.umeng.socialize.a.a.f11540f, i2);
    }

    private void a(String str, long j2) {
        this.f11553d.a(str + bh.aX, j2);
        this.f11553d.a(str + "ts", System.currentTimeMillis());
    }

    private boolean a(String str) {
        long jB = this.f11553d.b(str + bh.aX, 0L);
        if (jB <= 0) {
            return true;
        }
        long jAbs = Math.abs(System.currentTimeMillis() - this.f11553d.b(str + "ts", 0L)) / 1000;
        boolean z = jAbs >= jB;
        if (!z && com.umeng.socialize.a.a.f11537c) {
            m.a(f11550a, "interval deny ", str, " config:", Long.valueOf(jB), " current:", Long.valueOf(jAbs));
        }
        return z;
    }
}

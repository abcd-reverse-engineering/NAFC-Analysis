package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f12320a = 2;

    /* renamed from: a, reason: collision with other field name */
    private static Context f66a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f72a = false;

    /* renamed from: b, reason: collision with other field name */
    private static boolean f73b = false;

    /* renamed from: a, reason: collision with other field name */
    private static String f69a = "XMPush-" + Process.myPid();

    /* renamed from: a, reason: collision with other field name */
    private static LoggerInterface f67a = new a();

    /* renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f70a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, String> f12321b = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private static final Integer f68a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static AtomicInteger f71a = new AtomicInteger(1);

    static class a implements LoggerInterface {

        /* renamed from: a, reason: collision with root package name */
        private String f12322a = b.f69a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f12322a = str;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m53a() {
        return false;
    }

    public static void b(String str) {
        if (m54a(0)) {
            a(0, m49a(str));
        }
    }

    public static void c(String str) {
        if (m54a(0)) {
            a(1, m49a(str));
        }
    }

    public static void d(String str) {
        if (m54a(4)) {
            a(4, m49a(str));
        }
    }

    public static void e(String str) {
        if (f72a) {
            m50a(str);
            return;
        }
        m49a(str);
        if (f73b) {
            return;
        }
        m50a(str);
    }

    public static void a(LoggerInterface loggerInterface) {
        f67a = loggerInterface;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m54a(int i2) {
        return i2 >= f12320a || m53a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m55b(String str, String str2) {
        if (m54a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (m54a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f72a) {
            m51a(str, str2);
            return;
        }
        b(str, str2);
        if (f73b) {
            return;
        }
        m51a(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m50a(String str) {
        if (m54a(2)) {
            a(2, m49a(str));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m54a(1)) {
            a(1, a(str, objArr));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m51a(String str, String str2) {
        if (m54a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m52a(String str, Object... objArr) {
        if (m54a(2)) {
            a(2, a(str, objArr));
        }
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void a(String str, Throwable th) {
        if (m54a(4)) {
            a(4, m49a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m54a(4)) {
            a(4, th);
        }
    }

    public static Integer a(String str) {
        if (f12320a <= 1) {
            Integer numValueOf = Integer.valueOf(f71a.incrementAndGet());
            f70a.put(numValueOf, Long.valueOf(System.currentTimeMillis()));
            f12321b.put(numValueOf, str);
            f67a.log(str + " starts");
            return numValueOf;
        }
        return f68a;
    }

    public static void a(Integer num) {
        if (f12320a > 1 || !f70a.containsKey(num)) {
            return;
        }
        long jLongValue = f70a.remove(num).longValue();
        String strRemove = f12321b.remove(num);
        long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
        f67a.log(strRemove + " ends in " + jCurrentTimeMillis + " ms");
    }

    public static void a(int i2, String str) {
        if (i2 >= f12320a) {
            f67a.log(str);
            return;
        }
        if (m53a()) {
            String str2 = "-->log(" + i2 + "): " + str;
        }
    }

    public static void a(int i2, Throwable th) {
        if (i2 >= f12320a) {
            f67a.log("", th);
            return;
        }
        if (m53a()) {
            String str = "-->log(" + i2 + "): ";
        }
    }

    public static void a(int i2, String str, Throwable th) {
        if (i2 >= f12320a) {
            f67a.log(str, th);
            return;
        }
        if (m53a()) {
            String str2 = "-->log(" + i2 + "): " + str;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m49a(String str) {
        return b() + str;
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i2) {
        if (i2 < 0 || i2 > 5) {
            a(2, "set log level as " + i2);
        }
        f12320a = i2;
    }

    public static int a() {
        return f12320a;
    }

    public static void a(Context context) {
        f66a = context;
        if (j.m627a(context)) {
            f72a = true;
        }
        if (j.m626a()) {
            f73b = true;
        }
    }
}

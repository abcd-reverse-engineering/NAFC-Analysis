package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* compiled from: LogUtil.java */
/* loaded from: classes2.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20879a = "LogUtil";

    /* renamed from: b, reason: collision with root package name */
    public static String f20880b = "MM-dd HH:mm:ss";

    /* renamed from: c, reason: collision with root package name */
    private static String f20881c = "国家反诈中心_log_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + c.c.a.b.a.a.s1;

    /* renamed from: d, reason: collision with root package name */
    public static StringBuilder f20882d = new StringBuilder();

    public static void a(String str) {
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Exception exc) {
    }

    public static void b(String str) {
    }

    public static void b(String str, String str2) {
    }

    public static String c(String str) {
        try {
            return new SimpleDateFormat(str).format(new GregorianCalendar().getTime());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(String str, String str2) {
    }

    public static void d(String str) {
    }

    public static synchronized void d(String str, String str2) {
    }

    public static void e(String str) {
    }

    public static void e(String str, String str2) {
    }

    public static void f(String str) {
    }

    public static void f(String str, String str2) {
    }
}

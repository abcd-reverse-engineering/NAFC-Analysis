package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import h.q2.t.m0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f9862a = d.C0133d.a("yy.MM.dd.HH");

    /* renamed from: g, reason: collision with root package name */
    private File f9868g;

    /* renamed from: b, reason: collision with root package name */
    private String f9863b = "Tracer.File";

    /* renamed from: c, reason: collision with root package name */
    private int f9864c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f9865d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f9866e = 4096;

    /* renamed from: f, reason: collision with root package name */
    private long f9867f = com.heytap.mcssdk.constant.a.q;

    /* renamed from: h, reason: collision with root package name */
    private int f9869h = 10;

    /* renamed from: i, reason: collision with root package name */
    private String f9870i = ".log";

    /* renamed from: j, reason: collision with root package name */
    private long f9871j = m0.f16408b;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        b(j2);
        d(i5);
        b(str2);
        c(j3);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File d(long j2) {
        String strC = c(a(j2));
        String strB = m.b();
        if (!TextUtils.isEmpty(strB) || strB != null) {
            try {
                File file = new File(strB, c.o);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return new File(file, strC);
            } catch (Exception e2) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return null;
    }

    public File a() {
        return d(System.currentTimeMillis());
    }

    public String b() {
        return this.f9863b;
    }

    public static String a(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void b(int i2) {
        this.f9865d = i2;
    }

    public int c() {
        return this.f9866e;
    }

    public void b(long j2) {
        this.f9867f = j2;
    }

    public void c(int i2) {
        this.f9866e = i2;
    }

    public void b(String str) {
        this.f9870i = str;
    }

    public void c(long j2) {
        this.f9871j = j2;
    }

    public void a(String str) {
        this.f9863b = str;
    }

    public void a(int i2) {
        this.f9864c = i2;
    }

    public void a(File file) {
        this.f9868g = file;
    }

    public int d() {
        return this.f9869h;
    }

    public void d(int i2) {
        this.f9869h = i2;
    }
}

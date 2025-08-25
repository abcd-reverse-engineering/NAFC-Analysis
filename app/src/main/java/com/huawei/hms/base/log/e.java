package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogRecord.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private String f6662b;

    /* renamed from: c, reason: collision with root package name */
    private String f6663c;

    /* renamed from: d, reason: collision with root package name */
    private int f6664d;

    /* renamed from: g, reason: collision with root package name */
    private String f6667g;

    /* renamed from: h, reason: collision with root package name */
    private int f6668h;

    /* renamed from: i, reason: collision with root package name */
    private int f6669i;

    /* renamed from: j, reason: collision with root package name */
    private int f6670j;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f6661a = new StringBuilder();

    /* renamed from: e, reason: collision with root package name */
    private long f6665e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f6666f = 0;

    e(int i2, String str, int i3, String str2) {
        this.f6663c = "HMS";
        this.f6670j = i2;
        this.f6662b = str;
        this.f6664d = i3;
        if (str2 != null) {
            this.f6663c = str2;
        }
        b();
    }

    public static String a(int i2) {
        return i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? String.valueOf(i2) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D";
    }

    private e b() {
        this.f6665e = System.currentTimeMillis();
        Thread threadCurrentThread = Thread.currentThread();
        this.f6666f = threadCurrentThread.getId();
        this.f6668h = Process.myPid();
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.f6670j;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.f6667g = stackTraceElement.getFileName();
            this.f6669i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> e a(T t) {
        this.f6661a.append(t);
        return this;
    }

    public e a(Throwable th) {
        a((e) '\n').a((e) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    private StringBuilder a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.f6661a.toString());
        return sb;
    }

    private StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f6665e)));
        String strA = a(this.f6664d);
        sb.append(' ');
        sb.append(strA);
        sb.append('/');
        sb.append(this.f6663c);
        sb.append('/');
        sb.append(this.f6662b);
        sb.append(' ');
        sb.append(this.f6668h);
        sb.append(':');
        sb.append(this.f6666f);
        sb.append(' ');
        sb.append(this.f6667g);
        sb.append(':');
        sb.append(this.f6669i);
        sb.append(']');
        return sb;
    }
}

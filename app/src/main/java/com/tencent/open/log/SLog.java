package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.d;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f9845c = false;
    public static SLog instance;

    /* renamed from: a, reason: collision with root package name */
    protected a f9846a;

    /* renamed from: b, reason: collision with root package name */
    private Tracer f9847b;

    private SLog() {
    }

    private void d() {
        this.f9846a = new a(new b(a(), c.f9884m, c.f9878g, c.f9879h, c.f9874c, c.f9880i, 10, c.f9876e, c.n));
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    instance = new SLog();
                    instance.d();
                    f9845c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    protected void a(int i2, String str, String str2, Throwable th) {
        if (f9845c) {
            String strB = com.tencent.open.utils.g.b();
            if (!TextUtils.isEmpty(strB)) {
                String str3 = strB + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f9846a == null) {
                    return;
                }
                e.f9888a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.f9846a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                f9845c = false;
            }
        }
        e.f9888a.a(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.f9873b, i2)) {
            a aVar = this.f9846a;
            if (aVar == null) {
                return;
            } else {
                aVar.a(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            }
        }
        Tracer tracer = this.f9847b;
        if (tracer != null) {
            try {
                tracer.a(i2, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
            } catch (Exception unused) {
            }
        }
    }

    protected void b() {
        a aVar = this.f9846a;
        if (aVar != null) {
            aVar.a();
            this.f9846a.b();
            this.f9846a = null;
        }
    }

    protected void c() {
        a aVar = this.f9846a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f9847b = tracer;
    }

    public static final void e(String str, String str2, Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static final void i(String str, String str2, Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static final void u(String str, String str2, Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(String str, String str2, Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void d(String str, String str2, Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : d.a(str) ? "xxxxxx" : str;
    }

    protected static File a() {
        String str = c.f9875d;
        try {
            d.c cVarB = d.b.b();
            if (cVarB != null && cVarB.c() > c.f9877f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.g.c(), str);
        } catch (Throwable th) {
            e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}

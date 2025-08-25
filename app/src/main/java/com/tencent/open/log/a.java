package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class a extends Tracer implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private b f9851a;

    /* renamed from: b, reason: collision with root package name */
    private FileWriter f9852b;

    /* renamed from: c, reason: collision with root package name */
    private File f9853c;

    /* renamed from: d, reason: collision with root package name */
    private char[] f9854d;

    /* renamed from: e, reason: collision with root package name */
    private volatile f f9855e;

    /* renamed from: f, reason: collision with root package name */
    private volatile f f9856f;

    /* renamed from: g, reason: collision with root package name */
    private volatile f f9857g;

    /* renamed from: h, reason: collision with root package name */
    private volatile f f9858h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f9859i;

    /* renamed from: j, reason: collision with root package name */
    private HandlerThread f9860j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f9861k;

    public a(b bVar) {
        this(c.f9873b, true, g.f9891a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f9860j && !this.f9859i) {
            this.f9859i = true;
            i();
            try {
                try {
                    this.f9858h.a(g(), this.f9854d);
                } catch (IOException e2) {
                    SLog.e("FileTracer", "flushBuffer exception", e2);
                }
                this.f9859i = false;
            } finally {
                this.f9858h.b();
            }
        }
    }

    private Writer g() {
        File fileA = c().a();
        if (fileA != null && ((fileA != null && !fileA.equals(this.f9853c)) || (this.f9852b == null && fileA != null))) {
            this.f9853c = fileA;
            h();
            try {
                this.f9852b = new FileWriter(this.f9853c, true);
            } catch (IOException unused) {
                this.f9852b = null;
                SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
            }
            a(fileA);
        }
        return this.f9852b;
    }

    private void h() {
        try {
            if (this.f9852b != null) {
                this.f9852b.flush();
                this.f9852b.close();
            }
        } catch (IOException e2) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e2);
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f9857g == this.f9855e) {
                this.f9857g = this.f9856f;
                this.f9858h = this.f9855e;
            } else {
                this.f9857g = this.f9855e;
                this.f9858h = this.f9856f;
            }
        }
    }

    public void a() {
        if (this.f9861k.hasMessages(1024)) {
            this.f9861k.removeMessages(1024);
        }
        this.f9861k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.f9860j.quit();
    }

    public b c() {
        return this.f9851a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j2, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i2, boolean z, g gVar, b bVar) {
        super(i2, z, gVar);
        this.f9859i = false;
        a(bVar);
        this.f9855e = new f();
        this.f9856f = new f();
        this.f9857g = this.f9855e;
        this.f9858h = this.f9856f;
        this.f9854d = new char[bVar.c()];
        this.f9860j = new HandlerThread(bVar.b(), bVar.d());
        HandlerThread handlerThread = this.f9860j;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.f9860j.isAlive() || this.f9860j.getLooper() == null) {
            return;
        }
        this.f9861k = new Handler(this.f9860j.getLooper(), this);
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    private void a(String str) {
        this.f9857g.a(str);
        if (this.f9857g.a() >= c().c()) {
            a();
        }
    }

    private void a(File file) {
        File[] fileArrListFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (fileArrListFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (b(file2)) {
                String name = file2.getName();
                if (b.a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? com.heytap.mcssdk.constant.a.f5801e : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    public void a(b bVar) {
        this.f9851a = bVar;
    }
}

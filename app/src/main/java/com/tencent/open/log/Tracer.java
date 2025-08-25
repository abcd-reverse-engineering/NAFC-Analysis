package com.tencent.open.log;

import com.tencent.open.log.d;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public abstract class Tracer {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f9848a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f9849b;

    /* renamed from: c, reason: collision with root package name */
    private g f9850c;

    public Tracer() {
        this(c.f9872a, true, g.f9891a);
    }

    public void a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f9848a, i2)) {
            doTrace(i2, thread, j2, str, str2, th);
        }
    }

    public boolean d() {
        return this.f9849b;
    }

    protected abstract void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th);

    public g e() {
        return this.f9850c;
    }

    public Tracer(int i2, boolean z, g gVar) {
        this.f9848a = c.f9872a;
        this.f9849b = true;
        this.f9850c = g.f9891a;
        a(i2);
        a(z);
        a(gVar);
    }

    public void a(int i2) {
        this.f9848a = i2;
    }

    public void a(boolean z) {
        this.f9849b = z;
    }

    public void a(g gVar) {
        this.f9850c = gVar;
    }
}

package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f9282a;

    /* renamed from: b, reason: collision with root package name */
    private final String f9283b;

    /* renamed from: c, reason: collision with root package name */
    private long f9284c;

    /* renamed from: d, reason: collision with root package name */
    private final long f9285d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9286e = true;

    /* renamed from: f, reason: collision with root package name */
    private long f9287f;

    ar(Handler handler, String str, long j2) {
        this.f9282a = handler;
        this.f9283b = str;
        this.f9284c = j2;
        this.f9285d = j2;
    }

    public void a() {
        if (this.f9286e) {
            this.f9286e = false;
            this.f9287f = SystemClock.uptimeMillis();
            this.f9282a.postAtFrontOfQueue(this);
        }
    }

    public boolean b() {
        return !this.f9286e && SystemClock.uptimeMillis() > this.f9287f + this.f9284c;
    }

    public int c() {
        if (this.f9286e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f9287f < this.f9284c ? 1 : 3;
    }

    public Thread d() {
        return this.f9282a.getLooper().getThread();
    }

    public String e() {
        return this.f9283b;
    }

    public void f() {
        this.f9284c = this.f9285d;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9286e = true;
        f();
    }

    public void a(long j2) {
        this.f9284c = j2;
    }
}

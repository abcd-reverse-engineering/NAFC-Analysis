package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: CountDownTimer.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e, reason: collision with root package name */
    private static final int f11074e = 1;

    /* renamed from: a, reason: collision with root package name */
    private final long f11075a;

    /* renamed from: b, reason: collision with root package name */
    private final long f11076b;

    /* renamed from: c, reason: collision with root package name */
    private long f11077c;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f11079f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f11080g;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11078d = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler.Callback f11081h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f11078d) {
                    return true;
                }
                long jElapsedRealtime = a.this.f11077c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f11079f != null) {
                        a.this.f11079f.quit();
                    }
                } else if (jElapsedRealtime < a.this.f11076b) {
                    a.this.f11080g.sendMessageDelayed(a.this.f11080g.obtainMessage(1), jElapsedRealtime);
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = (jElapsedRealtime2 + a.this.f11076b) - SystemClock.elapsedRealtime();
                    while (jElapsedRealtime3 < 0) {
                        jElapsedRealtime3 += a.this.f11076b;
                    }
                    a.this.f11080g.sendMessageDelayed(a.this.f11080g.obtainMessage(1), jElapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j2, long j3) {
        this.f11075a = j2;
        this.f11076b = j3;
        if (d()) {
            this.f11080g = new Handler(this.f11081h);
            return;
        }
        this.f11079f = new HandlerThread("CountDownTimerThread");
        this.f11079f.start();
        this.f11080g = new Handler(this.f11079f.getLooper(), this.f11081h);
    }

    public abstract void a(long j2);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f11078d = true;
        this.f11080g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f11078d = false;
        if (this.f11075a <= 0) {
            c();
            return this;
        }
        this.f11077c = SystemClock.elapsedRealtime() + this.f11075a;
        this.f11080g.sendMessage(this.f11080g.obtainMessage(1));
        return this;
    }
}

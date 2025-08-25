package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public abstract class ah {

    /* renamed from: a, reason: collision with root package name */
    final long f11246a;

    /* renamed from: b, reason: collision with root package name */
    long f11247b;

    /* renamed from: d, reason: collision with root package name */
    private final long f11249d;

    /* renamed from: e, reason: collision with root package name */
    private long f11250e;

    /* renamed from: c, reason: collision with root package name */
    boolean f11248c = false;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f11251f = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            synchronized (ah.this) {
                if (message.what == 1) {
                    if (ah.this.f11248c) {
                        return;
                    }
                    long jElapsedRealtime = ah.this.f11247b - SystemClock.elapsedRealtime();
                    if (jElapsedRealtime <= 0) {
                        ah.this.e();
                    } else if (jElapsedRealtime < ah.this.f11246a) {
                        ah.this.a(jElapsedRealtime);
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        ah.this.a(jElapsedRealtime);
                        long jElapsedRealtime3 = (jElapsedRealtime2 + ah.this.f11246a) - SystemClock.elapsedRealtime();
                        while (jElapsedRealtime3 < 0) {
                            jElapsedRealtime3 += ah.this.f11246a;
                        }
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime3);
                    }
                }
            }
        }
    };

    public ah(long j2, long j3) {
        this.f11249d = j2;
        this.f11246a = j3;
    }

    public final synchronized void a() {
        this.f11248c = true;
        this.f11251f.removeMessages(1);
    }

    public abstract void a(long j2);

    public final synchronized ah b() {
        this.f11248c = false;
        if (this.f11249d <= 0) {
            e();
            return this;
        }
        this.f11247b = SystemClock.elapsedRealtime() + this.f11249d;
        this.f11251f.sendMessage(this.f11251f.obtainMessage(1));
        return this;
    }

    public final synchronized ah c() {
        this.f11248c = false;
        this.f11250e = this.f11247b - SystemClock.elapsedRealtime();
        if (this.f11250e <= 0) {
            return this;
        }
        this.f11251f.removeMessages(1);
        this.f11251f.sendMessageAtFrontOfQueue(this.f11251f.obtainMessage(2));
        return this;
    }

    public final synchronized ah d() {
        this.f11248c = false;
        if (this.f11250e <= 0) {
            return this;
        }
        this.f11251f.removeMessages(2);
        this.f11247b = this.f11250e + SystemClock.elapsedRealtime();
        this.f11251f.sendMessageAtFrontOfQueue(this.f11251f.obtainMessage(1));
        return this;
    }

    public abstract void e();
}

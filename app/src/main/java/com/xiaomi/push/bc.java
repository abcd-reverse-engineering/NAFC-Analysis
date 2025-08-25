package com.xiaomi.push;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class bc<T> {

    /* renamed from: a, reason: collision with root package name */
    private final long f12482a;

    /* renamed from: b, reason: collision with root package name */
    private long f12483b;

    /* renamed from: c, reason: collision with root package name */
    private long f12484c;

    /* renamed from: d, reason: collision with root package name */
    private long f12485d;

    /* renamed from: e, reason: collision with root package name */
    private long f12486e;

    /* renamed from: f, reason: collision with root package name */
    private long f12487f;

    /* renamed from: g, reason: collision with root package name */
    private long f12488g;

    /* renamed from: h, reason: collision with root package name */
    private long f12489h;

    /* renamed from: i, reason: collision with root package name */
    private final long f12490i;

    public bc(long j2, long j3) {
        this.f12490i = j2 * 1000000;
        this.f12482a = j3;
    }

    public long a() {
        return this.f12484c;
    }

    public long b() {
        return this.f12485d;
    }

    public long c() {
        long j2 = this.f12487f;
        if (j2 > 0) {
            long j3 = this.f12486e;
            if (j3 > 0) {
                return j2 / j3;
            }
        }
        return 0L;
    }

    public long d() {
        long j2 = this.f12489h;
        long j3 = this.f12488g;
        if (j2 > j3) {
            return j2 - j3;
        }
        return 0L;
    }

    public T a(Callable<T> callable) throws Exception {
        long j2 = this.f12483b;
        long j3 = this.f12490i;
        if (j2 > j3) {
            long j4 = (j2 / j3) * this.f12482a;
            this.f12483b = 0L;
            if (j4 > 0) {
                try {
                    Thread.sleep(j4);
                } catch (Exception unused) {
                }
            }
        }
        long jNanoTime = System.nanoTime();
        if (this.f12488g <= 0) {
            this.f12488g = jNanoTime;
        }
        T tCall = null;
        try {
            tCall = callable.call();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        this.f12489h = System.nanoTime();
        this.f12486e++;
        if (this.f12484c < jNanoTime2) {
            this.f12484c = jNanoTime2;
        }
        if (jNanoTime2 > 0) {
            this.f12487f += jNanoTime2;
            long j5 = this.f12485d;
            if (j5 == 0 || j5 > jNanoTime2) {
                this.f12485d = jNanoTime2;
            }
        }
        this.f12483b += Math.max(jNanoTime2, 0L);
        return tCall;
    }
}

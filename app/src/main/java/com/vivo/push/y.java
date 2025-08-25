package com.vivo.push;

import android.os.SystemClock;

/* compiled from: RequestFrequencyControl.java */
/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f12312a = -1;

    public final synchronized boolean a() {
        boolean z;
        long j2 = this.f12312a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z = j2 != -1 && jElapsedRealtime > j2 && jElapsedRealtime < j2 + 2000;
        this.f12312a = SystemClock.elapsedRealtime();
        return z;
    }
}

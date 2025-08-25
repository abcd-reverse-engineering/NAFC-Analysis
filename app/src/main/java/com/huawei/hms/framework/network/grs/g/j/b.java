package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f6909a;

    /* renamed from: b, reason: collision with root package name */
    private final long f6910b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f6909a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f6909a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f6910b <= 300000;
    }
}

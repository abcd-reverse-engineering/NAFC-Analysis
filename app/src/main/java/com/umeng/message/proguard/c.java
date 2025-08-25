package com.umeng.message.proguard;

import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected Future<?> f11339a;

    public final c a() {
        this.f11339a = b();
        return this;
    }

    protected abstract Future<?> b();

    public final void c() {
        Future<?> future = this.f11339a;
        if (future != null) {
            try {
                if (!future.isCancelled() && !future.isDone()) {
                    future.cancel(false);
                }
            } catch (Throwable unused) {
            }
        }
        this.f11339a = null;
    }

    public final boolean d() {
        Future<?> future = this.f11339a;
        return (future == null || future.isDone()) ? false : true;
    }
}

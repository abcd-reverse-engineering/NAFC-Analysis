package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f6367a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f6368b;

    public z0(n0 n0Var, Callable callable) {
        this.f6367a = n0Var;
        this.f6368b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6367a.a((n0) this.f6368b.call());
        } catch (Exception e2) {
            this.f6367a.a(e2);
        }
    }
}

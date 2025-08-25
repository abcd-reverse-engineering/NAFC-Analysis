package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class s0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f6329a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f6330b;

    public s0(t0 t0Var, a1 a1Var) {
        this.f6330b = t0Var;
        this.f6329a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f6330b.f6335c) {
            k0<TResult> k0Var = this.f6330b.f6334b;
            if (k0Var != 0) {
                k0Var.a(this.f6329a);
            }
        }
    }
}

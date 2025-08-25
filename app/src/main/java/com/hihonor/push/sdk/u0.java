package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class u0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f6339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f6340b;

    public u0(v0 v0Var, a1 a1Var) {
        this.f6340b = v0Var;
        this.f6339a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f6340b.f6345c) {
            l0 l0Var = this.f6340b.f6344b;
            if (l0Var != null) {
                this.f6339a.b();
                ((y0) l0Var).f6356a.countDown();
            }
        }
    }
}

package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class v0<TResult> implements j0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f6343a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f6344b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6345c = new Object();

    public v0(Executor executor, l0 l0Var) {
        this.f6344b = l0Var;
        this.f6343a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (a1Var.e()) {
            return;
        }
        a1Var.d();
        this.f6343a.execute(new u0(this, a1Var));
    }
}

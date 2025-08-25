package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class t0<TResult> implements j0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f6333a;

    /* renamed from: b, reason: collision with root package name */
    public k0<TResult> f6334b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6335c = new Object();

    public t0(Executor executor, k0<TResult> k0Var) {
        this.f6334b = k0Var;
        this.f6333a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        this.f6333a.execute(new s0(this, a1Var));
    }
}

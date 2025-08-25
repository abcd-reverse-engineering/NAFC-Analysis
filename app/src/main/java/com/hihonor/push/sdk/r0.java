package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class r0<TResult> implements j0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f6321a;

    /* renamed from: b, reason: collision with root package name */
    public y0 f6322b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6323c = new Object();

    public r0(Executor executor, y0 y0Var) {
        this.f6322b = y0Var;
        this.f6321a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        a1Var.d();
    }
}

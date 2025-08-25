package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.ExecutionException;

/* compiled from: OnEventListener.java */
/* loaded from: classes.dex */
public class h<TResult> implements c.c.a.d.e, c.c.a.d.g, c.c.a.d.h<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6072a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f6073b;

    /* renamed from: c, reason: collision with root package name */
    private final i<Void> f6074c;

    /* renamed from: d, reason: collision with root package name */
    private int f6075d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f6076e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6077f;

    h(int i2, i<Void> iVar) {
        this.f6073b = i2;
        this.f6074c = iVar;
    }

    private void a() {
        if (this.f6075d >= this.f6073b) {
            Exception exc = this.f6076e;
            if (exc != null) {
                this.f6074c.a(new ExecutionException("a task failed", exc));
            } else if (this.f6077f) {
                this.f6074c.f();
            } else {
                this.f6074c.a((i<Void>) null);
            }
        }
    }

    @Override // c.c.a.d.e
    public void onCanceled() {
        synchronized (this.f6072a) {
            this.f6075d++;
            this.f6077f = true;
            a();
        }
    }

    @Override // c.c.a.d.g
    public void onFailure(Exception exc) {
        synchronized (this.f6072a) {
            this.f6075d++;
            this.f6076e = exc;
            a();
        }
    }

    @Override // c.c.a.d.h
    public void onSuccess(TResult tresult) {
        synchronized (this.f6072a) {
            this.f6075d++;
            a();
        }
    }
}

package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* compiled from: ExecuteCompleteResult.java */
/* loaded from: classes.dex */
public final class c<TResult> implements c.c.a.d.d<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private c.c.a.d.f<TResult> f6050a;

    /* renamed from: b, reason: collision with root package name */
    Executor f6051b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6052c = new Object();

    /* compiled from: ExecuteCompleteResult.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.c.a.d.j f6053a;

        a(c.c.a.d.j jVar) {
            this.f6053a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (c.this.f6052c) {
                if (c.this.f6050a != null) {
                    c.this.f6050a.a(this.f6053a);
                }
            }
        }
    }

    c(Executor executor, c.c.a.d.f<TResult> fVar) {
        this.f6051b = executor;
        this.f6050a = fVar;
    }

    @Override // c.c.a.d.d
    public void cancel() {
        synchronized (this.f6052c) {
            this.f6050a = null;
        }
    }

    @Override // c.c.a.d.d
    public void a(c.c.a.d.j<TResult> jVar) {
        this.f6051b.execute(new a(jVar));
    }
}

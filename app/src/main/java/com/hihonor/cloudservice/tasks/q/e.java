package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* compiled from: ExecuteSuccessResult.java */
/* loaded from: classes.dex */
public final class e<TResult> implements c.c.a.d.d<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private c.c.a.d.h<TResult> f6060a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f6061b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6062c = new Object();

    /* compiled from: ExecuteSuccessResult.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.c.a.d.j f6063a;

        a(c.c.a.d.j jVar) {
            this.f6063a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (e.this.f6062c) {
                if (e.this.f6060a != null) {
                    e.this.f6060a.onSuccess(this.f6063a.b());
                }
            }
        }
    }

    e(Executor executor, c.c.a.d.h<TResult> hVar) {
        this.f6061b = executor;
        this.f6060a = hVar;
    }

    @Override // c.c.a.d.d
    public void cancel() {
        synchronized (this.f6062c) {
            this.f6060a = null;
        }
    }

    @Override // c.c.a.d.d
    public void a(c.c.a.d.j<TResult> jVar) {
        if (!jVar.e() || jVar.c()) {
            return;
        }
        this.f6061b.execute(new a(jVar));
    }
}

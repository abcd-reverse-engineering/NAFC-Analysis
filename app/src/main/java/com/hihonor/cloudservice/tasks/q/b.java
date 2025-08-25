package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* compiled from: ExecuteCanceledResult.java */
/* loaded from: classes.dex */
public final class b<TResult> implements c.c.a.d.d<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private c.c.a.d.e f6046a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f6047b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6048c = new Object();

    /* compiled from: ExecuteCanceledResult.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this.f6048c) {
                if (b.this.f6046a != null) {
                    b.this.f6046a.onCanceled();
                }
            }
        }
    }

    b(Executor executor, c.c.a.d.e eVar) {
        this.f6046a = eVar;
        this.f6047b = executor;
    }

    @Override // c.c.a.d.d
    public void cancel() {
        synchronized (this.f6048c) {
            this.f6046a = null;
        }
    }

    @Override // c.c.a.d.d
    public void a(c.c.a.d.j<TResult> jVar) {
        if (jVar.c()) {
            this.f6047b.execute(new a());
        }
    }
}

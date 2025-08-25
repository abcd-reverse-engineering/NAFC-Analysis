package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* compiled from: ExecuteFailureResult.java */
/* loaded from: classes.dex */
public final class d<TResult> implements c.c.a.d.d<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private c.c.a.d.g f6055a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f6056b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6057c = new Object();

    /* compiled from: ExecuteFailureResult.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.c.a.d.j f6058a;

        a(c.c.a.d.j jVar) {
            this.f6058a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.this.f6057c) {
                if (d.this.f6055a != null) {
                    d.this.f6055a.onFailure(this.f6058a.a());
                }
            }
        }
    }

    d(Executor executor, c.c.a.d.g gVar) {
        this.f6056b = executor;
        this.f6055a = gVar;
    }

    @Override // c.c.a.d.d
    public void cancel() {
        synchronized (this.f6057c) {
            this.f6055a = null;
        }
    }

    @Override // c.c.a.d.d
    public void a(c.c.a.d.j<TResult> jVar) {
        if (jVar.e() || jVar.c()) {
            return;
        }
        this.f6056b.execute(new a(jVar));
    }
}

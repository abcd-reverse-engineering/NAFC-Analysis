package com.hihonor.cloudservice.tasks.q;

import android.app.Activity;
import c.c.a.d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: TaskImpl.java */
/* loaded from: classes.dex */
public final class i<TResult> extends c.c.a.d.j<TResult> {

    /* renamed from: b, reason: collision with root package name */
    private boolean f6079b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f6080c;

    /* renamed from: d, reason: collision with root package name */
    private TResult f6081d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f6082e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f6078a = new Object();

    /* renamed from: f, reason: collision with root package name */
    private List<c.c.a.d.d<TResult>> f6083f = new ArrayList();

    /* compiled from: TaskImpl.java */
    class a implements c.c.a.d.h<TResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.c.a.d.i f6084a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f6085b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* compiled from: TaskImpl.java */
        /* renamed from: com.hihonor.cloudservice.tasks.q.i$a$a, reason: collision with other inner class name */
        class C0100a<TContinuationResult> implements c.c.a.d.f<TContinuationResult> {
            C0100a() {
            }

            @Override // c.c.a.d.f
            public final void a(c.c.a.d.j<TContinuationResult> jVar) {
                if (jVar.e()) {
                    a.this.f6085b.a((i) jVar.b());
                } else if (jVar.c()) {
                    a.this.f6085b.f();
                } else {
                    a.this.f6085b.a(jVar.a());
                }
            }
        }

        a(i iVar, c.c.a.d.i iVar2, i iVar3) {
            this.f6084a = iVar2;
            this.f6085b = iVar3;
        }

        @Override // c.c.a.d.h
        public final void onSuccess(TResult tresult) {
            try {
                c.c.a.d.j jVarThen = this.f6084a.then(tresult);
                if (jVarThen == null) {
                    this.f6085b.a((Exception) new NullPointerException("SuccessContinuation returned null"));
                } else {
                    jVarThen.a(new C0100a());
                }
            } catch (Exception e2) {
                this.f6085b.a(e2);
            }
        }
    }

    /* compiled from: TaskImpl.java */
    class b implements c.c.a.d.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6087a;

        b(i iVar, i iVar2) {
            this.f6087a = iVar2;
        }

        @Override // c.c.a.d.g
        public final void onFailure(Exception exc) {
            this.f6087a.a(exc);
        }
    }

    /* compiled from: TaskImpl.java */
    class c implements c.c.a.d.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6088a;

        c(i iVar, i iVar2) {
            this.f6088a = iVar2;
        }

        @Override // c.c.a.d.e
        public final void onCanceled() {
            this.f6088a.f();
        }
    }

    /* compiled from: TaskImpl.java */
    class d implements c.c.a.d.f<TResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.c.a.d.c f6089a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f6090b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* compiled from: TaskImpl.java */
        class a<TContinuationResult> implements c.c.a.d.f<TContinuationResult> {
            a() {
            }

            @Override // c.c.a.d.f
            public final void a(c.c.a.d.j<TContinuationResult> jVar) {
                if (jVar.e()) {
                    d.this.f6090b.a((i) jVar.b());
                } else if (jVar.c()) {
                    d.this.f6090b.f();
                } else {
                    d.this.f6090b.a(jVar.a());
                }
            }
        }

        d(i iVar, c.c.a.d.c cVar, i iVar2) {
            this.f6089a = cVar;
            this.f6090b = iVar2;
        }

        @Override // c.c.a.d.f
        public final void a(c.c.a.d.j<TResult> jVar) {
            try {
                c.c.a.d.j jVar2 = (c.c.a.d.j) this.f6089a.a(jVar);
                if (jVar2 == null) {
                    this.f6090b.a((Exception) new NullPointerException("Continuation returned null"));
                } else {
                    jVar2.a(new a());
                }
            } catch (Exception e2) {
                this.f6090b.a(e2);
            }
        }
    }

    /* compiled from: TaskImpl.java */
    class e implements c.c.a.d.f<TResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6092a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c.c.a.d.c f6093b;

        e(i iVar, i iVar2, c.c.a.d.c cVar) {
            this.f6092a = iVar2;
            this.f6093b = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.c.a.d.f
        public final void a(c.c.a.d.j<TResult> jVar) {
            if (jVar.c()) {
                this.f6092a.f();
                return;
            }
            try {
                this.f6092a.a((i) this.f6093b.a(jVar));
            } catch (Exception e2) {
                this.f6092a.a(e2);
            }
        }
    }

    private void g() {
        synchronized (this.f6078a) {
            Iterator<c.c.a.d.d<TResult>> it = this.f6083f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f6083f = null;
        }
    }

    public final void a(TResult tresult) {
        synchronized (this.f6078a) {
            if (!this.f6079b) {
                this.f6079b = true;
                this.f6081d = tresult;
                this.f6078a.notifyAll();
                g();
            }
        }
    }

    @Override // c.c.a.d.j
    public final <TContinuationResult> c.c.a.d.j<TContinuationResult> b(c.c.a.d.c<TResult, c.c.a.d.j<TContinuationResult>> cVar) {
        return b(l.c(), cVar);
    }

    @Override // c.c.a.d.j
    public boolean c() {
        return this.f6080c;
    }

    @Override // c.c.a.d.j
    public boolean d() {
        boolean z;
        synchronized (this.f6078a) {
            z = this.f6079b;
        }
        return z;
    }

    @Override // c.c.a.d.j
    public boolean e() {
        boolean z;
        synchronized (this.f6078a) {
            z = this.f6079b && !c() && this.f6082e == null;
        }
        return z;
    }

    public final boolean f() {
        synchronized (this.f6078a) {
            if (this.f6079b) {
                return false;
            }
            this.f6079b = true;
            this.f6080c = true;
            this.f6078a.notifyAll();
            g();
            return true;
        }
    }

    @Override // c.c.a.d.j
    public TResult b() {
        TResult tresult;
        synchronized (this.f6078a) {
            if (this.f6082e != null) {
                throw new RuntimeException(this.f6082e);
            }
            tresult = this.f6081d;
        }
        return tresult;
    }

    @Override // c.c.a.d.j
    public final <TContinuationResult> c.c.a.d.j<TContinuationResult> b(Executor executor, c.c.a.d.c<TResult, c.c.a.d.j<TContinuationResult>> cVar) {
        i iVar = new i();
        a(executor, new d(this, cVar, iVar));
        return iVar;
    }

    @Override // c.c.a.d.j
    public final c.c.a.d.j<TResult> a(c.c.a.d.e eVar) {
        return a(l.c(), eVar);
    }

    @Override // c.c.a.d.j
    public final c.c.a.d.j<TResult> a(c.c.a.d.f<TResult> fVar) {
        return a(l.c(), fVar);
    }

    @Override // c.c.a.d.j
    public c.c.a.d.j<TResult> a(c.c.a.d.g gVar) {
        return a(l.c(), gVar);
    }

    @Override // c.c.a.d.j
    public c.c.a.d.j<TResult> a(c.c.a.d.h<TResult> hVar) {
        return a(l.c(), hVar);
    }

    @Override // c.c.a.d.j
    public final <TContinuationResult> c.c.a.d.j<TContinuationResult> a(c.c.a.d.c<TResult, TContinuationResult> cVar) {
        return a(l.c(), cVar);
    }

    @Override // c.c.a.d.j
    public Exception a() {
        Exception exc;
        synchronized (this.f6078a) {
            exc = this.f6082e;
        }
        return exc;
    }

    @Override // c.c.a.d.j
    public final <E extends Throwable> TResult a(Class<E> cls) {
        TResult tresult;
        synchronized (this.f6078a) {
            if (cls != null) {
                if (cls.isInstance(this.f6082e)) {
                    throw cls.cast(this.f6082e);
                }
            }
            if (this.f6082e == null) {
                tresult = this.f6081d;
            } else {
                throw new RuntimeException(this.f6082e);
            }
        }
        return tresult;
    }

    @Override // c.c.a.d.j
    public final <TContinuationResult> c.c.a.d.j<TContinuationResult> a(c.c.a.d.i<TResult, TContinuationResult> iVar) {
        return a(l.c(), iVar);
    }

    @Override // c.c.a.d.j
    public final c.c.a.d.j<TResult> a(Executor executor, c.c.a.d.e eVar) {
        return a((c.c.a.d.d) new com.hihonor.cloudservice.tasks.q.b(executor, eVar));
    }

    @Override // c.c.a.d.j
    public final c.c.a.d.j<TResult> a(Executor executor, c.c.a.d.f<TResult> fVar) {
        return a((c.c.a.d.d) new com.hihonor.cloudservice.tasks.q.c(executor, fVar));
    }

    @Override // c.c.a.d.j
    public c.c.a.d.j<TResult> a(Executor executor, c.c.a.d.g gVar) {
        return a((c.c.a.d.d) new com.hihonor.cloudservice.tasks.q.d(executor, gVar));
    }

    @Override // c.c.a.d.j
    public c.c.a.d.j<TResult> a(Executor executor, c.c.a.d.h<TResult> hVar) {
        return a((c.c.a.d.d) new com.hihonor.cloudservice.tasks.q.e(executor, hVar));
    }

    @Override // c.c.a.d.j
    public final <TContinuationResult> c.c.a.d.j<TContinuationResult> a(Executor executor, c.c.a.d.c<TResult, TContinuationResult> cVar) {
        i iVar = new i();
        a(executor, new e(this, iVar, cVar));
        return iVar;
    }

    @Override // c.c.a.d.j
    public final <TContinuationResult> c.c.a.d.j<TContinuationResult> a(Executor executor, c.c.a.d.i<TResult, TContinuationResult> iVar) {
        i iVar2 = new i();
        a(executor, new a(this, iVar, iVar2));
        a((c.c.a.d.g) new b(this, iVar2));
        a((c.c.a.d.e) new c(this, iVar2));
        return iVar2;
    }

    @Override // c.c.a.d.j
    public final c.c.a.d.j<TResult> a(Activity activity, c.c.a.d.e eVar) {
        com.hihonor.cloudservice.tasks.q.b bVar = new com.hihonor.cloudservice.tasks.q.b(l.c(), eVar);
        f.a(activity, bVar);
        return a((c.c.a.d.d) bVar);
    }

    @Override // c.c.a.d.j
    public final c.c.a.d.j<TResult> a(Activity activity, c.c.a.d.f<TResult> fVar) {
        com.hihonor.cloudservice.tasks.q.c cVar = new com.hihonor.cloudservice.tasks.q.c(l.c(), fVar);
        f.a(activity, cVar);
        return a((c.c.a.d.d) cVar);
    }

    @Override // c.c.a.d.j
    public c.c.a.d.j<TResult> a(Activity activity, c.c.a.d.g gVar) {
        com.hihonor.cloudservice.tasks.q.d dVar = new com.hihonor.cloudservice.tasks.q.d(l.c(), gVar);
        f.a(activity, dVar);
        return a((c.c.a.d.d) dVar);
    }

    @Override // c.c.a.d.j
    public c.c.a.d.j<TResult> a(Activity activity, c.c.a.d.h<TResult> hVar) {
        com.hihonor.cloudservice.tasks.q.e eVar = new com.hihonor.cloudservice.tasks.q.e(l.c(), hVar);
        f.a(activity, eVar);
        return a((c.c.a.d.d) eVar);
    }

    public final void a(Exception exc) {
        synchronized (this.f6078a) {
            if (!this.f6079b) {
                this.f6079b = true;
                this.f6082e = exc;
                this.f6078a.notifyAll();
                g();
            }
        }
    }

    private c.c.a.d.j<TResult> a(c.c.a.d.d<TResult> dVar) {
        boolean zD;
        synchronized (this.f6078a) {
            zD = d();
            if (!zD) {
                this.f6083f.add(dVar);
            }
        }
        if (zD) {
            dVar.a(this);
        }
        return this;
    }
}

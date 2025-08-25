package com.bumptech.glide.load.p;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.p.h;
import com.bumptech.glide.load.p.p;
import com.bumptech.glide.util.n.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class l<R> implements h.b<R>, a.f {
    private static final c y = new c();

    /* renamed from: a, reason: collision with root package name */
    final e f4603a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.n.c f4604b;

    /* renamed from: c, reason: collision with root package name */
    private final p.a f4605c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<l<?>> f4606d;

    /* renamed from: e, reason: collision with root package name */
    private final c f4607e;

    /* renamed from: f, reason: collision with root package name */
    private final m f4608f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f4609g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f4610h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f4611i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f4612j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicInteger f4613k;

    /* renamed from: l, reason: collision with root package name */
    private com.bumptech.glide.load.g f4614l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4615m;
    private boolean n;
    private boolean o;
    private boolean p;
    private v<?> q;
    com.bumptech.glide.load.a r;
    private boolean s;
    q t;
    private boolean u;
    p<?> v;
    private h<R> w;
    private volatile boolean x;

    /* compiled from: EngineJob.java */
    private class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.r.i f4616a;

        a(com.bumptech.glide.r.i iVar) {
            this.f4616a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f4616a.e()) {
                synchronized (l.this) {
                    if (l.this.f4603a.a(this.f4616a)) {
                        l.this.a(this.f4616a);
                    }
                    l.this.b();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.r.i f4618a;

        b(com.bumptech.glide.r.i iVar) {
            this.f4618a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f4618a.e()) {
                synchronized (l.this) {
                    if (l.this.f4603a.a(this.f4618a)) {
                        l.this.v.c();
                        l.this.b(this.f4618a);
                        l.this.c(this.f4618a);
                    }
                    l.this.b();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    @VisibleForTesting
    static class c {
        c() {
        }

        public <R> p<R> a(v<R> vVar, boolean z, com.bumptech.glide.load.g gVar, p.a aVar) {
            return new p<>(vVar, z, true, gVar, aVar);
        }
    }

    /* compiled from: EngineJob.java */
    static final class d {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.r.i f4620a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f4621b;

        d(com.bumptech.glide.r.i iVar, Executor executor) {
            this.f4620a = iVar;
            this.f4621b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f4620a.equals(((d) obj).f4620a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4620a.hashCode();
        }
    }

    /* compiled from: EngineJob.java */
    static final class e implements Iterable<d> {

        /* renamed from: a, reason: collision with root package name */
        private final List<d> f4622a;

        e() {
            this(new ArrayList(2));
        }

        private static d c(com.bumptech.glide.r.i iVar) {
            return new d(iVar, com.bumptech.glide.util.d.a());
        }

        void a(com.bumptech.glide.r.i iVar, Executor executor) {
            this.f4622a.add(new d(iVar, executor));
        }

        void b(com.bumptech.glide.r.i iVar) {
            this.f4622a.remove(c(iVar));
        }

        void clear() {
            this.f4622a.clear();
        }

        boolean isEmpty() {
            return this.f4622a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f4622a.iterator();
        }

        int size() {
            return this.f4622a.size();
        }

        e(List<d> list) {
            this.f4622a = list;
        }

        boolean a(com.bumptech.glide.r.i iVar) {
            return this.f4622a.contains(c(iVar));
        }

        e a() {
            return new e(new ArrayList(this.f4622a));
        }
    }

    l(com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, y);
    }

    private com.bumptech.glide.load.p.c0.a h() {
        return this.n ? this.f4611i : this.o ? this.f4612j : this.f4610h;
    }

    private boolean i() {
        return this.u || this.s || this.x;
    }

    private synchronized void j() {
        if (this.f4614l == null) {
            throw new IllegalArgumentException();
        }
        this.f4603a.clear();
        this.f4614l = null;
        this.v = null;
        this.q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.w.a(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.f4606d.release(this);
    }

    @VisibleForTesting
    synchronized l<R> a(com.bumptech.glide.load.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4614l = gVar;
        this.f4615m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public synchronized void b(h<R> hVar) {
        this.w = hVar;
        (hVar.d() ? this.f4609g : h()).execute(hVar);
    }

    synchronized void c(com.bumptech.glide.r.i iVar) {
        this.f4604b.a();
        this.f4603a.b(iVar);
        if (this.f4603a.isEmpty()) {
            a();
            if ((this.s || this.u) && this.f4613k.get() == 0) {
                j();
            }
        }
    }

    synchronized boolean d() {
        return this.x;
    }

    void e() {
        synchronized (this) {
            this.f4604b.a();
            if (this.x) {
                j();
                return;
            }
            if (this.f4603a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.u) {
                throw new IllegalStateException("Already failed once");
            }
            this.u = true;
            com.bumptech.glide.load.g gVar = this.f4614l;
            e eVarA = this.f4603a.a();
            a(eVarA.size() + 1);
            this.f4608f.a(this, gVar, null);
            Iterator<d> it = eVarA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f4621b.execute(new a(next.f4620a));
            }
            b();
        }
    }

    void f() {
        synchronized (this) {
            this.f4604b.a();
            if (this.x) {
                this.q.recycle();
                j();
                return;
            }
            if (this.f4603a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.s) {
                throw new IllegalStateException("Already have resource");
            }
            this.v = this.f4607e.a(this.q, this.f4615m, this.f4614l, this.f4605c);
            this.s = true;
            e eVarA = this.f4603a.a();
            a(eVarA.size() + 1);
            this.f4608f.a(this, this.f4614l, this.v);
            Iterator<d> it = eVarA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f4621b.execute(new b(next.f4620a));
            }
            b();
        }
    }

    boolean g() {
        return this.p;
    }

    @VisibleForTesting
    l(com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.f4603a = new e();
        this.f4604b = com.bumptech.glide.util.n.c.b();
        this.f4613k = new AtomicInteger();
        this.f4609g = aVar;
        this.f4610h = aVar2;
        this.f4611i = aVar3;
        this.f4612j = aVar4;
        this.f4608f = mVar;
        this.f4605c = aVar5;
        this.f4606d = pool;
        this.f4607e = cVar;
    }

    @GuardedBy("this")
    void b(com.bumptech.glide.r.i iVar) {
        try {
            iVar.a(this.v, this.r);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.p.b(th);
        }
    }

    synchronized void a(com.bumptech.glide.r.i iVar, Executor executor) {
        this.f4604b.a();
        this.f4603a.a(iVar, executor);
        boolean z = true;
        if (this.s) {
            a(1);
            executor.execute(new b(iVar));
        } else if (this.u) {
            a(1);
            executor.execute(new a(iVar));
        } else {
            if (this.x) {
                z = false;
            }
            com.bumptech.glide.util.j.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    void b() {
        p<?> pVar;
        synchronized (this) {
            this.f4604b.a();
            com.bumptech.glide.util.j.a(i(), "Not yet complete!");
            int iDecrementAndGet = this.f4613k.decrementAndGet();
            com.bumptech.glide.util.j.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                pVar = this.v;
                j();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.f();
        }
    }

    @Override // com.bumptech.glide.util.n.a.f
    @NonNull
    public com.bumptech.glide.util.n.c c() {
        return this.f4604b;
    }

    @GuardedBy("this")
    void a(com.bumptech.glide.r.i iVar) {
        try {
            iVar.a(this.t);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.p.b(th);
        }
    }

    void a() {
        if (i()) {
            return;
        }
        this.x = true;
        this.w.a();
        this.f4608f.a(this, this.f4614l);
    }

    synchronized void a(int i2) {
        com.bumptech.glide.util.j.a(i(), "Not yet complete!");
        if (this.f4613k.getAndAdd(i2) == 0 && this.v != null) {
            this.v.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.p.h.b
    public void a(v<R> vVar, com.bumptech.glide.load.a aVar) {
        synchronized (this) {
            this.q = vVar;
            this.r = aVar;
        }
        f();
    }

    @Override // com.bumptech.glide.load.p.h.b
    public void a(q qVar) {
        synchronized (this) {
            this.t = qVar;
        }
        e();
    }

    @Override // com.bumptech.glide.load.p.h.b
    public void a(h<?> hVar) {
        h().execute(hVar);
    }
}

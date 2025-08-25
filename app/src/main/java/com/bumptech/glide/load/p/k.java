package com.bumptech.glide.load.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.j;
import com.bumptech.glide.load.p.h;
import com.bumptech.glide.load.p.p;
import com.bumptech.glide.util.n.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class k implements m, j.a, p.a {

    /* renamed from: j, reason: collision with root package name */
    private static final int f4576j = 150;

    /* renamed from: a, reason: collision with root package name */
    private final s f4578a;

    /* renamed from: b, reason: collision with root package name */
    private final o f4579b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.b0.j f4580c;

    /* renamed from: d, reason: collision with root package name */
    private final b f4581d;

    /* renamed from: e, reason: collision with root package name */
    private final y f4582e;

    /* renamed from: f, reason: collision with root package name */
    private final c f4583f;

    /* renamed from: g, reason: collision with root package name */
    private final a f4584g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a f4585h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f4575i = "Engine";

    /* renamed from: k, reason: collision with root package name */
    private static final boolean f4577k = Log.isLoggable(f4575i, 2);

    /* compiled from: Engine.java */
    @VisibleForTesting
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final h.e f4586a;

        /* renamed from: b, reason: collision with root package name */
        final Pools.Pool<h<?>> f4587b = com.bumptech.glide.util.n.a.b(150, new C0066a());

        /* renamed from: c, reason: collision with root package name */
        private int f4588c;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.p.k$a$a, reason: collision with other inner class name */
        class C0066a implements a.d<h<?>> {
            C0066a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.n.a.d
            public h<?> create() {
                a aVar = a.this;
                return new h<>(aVar.f4586a, aVar.f4587b);
            }
        }

        a(h.e eVar) {
            this.f4586a = eVar;
        }

        <R> h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.j jVar2, h.b<R> bVar) {
            h hVar2 = (h) com.bumptech.glide.util.j.a(this.f4587b.acquire());
            int i4 = this.f4588c;
            this.f4588c = i4 + 1;
            return hVar2.a(dVar, obj, nVar, gVar, i2, i3, cls, cls2, hVar, jVar, map, z, z2, z3, jVar2, bVar, i4);
        }
    }

    /* compiled from: Engine.java */
    private static class c implements h.e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0059a f4598a;

        /* renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.p.b0.a f4599b;

        c(a.InterfaceC0059a interfaceC0059a) {
            this.f4598a = interfaceC0059a;
        }

        @Override // com.bumptech.glide.load.p.h.e
        public com.bumptech.glide.load.p.b0.a a() {
            if (this.f4599b == null) {
                synchronized (this) {
                    if (this.f4599b == null) {
                        this.f4599b = this.f4598a.build();
                    }
                    if (this.f4599b == null) {
                        this.f4599b = new com.bumptech.glide.load.p.b0.b();
                    }
                }
            }
            return this.f4599b;
        }

        @VisibleForTesting
        synchronized void b() {
            if (this.f4599b == null) {
                return;
            }
            this.f4599b.clear();
        }
    }

    /* compiled from: Engine.java */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final l<?> f4600a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.r.i f4601b;

        d(com.bumptech.glide.r.i iVar, l<?> lVar) {
            this.f4601b = iVar;
            this.f4600a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f4600a.c(this.f4601b);
            }
        }
    }

    public k(com.bumptech.glide.load.p.b0.j jVar, a.InterfaceC0059a interfaceC0059a, com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, boolean z) {
        this(jVar, interfaceC0059a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    @Nullable
    private p<?> b(com.bumptech.glide.load.g gVar) {
        p<?> pVarB = this.f4585h.b(gVar);
        if (pVarB != null) {
            pVarB.c();
        }
        return pVarB;
    }

    private p<?> c(com.bumptech.glide.load.g gVar) {
        p<?> pVarA = a(gVar);
        if (pVarA != null) {
            pVarA.c();
            this.f4585h.a(gVar, pVarA);
        }
        return pVarA;
    }

    public <R> d a(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, com.bumptech.glide.load.j jVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.r.i iVar, Executor executor) {
        long jA = f4577k ? com.bumptech.glide.util.f.a() : 0L;
        n nVarA = this.f4579b.a(obj, gVar, i2, i3, map, cls, cls2, jVar2);
        synchronized (this) {
            p<?> pVarA = a(nVarA, z3, jA);
            if (pVarA == null) {
                return a(dVar, obj, gVar, i2, i3, cls, cls2, hVar, jVar, map, z, z2, jVar2, z3, z4, z5, z6, iVar, executor, nVarA, jA);
            }
            iVar.a(pVarA, com.bumptech.glide.load.a.MEMORY_CACHE);
            return null;
        }
    }

    @VisibleForTesting
    k(com.bumptech.glide.load.p.b0.j jVar, a.InterfaceC0059a interfaceC0059a, com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, s sVar, o oVar, com.bumptech.glide.load.p.a aVar5, b bVar, a aVar6, y yVar, boolean z) {
        this.f4580c = jVar;
        this.f4583f = new c(interfaceC0059a);
        com.bumptech.glide.load.p.a aVar7 = aVar5 == null ? new com.bumptech.glide.load.p.a(z) : aVar5;
        this.f4585h = aVar7;
        aVar7.a(this);
        this.f4579b = oVar == null ? new o() : oVar;
        this.f4578a = sVar == null ? new s() : sVar;
        this.f4581d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f4584g = aVar6 == null ? new a(this.f4583f) : aVar6;
        this.f4582e = yVar == null ? new y() : yVar;
        jVar.a(this);
    }

    public void b(v<?> vVar) {
        if (vVar instanceof p) {
            ((p) vVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* compiled from: Engine.java */
    @VisibleForTesting
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f4590a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f4591b;

        /* renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f4592c;

        /* renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f4593d;

        /* renamed from: e, reason: collision with root package name */
        final m f4594e;

        /* renamed from: f, reason: collision with root package name */
        final p.a f4595f;

        /* renamed from: g, reason: collision with root package name */
        final Pools.Pool<l<?>> f4596g = com.bumptech.glide.util.n.a.b(150, new a());

        /* compiled from: Engine.java */
        class a implements a.d<l<?>> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.n.a.d
            public l<?> create() {
                b bVar = b.this;
                return new l<>(bVar.f4590a, bVar.f4591b, bVar.f4592c, bVar.f4593d, bVar.f4594e, bVar.f4595f, bVar.f4596g);
            }
        }

        b(com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, m mVar, p.a aVar5) {
            this.f4590a = aVar;
            this.f4591b = aVar2;
            this.f4592c = aVar3;
            this.f4593d = aVar4;
            this.f4594e = mVar;
            this.f4595f = aVar5;
        }

        @VisibleForTesting
        void a() {
            com.bumptech.glide.util.d.a(this.f4590a);
            com.bumptech.glide.util.d.a(this.f4591b);
            com.bumptech.glide.util.d.a(this.f4592c);
            com.bumptech.glide.util.d.a(this.f4593d);
        }

        <R> l<R> a(com.bumptech.glide.load.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((l) com.bumptech.glide.util.j.a(this.f4596g.acquire())).a(gVar, z, z2, z3, z4);
        }
    }

    @VisibleForTesting
    public void b() {
        this.f4581d.a();
        this.f4583f.b();
        this.f4585h.b();
    }

    private <R> d a(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, com.bumptech.glide.load.j jVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.r.i iVar, Executor executor, n nVar, long j2) {
        l<?> lVarA = this.f4578a.a(nVar, z6);
        if (lVarA != null) {
            lVarA.a(iVar, executor);
            if (f4577k) {
                a("Added to existing load", j2, nVar);
            }
            return new d(iVar, lVarA);
        }
        l<R> lVarA2 = this.f4581d.a(nVar, z3, z4, z5, z6);
        h<R> hVarA = this.f4584g.a(dVar, obj, nVar, gVar, i2, i3, cls, cls2, hVar, jVar, map, z, z2, z6, jVar2, lVarA2);
        this.f4578a.a((com.bumptech.glide.load.g) nVar, (l<?>) lVarA2);
        lVarA2.a(iVar, executor);
        lVarA2.b(hVarA);
        if (f4577k) {
            a("Started new load", j2, nVar);
        }
        return new d(iVar, lVarA2);
    }

    @Nullable
    private p<?> a(n nVar, boolean z, long j2) {
        if (!z) {
            return null;
        }
        p<?> pVarB = b(nVar);
        if (pVarB != null) {
            if (f4577k) {
                a("Loaded resource from active resources", j2, nVar);
            }
            return pVarB;
        }
        p<?> pVarC = c(nVar);
        if (pVarC == null) {
            return null;
        }
        if (f4577k) {
            a("Loaded resource from cache", j2, nVar);
        }
        return pVarC;
    }

    private static void a(String str, long j2, com.bumptech.glide.load.g gVar) {
        String str2 = str + " in " + com.bumptech.glide.util.f.a(j2) + "ms, key: " + gVar;
    }

    private p<?> a(com.bumptech.glide.load.g gVar) {
        v<?> vVarA = this.f4580c.a(gVar);
        if (vVarA == null) {
            return null;
        }
        if (vVarA instanceof p) {
            return (p) vVarA;
        }
        return new p<>(vVarA, true, true, gVar, this);
    }

    @Override // com.bumptech.glide.load.p.m
    public synchronized void a(l<?> lVar, com.bumptech.glide.load.g gVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.e()) {
                this.f4585h.a(gVar, pVar);
            }
            this.f4578a.b(gVar, lVar);
        } else {
            this.f4578a.b(gVar, lVar);
        }
    }

    @Override // com.bumptech.glide.load.p.m
    public synchronized void a(l<?> lVar, com.bumptech.glide.load.g gVar) {
        this.f4578a.b(gVar, lVar);
    }

    @Override // com.bumptech.glide.load.p.b0.j.a
    public void a(@NonNull v<?> vVar) {
        this.f4582e.a(vVar, true);
    }

    @Override // com.bumptech.glide.load.p.p.a
    public void a(com.bumptech.glide.load.g gVar, p<?> pVar) {
        this.f4585h.a(gVar);
        if (pVar.e()) {
            this.f4580c.a(gVar, pVar);
        } else {
            this.f4582e.a(pVar, false);
        }
    }

    public void a() {
        this.f4583f.a().clear();
    }
}

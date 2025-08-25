package com.google.gson.b0.q;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes.dex */
public final class m<T> extends l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final r<T> f5607a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.j<T> f5608b;

    /* renamed from: c, reason: collision with root package name */
    final com.google.gson.e f5609c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.gson.d0.a<T> f5610d;

    /* renamed from: e, reason: collision with root package name */
    private final z f5611e;

    /* renamed from: f, reason: collision with root package name */
    private final m<T>.b f5612f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5613g;

    /* renamed from: h, reason: collision with root package name */
    private volatile y<T> f5614h;

    /* compiled from: TreeTypeAdapter.java */
    private final class b implements q, com.google.gson.i {
        private b() {
        }

        @Override // com.google.gson.q
        public com.google.gson.k a(Object obj) {
            return m.this.f5609c.b(obj);
        }

        @Override // com.google.gson.q
        public com.google.gson.k a(Object obj, Type type) {
            return m.this.f5609c.b(obj, type);
        }

        @Override // com.google.gson.i
        public <R> R a(com.google.gson.k kVar, Type type) throws com.google.gson.n {
            return (R) m.this.f5609c.a(kVar, type);
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    private static final class c implements z {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.gson.d0.a<?> f5616a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f5617b;

        /* renamed from: c, reason: collision with root package name */
        private final Class<?> f5618c;

        /* renamed from: d, reason: collision with root package name */
        private final r<?> f5619d;

        /* renamed from: e, reason: collision with root package name */
        private final com.google.gson.j<?> f5620e;

        c(Object obj, com.google.gson.d0.a<?> aVar, boolean z, Class<?> cls) {
            this.f5619d = obj instanceof r ? (r) obj : null;
            this.f5620e = obj instanceof com.google.gson.j ? (com.google.gson.j) obj : null;
            com.google.gson.b0.a.a((this.f5619d == null && this.f5620e == null) ? false : true);
            this.f5616a = aVar;
            this.f5617b = z;
            this.f5618c = cls;
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            com.google.gson.d0.a<?> aVar2 = this.f5616a;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f5617b && this.f5616a.getType() == aVar.getRawType()) : this.f5618c.isAssignableFrom(aVar.getRawType())) {
                return new m(this.f5619d, this.f5620e, eVar, aVar, this);
            }
            return null;
        }
    }

    public m(r<T> rVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, com.google.gson.d0.a<T> aVar, z zVar, boolean z) {
        this.f5612f = new b();
        this.f5607a = rVar;
        this.f5608b = jVar;
        this.f5609c = eVar;
        this.f5610d = aVar;
        this.f5611e = zVar;
        this.f5613g = z;
    }

    private y<T> b() {
        y<T> yVar = this.f5614h;
        if (yVar != null) {
            return yVar;
        }
        y<T> yVarA = this.f5609c.a(this.f5611e, this.f5610d);
        this.f5614h = yVarA;
        return yVarA;
    }

    @Override // com.google.gson.b0.q.l
    public y<T> a() {
        return this.f5607a != null ? this : b();
    }

    @Override // com.google.gson.y
    /* renamed from: read */
    public T read2(com.google.gson.e0.a aVar) throws com.google.gson.n, IOException {
        if (this.f5608b == null) {
            return b().read2(aVar);
        }
        com.google.gson.k kVarA = com.google.gson.b0.o.a(aVar);
        if (this.f5613g && kVarA.isJsonNull()) {
            return null;
        }
        return this.f5608b.a(kVarA, this.f5610d.getType(), this.f5612f);
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, T t) throws IOException {
        if (this.f5607a == null) {
            b().write(dVar, t);
        } else if (this.f5613g && t == null) {
            dVar.j();
        } else {
            com.google.gson.b0.o.a(this.f5607a.a(t, this.f5610d.getType(), this.f5612f), dVar);
        }
    }

    public static z a(com.google.gson.d0.a<?> aVar, Object obj) {
        return new c(obj, aVar, false, null);
    }

    public static z a(Class<?> cls, Object obj) {
        return new c(obj, null, false, cls);
    }

    public static z b(com.google.gson.d0.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public m(r<T> rVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, com.google.gson.d0.a<T> aVar, z zVar) {
        this(rVar, jVar, eVar, aVar, zVar, true);
    }
}

package com.bumptech.glide.load.p;

import com.bumptech.glide.i;
import com.bumptech.glide.load.p.h;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
final class g<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n.a<?>> f4525a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.g> f4526b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.d f4527c;

    /* renamed from: d, reason: collision with root package name */
    private Object f4528d;

    /* renamed from: e, reason: collision with root package name */
    private int f4529e;

    /* renamed from: f, reason: collision with root package name */
    private int f4530f;

    /* renamed from: g, reason: collision with root package name */
    private Class<?> f4531g;

    /* renamed from: h, reason: collision with root package name */
    private h.e f4532h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.j f4533i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.n<?>> f4534j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f4535k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4536l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4537m;
    private com.bumptech.glide.load.g n;
    private com.bumptech.glide.h o;
    private j p;
    private boolean q;
    private boolean r;

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, com.bumptech.glide.load.j jVar2, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, h.e eVar) {
        this.f4527c = dVar;
        this.f4528d = obj;
        this.n = gVar;
        this.f4529e = i2;
        this.f4530f = i3;
        this.p = jVar;
        this.f4531g = cls;
        this.f4532h = eVar;
        this.f4535k = cls2;
        this.o = hVar;
        this.f4533i = jVar2;
        this.f4534j = map;
        this.q = z;
        this.r = z2;
    }

    com.bumptech.glide.load.p.a0.b b() {
        return this.f4527c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    com.bumptech.glide.load.p.b0.a d() {
        return this.f4532h.a();
    }

    j e() {
        return this.p;
    }

    int f() {
        return this.f4530f;
    }

    List<n.a<?>> g() {
        if (!this.f4536l) {
            this.f4536l = true;
            this.f4525a.clear();
            List listA = this.f4527c.f().a((com.bumptech.glide.i) this.f4528d);
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVarA = ((com.bumptech.glide.load.q.n) listA.get(i2)).a(this.f4528d, this.f4529e, this.f4530f, this.f4533i);
                if (aVarA != null) {
                    this.f4525a.add(aVarA);
                }
            }
        }
        return this.f4525a;
    }

    Class<?> h() {
        return this.f4528d.getClass();
    }

    com.bumptech.glide.load.j i() {
        return this.f4533i;
    }

    com.bumptech.glide.h j() {
        return this.o;
    }

    List<Class<?>> k() {
        return this.f4527c.f().b(this.f4528d.getClass(), this.f4531g, this.f4535k);
    }

    com.bumptech.glide.load.g l() {
        return this.n;
    }

    Class<?> m() {
        return this.f4535k;
    }

    int n() {
        return this.f4529e;
    }

    boolean o() {
        return this.r;
    }

    <Z> com.bumptech.glide.load.n<Z> b(Class<Z> cls) {
        com.bumptech.glide.load.n<Z> nVar = (com.bumptech.glide.load.n) this.f4534j.get(cls);
        if (nVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.n<?>>> it = this.f4534j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.n<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    nVar = (com.bumptech.glide.load.n) next.getValue();
                    break;
                }
            }
        }
        if (nVar != null) {
            return nVar;
        }
        if (!this.f4534j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.r.c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    List<com.bumptech.glide.load.g> c() {
        if (!this.f4537m) {
            this.f4537m = true;
            this.f4526b.clear();
            List<n.a<?>> listG = g();
            int size = listG.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = listG.get(i2);
                if (!this.f4526b.contains(aVar.f4747a)) {
                    this.f4526b.add(aVar.f4747a);
                }
                for (int i3 = 0; i3 < aVar.f4748b.size(); i3++) {
                    if (!this.f4526b.contains(aVar.f4748b.get(i3))) {
                        this.f4526b.add(aVar.f4748b.get(i3));
                    }
                }
            }
        }
        return this.f4526b;
    }

    boolean b(v<?> vVar) {
        return this.f4527c.f().b(vVar);
    }

    void a() {
        this.f4527c = null;
        this.f4528d = null;
        this.n = null;
        this.f4531g = null;
        this.f4535k = null;
        this.f4533i = null;
        this.o = null;
        this.f4534j = null;
        this.p = null;
        this.f4525a.clear();
        this.f4536l = false;
        this.f4526b.clear();
        this.f4537m = false;
    }

    <Data> t<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f4527c.f().a(cls, this.f4531g, this.f4535k);
    }

    <Z> com.bumptech.glide.load.m<Z> a(v<Z> vVar) {
        return this.f4527c.f().a((v) vVar);
    }

    List<com.bumptech.glide.load.q.n<File, ?>> a(File file) throws i.c {
        return this.f4527c.f().a((com.bumptech.glide.i) file);
    }

    boolean a(com.bumptech.glide.load.g gVar) {
        List<n.a<?>> listG = g();
        int size = listG.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listG.get(i2).f4747a.equals(gVar)) {
                return true;
            }
        }
        return false;
    }

    <X> com.bumptech.glide.load.d<X> a(X x) throws i.e {
        return this.f4527c.f().c(x);
    }
}

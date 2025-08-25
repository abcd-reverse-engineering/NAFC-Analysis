package com.google.gson;

import com.google.gson.b0.q.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: GsonBuilder.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private com.google.gson.b0.d f5735a;

    /* renamed from: b, reason: collision with root package name */
    private u f5736b;

    /* renamed from: c, reason: collision with root package name */
    private d f5737c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Type, g<?>> f5738d;

    /* renamed from: e, reason: collision with root package name */
    private final List<z> f5739e;

    /* renamed from: f, reason: collision with root package name */
    private final List<z> f5740f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5741g;

    /* renamed from: h, reason: collision with root package name */
    private String f5742h;

    /* renamed from: i, reason: collision with root package name */
    private int f5743i;

    /* renamed from: j, reason: collision with root package name */
    private int f5744j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5745k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5746l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5747m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private x r;
    private x s;
    private final LinkedList<v> t;

    public f() {
        this.f5735a = com.google.gson.b0.d.f5505h;
        this.f5736b = u.DEFAULT;
        this.f5737c = c.IDENTITY;
        this.f5738d = new HashMap();
        this.f5739e = new ArrayList();
        this.f5740f = new ArrayList();
        this.f5741g = false;
        this.f5742h = e.H;
        this.f5743i = 2;
        this.f5744j = 2;
        this.f5745k = false;
        this.f5746l = false;
        this.f5747m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = e.J;
        this.s = e.K;
        this.t = new LinkedList<>();
    }

    public f a(double d2) {
        if (!Double.isNaN(d2) && d2 >= 0.0d) {
            this.f5735a = this.f5735a.a(d2);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d2);
    }

    public f b(x xVar) {
        this.r = (x) Objects.requireNonNull(xVar);
        return this;
    }

    public f c() {
        this.f5735a = this.f5735a.a();
        return this;
    }

    public f d() {
        this.q = false;
        return this;
    }

    public f e() {
        this.f5745k = true;
        return this;
    }

    public f f() {
        this.f5735a = this.f5735a.b();
        return this;
    }

    public f g() {
        this.o = true;
        return this;
    }

    public f h() {
        this.f5741g = true;
        return this;
    }

    public f i() {
        this.f5746l = true;
        return this;
    }

    public f j() {
        this.p = true;
        return this;
    }

    public f k() {
        this.n = true;
        return this;
    }

    public f b(a aVar) {
        Objects.requireNonNull(aVar);
        this.f5735a = this.f5735a.a(aVar, true, false);
        return this;
    }

    public f a(int... iArr) {
        Objects.requireNonNull(iArr);
        this.f5735a = this.f5735a.a(iArr);
        return this;
    }

    public f b() {
        this.f5747m = false;
        return this;
    }

    public f a(u uVar) {
        this.f5736b = (u) Objects.requireNonNull(uVar);
        return this;
    }

    public f a(c cVar) {
        return a((d) cVar);
    }

    public f a(d dVar) {
        this.f5737c = (d) Objects.requireNonNull(dVar);
        return this;
    }

    public f a(x xVar) {
        this.s = (x) Objects.requireNonNull(xVar);
        return this;
    }

    public f a(a... aVarArr) {
        Objects.requireNonNull(aVarArr);
        for (a aVar : aVarArr) {
            this.f5735a = this.f5735a.a(aVar, true, true);
        }
        return this;
    }

    public f a(a aVar) {
        Objects.requireNonNull(aVar);
        this.f5735a = this.f5735a.a(aVar, false, true);
        return this;
    }

    public f a(String str) {
        this.f5742h = str;
        return this;
    }

    public f a(int i2) {
        this.f5743i = i2;
        this.f5742h = null;
        return this;
    }

    public f a(int i2, int i3) {
        this.f5743i = i2;
        this.f5744j = i3;
        this.f5742h = null;
        return this;
    }

    public f a(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z = obj instanceof r;
        com.google.gson.b0.a.a(z || (obj instanceof j) || (obj instanceof g) || (obj instanceof y));
        if (obj instanceof g) {
            this.f5738d.put(type, (g) obj);
        }
        if (z || (obj instanceof j)) {
            this.f5739e.add(com.google.gson.b0.q.m.b(com.google.gson.d0.a.get(type), obj));
        }
        if (obj instanceof y) {
            this.f5739e.add(com.google.gson.b0.q.o.a(com.google.gson.d0.a.get(type), (y) obj));
        }
        return this;
    }

    f(e eVar) {
        this.f5735a = com.google.gson.b0.d.f5505h;
        this.f5736b = u.DEFAULT;
        this.f5737c = c.IDENTITY;
        this.f5738d = new HashMap();
        this.f5739e = new ArrayList();
        this.f5740f = new ArrayList();
        this.f5741g = false;
        this.f5742h = e.H;
        this.f5743i = 2;
        this.f5744j = 2;
        this.f5745k = false;
        this.f5746l = false;
        this.f5747m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = e.J;
        this.s = e.K;
        this.t = new LinkedList<>();
        this.f5735a = eVar.f5688f;
        this.f5737c = eVar.f5689g;
        this.f5738d.putAll(eVar.f5690h);
        this.f5741g = eVar.f5691i;
        this.f5745k = eVar.f5692j;
        this.o = eVar.f5693k;
        this.f5747m = eVar.f5694l;
        this.n = eVar.f5695m;
        this.p = eVar.n;
        this.f5746l = eVar.o;
        this.f5736b = eVar.t;
        this.f5742h = eVar.q;
        this.f5743i = eVar.r;
        this.f5744j = eVar.s;
        this.f5739e.addAll(eVar.u);
        this.f5740f.addAll(eVar.v);
        this.q = eVar.p;
        this.r = eVar.w;
        this.s = eVar.x;
        this.t.addAll(eVar.y);
    }

    public f a(z zVar) {
        Objects.requireNonNull(zVar);
        this.f5739e.add(zVar);
        return this;
    }

    public f a(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        boolean z = obj instanceof r;
        com.google.gson.b0.a.a(z || (obj instanceof j) || (obj instanceof y));
        if ((obj instanceof j) || z) {
            this.f5740f.add(com.google.gson.b0.q.m.a(cls, obj));
        }
        if (obj instanceof y) {
            this.f5739e.add(com.google.gson.b0.q.o.b(cls, (y) obj));
        }
        return this;
    }

    public f a(v vVar) {
        Objects.requireNonNull(vVar);
        this.t.addFirst(vVar);
        return this;
    }

    public e a() {
        List<z> arrayList = new ArrayList<>(this.f5739e.size() + this.f5740f.size() + 3);
        arrayList.addAll(this.f5739e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f5740f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f5742h, this.f5743i, this.f5744j, arrayList);
        return new e(this.f5735a, this.f5737c, new HashMap(this.f5738d), this.f5741g, this.f5745k, this.o, this.f5747m, this.n, this.p, this.f5746l, this.q, this.f5736b, this.f5742h, this.f5743i, this.f5744j, new ArrayList(this.f5739e), new ArrayList(this.f5740f), arrayList, this.r, this.s, new ArrayList(this.t));
    }

    private void a(String str, int i2, int i3, List<z> list) {
        z zVarA;
        z zVarA2;
        boolean z = com.google.gson.b0.t.d.f5676a;
        z zVarA3 = null;
        if (str != null && !str.trim().isEmpty()) {
            z zVarA4 = d.b.f5563b.a(str);
            if (z) {
                zVarA3 = com.google.gson.b0.t.d.f5678c.a(str);
                zVarA2 = com.google.gson.b0.t.d.f5677b.a(str);
                zVarA = zVarA4;
            } else {
                zVarA = zVarA4;
                zVarA2 = null;
            }
        } else {
            if (i2 == 2 || i3 == 2) {
                return;
            }
            zVarA = d.b.f5563b.a(i2, i3);
            if (z) {
                zVarA3 = com.google.gson.b0.t.d.f5678c.a(i2, i3);
                zVarA2 = com.google.gson.b0.t.d.f5677b.a(i2, i3);
            } else {
                zVarA2 = null;
            }
        }
        list.add(zVarA);
        if (z) {
            list.add(zVarA3);
            list.add(zVarA2);
        }
    }
}

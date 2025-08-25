package com.google.gson.b0;

import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class d implements z, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    private static final double f5504g = -1.0d;

    /* renamed from: h, reason: collision with root package name */
    public static final d f5505h = new d();

    /* renamed from: d, reason: collision with root package name */
    private boolean f5509d;

    /* renamed from: a, reason: collision with root package name */
    private double f5506a = f5504g;

    /* renamed from: b, reason: collision with root package name */
    private int f5507b = 136;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5508c = true;

    /* renamed from: e, reason: collision with root package name */
    private List<com.google.gson.a> f5510e = Collections.emptyList();

    /* renamed from: f, reason: collision with root package name */
    private List<com.google.gson.a> f5511f = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    class a<T> extends y<T> {

        /* renamed from: a, reason: collision with root package name */
        private y<T> f5512a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5513b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5514c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f5515d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d0.a f5516e;

        a(boolean z, boolean z2, com.google.gson.e eVar, com.google.gson.d0.a aVar) {
            this.f5513b = z;
            this.f5514c = z2;
            this.f5515d = eVar;
            this.f5516e = aVar;
        }

        private y<T> a() {
            y<T> yVar = this.f5512a;
            if (yVar != null) {
                return yVar;
            }
            y<T> yVarA = this.f5515d.a(d.this, this.f5516e);
            this.f5512a = yVarA;
            return yVarA;
        }

        @Override // com.google.gson.y
        /* renamed from: read */
        public T read2(com.google.gson.e0.a aVar) throws IOException {
            if (!this.f5513b) {
                return a().read2(aVar);
            }
            aVar.t();
            return null;
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            if (this.f5514c) {
                dVar.j();
            } else {
                a().write(dVar, t);
            }
        }
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public d a(double d2) {
        d dVarM38clone = m38clone();
        dVarM38clone.f5506a = d2;
        return dVarM38clone;
    }

    public d b() {
        d dVarM38clone = m38clone();
        dVarM38clone.f5509d = true;
        return dVarM38clone;
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zA = a(rawType);
        boolean z = zA || b(rawType, true);
        boolean z2 = zA || b(rawType, false);
        if (z || z2) {
            return new a(z2, z, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public d m38clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean b(Class<?> cls, boolean z) {
        Iterator<com.google.gson.a> it = (z ? this.f5510e : this.f5511f).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    public d a(int... iArr) {
        d dVarM38clone = m38clone();
        dVarM38clone.f5507b = 0;
        for (int i2 : iArr) {
            dVarM38clone.f5507b = i2 | dVarM38clone.f5507b;
        }
        return dVarM38clone;
    }

    private boolean b(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || d(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    public d a() {
        d dVarM38clone = m38clone();
        dVarM38clone.f5508c = false;
        return dVarM38clone;
    }

    public d a(com.google.gson.a aVar, boolean z, boolean z2) {
        d dVarM38clone = m38clone();
        if (z) {
            dVarM38clone.f5510e = new ArrayList(this.f5510e);
            dVarM38clone.f5510e.add(aVar);
        }
        if (z2) {
            dVarM38clone.f5511f = new ArrayList(this.f5511f);
            dVarM38clone.f5511f.add(aVar);
        }
        return dVarM38clone;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a0.a aVar;
        if ((this.f5507b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f5506a != f5504g && !a((com.google.gson.a0.d) field.getAnnotation(com.google.gson.a0.d.class), (com.google.gson.a0.e) field.getAnnotation(com.google.gson.a0.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f5509d && ((aVar = (com.google.gson.a0.a) field.getAnnotation(com.google.gson.a0.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f5508c && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.google.gson.a> list = z ? this.f5510e : this.f5511f;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.b bVar = new com.google.gson.b(field);
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.f5506a != f5504g && !a((com.google.gson.a0.d) cls.getAnnotation(com.google.gson.a0.d.class), (com.google.gson.a0.e) cls.getAnnotation(com.google.gson.a0.e.class))) {
            return true;
        }
        if (this.f5508c || !c(cls)) {
            return b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean a(com.google.gson.a0.d dVar, com.google.gson.a0.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a0.d dVar) {
        if (dVar != null) {
            return this.f5506a >= dVar.value();
        }
        return true;
    }

    private boolean a(com.google.gson.a0.e eVar) {
        if (eVar != null) {
            return this.f5506a < eVar.value();
        }
        return true;
    }
}

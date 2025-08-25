package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.g;
import org.greenrobot.eventbus.h;

/* compiled from: EventBusBuilder.java */
/* loaded from: classes2.dex */
public class d {
    private static final ExecutorService n = Executors.newCachedThreadPool();

    /* renamed from: e, reason: collision with root package name */
    boolean f17393e;

    /* renamed from: g, reason: collision with root package name */
    boolean f17395g;

    /* renamed from: h, reason: collision with root package name */
    boolean f17396h;

    /* renamed from: j, reason: collision with root package name */
    List<Class<?>> f17398j;

    /* renamed from: k, reason: collision with root package name */
    List<org.greenrobot.eventbus.r.d> f17399k;

    /* renamed from: l, reason: collision with root package name */
    g f17400l;

    /* renamed from: m, reason: collision with root package name */
    h f17401m;

    /* renamed from: a, reason: collision with root package name */
    boolean f17389a = true;

    /* renamed from: b, reason: collision with root package name */
    boolean f17390b = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f17391c = true;

    /* renamed from: d, reason: collision with root package name */
    boolean f17392d = true;

    /* renamed from: f, reason: collision with root package name */
    boolean f17394f = true;

    /* renamed from: i, reason: collision with root package name */
    ExecutorService f17397i = n;

    d() {
    }

    public d a(boolean z) {
        this.f17394f = z;
        return this;
    }

    public d b(boolean z) {
        this.f17395g = z;
        return this;
    }

    public d c(boolean z) {
        this.f17390b = z;
        return this;
    }

    public d d(boolean z) {
        this.f17389a = z;
        return this;
    }

    public d e(boolean z) {
        this.f17392d = z;
        return this;
    }

    public d f(boolean z) {
        this.f17391c = z;
        return this;
    }

    public d g(boolean z) {
        this.f17396h = z;
        return this;
    }

    public d h(boolean z) {
        this.f17393e = z;
        return this;
    }

    public d a(ExecutorService executorService) {
        this.f17397i = executorService;
        return this;
    }

    Object b() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    g c() {
        g gVar = this.f17400l;
        return gVar != null ? gVar : (!g.a.a() || b() == null) ? new g.c() : new g.a("EventBus");
    }

    h d() {
        Object objB;
        h hVar = this.f17401m;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.a() || (objB = b()) == null) {
            return null;
        }
        return new h.a((Looper) objB);
    }

    public c e() {
        c cVar;
        synchronized (c.class) {
            if (c.t != null) {
                throw new e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            c.t = a();
            cVar = c.t;
        }
        return cVar;
    }

    public d a(Class<?> cls) {
        if (this.f17398j == null) {
            this.f17398j = new ArrayList();
        }
        this.f17398j.add(cls);
        return this;
    }

    public d a(org.greenrobot.eventbus.r.d dVar) {
        if (this.f17399k == null) {
            this.f17399k = new ArrayList();
        }
        this.f17399k.add(dVar);
        return this;
    }

    public d a(g gVar) {
        this.f17400l = gVar;
        return this;
    }

    public c a() {
        return new c(this);
    }
}

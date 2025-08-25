package com.bumptech.glide.r;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.e;

/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class b implements e, d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5225a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final e f5226b;

    /* renamed from: c, reason: collision with root package name */
    private volatile d f5227c;

    /* renamed from: d, reason: collision with root package name */
    private volatile d f5228d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f5229e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f5230f;

    public b(Object obj, @Nullable e eVar) {
        e.a aVar = e.a.CLEARED;
        this.f5229e = aVar;
        this.f5230f = aVar;
        this.f5225a = obj;
        this.f5226b = eVar;
    }

    @GuardedBy("requestLock")
    private boolean e() {
        e eVar = this.f5226b;
        return eVar == null || eVar.f(this);
    }

    @GuardedBy("requestLock")
    private boolean g() {
        e eVar = this.f5226b;
        return eVar == null || eVar.d(this);
    }

    public void a(d dVar, d dVar2) {
        this.f5227c = dVar;
        this.f5228d = dVar2;
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        boolean z;
        synchronized (this.f5225a) {
            z = this.f5229e == e.a.CLEARED && this.f5230f == e.a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void c() {
        synchronized (this.f5225a) {
            if (this.f5229e != e.a.RUNNING) {
                this.f5229e = e.a.RUNNING;
                this.f5227c.c();
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        synchronized (this.f5225a) {
            this.f5229e = e.a.CLEARED;
            this.f5227c.clear();
            if (this.f5230f != e.a.CLEARED) {
                this.f5230f = e.a.CLEARED;
                this.f5228d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean d() {
        boolean z;
        synchronized (this.f5225a) {
            z = this.f5229e == e.a.SUCCESS || this.f5230f == e.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public boolean f(d dVar) {
        boolean z;
        synchronized (this.f5225a) {
            z = e() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public e getRoot() {
        e root;
        synchronized (this.f5225a) {
            root = this.f5226b != null ? this.f5226b.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f5225a) {
            z = this.f5229e == e.a.RUNNING || this.f5230f == e.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void pause() {
        synchronized (this.f5225a) {
            if (this.f5229e == e.a.RUNNING) {
                this.f5229e = e.a.PAUSED;
                this.f5227c.pause();
            }
            if (this.f5230f == e.a.RUNNING) {
                this.f5230f = e.a.PAUSED;
                this.f5228d.pause();
            }
        }
    }

    @GuardedBy("requestLock")
    private boolean g(d dVar) {
        return dVar.equals(this.f5227c) || (this.f5229e == e.a.FAILED && dVar.equals(this.f5228d));
    }

    @Override // com.bumptech.glide.r.e
    public void e(d dVar) {
        synchronized (this.f5225a) {
            if (dVar.equals(this.f5227c)) {
                this.f5229e = e.a.SUCCESS;
            } else if (dVar.equals(this.f5228d)) {
                this.f5230f = e.a.SUCCESS;
            }
            if (this.f5226b != null) {
                this.f5226b.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean a(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        return this.f5227c.a(bVar.f5227c) && this.f5228d.a(bVar.f5228d);
    }

    @GuardedBy("requestLock")
    private boolean f() {
        e eVar = this.f5226b;
        return eVar == null || eVar.c(this);
    }

    @Override // com.bumptech.glide.r.e
    public void b(d dVar) {
        synchronized (this.f5225a) {
            if (!dVar.equals(this.f5228d)) {
                this.f5229e = e.a.FAILED;
                if (this.f5230f != e.a.RUNNING) {
                    this.f5230f = e.a.RUNNING;
                    this.f5228d.c();
                }
                return;
            }
            this.f5230f = e.a.FAILED;
            if (this.f5226b != null) {
                this.f5226b.b(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean d(d dVar) {
        boolean z;
        synchronized (this.f5225a) {
            z = g() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e, com.bumptech.glide.r.d
    public boolean a() {
        boolean z;
        synchronized (this.f5225a) {
            z = this.f5227c.a() || this.f5228d.a();
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.f5225a) {
            z = f() && g(dVar);
        }
        return z;
    }
}

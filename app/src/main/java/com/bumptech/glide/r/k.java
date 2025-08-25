package com.bumptech.glide.r;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.e;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class k implements e, d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final e f5257a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f5258b;

    /* renamed from: c, reason: collision with root package name */
    private volatile d f5259c;

    /* renamed from: d, reason: collision with root package name */
    private volatile d f5260d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f5261e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f5262f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f5263g;

    public k(Object obj, @Nullable e eVar) {
        e.a aVar = e.a.CLEARED;
        this.f5261e = aVar;
        this.f5262f = aVar;
        this.f5258b = obj;
        this.f5257a = eVar;
    }

    @GuardedBy("requestLock")
    private boolean e() {
        e eVar = this.f5257a;
        return eVar == null || eVar.f(this);
    }

    @GuardedBy("requestLock")
    private boolean g() {
        e eVar = this.f5257a;
        return eVar == null || eVar.d(this);
    }

    public void a(d dVar, d dVar2) {
        this.f5259c = dVar;
        this.f5260d = dVar2;
    }

    @Override // com.bumptech.glide.r.e
    public void b(d dVar) {
        synchronized (this.f5258b) {
            if (!dVar.equals(this.f5259c)) {
                this.f5262f = e.a.FAILED;
                return;
            }
            this.f5261e = e.a.FAILED;
            if (this.f5257a != null) {
                this.f5257a.b(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.f5258b) {
            z = f() && dVar.equals(this.f5259c) && !a();
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        synchronized (this.f5258b) {
            this.f5263g = false;
            this.f5261e = e.a.CLEARED;
            this.f5262f = e.a.CLEARED;
            this.f5260d.clear();
            this.f5259c.clear();
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean d(d dVar) {
        boolean z;
        synchronized (this.f5258b) {
            z = g() && (dVar.equals(this.f5259c) || this.f5261e != e.a.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public boolean f(d dVar) {
        boolean z;
        synchronized (this.f5258b) {
            z = e() && dVar.equals(this.f5259c) && this.f5261e != e.a.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public e getRoot() {
        e root;
        synchronized (this.f5258b) {
            root = this.f5257a != null ? this.f5257a.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f5258b) {
            z = this.f5261e == e.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void pause() {
        synchronized (this.f5258b) {
            if (!this.f5262f.isComplete()) {
                this.f5262f = e.a.PAUSED;
                this.f5260d.pause();
            }
            if (!this.f5261e.isComplete()) {
                this.f5261e = e.a.PAUSED;
                this.f5259c.pause();
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void e(d dVar) {
        synchronized (this.f5258b) {
            if (dVar.equals(this.f5260d)) {
                this.f5262f = e.a.SUCCESS;
                return;
            }
            this.f5261e = e.a.SUCCESS;
            if (this.f5257a != null) {
                this.f5257a.e(this);
            }
            if (!this.f5262f.isComplete()) {
                this.f5260d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.r.e, com.bumptech.glide.r.d
    public boolean a() {
        boolean z;
        synchronized (this.f5258b) {
            z = this.f5260d.a() || this.f5259c.a();
        }
        return z;
    }

    @GuardedBy("requestLock")
    private boolean f() {
        e eVar = this.f5257a;
        return eVar == null || eVar.c(this);
    }

    @Override // com.bumptech.glide.r.d
    public void c() {
        synchronized (this.f5258b) {
            this.f5263g = true;
            try {
                if (this.f5261e != e.a.SUCCESS && this.f5262f != e.a.RUNNING) {
                    this.f5262f = e.a.RUNNING;
                    this.f5260d.c();
                }
                if (this.f5263g && this.f5261e != e.a.RUNNING) {
                    this.f5261e = e.a.RUNNING;
                    this.f5259c.c();
                }
            } finally {
                this.f5263g = false;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean d() {
        boolean z;
        synchronized (this.f5258b) {
            z = this.f5261e == e.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public boolean a(d dVar) {
        if (!(dVar instanceof k)) {
            return false;
        }
        k kVar = (k) dVar;
        if (this.f5259c == null) {
            if (kVar.f5259c != null) {
                return false;
            }
        } else if (!this.f5259c.a(kVar.f5259c)) {
            return false;
        }
        if (this.f5260d == null) {
            if (kVar.f5260d != null) {
                return false;
            }
        } else if (!this.f5260d.a(kVar.f5260d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        boolean z;
        synchronized (this.f5258b) {
            z = this.f5261e == e.a.CLEARED;
        }
        return z;
    }
}

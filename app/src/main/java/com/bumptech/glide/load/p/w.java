package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
class w implements f, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final f.a f4655a;

    /* renamed from: b, reason: collision with root package name */
    private final g<?> f4656b;

    /* renamed from: c, reason: collision with root package name */
    private int f4657c;

    /* renamed from: d, reason: collision with root package name */
    private int f4658d = -1;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.g f4659e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.q.n<File, ?>> f4660f;

    /* renamed from: g, reason: collision with root package name */
    private int f4661g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f4662h;

    /* renamed from: i, reason: collision with root package name */
    private File f4663i;

    /* renamed from: j, reason: collision with root package name */
    private x f4664j;

    w(g<?> gVar, f.a aVar) {
        this.f4656b = gVar;
        this.f4655a = aVar;
    }

    private boolean b() {
        return this.f4661g < this.f4660f.size();
    }

    @Override // com.bumptech.glide.load.p.f
    public boolean a() {
        List<com.bumptech.glide.load.g> listC = this.f4656b.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listK = this.f4656b.k();
        if (listK.isEmpty()) {
            if (File.class.equals(this.f4656b.m())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f4656b.h() + " to " + this.f4656b.m());
        }
        while (true) {
            if (this.f4660f != null && b()) {
                this.f4662h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.q.n<File, ?>> list = this.f4660f;
                    int i2 = this.f4661g;
                    this.f4661g = i2 + 1;
                    this.f4662h = list.get(i2).a(this.f4663i, this.f4656b.n(), this.f4656b.f(), this.f4656b.i());
                    if (this.f4662h != null && this.f4656b.c(this.f4662h.f4749c.a())) {
                        this.f4662h.f4749c.a(this.f4656b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f4658d++;
            if (this.f4658d >= listK.size()) {
                this.f4657c++;
                if (this.f4657c >= listC.size()) {
                    return false;
                }
                this.f4658d = 0;
            }
            com.bumptech.glide.load.g gVar = listC.get(this.f4657c);
            Class<?> cls = listK.get(this.f4658d);
            this.f4664j = new x(this.f4656b.b(), gVar, this.f4656b.l(), this.f4656b.n(), this.f4656b.f(), this.f4656b.b(cls), cls, this.f4656b.i());
            this.f4663i = this.f4656b.d().a(this.f4664j);
            File file = this.f4663i;
            if (file != null) {
                this.f4659e = gVar;
                this.f4660f = this.f4656b.a(file);
                this.f4661g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f
    public void cancel() {
        n.a<?> aVar = this.f4662h;
        if (aVar != null) {
            aVar.f4749c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(Object obj) {
        this.f4655a.a(this.f4659e, obj, this.f4662h.f4749c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE, this.f4664j);
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(@NonNull Exception exc) {
        this.f4655a.a(this.f4664j, exc, this.f4662h.f4749c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE);
    }
}

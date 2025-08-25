package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
class c implements f, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.g> f4449a;

    /* renamed from: b, reason: collision with root package name */
    private final g<?> f4450b;

    /* renamed from: c, reason: collision with root package name */
    private final f.a f4451c;

    /* renamed from: d, reason: collision with root package name */
    private int f4452d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.g f4453e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.q.n<File, ?>> f4454f;

    /* renamed from: g, reason: collision with root package name */
    private int f4455g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f4456h;

    /* renamed from: i, reason: collision with root package name */
    private File f4457i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean b() {
        return this.f4455g < this.f4454f.size();
    }

    @Override // com.bumptech.glide.load.p.f
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f4454f != null && b()) {
                this.f4456h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.q.n<File, ?>> list = this.f4454f;
                    int i2 = this.f4455g;
                    this.f4455g = i2 + 1;
                    this.f4456h = list.get(i2).a(this.f4457i, this.f4450b.n(), this.f4450b.f(), this.f4450b.i());
                    if (this.f4456h != null && this.f4450b.c(this.f4456h.f4749c.a())) {
                        this.f4456h.f4749c.a(this.f4450b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f4452d++;
            if (this.f4452d >= this.f4449a.size()) {
                return false;
            }
            com.bumptech.glide.load.g gVar = this.f4449a.get(this.f4452d);
            this.f4457i = this.f4450b.d().a(new d(gVar, this.f4450b.l()));
            File file = this.f4457i;
            if (file != null) {
                this.f4453e = gVar;
                this.f4454f = this.f4450b.a(file);
                this.f4455g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f
    public void cancel() {
        n.a<?> aVar = this.f4456h;
        if (aVar != null) {
            aVar.f4749c.cancel();
        }
    }

    c(List<com.bumptech.glide.load.g> list, g<?> gVar, f.a aVar) {
        this.f4452d = -1;
        this.f4449a = list;
        this.f4450b = gVar;
        this.f4451c = aVar;
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(Object obj) {
        this.f4451c.a(this.f4453e, obj, this.f4456h.f4749c, com.bumptech.glide.load.a.DATA_DISK_CACHE, this.f4453e);
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(@NonNull Exception exc) {
        this.f4451c.a(this.f4453e, exc, this.f4456h.f4749c, com.bumptech.glide.load.a.DATA_DISK_CACHE);
    }
}

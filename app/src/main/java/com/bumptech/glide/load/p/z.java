package com.bumptech.glide.load.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.q.n;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
class z implements f, f.a {

    /* renamed from: h, reason: collision with root package name */
    private static final String f4677h = "SourceGenerator";

    /* renamed from: a, reason: collision with root package name */
    private final g<?> f4678a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a f4679b;

    /* renamed from: c, reason: collision with root package name */
    private int f4680c;

    /* renamed from: d, reason: collision with root package name */
    private c f4681d;

    /* renamed from: e, reason: collision with root package name */
    private Object f4682e;

    /* renamed from: f, reason: collision with root package name */
    private volatile n.a<?> f4683f;

    /* renamed from: g, reason: collision with root package name */
    private d f4684g;

    z(g<?> gVar, f.a aVar) {
        this.f4678a = gVar;
        this.f4679b = aVar;
    }

    private void b(n.a<?> aVar) {
        this.f4683f.f4749c.a(this.f4678a.j(), new a(aVar));
    }

    private boolean c() {
        return this.f4680c < this.f4678a.g().size();
    }

    @Override // com.bumptech.glide.load.p.f
    public boolean a() {
        Object obj = this.f4682e;
        if (obj != null) {
            this.f4682e = null;
            a(obj);
        }
        c cVar = this.f4681d;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f4681d = null;
        this.f4683f = null;
        boolean z = false;
        while (!z && c()) {
            List<n.a<?>> listG = this.f4678a.g();
            int i2 = this.f4680c;
            this.f4680c = i2 + 1;
            this.f4683f = listG.get(i2);
            if (this.f4683f != null && (this.f4678a.e().a(this.f4683f.f4749c.c()) || this.f4678a.c(this.f4683f.f4749c.a()))) {
                b(this.f4683f);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.p.f
    public void cancel() {
        n.a<?> aVar = this.f4683f;
        if (aVar != null) {
            aVar.f4749c.cancel();
        }
    }

    /* compiled from: SourceGenerator.java */
    class a implements d.a<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a f4685a;

        a(n.a aVar) {
            this.f4685a = aVar;
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@Nullable Object obj) {
            if (z.this.a(this.f4685a)) {
                z.this.a(this.f4685a, obj);
            }
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@NonNull Exception exc) {
            if (z.this.a(this.f4685a)) {
                z.this.a(this.f4685a, exc);
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void b() {
        throw new UnsupportedOperationException();
    }

    boolean a(n.a<?> aVar) {
        n.a<?> aVar2 = this.f4683f;
        return aVar2 != null && aVar2 == aVar;
    }

    private void a(Object obj) {
        long jA = com.bumptech.glide.util.f.a();
        try {
            com.bumptech.glide.load.d<X> dVarA = this.f4678a.a((g<?>) obj);
            e eVar = new e(dVarA, obj, this.f4678a.i());
            this.f4684g = new d(this.f4683f.f4747a, this.f4678a.l());
            this.f4678a.d().a(this.f4684g, eVar);
            if (Log.isLoggable(f4677h, 2)) {
                String str = "Finished encoding source to cache, key: " + this.f4684g + ", data: " + obj + ", encoder: " + dVarA + ", duration: " + com.bumptech.glide.util.f.a(jA);
            }
            this.f4683f.f4749c.b();
            this.f4681d = new c(Collections.singletonList(this.f4683f.f4747a), this.f4678a, this);
        } catch (Throwable th) {
            this.f4683f.f4749c.b();
            throw th;
        }
    }

    void a(n.a<?> aVar, Object obj) {
        j jVarE = this.f4678a.e();
        if (obj != null && jVarE.a(aVar.f4749c.c())) {
            this.f4682e = obj;
            this.f4679b.b();
        } else {
            f.a aVar2 = this.f4679b;
            com.bumptech.glide.load.g gVar = aVar.f4747a;
            com.bumptech.glide.load.o.d<?> dVar = aVar.f4749c;
            aVar2.a(gVar, obj, dVar, dVar.c(), this.f4684g);
        }
    }

    void a(n.a<?> aVar, @NonNull Exception exc) {
        f.a aVar2 = this.f4679b;
        d dVar = this.f4684g;
        com.bumptech.glide.load.o.d<?> dVar2 = aVar.f4749c;
        aVar2.a(dVar, exc, dVar2, dVar2.c());
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        this.f4679b.a(gVar, obj, dVar, this.f4683f.f4749c.c(), gVar);
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.f4679b.a(gVar, exc, dVar, this.f4683f.f4749c.c());
    }
}

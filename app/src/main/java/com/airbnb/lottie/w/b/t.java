package com.airbnb.lottie.w.b;

import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class t implements c, a.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3737a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3738b;

    /* renamed from: c, reason: collision with root package name */
    private final List<a.b> f3739c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final q.a f3740d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3741e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3742f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3743g;

    public t(com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.q qVar) {
        this.f3737a = qVar.b();
        this.f3738b = qVar.f();
        this.f3740d = qVar.e();
        this.f3741e = qVar.d().a();
        this.f3742f = qVar.a().a();
        this.f3743g = qVar.c().a();
        aVar.a(this.f3741e);
        aVar.a(this.f3742f);
        aVar.a(this.f3743g);
        this.f3741e.a(this);
        this.f3742f.a(this);
        this.f3743g.a(this);
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        for (int i2 = 0; i2 < this.f3739c.size(); i2++) {
            this.f3739c.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
    }

    public com.airbnb.lottie.w.c.a<?, Float> b() {
        return this.f3742f;
    }

    public com.airbnb.lottie.w.c.a<?, Float> c() {
        return this.f3743g;
    }

    public com.airbnb.lottie.w.c.a<?, Float> d() {
        return this.f3741e;
    }

    q.a e() {
        return this.f3740d;
    }

    public boolean f() {
        return this.f3738b;
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3737a;
    }

    void a(a.b bVar) {
        this.f3739c.add(bVar);
    }
}

package com.airbnb.lottie.w.b;

import android.graphics.Path;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class r implements n, a.b {

    /* renamed from: b, reason: collision with root package name */
    private final String f3731b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3732c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.j f3733d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Path> f3734e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3735f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3730a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private b f3736g = new b();

    public r(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.o oVar) {
        this.f3731b = oVar.a();
        this.f3732c = oVar.c();
        this.f3733d = jVar;
        this.f3734e = oVar.b().a();
        aVar.a(this.f3734e);
        this.f3734e.a(this);
    }

    private void b() {
        this.f3735f = false;
        this.f3733d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3731b;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.f3735f) {
            return this.f3730a;
        }
        this.f3730a.reset();
        if (this.f3732c) {
            this.f3735f = true;
            return this.f3730a;
        }
        this.f3730a.set(this.f3734e.f());
        this.f3730a.setFillType(Path.FillType.EVEN_ODD);
        this.f3736g.a(this.f3730a);
        this.f3735f = true;
        return this.f3730a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f3736g.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }
}

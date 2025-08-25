package com.airbnb.lottie.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public class f implements n, a.b, k {

    /* renamed from: i, reason: collision with root package name */
    private static final float f3657i = 0.55228f;

    /* renamed from: b, reason: collision with root package name */
    private final String f3659b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.j f3660c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f3661d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f3662e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.a f3663f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3665h;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3658a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private b f3664g = new b();

    public f(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.a aVar2) {
        this.f3659b = aVar2.a();
        this.f3660c = jVar;
        this.f3661d = aVar2.c().a();
        this.f3662e = aVar2.b().a();
        this.f3663f = aVar2;
        aVar.a(this.f3661d);
        aVar.a(this.f3662e);
        this.f3661d.a(this);
        this.f3662e.a(this);
    }

    private void b() {
        this.f3665h = false;
        this.f3660c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3659b;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.f3665h) {
            return this.f3658a;
        }
        this.f3658a.reset();
        if (this.f3663f.d()) {
            this.f3665h = true;
            return this.f3658a;
        }
        PointF pointFF = this.f3661d.f();
        float f2 = pointFF.x / 2.0f;
        float f3 = pointFF.y / 2.0f;
        float f4 = f2 * f3657i;
        float f5 = f3657i * f3;
        this.f3658a.reset();
        if (this.f3663f.e()) {
            float f6 = -f3;
            this.f3658a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f3658a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.f3658a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.f3658a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.f3658a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.f3658a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.f3658a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.f3658a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.f3658a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.f3658a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF pointFF2 = this.f3662e.f();
        this.f3658a.offset(pointFF2.x, pointFF2.y);
        this.f3658a.close();
        this.f3664g.a(this.f3658a);
        this.f3665h = true;
        return this.f3658a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f3664g.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f3606i) {
            this.f3661d.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        } else if (t == com.airbnb.lottie.o.f3609l) {
            this.f3662e.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        }
    }
}

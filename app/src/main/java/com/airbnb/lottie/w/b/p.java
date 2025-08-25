package com.airbnb.lottie.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class p implements a.b, k, n {

    /* renamed from: c, reason: collision with root package name */
    private final String f3712c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3713d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.j f3714e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f3715f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f3716g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3717h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3719j;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3710a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f3711b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private b f3718i = new b();

    public p(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.j jVar2) {
        this.f3712c = jVar2.b();
        this.f3713d = jVar2.e();
        this.f3714e = jVar;
        this.f3715f = jVar2.c().a();
        this.f3716g = jVar2.d().a();
        this.f3717h = jVar2.a().a();
        aVar.a(this.f3715f);
        aVar.a(this.f3716g);
        aVar.a(this.f3717h);
        this.f3715f.a(this);
        this.f3716g.a(this);
        this.f3717h.a(this);
    }

    private void b() {
        this.f3719j = false;
        this.f3714e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3712c;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.f3719j) {
            return this.f3710a;
        }
        this.f3710a.reset();
        if (this.f3713d) {
            this.f3719j = true;
            return this.f3710a;
        }
        PointF pointFF = this.f3716g.f();
        float f2 = pointFF.x / 2.0f;
        float f3 = pointFF.y / 2.0f;
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f3717h;
        float fI = aVar == null ? 0.0f : ((com.airbnb.lottie.w.c.c) aVar).i();
        float fMin = Math.min(f2, f3);
        if (fI > fMin) {
            fI = fMin;
        }
        PointF pointFF2 = this.f3715f.f();
        this.f3710a.moveTo(pointFF2.x + f2, (pointFF2.y - f3) + fI);
        this.f3710a.lineTo(pointFF2.x + f2, (pointFF2.y + f3) - fI);
        if (fI > 0.0f) {
            RectF rectF = this.f3711b;
            float f4 = pointFF2.x;
            float f5 = fI * 2.0f;
            float f6 = pointFF2.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f3710a.arcTo(this.f3711b, 0.0f, 90.0f, false);
        }
        this.f3710a.lineTo((pointFF2.x - f2) + fI, pointFF2.y + f3);
        if (fI > 0.0f) {
            RectF rectF2 = this.f3711b;
            float f7 = pointFF2.x;
            float f8 = pointFF2.y;
            float f9 = fI * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f3710a.arcTo(this.f3711b, 90.0f, 90.0f, false);
        }
        this.f3710a.lineTo(pointFF2.x - f2, (pointFF2.y - f3) + fI);
        if (fI > 0.0f) {
            RectF rectF3 = this.f3711b;
            float f10 = pointFF2.x;
            float f11 = pointFF2.y;
            float f12 = fI * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f3710a.arcTo(this.f3711b, 180.0f, 90.0f, false);
        }
        this.f3710a.lineTo((pointFF2.x + f2) - fI, pointFF2.y - f3);
        if (fI > 0.0f) {
            RectF rectF4 = this.f3711b;
            float f13 = pointFF2.x;
            float f14 = fI * 2.0f;
            float f15 = pointFF2.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f3710a.arcTo(this.f3711b, 270.0f, 90.0f, false);
        }
        this.f3710a.close();
        this.f3718i.a(this.f3710a);
        this.f3719j = true;
        return this.f3710a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f3718i.a(tVar);
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
        if (t == com.airbnb.lottie.o.f3607j) {
            this.f3716g.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        } else if (t == com.airbnb.lottie.o.f3609l) {
            this.f3715f.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        } else if (t == com.airbnb.lottie.o.f3608k) {
            this.f3717h.a((com.airbnb.lottie.c0.j<Float>) jVar);
        }
    }
}

package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g implements e, a.b, k {

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.l.a f3668c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3669d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3670e;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Integer, Integer> f3672g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Integer, Integer> f3673h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> f3674i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.j f3675j;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3666a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Paint f3667b = new com.airbnb.lottie.w.a(1);

    /* renamed from: f, reason: collision with root package name */
    private final List<n> f3671f = new ArrayList();

    public g(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.m mVar) {
        this.f3668c = aVar;
        this.f3669d = mVar.c();
        this.f3670e = mVar.e();
        this.f3675j = jVar;
        if (mVar.a() == null || mVar.d() == null) {
            this.f3672g = null;
            this.f3673h = null;
            return;
        }
        this.f3666a.setFillType(mVar.b());
        this.f3672g = mVar.a().a();
        this.f3672g.a(this);
        aVar.a(this.f3672g);
        this.f3673h = mVar.d().a();
        this.f3673h.a(this);
        aVar.a(this.f3673h);
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f3675j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3669d;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof n) {
                this.f3671f.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f3670e) {
            return;
        }
        com.airbnb.lottie.e.a("FillContent#draw");
        this.f3667b.setColor(((com.airbnb.lottie.w.c.b) this.f3672g).i());
        this.f3667b.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * this.f3673h.f().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.f3674i;
        if (aVar != null) {
            this.f3667b.setColorFilter(aVar.f());
        }
        this.f3666a.reset();
        for (int i3 = 0; i3 < this.f3671f.size(); i3++) {
            this.f3666a.addPath(this.f3671f.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.f3666a, this.f3667b);
        com.airbnb.lottie.e.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f3666a.reset();
        for (int i2 = 0; i2 < this.f3671f.size(); i2++) {
            this.f3666a.addPath(this.f3671f.get(i2).getPath(), matrix);
        }
        this.f3666a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f3598a) {
            this.f3672g.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.f3601d) {
            this.f3673h.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.f3674i;
            if (aVar != null) {
                this.f3668c.b(aVar);
            }
            if (jVar == null) {
                this.f3674i = null;
                return;
            }
            this.f3674i = new com.airbnb.lottie.w.c.p(jVar);
            this.f3674i.a(this);
            this.f3668c.a(this.f3674i);
        }
    }
}

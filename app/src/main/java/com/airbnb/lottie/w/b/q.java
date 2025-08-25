package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class q implements e, n, j, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f3720a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Path f3721b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.j f3722c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.y.l.a f3723d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3724e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3725f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Float, Float> f3726g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Float, Float> f3727h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.o f3728i;

    /* renamed from: j, reason: collision with root package name */
    private d f3729j;

    public q(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.k kVar) {
        this.f3722c = jVar;
        this.f3723d = aVar;
        this.f3724e = kVar.b();
        this.f3725f = kVar.e();
        this.f3726g = kVar.a().a();
        aVar.a(this.f3726g);
        this.f3726g.a(this);
        this.f3727h = kVar.c().a();
        aVar.a(this.f3727h);
        this.f3727h.a(this);
        this.f3728i = kVar.d().a();
        this.f3728i.a(aVar);
        this.f3728i.a(this);
    }

    @Override // com.airbnb.lottie.w.b.j
    public void a(ListIterator<c> listIterator) {
        if (this.f3729j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f3729j = new d(this.f3722c, this.f3723d, "Repeater", this.f3725f, arrayList, null);
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3724e;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        Path path = this.f3729j.getPath();
        this.f3721b.reset();
        float fFloatValue = this.f3726g.f().floatValue();
        float fFloatValue2 = this.f3727h.f().floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f3720a.set(this.f3728i.a(i2 + fFloatValue2));
            this.f3721b.addPath(path, this.f3720a);
        }
        return this.f3721b;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        this.f3729j.a(list, list2);
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = this.f3726g.f().floatValue();
        float fFloatValue2 = this.f3727h.f().floatValue();
        float fFloatValue3 = this.f3728i.d().f().floatValue() / 100.0f;
        float fFloatValue4 = this.f3728i.a().f().floatValue() / 100.0f;
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            this.f3720a.set(matrix);
            float f2 = i3;
            this.f3720a.preConcat(this.f3728i.a(f2 + fFloatValue2));
            this.f3729j.a(canvas, this.f3720a, (int) (i2 * com.airbnb.lottie.b0.g.c(fFloatValue3, fFloatValue4, f2 / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f3729j.a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f3722c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (this.f3728i.a(t, jVar)) {
            return;
        }
        if (t == com.airbnb.lottie.o.s) {
            this.f3726g.a((com.airbnb.lottie.c0.j<Float>) jVar);
        } else if (t == com.airbnb.lottie.o.t) {
            this.f3727h.a((com.airbnb.lottie.c0.j<Float>) jVar);
        }
    }
}

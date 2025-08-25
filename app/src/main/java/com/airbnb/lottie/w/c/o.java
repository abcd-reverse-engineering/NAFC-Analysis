package com.airbnb.lottie.w.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f3775a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f3776b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f3777c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f3778d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f3779e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private a<PointF, PointF> f3780f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private a<?, PointF> f3781g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> f3782h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private a<Float, Float> f3783i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private a<Integer, Integer> f3784j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private c f3785k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private c f3786l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private a<?, Float> f3787m;

    @Nullable
    private a<?, Float> n;

    public o(com.airbnb.lottie.y.j.l lVar) {
        this.f3780f = lVar.b() == null ? null : lVar.b().a();
        this.f3781g = lVar.e() == null ? null : lVar.e().a();
        this.f3782h = lVar.g() == null ? null : lVar.g().a();
        this.f3783i = lVar.f() == null ? null : lVar.f().a();
        this.f3785k = lVar.h() == null ? null : (c) lVar.h().a();
        if (this.f3785k != null) {
            this.f3776b = new Matrix();
            this.f3777c = new Matrix();
            this.f3778d = new Matrix();
            this.f3779e = new float[9];
        } else {
            this.f3776b = null;
            this.f3777c = null;
            this.f3778d = null;
            this.f3779e = null;
        }
        this.f3786l = lVar.i() == null ? null : (c) lVar.i().a();
        if (lVar.d() != null) {
            this.f3784j = lVar.d().a();
        }
        if (lVar.j() != null) {
            this.f3787m = lVar.j().a();
        } else {
            this.f3787m = null;
        }
        if (lVar.c() != null) {
            this.n = lVar.c().a();
        } else {
            this.n = null;
        }
    }

    private void e() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f3779e[i2] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.y.l.a aVar) {
        aVar.a(this.f3784j);
        aVar.a(this.f3787m);
        aVar.a(this.n);
        aVar.a(this.f3780f);
        aVar.a(this.f3781g);
        aVar.a(this.f3782h);
        aVar.a(this.f3783i);
        aVar.a(this.f3785k);
        aVar.a(this.f3786l);
    }

    public void b(float f2) {
        a<Integer, Integer> aVar = this.f3784j;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f3787m;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(f2);
        }
        a<PointF, PointF> aVar4 = this.f3780f;
        if (aVar4 != null) {
            aVar4.a(f2);
        }
        a<?, PointF> aVar5 = this.f3781g;
        if (aVar5 != null) {
            aVar5.a(f2);
        }
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar6 = this.f3782h;
        if (aVar6 != null) {
            aVar6.a(f2);
        }
        a<Float, Float> aVar7 = this.f3783i;
        if (aVar7 != null) {
            aVar7.a(f2);
        }
        c cVar = this.f3785k;
        if (cVar != null) {
            cVar.a(f2);
        }
        c cVar2 = this.f3786l;
        if (cVar2 != null) {
            cVar2.a(f2);
        }
    }

    @Nullable
    public a<?, Integer> c() {
        return this.f3784j;
    }

    @Nullable
    public a<?, Float> d() {
        return this.f3787m;
    }

    public void a(a.b bVar) {
        a<Integer, Integer> aVar = this.f3784j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f3787m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f3780f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f3781g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar6 = this.f3782h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f3783i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f3785k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f3786l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public Matrix b() {
        float fI;
        this.f3775a.reset();
        a<?, PointF> aVar = this.f3781g;
        if (aVar != null) {
            PointF pointFF = aVar.f();
            if (pointFF.x != 0.0f || pointFF.y != 0.0f) {
                this.f3775a.preTranslate(pointFF.x, pointFF.y);
            }
        }
        a<Float, Float> aVar2 = this.f3783i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                fI = aVar2.f().floatValue();
            } else {
                fI = ((c) aVar2).i();
            }
            if (fI != 0.0f) {
                this.f3775a.preRotate(fI);
            }
        }
        if (this.f3785k != null) {
            float fCos = this.f3786l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.i()) + 90.0f));
            float fSin = this.f3786l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.i()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f3785k.i()));
            e();
            float[] fArr = this.f3779e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f3776b.setValues(fArr);
            e();
            float[] fArr2 = this.f3779e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f3777c.setValues(fArr2);
            e();
            float[] fArr3 = this.f3779e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f3778d.setValues(fArr3);
            this.f3777c.preConcat(this.f3776b);
            this.f3778d.preConcat(this.f3777c);
            this.f3775a.preConcat(this.f3778d);
        }
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar3 = this.f3782h;
        if (aVar3 != null) {
            com.airbnb.lottie.c0.k kVarF = aVar3.f();
            if (kVarF.a() != 1.0f || kVarF.b() != 1.0f) {
                this.f3775a.preScale(kVarF.a(), kVarF.b());
            }
        }
        a<PointF, PointF> aVar4 = this.f3780f;
        if (aVar4 != null) {
            PointF pointFF2 = aVar4.f();
            if (pointFF2.x != 0.0f || pointFF2.y != 0.0f) {
                this.f3775a.preTranslate(-pointFF2.x, -pointFF2.y);
            }
        }
        return this.f3775a;
    }

    @Nullable
    public a<?, Float> a() {
        return this.n;
    }

    public Matrix a(float f2) {
        a<?, PointF> aVar = this.f3781g;
        PointF pointFF = aVar == null ? null : aVar.f();
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar2 = this.f3782h;
        com.airbnb.lottie.c0.k kVarF = aVar2 == null ? null : aVar2.f();
        this.f3775a.reset();
        if (pointFF != null) {
            this.f3775a.preTranslate(pointFF.x * f2, pointFF.y * f2);
        }
        if (kVarF != null) {
            double d2 = f2;
            this.f3775a.preScale((float) Math.pow(kVarF.a(), d2), (float) Math.pow(kVarF.b(), d2));
        }
        a<Float, Float> aVar3 = this.f3783i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.f().floatValue();
            a<PointF, PointF> aVar4 = this.f3780f;
            PointF pointFF2 = aVar4 != null ? aVar4.f() : null;
            this.f3775a.preRotate(fFloatValue * f2, pointFF2 == null ? 0.0f : pointFF2.x, pointFF2 != null ? pointFF2.y : 0.0f);
        }
        return this.f3775a;
    }

    public <T> boolean a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        c cVar;
        c cVar2;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == com.airbnb.lottie.o.f3602e) {
            a<PointF, PointF> aVar3 = this.f3780f;
            if (aVar3 == null) {
                this.f3780f = new p(jVar, new PointF());
                return true;
            }
            aVar3.a((com.airbnb.lottie.c0.j<PointF>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f3603f) {
            a<?, PointF> aVar4 = this.f3781g;
            if (aVar4 == null) {
                this.f3781g = new p(jVar, new PointF());
                return true;
            }
            aVar4.a((com.airbnb.lottie.c0.j<PointF>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f3604g) {
            a<?, PointF> aVar5 = this.f3781g;
            if (aVar5 instanceof m) {
                ((m) aVar5).b(jVar);
                return true;
            }
        }
        if (t == com.airbnb.lottie.o.f3605h) {
            a<?, PointF> aVar6 = this.f3781g;
            if (aVar6 instanceof m) {
                ((m) aVar6).c(jVar);
                return true;
            }
        }
        if (t == com.airbnb.lottie.o.f3610m) {
            a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar7 = this.f3782h;
            if (aVar7 == null) {
                this.f3782h = new p(jVar, new com.airbnb.lottie.c0.k());
                return true;
            }
            aVar7.a((com.airbnb.lottie.c0.j<com.airbnb.lottie.c0.k>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.n) {
            a<Float, Float> aVar8 = this.f3783i;
            if (aVar8 == null) {
                this.f3783i = new p(jVar, Float.valueOf(0.0f));
                return true;
            }
            aVar8.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f3600c) {
            a<Integer, Integer> aVar9 = this.f3784j;
            if (aVar9 == null) {
                this.f3784j = new p(jVar, 100);
                return true;
            }
            aVar9.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.A && (aVar2 = this.f3787m) != null) {
            if (aVar2 == null) {
                this.f3787m = new p(jVar, 100);
                return true;
            }
            aVar2.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.B && (aVar = this.n) != null) {
            if (aVar == null) {
                this.n = new p(jVar, 100);
                return true;
            }
            aVar.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.o && (cVar2 = this.f3785k) != null) {
            if (cVar2 == null) {
                this.f3785k = new c(Collections.singletonList(new com.airbnb.lottie.c0.a(Float.valueOf(0.0f))));
            }
            this.f3785k.a(jVar);
            return true;
        }
        if (t != com.airbnb.lottie.o.p || (cVar = this.f3786l) == null) {
            return false;
        }
        if (cVar == null) {
            this.f3786l = new c(Collections.singletonList(new com.airbnb.lottie.c0.a(Float.valueOf(0.0f))));
        }
        this.f3786l.a(jVar);
        return true;
    }
}

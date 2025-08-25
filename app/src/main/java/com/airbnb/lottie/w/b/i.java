package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i extends a {
    private static final int z = 32;
    private final String o;
    private final boolean p;
    private final LongSparseArray<LinearGradient> q;
    private final LongSparseArray<RadialGradient> r;
    private final RectF s;
    private final com.airbnb.lottie.y.k.f t;
    private final int u;
    private final com.airbnb.lottie.w.c.a<com.airbnb.lottie.y.k.c, com.airbnb.lottie.y.k.c> v;
    private final com.airbnb.lottie.w.c.a<PointF, PointF> w;
    private final com.airbnb.lottie.w.c.a<PointF, PointF> x;

    @Nullable
    private com.airbnb.lottie.w.c.p y;

    public i(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.e eVar) {
        super(jVar, aVar, eVar.a().toPaintCap(), eVar.f().toPaintJoin(), eVar.h(), eVar.j(), eVar.l(), eVar.g(), eVar.b());
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.s = new RectF();
        this.o = eVar.i();
        this.t = eVar.e();
        this.p = eVar.m();
        this.u = (int) (jVar.f().c() / 32.0f);
        this.v = eVar.d().a();
        this.v.a(this);
        aVar.a(this.v);
        this.w = eVar.k().a();
        this.w.a(this);
        aVar.a(this.w);
        this.x = eVar.c().a();
        this.x.a(this);
        aVar.a(this.x);
    }

    private int b() {
        int iRound = Math.round(this.w.e() * this.u);
        int iRound2 = Math.round(this.x.e() * this.u);
        int iRound3 = Math.round(this.v.e() * this.u);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient c() {
        long jB = b();
        LinearGradient linearGradient = this.q.get(jB);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFF = this.w.f();
        PointF pointFF2 = this.x.f();
        com.airbnb.lottie.y.k.c cVarF = this.v.f();
        LinearGradient linearGradient2 = new LinearGradient(pointFF.x, pointFF.y, pointFF2.x, pointFF2.y, a(cVarF.a()), cVarF.b(), Shader.TileMode.CLAMP);
        this.q.put(jB, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long jB = b();
        RadialGradient radialGradient = this.r.get(jB);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFF = this.w.f();
        PointF pointFF2 = this.x.f();
        com.airbnb.lottie.y.k.c cVarF = this.v.f();
        int[] iArrA = a(cVarF.a());
        float[] fArrB = cVarF.b();
        RadialGradient radialGradient2 = new RadialGradient(pointFF.x, pointFF.y, (float) Math.hypot(pointFF2.x - r7, pointFF2.y - r8), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.r.put(jB, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.w.b.a, com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.p) {
            return;
        }
        a(this.s, matrix, false);
        Shader shaderC = this.t == com.airbnb.lottie.y.k.f.LINEAR ? c() : d();
        shaderC.setLocalMatrix(matrix);
        this.f3638i.setShader(shaderC);
        super.a(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.o;
    }

    private int[] a(int[] iArr) {
        com.airbnb.lottie.w.c.p pVar = this.y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.f();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.w.b.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a((i) t, (com.airbnb.lottie.c0.j<i>) jVar);
        if (t == com.airbnb.lottie.o.F) {
            com.airbnb.lottie.w.c.p pVar = this.y;
            if (pVar != null) {
                this.f3635f.b(pVar);
            }
            if (jVar == null) {
                this.y = null;
                return;
            }
            this.y = new com.airbnb.lottie.w.c.p(jVar);
            this.y.a(this);
            this.f3635f.a(this.y);
        }
    }
}

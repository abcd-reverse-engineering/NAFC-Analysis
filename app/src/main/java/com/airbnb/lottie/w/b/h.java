package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class h implements e, a.b, k {
    private static final int s = 32;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f3676a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3677b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.l.a f3678c;

    /* renamed from: d, reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f3679d = new LongSparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f3680e = new LongSparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private final Path f3681f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final Paint f3682g = new com.airbnb.lottie.w.a(1);

    /* renamed from: h, reason: collision with root package name */
    private final RectF f3683h = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private final List<n> f3684i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.f f3685j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<com.airbnb.lottie.y.k.c, com.airbnb.lottie.y.k.c> f3686k;

    /* renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Integer, Integer> f3687l;

    /* renamed from: m, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<PointF, PointF> f3688m;
    private final com.airbnb.lottie.w.c.a<PointF, PointF> n;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> o;

    @Nullable
    private com.airbnb.lottie.w.c.p p;
    private final com.airbnb.lottie.j q;
    private final int r;

    public h(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.d dVar) {
        this.f3678c = aVar;
        this.f3676a = dVar.g();
        this.f3677b = dVar.j();
        this.q = jVar;
        this.f3685j = dVar.d();
        this.f3681f.setFillType(dVar.b());
        this.r = (int) (jVar.f().c() / 32.0f);
        this.f3686k = dVar.c().a();
        this.f3686k.a(this);
        aVar.a(this.f3686k);
        this.f3687l = dVar.h().a();
        this.f3687l.a(this);
        aVar.a(this.f3687l);
        this.f3688m = dVar.i().a();
        this.f3688m.a(this);
        aVar.a(this.f3688m);
        this.n = dVar.a().a();
        this.n.a(this);
        aVar.a(this.n);
    }

    private int b() {
        int iRound = Math.round(this.f3688m.e() * this.r);
        int iRound2 = Math.round(this.n.e() * this.r);
        int iRound3 = Math.round(this.f3686k.e() * this.r);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient c() {
        long jB = b();
        LinearGradient linearGradient = this.f3679d.get(jB);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFF = this.f3688m.f();
        PointF pointFF2 = this.n.f();
        com.airbnb.lottie.y.k.c cVarF = this.f3686k.f();
        LinearGradient linearGradient2 = new LinearGradient(pointFF.x, pointFF.y, pointFF2.x, pointFF2.y, a(cVarF.a()), cVarF.b(), Shader.TileMode.CLAMP);
        this.f3679d.put(jB, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long jB = b();
        RadialGradient radialGradient = this.f3680e.get(jB);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFF = this.f3688m.f();
        PointF pointFF2 = this.n.f();
        com.airbnb.lottie.y.k.c cVarF = this.f3686k.f();
        int[] iArrA = a(cVarF.a());
        float[] fArrB = cVarF.b();
        float f2 = pointFF.x;
        float f3 = pointFF.y;
        float fHypot = (float) Math.hypot(pointFF2.x - f2, pointFF2.y - f3);
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, fHypot <= 0.0f ? 0.001f : fHypot, iArrA, fArrB, Shader.TileMode.CLAMP);
        this.f3680e.put(jB, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3676a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof n) {
                this.f3684i.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Shader shaderD;
        if (this.f3677b) {
            return;
        }
        com.airbnb.lottie.e.a("GradientFillContent#draw");
        this.f3681f.reset();
        for (int i3 = 0; i3 < this.f3684i.size(); i3++) {
            this.f3681f.addPath(this.f3684i.get(i3).getPath(), matrix);
        }
        this.f3681f.computeBounds(this.f3683h, false);
        if (this.f3685j == com.airbnb.lottie.y.k.f.LINEAR) {
            shaderD = c();
        } else {
            shaderD = d();
        }
        shaderD.setLocalMatrix(matrix);
        this.f3682g.setShader(shaderD);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f3682g.setColorFilter(aVar.f());
        }
        this.f3682g.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * this.f3687l.f().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f3681f, this.f3682g);
        com.airbnb.lottie.e.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f3681f.reset();
        for (int i2 = 0; i2 < this.f3684i.size(); i2++) {
            this.f3681f.addPath(this.f3684i.get(i2).getPath(), matrix);
        }
        this.f3681f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] a(int[] iArr) {
        com.airbnb.lottie.w.c.p pVar = this.p;
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

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f3601d) {
            this.f3687l.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.f3678c.b(aVar);
            }
            if (jVar == null) {
                this.o = null;
                return;
            }
            this.o = new com.airbnb.lottie.w.c.p(jVar);
            this.o.a(this);
            this.f3678c.a(this.o);
            return;
        }
        if (t == com.airbnb.lottie.o.F) {
            com.airbnb.lottie.w.c.p pVar = this.p;
            if (pVar != null) {
                this.f3678c.b(pVar);
            }
            if (jVar == null) {
                this.p = null;
                return;
            }
            this.f3679d.clear();
            this.f3680e.clear();
            this.p = new com.airbnb.lottie.w.c.p(jVar);
            this.p.a(this);
            this.f3678c.a(this.p);
        }
    }
}

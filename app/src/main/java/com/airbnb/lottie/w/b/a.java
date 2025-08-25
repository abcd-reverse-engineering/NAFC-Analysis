package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.j f3634e;

    /* renamed from: f, reason: collision with root package name */
    protected final com.airbnb.lottie.y.l.a f3635f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f3637h;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3639j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Integer> f3640k;

    /* renamed from: l, reason: collision with root package name */
    private final List<com.airbnb.lottie.w.c.a<?, Float>> f3641l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f3642m;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> n;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f3630a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f3631b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f3632c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f3633d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List<b> f3636g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final Paint f3638i = new com.airbnb.lottie.w.a(1);

    /* compiled from: BaseStrokeContent.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<n> f3643a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final t f3644b;

        private b(@Nullable t tVar) {
            this.f3643a = new ArrayList();
            this.f3644b = tVar;
        }
    }

    a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.airbnb.lottie.y.j.d dVar, com.airbnb.lottie.y.j.b bVar, List<com.airbnb.lottie.y.j.b> list, com.airbnb.lottie.y.j.b bVar2) {
        this.f3634e = jVar;
        this.f3635f = aVar;
        this.f3638i.setStyle(Paint.Style.STROKE);
        this.f3638i.setStrokeCap(cap);
        this.f3638i.setStrokeJoin(join);
        this.f3638i.setStrokeMiter(f2);
        this.f3640k = dVar.a();
        this.f3639j = bVar.a();
        if (bVar2 == null) {
            this.f3642m = null;
        } else {
            this.f3642m = bVar2.a();
        }
        this.f3641l = new ArrayList(list.size());
        this.f3637h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3641l.add(list.get(i2).a());
        }
        aVar.a(this.f3640k);
        aVar.a(this.f3639j);
        for (int i3 = 0; i3 < this.f3641l.size(); i3++) {
            aVar.a(this.f3641l.get(i3));
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar2 = this.f3642m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.f3640k.a(this);
        this.f3639j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f3641l.get(i4).a(this);
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar3 = this.f3642m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f3634e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.airbnb.lottie.w.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.airbnb.lottie.w.b.c> r8, java.util.List<com.airbnb.lottie.w.b.c> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.airbnb.lottie.w.b.c r3 = (com.airbnb.lottie.w.b.c) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.w.b.t
            if (r4 == 0) goto L1f
            com.airbnb.lottie.w.b.t r3 = (com.airbnb.lottie.w.b.t) r3
            com.airbnb.lottie.y.k.q$a r4 = r3.e()
            com.airbnb.lottie.y.k.q$a r5 = com.airbnb.lottie.y.k.q.a.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.a(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.airbnb.lottie.w.b.c r3 = (com.airbnb.lottie.w.b.c) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.w.b.t
            if (r4 == 0) goto L55
            r4 = r3
            com.airbnb.lottie.w.b.t r4 = (com.airbnb.lottie.w.b.t) r4
            com.airbnb.lottie.y.k.q$a r5 = r4.e()
            com.airbnb.lottie.y.k.q$a r6 = com.airbnb.lottie.y.k.q.a.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.airbnb.lottie.w.b.a$b> r3 = r7.f3636g
            r3.add(r0)
        L4c:
            com.airbnb.lottie.w.b.a$b r0 = new com.airbnb.lottie.w.b.a$b
            r0.<init>(r4)
            r4.a(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.airbnb.lottie.w.b.n
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.airbnb.lottie.w.b.a$b r0 = new com.airbnb.lottie.w.b.a$b
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.airbnb.lottie.w.b.a.b.a(r0)
            com.airbnb.lottie.w.b.n r3 = (com.airbnb.lottie.w.b.n) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.airbnb.lottie.w.b.a$b> r8 = r7.f3636g
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.w.b.a.a(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.e.a("StrokeContent#draw");
        if (com.airbnb.lottie.b0.h.b(matrix)) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        this.f3638i.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * ((com.airbnb.lottie.w.c.e) this.f3640k).i()) / 100.0f) * 255.0f), 0, 255));
        this.f3638i.setStrokeWidth(((com.airbnb.lottie.w.c.c) this.f3639j).i() * com.airbnb.lottie.b0.h.a(matrix));
        if (this.f3638i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f3638i.setColorFilter(aVar.f());
        }
        for (int i3 = 0; i3 < this.f3636g.size(); i3++) {
            b bVar = this.f3636g.get(i3);
            if (bVar.f3644b != null) {
                a(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.e.a("StrokeContent#buildPath");
                this.f3631b.reset();
                for (int size = bVar.f3643a.size() - 1; size >= 0; size--) {
                    this.f3631b.addPath(((n) bVar.f3643a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.e.b("StrokeContent#buildPath");
                com.airbnb.lottie.e.a("StrokeContent#drawPath");
                canvas.drawPath(this.f3631b, this.f3638i);
                com.airbnb.lottie.e.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.e.b("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.graphics.Canvas r13, com.airbnb.lottie.w.b.a.b r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.w.b.a.a(android.graphics.Canvas, com.airbnb.lottie.w.b.a$b, android.graphics.Matrix):void");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        com.airbnb.lottie.e.a("StrokeContent#getBounds");
        this.f3631b.reset();
        for (int i2 = 0; i2 < this.f3636g.size(); i2++) {
            b bVar = this.f3636g.get(i2);
            for (int i3 = 0; i3 < bVar.f3643a.size(); i3++) {
                this.f3631b.addPath(((n) bVar.f3643a.get(i3)).getPath(), matrix);
            }
        }
        this.f3631b.computeBounds(this.f3633d, false);
        float fI = ((com.airbnb.lottie.w.c.c) this.f3639j).i();
        RectF rectF2 = this.f3633d;
        float f2 = fI / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f3633d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.e.b("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.e.a("StrokeContent#applyDashPattern");
        if (this.f3641l.isEmpty()) {
            com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
            return;
        }
        float fA = com.airbnb.lottie.b0.h.a(matrix);
        for (int i2 = 0; i2 < this.f3641l.size(); i2++) {
            this.f3637h[i2] = this.f3641l.get(i2).f().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f3637h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f3637h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f3637h;
            fArr3[i2] = fArr3[i2] * fA;
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f3642m;
        this.f3638i.setPathEffect(new DashPathEffect(this.f3637h, aVar == null ? 0.0f : fA * aVar.f().floatValue()));
        com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f3601d) {
            this.f3640k.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.q) {
            this.f3639j.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f3635f.b(aVar);
            }
            if (jVar == null) {
                this.n = null;
                return;
            }
            this.n = new com.airbnb.lottie.w.c.p(jVar);
            this.n.a(this);
            this.f3635f.a(this.n);
        }
    }
}

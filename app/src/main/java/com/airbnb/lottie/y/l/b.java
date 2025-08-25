package com.airbnb.lottie.y.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.o;
import com.airbnb.lottie.w.c.p;
import com.airbnb.lottie.y.l.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class b extends com.airbnb.lottie.y.l.a {

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> D;
    private final List<com.airbnb.lottie.y.l.a> E;
    private final RectF F;
    private final RectF G;
    private Paint H;

    @Nullable
    private Boolean I;

    @Nullable
    private Boolean J;

    /* compiled from: CompositionLayer.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3969a = new int[d.b.values().length];

        static {
            try {
                f3969a[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3969a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(j jVar, d dVar, List<d> list, com.airbnb.lottie.g gVar) {
        int i2;
        com.airbnb.lottie.y.l.a aVar;
        super(jVar, dVar);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        com.airbnb.lottie.y.j.b bVarS = dVar.s();
        if (bVarS != null) {
            this.D = bVarS.a();
            a(this.D);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(gVar.i().size());
        int size = list.size() - 1;
        com.airbnb.lottie.y.l.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar2 = list.get(size);
            com.airbnb.lottie.y.l.a aVarA = com.airbnb.lottie.y.l.a.a(dVar2, jVar, gVar);
            if (aVarA != null) {
                longSparseArray.put(aVarA.b().b(), aVarA);
                if (aVar2 != null) {
                    aVar2.a(aVarA);
                    aVar2 = null;
                } else {
                    this.E.add(0, aVarA);
                    int i3 = a.f3969a[dVar2.f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar2 = aVarA;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            com.airbnb.lottie.y.l.a aVar3 = (com.airbnb.lottie.y.l.a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (aVar3 != null && (aVar = (com.airbnb.lottie.y.l.a) longSparseArray.get(aVar3.b().h())) != null) {
                aVar3.b(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.y.l.a
    public void a(boolean z) {
        super.a(z);
        Iterator<com.airbnb.lottie.y.l.a> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    @Override // com.airbnb.lottie.y.l.a
    void b(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.e.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.G);
        boolean z = this.n.u() && this.E.size() > 1 && i2 != 255;
        if (z) {
            this.H.setAlpha(i2);
            com.airbnb.lottie.b0.h.a(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (!this.G.isEmpty() ? canvas.clipRect(this.G) : true) {
                this.E.get(size).a(canvas, matrix, i2);
            }
        }
        canvas.restore();
        com.airbnb.lottie.e.b("CompositionLayer#draw");
    }

    public boolean e() {
        if (this.J == null) {
            for (int size = this.E.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.y.l.a aVar = this.E.get(size);
                if (aVar instanceof f) {
                    if (aVar.c()) {
                        this.J = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).e()) {
                    this.J = true;
                    return true;
                }
            }
            this.J = false;
        }
        return this.J.booleanValue();
    }

    public boolean f() {
        if (this.I == null) {
            if (d()) {
                this.I = true;
                return true;
            }
            for (int size = this.E.size() - 1; size >= 0; size--) {
                if (this.E.get(size).d()) {
                    this.I = true;
                    return true;
                }
            }
            this.I = false;
        }
        return this.I.booleanValue();
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).a(this.F, this.f3965m, true);
            rectF.union(this.F);
        }
    }

    @Override // com.airbnb.lottie.y.l.a
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.a(f2);
        if (this.D != null) {
            f2 = ((this.D.f().floatValue() * this.o.a().g()) - this.o.a().m()) / (this.n.f().d() + 0.01f);
        }
        if (this.D == null) {
            f2 -= this.o.p();
        }
        if (this.o.t() != 0.0f && !"__container".equals(this.o.g())) {
            f2 /= this.o.t();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).a(f2);
        }
    }

    @Override // com.airbnb.lottie.y.l.a
    protected void b(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            this.E.get(i3).a(eVar, i2, list, eVar2);
        }
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a((b) t, (com.airbnb.lottie.c0.j<b>) jVar);
        if (t == o.C) {
            if (jVar == null) {
                com.airbnb.lottie.w.c.a<Float, Float> aVar = this.D;
                if (aVar != null) {
                    aVar.a((com.airbnb.lottie.c0.j<Float>) null);
                    return;
                }
                return;
            }
            this.D = new p(jVar);
            this.D.a(this);
            a(this.D);
        }
    }
}

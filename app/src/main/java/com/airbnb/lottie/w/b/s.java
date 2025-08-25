package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class s extends a {
    private final com.airbnb.lottie.y.l.a o;
    private final String p;
    private final boolean q;
    private final com.airbnb.lottie.w.c.a<Integer, Integer> r;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> s;

    public s(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.p pVar) {
        super(jVar, aVar, pVar.a().toPaintCap(), pVar.d().toPaintJoin(), pVar.f(), pVar.h(), pVar.i(), pVar.e(), pVar.c());
        this.o = aVar;
        this.p = pVar.g();
        this.q = pVar.j();
        this.r = pVar.b().a();
        this.r.a(this);
        aVar.a(this.r);
    }

    @Override // com.airbnb.lottie.w.b.a, com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.q) {
            return;
        }
        this.f3638i.setColor(((com.airbnb.lottie.w.c.b) this.r).i());
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.s;
        if (aVar != null) {
            this.f3638i.setColorFilter(aVar.f());
        }
        super.a(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.p;
    }

    @Override // com.airbnb.lottie.w.b.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a((s) t, (com.airbnb.lottie.c0.j<s>) jVar);
        if (t == com.airbnb.lottie.o.f3599b) {
            this.r.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.o.b(aVar);
            }
            if (jVar == null) {
                this.s = null;
                return;
            }
            this.s = new com.airbnb.lottie.w.c.p(jVar);
            this.s.a(this);
            this.o.a(this.r);
        }
    }
}

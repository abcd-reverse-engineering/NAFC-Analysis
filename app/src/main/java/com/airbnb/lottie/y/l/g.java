package com.airbnb.lottie.y.l;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.j;
import com.airbnb.lottie.o;
import com.airbnb.lottie.w.c.p;

/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class g extends a {
    private final RectF D;
    private final Paint E;
    private final float[] F;
    private final Path G;
    private final d H;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> I;

    g(j jVar, d dVar) {
        super(jVar, dVar);
        this.D = new RectF();
        this.E = new com.airbnb.lottie.w.a();
        this.F = new float[8];
        this.G = new Path();
        this.H = dVar;
        this.E.setAlpha(0);
        this.E.setStyle(Paint.Style.FILL);
        this.E.setColor(dVar.m());
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.D.set(0.0f, 0.0f, this.H.o(), this.H.n());
        this.f3965m.mapRect(this.D);
        rectF.set(this.D);
    }

    @Override // com.airbnb.lottie.y.l.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        int iAlpha = Color.alpha(this.H.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i2 / 255.0f) * (((iAlpha / 255.0f) * (this.v.c() == null ? 100 : this.v.c().f().intValue())) / 100.0f) * 255.0f);
        this.E.setAlpha(iIntValue);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.I;
        if (aVar != null) {
            this.E.setColorFilter(aVar.f());
        }
        if (iIntValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.H.o();
            float[] fArr2 = this.F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.H.o();
            this.F[5] = this.H.n();
            float[] fArr3 = this.F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.H.n();
            matrix.mapPoints(this.F);
            this.G.reset();
            Path path = this.G;
            float[] fArr4 = this.F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.G;
            float[] fArr5 = this.F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.G;
            float[] fArr6 = this.F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.G;
            float[] fArr7 = this.F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.G;
            float[] fArr8 = this.F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.G.close();
            canvas.drawPath(this.G, this.E);
        }
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a((g) t, (com.airbnb.lottie.c0.j<g>) jVar);
        if (t == o.E) {
            if (jVar == null) {
                this.I = null;
            } else {
                this.I = new p(jVar);
            }
        }
    }
}

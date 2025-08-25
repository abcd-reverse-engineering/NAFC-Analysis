package com.airbnb.lottie.y.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.j;
import com.airbnb.lottie.y.k.n;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class f extends a {
    private final com.airbnb.lottie.w.b.d D;

    f(j jVar, d dVar) {
        super(jVar, dVar);
        this.D = new com.airbnb.lottie.w.b.d(jVar, this, new n("__container", dVar.l(), false));
        this.D.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.D.a(rectF, this.f3965m, z);
    }

    @Override // com.airbnb.lottie.y.l.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i2) {
        this.D.a(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.y.l.a
    protected void b(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        this.D.a(eVar, i2, list, eVar2);
    }
}

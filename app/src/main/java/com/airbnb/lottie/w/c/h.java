package com.airbnb.lottie.w.c;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.c0.a<PointF> {

    @Nullable
    private Path s;
    private final com.airbnb.lottie.c0.a<PointF> t;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.c0.a<PointF> aVar) {
        super(gVar, aVar.f3450b, aVar.f3451c, aVar.f3452d, aVar.f3453e, aVar.f3454f, aVar.f3455g, aVar.f3456h);
        this.t = aVar;
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        T t;
        T t2;
        T t3 = this.f3451c;
        boolean z = (t3 == 0 || (t2 = this.f3450b) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.f3450b;
        if (t4 == 0 || (t = this.f3451c) == 0 || z) {
            return;
        }
        com.airbnb.lottie.c0.a<PointF> aVar = this.t;
        this.s = com.airbnb.lottie.b0.h.a((PointF) t4, (PointF) t, aVar.o, aVar.p);
    }

    @Nullable
    Path i() {
        return this.s;
    }
}

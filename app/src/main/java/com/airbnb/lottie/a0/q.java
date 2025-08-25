package com.airbnb.lottie.a0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private static final float f3408a = 100.0f;

    /* renamed from: c, reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f3410c;

    /* renamed from: b, reason: collision with root package name */
    private static final Interpolator f3409b = new LinearInterpolator();

    /* renamed from: d, reason: collision with root package name */
    static c.a f3411d = c.a.a("t", bh.aE, "e", "o", bh.aF, bh.aJ, "to", "ti");

    /* renamed from: e, reason: collision with root package name */
    static c.a f3412e = c.a.a("x", "y");

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> a() {
        if (f3410c == null) {
            f3410c = new SparseArrayCompat<>();
        }
        return f3410c;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.airbnb.lottie.c0.a<T> b(com.airbnb.lottie.g r20, com.airbnb.lottie.a0.l0.c r21, float r22, com.airbnb.lottie.a0.k0<T> r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a0.q.b(com.airbnb.lottie.g, com.airbnb.lottie.a0.l0.c, float, com.airbnb.lottie.a0.k0):com.airbnb.lottie.c0.a");
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = a().get(i2);
        }
        return weakReference;
    }

    private static void a(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f3410c.put(i2, weakReference);
        }
    }

    static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, float f2, k0<T> k0Var, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return b(gVar, cVar, f2, k0Var);
        }
        if (z) {
            return a(gVar, cVar, f2, k0Var);
        }
        return a(cVar, f2, k0Var);
    }

    private static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.g gVar, com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        Interpolator interpolatorA;
        Interpolator interpolator;
        T t;
        cVar.d();
        PointF pointFD = null;
        PointF pointFD2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFD3 = null;
        PointF pointFD4 = null;
        boolean z = false;
        float fJ = 0.0f;
        while (cVar.h()) {
            switch (cVar.a(f3411d)) {
                case 0:
                    fJ = (float) cVar.j();
                    break;
                case 1:
                    tA2 = k0Var.a(cVar, f2);
                    break;
                case 2:
                    tA = k0Var.a(cVar, f2);
                    break;
                case 3:
                    pointFD = p.d(cVar, 1.0f);
                    break;
                case 4:
                    pointFD2 = p.d(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.k() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointFD3 = p.d(cVar, f2);
                    break;
                case 7:
                    pointFD4 = p.d(cVar, f2);
                    break;
                default:
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        if (z) {
            interpolator = f3409b;
            t = tA2;
        } else {
            if (pointFD != null && pointFD2 != null) {
                interpolatorA = a(pointFD, pointFD2);
            } else {
                interpolatorA = f3409b;
            }
            interpolator = interpolatorA;
            t = tA;
        }
        com.airbnb.lottie.c0.a<T> aVar = new com.airbnb.lottie.c0.a<>(gVar, tA2, t, interpolator, fJ, null);
        aVar.o = pointFD3;
        aVar.p = pointFD4;
        return aVar;
    }

    private static Interpolator a(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.airbnb.lottie.b0.g.a(pointF.x, -1.0f, 1.0f);
        pointF.y = com.airbnb.lottie.b0.g.a(pointF.y, -100.0f, f3408a);
        pointF2.x = com.airbnb.lottie.b0.g.a(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.airbnb.lottie.b0.g.a(pointF2.y, -100.0f, f3408a);
        int iA = com.airbnb.lottie.b0.h.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceA = a(iA);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e2) {
                if ("The Path cannot loop back on itself.".equals(e2.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                a(iA, (WeakReference<Interpolator>) new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    private static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        return new com.airbnb.lottie.c0.a<>(k0Var.a(cVar, f2));
    }
}

package com.airbnb.lottie.b0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.w.b.k;
import com.airbnb.lottie.y.k.l;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static PointF f3441a = new PointF();

    public static int a(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    private static int b(int i2, int i3) {
        return i2 - (i3 * a(i2, i3));
    }

    public static boolean b(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    public static float c(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static void a(l lVar, Path path) {
        path.reset();
        PointF pointFB = lVar.b();
        path.moveTo(pointFB.x, pointFB.y);
        f3441a.set(pointFB.x, pointFB.y);
        for (int i2 = 0; i2 < lVar.a().size(); i2++) {
            com.airbnb.lottie.y.a aVar = lVar.a().get(i2);
            PointF pointFA = aVar.a();
            PointF pointFB2 = aVar.b();
            PointF pointFC = aVar.c();
            if (pointFA.equals(f3441a) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            f3441a.set(pointFC.x, pointFC.y);
        }
        if (lVar.c()) {
            path.close();
        }
    }

    static int a(float f2, float f3) {
        return b((int) f2, (int) f3);
    }

    private static int a(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static float a(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static double a(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d4, d2));
    }

    public static void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2, k kVar) {
        if (eVar.a(kVar.getName(), i2)) {
            list.add(eVar2.a(kVar.getName()).a(kVar));
        }
    }
}

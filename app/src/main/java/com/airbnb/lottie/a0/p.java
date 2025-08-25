package com.airbnb.lottie.a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3406a = c.a.a("x", "y");

    /* compiled from: JsonUtils.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3407a = new int[c.b.values().length];

        static {
            try {
                f3407a[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3407a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3407a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private p() {
    }

    @ColorInt
    static int a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        cVar.c();
        int iJ = (int) (cVar.j() * 255.0d);
        int iJ2 = (int) (cVar.j() * 255.0d);
        int iJ3 = (int) (cVar.j() * 255.0d);
        while (cVar.h()) {
            cVar.o();
        }
        cVar.e();
        return Color.argb(255, iJ, iJ2, iJ3);
    }

    private static PointF b(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        float fJ = (float) cVar.j();
        float fJ2 = (float) cVar.j();
        while (cVar.h()) {
            cVar.o();
        }
        return new PointF(fJ * f2, fJ2 * f2);
    }

    private static PointF c(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        cVar.d();
        float fB = 0.0f;
        float fB2 = 0.0f;
        while (cVar.h()) {
            int iA = cVar.a(f3406a);
            if (iA == 0) {
                fB = b(cVar);
            } else if (iA != 1) {
                cVar.n();
                cVar.o();
            } else {
                fB2 = b(cVar);
            }
        }
        cVar.f();
        return new PointF(fB * f2, fB2 * f2);
    }

    static PointF d(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        int i2 = a.f3407a[cVar.peek().ordinal()];
        if (i2 == 1) {
            return b(cVar, f2);
        }
        if (i2 == 2) {
            return a(cVar, f2);
        }
        if (i2 == 3) {
            return c(cVar, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.peek());
    }

    static List<PointF> e(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        while (cVar.peek() == c.b.BEGIN_ARRAY) {
            cVar.c();
            arrayList.add(d(cVar, f2));
            cVar.e();
        }
        cVar.e();
        return arrayList;
    }

    static float b(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        c.b bVarPeek = cVar.peek();
        int i2 = a.f3407a[bVarPeek.ordinal()];
        if (i2 == 1) {
            return (float) cVar.j();
        }
        if (i2 == 2) {
            cVar.c();
            float fJ = (float) cVar.j();
            while (cVar.h()) {
                cVar.o();
            }
            cVar.e();
            return fJ;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + bVarPeek);
    }

    private static PointF a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        cVar.c();
        float fJ = (float) cVar.j();
        float fJ2 = (float) cVar.j();
        while (cVar.peek() != c.b.END_ARRAY) {
            cVar.o();
        }
        cVar.e();
        return new PointF(fJ * f2, fJ2 * f2);
    }
}

package com.airbnb.lottie.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.i;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class o implements n, a.b, k {
    private static final float o = 0.47829f;
    private static final float p = 0.25f;

    /* renamed from: b, reason: collision with root package name */
    private final String f3697b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.j f3698c;

    /* renamed from: d, reason: collision with root package name */
    private final i.a f3699d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3700e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3701f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f3702g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3703h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f3704i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3705j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f3706k;

    /* renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3707l;
    private boolean n;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3696a = new Path();

    /* renamed from: m, reason: collision with root package name */
    private b f3708m = new b();

    /* compiled from: PolystarContent.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3709a = new int[i.a.values().length];

        static {
            try {
                f3709a[i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3709a[i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.i iVar) {
        this.f3698c = jVar;
        this.f3697b = iVar.c();
        this.f3699d = iVar.i();
        this.f3700e = iVar.j();
        this.f3701f = iVar.f().a();
        this.f3702g = iVar.g().a();
        this.f3703h = iVar.h().a();
        this.f3705j = iVar.d().a();
        this.f3707l = iVar.e().a();
        if (this.f3699d == i.a.STAR) {
            this.f3704i = iVar.a().a();
            this.f3706k = iVar.b().a();
        } else {
            this.f3704i = null;
            this.f3706k = null;
        }
        aVar.a(this.f3701f);
        aVar.a(this.f3702g);
        aVar.a(this.f3703h);
        aVar.a(this.f3705j);
        aVar.a(this.f3707l);
        if (this.f3699d == i.a.STAR) {
            aVar.a(this.f3704i);
            aVar.a(this.f3706k);
        }
        this.f3701f.a(this);
        this.f3702g.a(this);
        this.f3703h.a(this);
        this.f3705j.a(this);
        this.f3707l.a(this);
        if (this.f3699d == i.a.STAR) {
            this.f3704i.a(this);
            this.f3706k.a(this);
        }
    }

    private void b() {
        double d2;
        double d3;
        double d4;
        int i2;
        int iFloor = (int) Math.floor(this.f3701f.f().floatValue());
        double radians = Math.toRadians((this.f3703h == null ? 0.0d : r2.f().floatValue()) - 90.0d);
        double d5 = iFloor;
        float fFloatValue = this.f3707l.f().floatValue() / 100.0f;
        float fFloatValue2 = this.f3705j.f().floatValue();
        double d6 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d6);
        float fSin = (float) (Math.sin(radians) * d6);
        this.f3696a.moveTo(fCos, fSin);
        double d7 = (float) (6.283185307179586d / d5);
        double d8 = radians + d7;
        double dCeil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < dCeil) {
            float fCos2 = (float) (Math.cos(d8) * d6);
            double d9 = dCeil;
            float fSin2 = (float) (d6 * Math.sin(d8));
            if (fFloatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d4 = d7;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f2 = fFloatValue2 * fFloatValue * p;
                this.f3696a.cubicTo(fCos - (fCos3 * f2), fSin - (fSin3 * f2), fCos2 + (fCos4 * f2), fSin2 + (f2 * fSin4), fCos2, fSin2);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i2 = i3;
                this.f3696a.lineTo(fCos2, fSin2);
            }
            d8 = d2 + d4;
            i3 = i2 + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF pointFF = this.f3702g.f();
        this.f3696a.offset(pointFF.x, pointFF.y);
        this.f3696a.close();
    }

    private void c() {
        double d2;
        int i2;
        double d3;
        float fCos;
        float fSin;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float fFloatValue = this.f3701f.f().floatValue();
        double radians = Math.toRadians((this.f3703h == null ? 0.0d : r2.f().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f12 = (float) (6.283185307179586d / d4);
        float f13 = f12 / 2.0f;
        float f14 = fFloatValue - ((int) fFloatValue);
        int i3 = (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f14) * f13;
        }
        float fFloatValue2 = this.f3705j.f().floatValue();
        float fFloatValue3 = this.f3704i.f().floatValue();
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f3706k;
        float fFloatValue4 = aVar != null ? aVar.f().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.w.c.a<?, Float> aVar2 = this.f3707l;
        float fFloatValue5 = aVar2 != null ? aVar2.f().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f2 = ((fFloatValue2 - fFloatValue3) * f14) + fFloatValue3;
            i2 = i3;
            double d5 = f2;
            d2 = d4;
            fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.f3696a.moveTo(fCos, fSin);
            d3 = radians + ((f12 * f14) / 2.0f);
        } else {
            d2 = d4;
            i2 = i3;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.f3696a.moveTo(fCos2, fSin2);
            d3 = radians + f13;
            fCos = fCos2;
            fSin = fSin2;
            f2 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        boolean z = false;
        double d7 = d3;
        float f15 = f13;
        int i4 = 0;
        while (true) {
            double d8 = i4;
            if (d8 >= dCeil) {
                PointF pointFF = this.f3702g.f();
                this.f3696a.offset(pointFF.x, pointFF.y);
                this.f3696a.close();
                return;
            }
            float f16 = z ? fFloatValue2 : fFloatValue3;
            if (f2 == 0.0f || d8 != dCeil - 2.0d) {
                f3 = f15;
            } else {
                f3 = f15;
                f15 = (f12 * f14) / 2.0f;
            }
            if (f2 == 0.0f || d8 != dCeil - 1.0d) {
                f4 = f12;
                f5 = fFloatValue3;
                f6 = f16;
                f7 = fFloatValue2;
            } else {
                f4 = f12;
                f7 = fFloatValue2;
                f5 = fFloatValue3;
                f6 = f2;
            }
            double d9 = f6;
            float f17 = f15;
            float fCos3 = (float) (d9 * Math.cos(d7));
            float fSin3 = (float) (d9 * Math.sin(d7));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f3696a.lineTo(fCos3, fSin3);
                f11 = fSin3;
                f8 = fFloatValue4;
                f9 = fFloatValue5;
                f10 = f2;
            } else {
                f8 = fFloatValue4;
                f9 = fFloatValue5;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f10 = f2;
                f11 = fSin3;
                float f18 = fCos;
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f19 = z ? f8 : f9;
                float f20 = z ? f9 : f8;
                float f21 = z ? f5 : f7;
                float f22 = z ? f7 : f5;
                float f23 = f21 * f19 * o;
                float f24 = fCos4 * f23;
                float f25 = f23 * fSin4;
                float f26 = f22 * f20 * o;
                float f27 = fCos5 * f26;
                float f28 = f26 * fSin5;
                if (i2 != 0) {
                    if (i4 == 0) {
                        f24 *= f14;
                        f25 *= f14;
                    } else if (d8 == dCeil - 1.0d) {
                        f27 *= f14;
                        f28 *= f14;
                    }
                }
                this.f3696a.cubicTo(f18 - f24, fSin - f25, fCos3 + f27, f11 + f28, fCos3, f11);
            }
            d7 += f17;
            z = !z;
            i4++;
            fCos = fCos3;
            f2 = f10;
            fFloatValue2 = f7;
            f12 = f4;
            f15 = f3;
            fFloatValue3 = f5;
            fFloatValue4 = f8;
            fFloatValue5 = f9;
            fSin = f11;
        }
    }

    private void d() {
        this.n = false;
        this.f3698c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        d();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3697b;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.n) {
            return this.f3696a;
        }
        this.f3696a.reset();
        if (this.f3700e) {
            this.n = true;
            return this.f3696a;
        }
        int i2 = a.f3709a[this.f3699d.ordinal()];
        if (i2 == 1) {
            c();
        } else if (i2 == 2) {
            b();
        }
        this.f3696a.close();
        this.f3708m.a(this.f3696a);
        this.n = true;
        return this.f3696a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f3708m.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        com.airbnb.lottie.w.c.a<?, Float> aVar;
        com.airbnb.lottie.w.c.a<?, Float> aVar2;
        if (t == com.airbnb.lottie.o.u) {
            this.f3701f.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.v) {
            this.f3703h.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.f3609l) {
            this.f3702g.a((com.airbnb.lottie.c0.j<PointF>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.w && (aVar2 = this.f3704i) != null) {
            aVar2.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.x) {
            this.f3705j.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.y && (aVar = this.f3706k) != null) {
            aVar.a((com.airbnb.lottie.c0.j<Float>) jVar);
        } else if (t == com.airbnb.lottie.o.z) {
            this.f3707l.a((com.airbnb.lottie.c0.j<Float>) jVar);
        }
    }
}

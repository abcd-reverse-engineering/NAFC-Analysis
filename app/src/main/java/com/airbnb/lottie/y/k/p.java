package com.airbnb.lottie.y.k;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.b.s;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public class p implements com.airbnb.lottie.y.k.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3932a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.y.j.b f3933b;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.y.j.b> f3934c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.a f3935d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.d f3936e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.b f3937f;

    /* renamed from: g, reason: collision with root package name */
    private final b f3938g;

    /* renamed from: h, reason: collision with root package name */
    private final c f3939h;

    /* renamed from: i, reason: collision with root package name */
    private final float f3940i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f3941j;

    /* compiled from: ShapeStroke.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3942a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3943b = new int[c.values().length];

        static {
            try {
                f3943b[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3943b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3943b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3942a = new int[b.values().length];
            try {
                f3942a[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3942a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3942a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i2 = a.f3942a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* compiled from: ShapeStroke.java */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i2 = a.f3943b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, @Nullable com.airbnb.lottie.y.j.b bVar, List<com.airbnb.lottie.y.j.b> list, com.airbnb.lottie.y.j.a aVar, com.airbnb.lottie.y.j.d dVar, com.airbnb.lottie.y.j.b bVar2, b bVar3, c cVar, float f2, boolean z) {
        this.f3932a = str;
        this.f3933b = bVar;
        this.f3934c = list;
        this.f3935d = aVar;
        this.f3936e = dVar;
        this.f3937f = bVar2;
        this.f3938g = bVar3;
        this.f3939h = cVar;
        this.f3940i = f2;
        this.f3941j = z;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new s(jVar, aVar, this);
    }

    public com.airbnb.lottie.y.j.a b() {
        return this.f3935d;
    }

    public com.airbnb.lottie.y.j.b c() {
        return this.f3933b;
    }

    public c d() {
        return this.f3939h;
    }

    public List<com.airbnb.lottie.y.j.b> e() {
        return this.f3934c;
    }

    public float f() {
        return this.f3940i;
    }

    public String g() {
        return this.f3932a;
    }

    public com.airbnb.lottie.y.j.d h() {
        return this.f3936e;
    }

    public com.airbnb.lottie.y.j.b i() {
        return this.f3937f;
    }

    public boolean j() {
        return this.f3941j;
    }

    public b a() {
        return this.f3938g;
    }
}

package com.airbnb.lottie.y.l;

import androidx.annotation.Nullable;
import com.airbnb.lottie.y.j.j;
import com.airbnb.lottie.y.j.k;
import com.airbnb.lottie.y.j.l;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.airbnb.lottie.y.k.b> f3970a;

    /* renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.g f3971b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3972c;

    /* renamed from: d, reason: collision with root package name */
    private final long f3973d;

    /* renamed from: e, reason: collision with root package name */
    private final a f3974e;

    /* renamed from: f, reason: collision with root package name */
    private final long f3975f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final String f3976g;

    /* renamed from: h, reason: collision with root package name */
    private final List<com.airbnb.lottie.y.k.g> f3977h;

    /* renamed from: i, reason: collision with root package name */
    private final l f3978i;

    /* renamed from: j, reason: collision with root package name */
    private final int f3979j;

    /* renamed from: k, reason: collision with root package name */
    private final int f3980k;

    /* renamed from: l, reason: collision with root package name */
    private final int f3981l;

    /* renamed from: m, reason: collision with root package name */
    private final float f3982m;
    private final float n;
    private final int o;
    private final int p;

    @Nullable
    private final j q;

    @Nullable
    private final k r;

    @Nullable
    private final com.airbnb.lottie.y.j.b s;
    private final List<com.airbnb.lottie.c0.a<Float>> t;
    private final b u;
    private final boolean v;

    /* compiled from: Layer.java */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Layer.java */
    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public d(List<com.airbnb.lottie.y.k.b> list, com.airbnb.lottie.g gVar, String str, long j2, a aVar, long j3, @Nullable String str2, List<com.airbnb.lottie.y.k.g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.c0.a<Float>> list3, b bVar, @Nullable com.airbnb.lottie.y.j.b bVar2, boolean z) {
        this.f3970a = list;
        this.f3971b = gVar;
        this.f3972c = str;
        this.f3973d = j2;
        this.f3974e = aVar;
        this.f3975f = j3;
        this.f3976g = str2;
        this.f3977h = list2;
        this.f3978i = lVar;
        this.f3979j = i2;
        this.f3980k = i3;
        this.f3981l = i4;
        this.f3982m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    com.airbnb.lottie.g a() {
        return this.f3971b;
    }

    public long b() {
        return this.f3973d;
    }

    List<com.airbnb.lottie.c0.a<Float>> c() {
        return this.t;
    }

    public a d() {
        return this.f3974e;
    }

    List<com.airbnb.lottie.y.k.g> e() {
        return this.f3977h;
    }

    b f() {
        return this.u;
    }

    String g() {
        return this.f3972c;
    }

    long h() {
        return this.f3975f;
    }

    int i() {
        return this.p;
    }

    int j() {
        return this.o;
    }

    @Nullable
    String k() {
        return this.f3976g;
    }

    List<com.airbnb.lottie.y.k.b> l() {
        return this.f3970a;
    }

    int m() {
        return this.f3981l;
    }

    int n() {
        return this.f3980k;
    }

    int o() {
        return this.f3979j;
    }

    float p() {
        return this.n / this.f3971b.d();
    }

    @Nullable
    j q() {
        return this.q;
    }

    @Nullable
    k r() {
        return this.r;
    }

    @Nullable
    com.airbnb.lottie.y.j.b s() {
        return this.s;
    }

    float t() {
        return this.f3982m;
    }

    public String toString() {
        return a("");
    }

    l u() {
        return this.f3978i;
    }

    public boolean v() {
        return this.v;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        d dVarA = this.f3971b.a(h());
        if (dVarA != null) {
            sb.append("\t\tParents: ");
            sb.append(dVarA.g());
            d dVarA2 = this.f3971b.a(dVarA.h());
            while (dVarA2 != null) {
                sb.append("->");
                sb.append(dVarA2.g());
                dVarA2 = this.f3971b.a(dVarA2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f3970a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.y.k.b bVar : this.f3970a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

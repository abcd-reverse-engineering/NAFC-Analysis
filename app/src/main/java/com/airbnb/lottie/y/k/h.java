package com.airbnb.lottie.y.k;

import androidx.annotation.Nullable;

/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class h implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f3891a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3892b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3893c;

    /* compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.f3891a = str;
        this.f3892b = aVar;
        this.f3893c = z;
    }

    public a a() {
        return this.f3892b;
    }

    public String b() {
        return this.f3891a;
    }

    public boolean c() {
        return this.f3893c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f3892b + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    @Nullable
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        if (jVar.d()) {
            return new com.airbnb.lottie.w.b.l(this);
        }
        com.airbnb.lottie.b0.d.b("Animation contains merge paths but they are disabled.");
        return null;
    }
}

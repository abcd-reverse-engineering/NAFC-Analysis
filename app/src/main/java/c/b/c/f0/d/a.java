package c.b.c.f0.d;

import c.b.c.t;

/* compiled from: AlignmentPattern.java */
/* loaded from: classes.dex */
public final class a extends t {

    /* renamed from: c, reason: collision with root package name */
    private final float f2773c;

    a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f2773c = f4;
    }

    boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f2773c);
        return fAbs <= 1.0f || fAbs <= this.f2773c;
    }

    a b(float f2, float f3, float f4) {
        return new a((a() + f3) / 2.0f, (b() + f2) / 2.0f, (this.f2773c + f4) / 2.0f);
    }
}

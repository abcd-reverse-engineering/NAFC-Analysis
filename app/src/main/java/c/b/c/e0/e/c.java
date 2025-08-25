package c.b.c.e0.e;

import c.b.c.m;
import c.b.c.t;

/* compiled from: BoundingBox.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private c.b.c.z.b f2635a;

    /* renamed from: b, reason: collision with root package name */
    private t f2636b;

    /* renamed from: c, reason: collision with root package name */
    private t f2637c;

    /* renamed from: d, reason: collision with root package name */
    private t f2638d;

    /* renamed from: e, reason: collision with root package name */
    private t f2639e;

    /* renamed from: f, reason: collision with root package name */
    private int f2640f;

    /* renamed from: g, reason: collision with root package name */
    private int f2641g;

    /* renamed from: h, reason: collision with root package name */
    private int f2642h;

    /* renamed from: i, reason: collision with root package name */
    private int f2643i;

    c(c.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        if ((tVar == null && tVar3 == null) || ((tVar2 == null && tVar4 == null) || ((tVar != null && tVar2 == null) || (tVar3 != null && tVar4 == null)))) {
            throw m.getNotFoundInstance();
        }
        a(bVar, tVar, tVar2, tVar3, tVar4);
    }

    private void a(c.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4) {
        this.f2635a = bVar;
        this.f2636b = tVar;
        this.f2637c = tVar2;
        this.f2638d = tVar3;
        this.f2639e = tVar4;
        i();
    }

    private void i() {
        if (this.f2636b == null) {
            this.f2636b = new t(0.0f, this.f2638d.b());
            this.f2637c = new t(0.0f, this.f2639e.b());
        } else if (this.f2638d == null) {
            this.f2638d = new t(this.f2635a.g() - 1, this.f2636b.b());
            this.f2639e = new t(this.f2635a.g() - 1, this.f2637c.b());
        }
        this.f2640f = (int) Math.min(this.f2636b.a(), this.f2637c.a());
        this.f2641g = (int) Math.max(this.f2638d.a(), this.f2639e.a());
        this.f2642h = (int) Math.min(this.f2636b.b(), this.f2638d.b());
        this.f2643i = (int) Math.max(this.f2637c.b(), this.f2639e.b());
    }

    t b() {
        return this.f2639e;
    }

    int c() {
        return this.f2641g;
    }

    int d() {
        return this.f2643i;
    }

    int e() {
        return this.f2640f;
    }

    int f() {
        return this.f2642h;
    }

    t g() {
        return this.f2636b;
    }

    t h() {
        return this.f2638d;
    }

    c(c cVar) {
        a(cVar.f2635a, cVar.f2636b, cVar.f2637c, cVar.f2638d, cVar.f2639e);
    }

    static c a(c cVar, c cVar2) throws m {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f2635a, cVar.f2636b, cVar.f2637c, cVar2.f2638d, cVar2.f2639e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    c.b.c.e0.e.c a(int r13, int r14, boolean r15) throws c.b.c.m {
        /*
            r12 = this;
            c.b.c.t r0 = r12.f2636b
            c.b.c.t r1 = r12.f2637c
            c.b.c.t r2 = r12.f2638d
            c.b.c.t r3 = r12.f2639e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.b()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            c.b.c.t r13 = new c.b.c.t
            float r4 = r4.a()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            c.b.c.t r13 = r12.f2637c
            goto L34
        L32:
            c.b.c.t r13 = r12.f2639e
        L34:
            float r0 = r13.b()
            int r0 = (int) r0
            int r0 = r0 + r14
            c.b.c.z.b r14 = r12.f2635a
            int r14 = r14.d()
            if (r0 < r14) goto L4a
            c.b.c.z.b r14 = r12.f2635a
            int r14 = r14.d()
            int r0 = r14 + (-1)
        L4a:
            c.b.c.t r14 = new c.b.c.t
            float r13 = r13.a()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            r12.i()
            c.b.c.e0.e.c r13 = new c.b.c.e0.e.c
            c.b.c.z.b r7 = r12.f2635a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.e0.e.c.a(int, int, boolean):c.b.c.e0.e.c");
    }

    t a() {
        return this.f2637c;
    }
}

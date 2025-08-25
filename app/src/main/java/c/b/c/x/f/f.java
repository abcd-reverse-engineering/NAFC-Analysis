package c.b.c.x.f;

import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: State.java */
/* loaded from: classes.dex */
final class f {

    /* renamed from: e, reason: collision with root package name */
    static final f f2898e = new f(g.f2903b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f2899a;

    /* renamed from: b, reason: collision with root package name */
    private final g f2900b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2901c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2902d;

    private f(g gVar, int i2, int i3, int i4) {
        this.f2900b = gVar;
        this.f2899a = i2;
        this.f2901c = i3;
        this.f2902d = i4;
    }

    int a() {
        return this.f2901c;
    }

    int b() {
        return this.f2902d;
    }

    int c() {
        return this.f2899a;
    }

    g d() {
        return this.f2900b;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f2885b[this.f2899a], Integer.valueOf(this.f2902d), Integer.valueOf(this.f2901c));
    }

    f a(int i2, int i3) {
        int i4 = this.f2902d;
        g gVarA = this.f2900b;
        int i5 = this.f2899a;
        if (i2 != i5) {
            int i6 = d.f2891h[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            gVarA = gVarA.a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new f(gVarA.a(i3, i9), i2, 0, i4 + i9);
    }

    f b(int i2, int i3) {
        g gVar = this.f2900b;
        int i4 = this.f2899a == 2 ? 4 : 5;
        return new f(gVar.a(d.f2893j[this.f2899a][i2], i4).a(i3, 5), this.f2899a, 0, this.f2902d + i4 + 5);
    }

    f b(int i2) {
        int i3 = this.f2901c;
        return i3 == 0 ? this : new f(this.f2900b.b(i2 - i3, i3), this.f2899a, 0, this.f2902d);
    }

    f a(int i2) {
        g gVarA = this.f2900b;
        int i3 = this.f2899a;
        int i4 = this.f2902d;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.f2891h[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVarA = gVarA.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f2901c;
        f fVar = new f(gVarA, i3, this.f2901c + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.f2901c == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    boolean a(f fVar) {
        int i2;
        int i3 = this.f2902d + (d.f2891h[this.f2899a][fVar.f2899a] >> 16);
        int i4 = fVar.f2901c;
        if (i4 > 0 && ((i2 = this.f2901c) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f2902d;
    }

    c.b.c.z.a a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVarA = b(bArr.length).f2900b; gVarA != null; gVarA = gVarA.a()) {
            linkedList.addFirst(gVarA);
        }
        c.b.c.z.a aVar = new c.b.c.z.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(aVar, bArr);
        }
        return aVar;
    }
}

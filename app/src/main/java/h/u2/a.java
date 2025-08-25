package h.u2;

import h.q2.t.i0;
import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
public abstract class a extends f {
    @Override // h.u2.f
    public int a(int i2) {
        return g.b(g().nextInt(), i2);
    }

    @Override // h.u2.f
    public double b() {
        return g().nextDouble();
    }

    @Override // h.u2.f
    public int c(int i2) {
        return g().nextInt(i2);
    }

    @Override // h.u2.f
    public int d() {
        return g().nextInt();
    }

    @Override // h.u2.f
    public long e() {
        return g().nextLong();
    }

    @i.c.a.d
    public abstract Random g();

    @Override // h.u2.f
    public boolean a() {
        return g().nextBoolean();
    }

    @Override // h.u2.f
    public float c() {
        return g().nextFloat();
    }

    @Override // h.u2.f
    @i.c.a.d
    public byte[] a(@i.c.a.d byte[] bArr) {
        i0.f(bArr, "array");
        g().nextBytes(bArr);
        return bArr;
    }
}

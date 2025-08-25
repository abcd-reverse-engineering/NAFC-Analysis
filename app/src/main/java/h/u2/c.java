package h.u2;

import h.q2.t.i0;
import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
final class c extends Random {

    @i.c.a.d
    private final f impl;
    private boolean seedInitialized;

    public c(@i.c.a.d f fVar) {
        i0.f(fVar, "impl");
        this.impl = fVar;
    }

    @i.c.a.d
    public final f getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int i2) {
        return this.impl.a(i2);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.a();
    }

    @Override // java.util.Random
    public void nextBytes(@i.c.a.d byte[] bArr) {
        i0.f(bArr, "bytes");
        this.impl.a(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.b();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.c();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.d();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.e();
    }

    @Override // java.util.Random
    public void setSeed(long j2) {
        if (this.seedInitialized) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.seedInitialized = true;
    }

    @Override // java.util.Random
    public int nextInt(int i2) {
        return this.impl.c(i2);
    }
}

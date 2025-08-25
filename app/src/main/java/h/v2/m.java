package h.v2;

import h.g2.v0;
import java.util.NoSuchElementException;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class m extends v0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f16537a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16538b;

    /* renamed from: c, reason: collision with root package name */
    private long f16539c;

    /* renamed from: d, reason: collision with root package name */
    private final long f16540d;

    public m(long j2, long j3, long j4) {
        this.f16540d = j4;
        this.f16537a = j3;
        boolean z = true;
        if (this.f16540d <= 0 ? j2 < j3 : j2 > j3) {
            z = false;
        }
        this.f16538b = z;
        this.f16539c = this.f16538b ? j2 : this.f16537a;
    }

    public final long b() {
        return this.f16540d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16538b;
    }

    @Override // h.g2.v0
    public long nextLong() {
        long j2 = this.f16539c;
        if (j2 != this.f16537a) {
            this.f16539c = this.f16540d + j2;
        } else {
            if (!this.f16538b) {
                throw new NoSuchElementException();
            }
            this.f16538b = false;
        }
        return j2;
    }
}

package h.v2;

import h.b2;
import h.g2.y1;
import h.n1;
import h.t0;
import java.util.NoSuchElementException;

/* compiled from: ULongRange.kt */
@t0(version = "1.3")
@h.k
/* loaded from: classes2.dex */
final class v extends y1 {

    /* renamed from: a, reason: collision with root package name */
    private final long f16557a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16558b;

    /* renamed from: c, reason: collision with root package name */
    private final long f16559c;

    /* renamed from: d, reason: collision with root package name */
    private long f16560d;

    private v(long j2, long j3, long j4) {
        this.f16557a = j3;
        boolean z = true;
        int iA = b2.a(j2, j3);
        if (j4 <= 0 ? iA < 0 : iA > 0) {
            z = false;
        }
        this.f16558b = z;
        this.f16559c = n1.c(j4);
        this.f16560d = this.f16558b ? j2 : this.f16557a;
    }

    @Override // h.g2.y1
    public long b() {
        long j2 = this.f16560d;
        if (j2 != this.f16557a) {
            this.f16560d = n1.c(this.f16559c + j2);
        } else {
            if (!this.f16558b) {
                throw new NoSuchElementException();
            }
            this.f16558b = false;
        }
        return j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16558b;
    }

    public /* synthetic */ v(long j2, long j3, long j4, h.q2.t.v vVar) {
        this(j2, j3, j4);
    }
}

package h.v2;

import h.b2;
import h.g2.x1;
import h.j1;
import h.t0;
import java.util.NoSuchElementException;

/* compiled from: UIntRange.kt */
@t0(version = "1.3")
@h.k
/* loaded from: classes2.dex */
final class s extends x1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f16547a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16548b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16549c;

    /* renamed from: d, reason: collision with root package name */
    private int f16550d;

    private s(int i2, int i3, int i4) {
        this.f16547a = i3;
        boolean z = true;
        int iA = b2.a(i2, i3);
        if (i4 <= 0 ? iA < 0 : iA > 0) {
            z = false;
        }
        this.f16548b = z;
        this.f16549c = j1.c(i4);
        this.f16550d = this.f16548b ? i2 : this.f16547a;
    }

    @Override // h.g2.x1
    public int b() {
        int i2 = this.f16550d;
        if (i2 != this.f16547a) {
            this.f16550d = j1.c(this.f16549c + i2);
        } else {
            if (!this.f16548b) {
                throw new NoSuchElementException();
            }
            this.f16548b = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16548b;
    }

    public /* synthetic */ s(int i2, int i3, int i4, h.q2.t.v vVar) {
        this(i2, i3, i4);
    }
}

package h.v2;

import h.g2.u0;
import java.util.NoSuchElementException;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class j extends u0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f16527a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16528b;

    /* renamed from: c, reason: collision with root package name */
    private int f16529c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16530d;

    public j(int i2, int i3, int i4) {
        this.f16530d = i4;
        this.f16527a = i3;
        boolean z = true;
        if (this.f16530d <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f16528b = z;
        this.f16529c = this.f16528b ? i2 : this.f16527a;
    }

    public final int b() {
        return this.f16530d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16528b;
    }

    @Override // h.g2.u0
    public int nextInt() {
        int i2 = this.f16529c;
        if (i2 != this.f16527a) {
            this.f16529c = this.f16530d + i2;
        } else {
            if (!this.f16528b) {
                throw new NoSuchElementException();
            }
            this.f16528b = false;
        }
        return i2;
    }
}

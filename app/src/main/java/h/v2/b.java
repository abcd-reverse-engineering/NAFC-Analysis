package h.v2;

import java.util.NoSuchElementException;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class b extends h.g2.v {

    /* renamed from: a, reason: collision with root package name */
    private final int f16511a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16512b;

    /* renamed from: c, reason: collision with root package name */
    private int f16513c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16514d;

    public b(char c2, char c3, int i2) {
        this.f16514d = i2;
        this.f16511a = c3;
        boolean z = true;
        if (this.f16514d <= 0 ? c2 < c3 : c2 > c3) {
            z = false;
        }
        this.f16512b = z;
        this.f16513c = this.f16512b ? c2 : this.f16511a;
    }

    @Override // h.g2.v
    public char b() {
        int i2 = this.f16513c;
        if (i2 != this.f16511a) {
            this.f16513c = this.f16514d + i2;
        } else {
            if (!this.f16512b) {
                throw new NoSuchElementException();
            }
            this.f16512b = false;
        }
        return (char) i2;
    }

    public final int c() {
        return this.f16514d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16512b;
    }
}

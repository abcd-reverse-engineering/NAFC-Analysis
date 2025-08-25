package h.h2;

import h.q2.t.i0;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
final class g<T> implements Comparator<T> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final Comparator<T> f16229a;

    public g(@i.c.a.d Comparator<T> comparator) {
        i0.f(comparator, "comparator");
        this.f16229a = comparator;
    }

    @i.c.a.d
    public final Comparator<T> a() {
        return this.f16229a;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f16229a.compare(t2, t);
    }

    @Override // java.util.Comparator
    @i.c.a.d
    public final Comparator<T> reversed() {
        return this.f16229a;
    }
}

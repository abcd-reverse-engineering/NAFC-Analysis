package h.g2;

import java.util.List;

/* compiled from: ReversedViews.kt */
/* loaded from: classes2.dex */
class i1<T> extends d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<T> f16141a;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(@i.c.a.d List<? extends T> list) {
        h.q2.t.i0.f(list, "delegate");
        this.f16141a = list;
    }

    @Override // h.g2.d, java.util.List
    public T get(int i2) {
        return this.f16141a.get(e0.c((List<?>) this, i2));
    }

    @Override // h.g2.d, h.g2.a
    public int getSize() {
        return this.f16141a.size();
    }
}

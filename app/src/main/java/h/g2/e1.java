package h.g2;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes2.dex */
public final class e1<E> extends d<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private int f16131a;

    /* renamed from: b, reason: collision with root package name */
    private int f16132b;

    /* renamed from: c, reason: collision with root package name */
    private final List<E> f16133c;

    /* JADX WARN: Multi-variable type inference failed */
    public e1(@i.c.a.d List<? extends E> list) {
        h.q2.t.i0.f(list, "list");
        this.f16133c = list;
    }

    public final void a(int i2, int i3) {
        d.Companion.b(i2, i3, this.f16133c.size());
        this.f16131a = i2;
        this.f16132b = i3 - i2;
    }

    @Override // h.g2.d, java.util.List
    public E get(int i2) {
        d.Companion.a(i2, this.f16132b);
        return this.f16133c.get(this.f16131a + i2);
    }

    @Override // h.g2.d, h.g2.a
    public int getSize() {
        return this.f16132b;
    }
}

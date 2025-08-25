package g.a.y0.j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: SorterFunction.java */
/* loaded from: classes2.dex */
public final class w<T> implements g.a.x0.o<List<T>, List<T>> {

    /* renamed from: a, reason: collision with root package name */
    final Comparator<? super T> f16066a;

    public w(Comparator<? super T> comparator) {
        this.f16066a = comparator;
    }

    @Override // g.a.x0.o
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.f16066a);
        return list;
    }
}

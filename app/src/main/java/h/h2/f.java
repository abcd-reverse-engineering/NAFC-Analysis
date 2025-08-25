package h.h2;

import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* renamed from: a, reason: collision with root package name */
    public static final f f16228a = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@i.c.a.d Comparable<Object> comparable, @i.c.a.d Comparable<Object> comparable2) {
        i0.f(comparable, bh.ay);
        i0.f(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    @i.c.a.d
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f16227a;
    }
}

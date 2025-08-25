package h.z2;

import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: _StringsJvm.kt */
/* loaded from: classes2.dex */
class d0 extends c0 {
    @h.m2.f
    private static final char c(@i.c.a.d CharSequence charSequence, int i2) {
        return charSequence.charAt(i2);
    }

    @i.c.a.d
    public static final SortedSet<Character> d(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$toSortedSet");
        return (SortedSet) e0.a(charSequence, new TreeSet());
    }
}

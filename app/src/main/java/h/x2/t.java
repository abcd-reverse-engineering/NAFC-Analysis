package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.e1;
import h.q2.t.i0;
import h.q2.t.j0;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: _SequencesJvm.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aA\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001\u001a8\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010¨\u0006\u0011"}, d2 = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", ExifInterface.GPS_DIRECTION_TRUE, "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes2.dex */
class t extends s {

    /* compiled from: _SequencesJvm.kt */
    static final class a extends j0 implements h.q2.s.l<Object, Boolean> {
        final /* synthetic */ Class $klass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls) {
            super(1);
            this.$klass = cls;
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(@i.c.a.e Object obj) {
            return this.$klass.isInstance(obj);
        }
    }

    @i.c.a.d
    public static final <R> m<R> a(@i.c.a.d m<?> mVar, @i.c.a.d Class<R> cls) {
        i0.f(mVar, "$this$filterIsInstance");
        i0.f(cls, "klass");
        m<R> mVarI = u.i(mVar, new a(cls));
        if (mVarI != null) {
            return mVarI;
        }
        throw new e1("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> SortedSet<T> d(@i.c.a.d m<? extends T> mVar) {
        i0.f(mVar, "$this$toSortedSet");
        return (SortedSet) u.c((m) mVar, new TreeSet());
    }

    @i.c.a.d
    public static final <C extends Collection<? super R>, R> C a(@i.c.a.d m<?> mVar, @i.c.a.d C c2, @i.c.a.d Class<R> cls) {
        i0.f(mVar, "$this$filterIsInstanceTo");
        i0.f(c2, "destination");
        i0.f(cls, "klass");
        for (Object obj : mVar) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @i.c.a.d
    public static final <T> SortedSet<T> a(@i.c.a.d m<? extends T> mVar, @i.c.a.d Comparator<? super T> comparator) {
        i0.f(mVar, "$this$toSortedSet");
        i0.f(comparator, "comparator");
        return (SortedSet) u.c((m) mVar, new TreeSet(comparator));
    }
}

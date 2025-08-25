package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import h.q2.t.i0;
import h.v2.g;
import h.y;
import i.c.a.d;

/* compiled from: Range.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001a6\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"and", "Landroid/util/Range;", ExifInterface.GPS_DIRECTION_TRUE, "", DispatchConstants.OTHER, "plus", SurveyH5Bean.VALUE, "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    @d
    public static final <T extends Comparable<? super T>> Range<T> and(@d Range<T> range, @d Range<T> range2) {
        i0.f(range, "$receiver");
        i0.f(range2, DispatchConstants.OTHER);
        Range<T> rangeIntersect = range.intersect(range2);
        i0.a((Object) rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    @d
    public static final <T extends Comparable<? super T>> Range<T> plus(@d Range<T> range, @d T t) {
        i0.f(range, "$receiver");
        i0.f(t, SurveyH5Bean.VALUE);
        Range<T> rangeExtend = range.extend((Range<T>) t);
        i0.a((Object) rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    @d
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@d T t, @d T t2) {
        i0.f(t, "$receiver");
        i0.f(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    @d
    public static final <T extends Comparable<? super T>> g<T> toClosedRange(@d final Range<T> range) {
        i0.f(range, "$receiver");
        return (g<T>) new g<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // h.v2.g
            public boolean contains(@d Comparable comparable) {
                i0.f(comparable, SurveyH5Bean.VALUE);
                return g.a.a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // h.v2.g
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // h.v2.g
            public Comparable getStart() {
                return range.getLower();
            }

            @Override // h.v2.g
            public boolean isEmpty() {
                return g.a.a(this);
            }
        };
    }

    @RequiresApi(21)
    @d
    public static final <T extends Comparable<? super T>> Range<T> toRange(@d g<T> gVar) {
        i0.f(gVar, "$receiver");
        return new Range<>(gVar.getStart(), gVar.getEndInclusive());
    }

    @RequiresApi(21)
    @d
    public static final <T extends Comparable<? super T>> Range<T> plus(@d Range<T> range, @d Range<T> range2) {
        i0.f(range, "$receiver");
        i0.f(range2, DispatchConstants.OTHER);
        Range<T> rangeExtend = range.extend(range2);
        i0.a((Object) rangeExtend, "extend(other)");
        return rangeExtend;
    }
}

package h.v2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.t0;
import java.lang.Comparable;

/* compiled from: Ranges.kt */
@t0(version = "1.1")
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedRange;", "contains", "", SurveyH5Bean.VALUE, "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", bh.ay, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface f<T extends Comparable<? super T>> extends g<T> {

    /* compiled from: Ranges.kt */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(f<T> fVar, @i.c.a.d T t) {
            i0.f(t, SurveyH5Bean.VALUE);
            return fVar.a(fVar.getStart(), t) && fVar.a(t, fVar.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean a(f<T> fVar) {
            return !fVar.a(fVar.getStart(), fVar.getEndInclusive());
        }
    }

    boolean a(@i.c.a.d T t, @i.c.a.d T t2);

    @Override // h.v2.g
    boolean contains(@i.c.a.d T t);

    @Override // h.v2.g
    boolean isEmpty();
}

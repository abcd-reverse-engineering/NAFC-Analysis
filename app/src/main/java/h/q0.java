package h;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.io.Serializable;

/* compiled from: Result.kt */
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001e\u001fB\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", SurveyH5Bean.VALUE, "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", c.c.a.b.a.a.k0, "isSuccess-impl", "value$annotations", "()V", "equals", DispatchConstants.OTHER, "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class q0<T> implements Serializable {
    public static final a Companion = new a(null);

    @i.c.a.e
    private final Object value;

    /* compiled from: Result.kt */
    public static final class a {
        private a() {
        }

        @h.m2.f
        private final <T> Object a(T t) {
            return q0.m772constructorimpl(t);
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }

        @h.m2.f
        private final <T> Object a(Throwable th) {
            return q0.m772constructorimpl(r0.a(th));
        }
    }

    /* compiled from: Result.kt */
    public static final class b implements Serializable {

        @h.q2.c
        @i.c.a.d
        public final Throwable exception;

        public b(@i.c.a.d Throwable th) {
            h.q2.t.i0.f(th, "exception");
            this.exception = th;
        }

        public boolean equals(@i.c.a.e Object obj) {
            return (obj instanceof b) && h.q2.t.i0.a(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @i.c.a.d
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    @n0
    private /* synthetic */ q0(@i.c.a.e Object obj) {
        this.value = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final T a(Object obj) {
        if (m777isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @i.c.a.d
    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ q0 m771boximpl(@i.c.a.e Object obj) {
        return new q0(obj);
    }

    @n0
    @i.c.a.d
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m772constructorimpl(@i.c.a.e Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m773equalsimpl(Object obj, @i.c.a.e Object obj2) {
        return (obj2 instanceof q0) && h.q2.t.i0.a(obj, ((q0) obj2).m780unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m774equalsimpl0(@i.c.a.e Object obj, @i.c.a.e Object obj2) {
        return h.q2.t.i0.a(obj, obj2);
    }

    @i.c.a.e
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m775exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m776hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m777isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m778isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    @i.c.a.d
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m779toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    @n0
    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m773equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m776hashCodeimpl(this.value);
    }

    @i.c.a.d
    public String toString() {
        return m779toStringimpl(this.value);
    }

    @i.c.a.e
    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m780unboximpl() {
        return this.value;
    }
}

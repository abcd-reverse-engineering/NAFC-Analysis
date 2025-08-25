package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import h.b2;
import h.n1;
import h.t0;

/* compiled from: ULongRange.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/ULong;", "getStart", "contains", "", SurveyH5Bean.VALUE, "contains-VKZWuLQ", "(J)Z", "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@h.k
/* loaded from: classes2.dex */
public final class w extends u implements g<n1> {

    /* renamed from: f, reason: collision with root package name */
    public static final a f16562f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @i.c.a.d
    private static final w f16561e = new w(-1, 0, null);

    /* compiled from: ULongRange.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final w a() {
            return w.f16561e;
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    private w(long j2, long j3) {
        super(j2, j3, 1L, null);
    }

    public boolean a(long j2) {
        return b2.a(getFirst(), j2) <= 0 && b2.a(j2, getLast()) <= 0;
    }

    @Override // h.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((n1) comparable).a());
    }

    @Override // h.v2.u
    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof w) {
            if (!isEmpty() || !((w) obj).isEmpty()) {
                w wVar = (w) obj;
                if (getFirst() != wVar.getFirst() || getLast() != wVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.v2.u
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) n1.c(getLast() ^ n1.c(getLast() >>> 32))) + (((int) n1.c(getFirst() ^ n1.c(getFirst() >>> 32))) * 31);
    }

    @Override // h.v2.u, h.v2.g
    public boolean isEmpty() {
        return b2.a(getFirst(), getLast()) > 0;
    }

    @Override // h.v2.u
    @i.c.a.d
    public String toString() {
        return n1.n(getFirst()) + ".." + n1.n(getLast());
    }

    public /* synthetic */ w(long j2, long j3, h.q2.t.v vVar) {
        this(j2, j3);
    }

    @Override // h.v2.g
    @i.c.a.d
    public n1 getEndInclusive() {
        return n1.a(getLast());
    }

    @Override // h.v2.g
    @i.c.a.d
    public n1 getStart() {
        return n1.a(getFirst());
    }
}

package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import h.b2;
import h.j1;
import h.t0;

/* compiled from: UIntRange.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/UInt;", "getStart", "contains", "", SurveyH5Bean.VALUE, "contains-WZ4Q5Ns", "(I)Z", "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@h.k
/* loaded from: classes2.dex */
public final class t extends r implements g<j1> {

    /* renamed from: e, reason: collision with root package name */
    @i.c.a.d
    private static final t f16551e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16552f;

    /* compiled from: UIntRange.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final t a() {
            return t.f16551e;
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    static {
        h.q2.t.v vVar = null;
        f16552f = new a(vVar);
        f16551e = new t(-1, 0, vVar);
    }

    private t(int i2, int i3) {
        super(i2, i3, 1, null);
    }

    public boolean a(int i2) {
        return b2.a(getFirst(), i2) <= 0 && b2.a(i2, getLast()) <= 0;
    }

    @Override // h.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((j1) comparable).a());
    }

    @Override // h.v2.r
    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof t) {
            if (!isEmpty() || !((t) obj).isEmpty()) {
                t tVar = (t) obj;
                if (getFirst() != tVar.getFirst() || getLast() != tVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.v2.r
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // h.v2.r, h.v2.g
    public boolean isEmpty() {
        return b2.a(getFirst(), getLast()) > 0;
    }

    @Override // h.v2.r
    @i.c.a.d
    public String toString() {
        return j1.n(getFirst()) + ".." + j1.n(getLast());
    }

    public /* synthetic */ t(int i2, int i3, h.q2.t.v vVar) {
        this(i2, i3);
    }

    @Override // h.v2.g
    @i.c.a.d
    public j1 getEndInclusive() {
        return j1.a(getLast());
    }

    @Override // h.v2.g
    @i.c.a.d
    public j1 getStart() {
        return j1.a(getFirst());
    }
}

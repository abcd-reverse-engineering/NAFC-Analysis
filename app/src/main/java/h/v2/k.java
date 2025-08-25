package h.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;

/* compiled from: Ranges.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", SurveyH5Bean.VALUE, "equals", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class k extends i implements g<Integer> {

    /* renamed from: f, reason: collision with root package name */
    public static final a f16532f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @i.c.a.d
    private static final k f16531e = new k(1, 0);

    /* compiled from: Ranges.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final k a() {
            return k.f16531e;
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    public k(int i2, int i3) {
        super(i2, i3, 1);
    }

    public boolean a(int i2) {
        return getFirst() <= i2 && i2 <= getLast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).intValue());
    }

    @Override // h.v2.i
    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (getFirst() != kVar.getFirst() || getLast() != kVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.v2.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // h.v2.i, h.v2.g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // h.v2.i
    @i.c.a.d
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    @Override // h.v2.g
    @i.c.a.d
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // h.v2.g
    @i.c.a.d
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}

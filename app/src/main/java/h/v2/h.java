package h.v2;

import bean.SurveyH5Bean;
import h.q2.t.i0;
import h.v2.g;
import java.lang.Comparable;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
class h<T extends Comparable<? super T>> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final T f16521a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final T f16522b;

    public h(@i.c.a.d T t, @i.c.a.d T t2) {
        i0.f(t, "start");
        i0.f(t2, "endInclusive");
        this.f16521a = t;
        this.f16522b = t2;
    }

    @Override // h.v2.g
    public boolean contains(@i.c.a.d T t) {
        i0.f(t, SurveyH5Bean.VALUE);
        return g.a.a(this, t);
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!i0.a(getStart(), hVar.getStart()) || !i0.a(getEndInclusive(), hVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.v2.g
    @i.c.a.d
    public T getEndInclusive() {
        return this.f16522b;
    }

    @Override // h.v2.g
    @i.c.a.d
    public T getStart() {
        return this.f16521a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // h.v2.g
    public boolean isEmpty() {
        return g.a.a(this);
    }

    @i.c.a.d
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}

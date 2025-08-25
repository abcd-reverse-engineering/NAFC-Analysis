package h.z2;

import bean.SurveyH5Bean;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final String f16717a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final h.v2.k f16718b;

    public j(@i.c.a.d String str, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(str, SurveyH5Bean.VALUE);
        h.q2.t.i0.f(kVar, "range");
        this.f16717a = str;
        this.f16718b = kVar;
    }

    public static /* synthetic */ j a(j jVar, String str, h.v2.k kVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = jVar.f16717a;
        }
        if ((i2 & 2) != 0) {
            kVar = jVar.f16718b;
        }
        return jVar.a(str, kVar);
    }

    @i.c.a.d
    public final j a(@i.c.a.d String str, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(str, SurveyH5Bean.VALUE);
        h.q2.t.i0.f(kVar, "range");
        return new j(str, kVar);
    }

    @i.c.a.d
    public final String a() {
        return this.f16717a;
    }

    @i.c.a.d
    public final h.v2.k b() {
        return this.f16718b;
    }

    @i.c.a.d
    public final h.v2.k c() {
        return this.f16718b;
    }

    @i.c.a.d
    public final String d() {
        return this.f16717a;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return h.q2.t.i0.a((Object) this.f16717a, (Object) jVar.f16717a) && h.q2.t.i0.a(this.f16718b, jVar.f16718b);
    }

    public int hashCode() {
        String str = this.f16717a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        h.v2.k kVar = this.f16718b;
        return iHashCode + (kVar != null ? kVar.hashCode() : 0);
    }

    @i.c.a.d
    public String toString() {
        return "MatchGroup(value=" + this.f16717a + ", range=" + this.f16718b + ")";
    }
}

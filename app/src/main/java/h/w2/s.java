package h.w2;

import anet.channel.strategy.dispatch.DispatchConstants;
import h.q2.t.i0;
import h.t0;
import h.y;

/* compiled from: KType.kt */
@t0(version = "1.1")
@y(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", DispatchConstants.OTHER, "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private final t f16566a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.e
    private final q f16567b;

    /* renamed from: d, reason: collision with root package name */
    public static final a f16565d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @i.c.a.d
    private static final s f16564c = new s(null, null);

    /* compiled from: KType.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final s a() {
            return s.f16564c;
        }

        @i.c.a.d
        public final s b(@i.c.a.d q qVar) {
            i0.f(qVar, "type");
            return new s(t.OUT, qVar);
        }

        @i.c.a.d
        public final s c(@i.c.a.d q qVar) {
            i0.f(qVar, "type");
            return new s(t.INVARIANT, qVar);
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }

        @i.c.a.d
        public final s a(@i.c.a.d q qVar) {
            i0.f(qVar, "type");
            return new s(t.IN, qVar);
        }
    }

    public s(@i.c.a.e t tVar, @i.c.a.e q qVar) {
        this.f16566a = tVar;
        this.f16567b = qVar;
    }

    public static /* synthetic */ s a(s sVar, t tVar, q qVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            tVar = sVar.f16566a;
        }
        if ((i2 & 2) != 0) {
            qVar = sVar.f16567b;
        }
        return sVar.a(tVar, qVar);
    }

    @i.c.a.d
    public final s a(@i.c.a.e t tVar, @i.c.a.e q qVar) {
        return new s(tVar, qVar);
    }

    @i.c.a.e
    public final t a() {
        return this.f16566a;
    }

    @i.c.a.e
    public final q b() {
        return this.f16567b;
    }

    @i.c.a.e
    public final q c() {
        return this.f16567b;
    }

    @i.c.a.e
    public final t d() {
        return this.f16566a;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return i0.a(this.f16566a, sVar.f16566a) && i0.a(this.f16567b, sVar.f16567b);
    }

    public int hashCode() {
        t tVar = this.f16566a;
        int iHashCode = (tVar != null ? tVar.hashCode() : 0) * 31;
        q qVar = this.f16567b;
        return iHashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    @i.c.a.d
    public String toString() {
        return "KTypeProjection(variance=" + this.f16566a + ", type=" + this.f16567b + ")";
    }
}

package h.k2.l;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import h.e1;
import h.k2.l.e;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y;

/* compiled from: CoroutineContextImpl.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0000H\u0002J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J5\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0096\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\u001e\u001a\u00020\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\""}, d2 = {"Lkotlin/coroutines/experimental/CombinedContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "left", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/CoroutineContext$Element;)V", "getElement", "()Lkotlin/coroutines/experimental/CoroutineContext$Element;", "getLeft", "()Lkotlin/coroutines/experimental/CoroutineContext;", "contains", "", "containsAll", com.umeng.analytics.pro.d.R, "equals", DispatchConstants.OTHER, "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class b implements e {

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final e f16253b;

    /* renamed from: c, reason: collision with root package name */
    @i.c.a.d
    private final e.b f16254c;

    /* compiled from: CoroutineContextImpl.kt */
    static final class a extends j0 implements p<String, e.b, String> {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        @Override // h.q2.s.p
        @i.c.a.d
        public final String invoke(@i.c.a.d String str, @i.c.a.d e.b bVar) {
            i0.f(str, "acc");
            i0.f(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public b(@i.c.a.d e eVar, @i.c.a.d e.b bVar) {
        i0.f(eVar, "left");
        i0.f(bVar, "element");
        this.f16253b = eVar;
        this.f16254c = bVar;
    }

    private final int c() {
        e eVar = this.f16253b;
        if (eVar instanceof b) {
            return ((b) eVar).c() + 1;
        }
        return 2;
    }

    @i.c.a.d
    public final e.b a() {
        return this.f16254c;
    }

    @i.c.a.d
    public final e b() {
        return this.f16253b;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.c() != c() || !bVar.a(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // h.k2.l.e
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return pVar.invoke((Object) this.f16253b.fold(r, pVar), this.f16254c);
    }

    public int hashCode() {
        return this.f16253b.hashCode() + this.f16254c.hashCode();
    }

    @i.c.a.d
    public String toString() {
        return "[" + ((String) fold("", a.INSTANCE)) + "]";
    }

    @Override // h.k2.l.e
    @i.c.a.d
    public e a(@i.c.a.d e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return e.a.a(this, eVar);
    }

    @Override // h.k2.l.e
    @i.c.a.d
    public e b(@i.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        if (this.f16254c.a(cVar) != null) {
            return this.f16253b;
        }
        e eVarB = this.f16253b.b(cVar);
        return eVarB == this.f16253b ? this : eVarB == g.f16257b ? this.f16254c : new b(eVarB, this.f16254c);
    }

    @Override // h.k2.l.e
    @i.c.a.e
    public <E extends e.b> E a(@i.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        b bVar = this;
        while (true) {
            E e2 = (E) bVar.f16254c.a(cVar);
            if (e2 != null) {
                return e2;
            }
            e eVar = bVar.f16253b;
            if (eVar instanceof b) {
                bVar = (b) eVar;
            } else {
                return (E) eVar.a(cVar);
            }
        }
    }

    private final boolean a(e.b bVar) {
        return i0.a(a(bVar.getKey()), bVar);
    }

    private final boolean a(b bVar) {
        while (a(bVar.f16254c)) {
            e eVar = bVar.f16253b;
            if (!(eVar instanceof b)) {
                if (eVar != null) {
                    return a((e.b) eVar);
                }
                throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.CoroutineContext.Element");
            }
            bVar = (b) eVar;
        }
        return false;
    }
}

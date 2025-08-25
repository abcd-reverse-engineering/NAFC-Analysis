package h.k2;

import androidx.exifinterface.media.ExifInterface;
import h.e1;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.j0;
import h.t0;
import h.y;

/* compiled from: CoroutineContext.kt */
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", com.umeng.analytics.pro.d.R, "Element", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface g {

    /* compiled from: CoroutineContext.kt */
    public static final class a {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: h.k2.g$a$a, reason: collision with other inner class name */
        static final class C0242a extends j0 implements p<g, b, g> {
            public static final C0242a INSTANCE = new C0242a();

            C0242a() {
                super(2);
            }

            @Override // h.q2.s.p
            @i.c.a.d
            public final g invoke(@i.c.a.d g gVar, @i.c.a.d b bVar) {
                i0.f(gVar, "acc");
                i0.f(bVar, "element");
                g gVarMinusKey = gVar.minusKey(bVar.getKey());
                if (gVarMinusKey == i.INSTANCE) {
                    return bVar;
                }
                e eVar = (e) gVarMinusKey.get(e.V);
                if (eVar == null) {
                    return new h.k2.c(gVarMinusKey, bVar);
                }
                g gVarMinusKey2 = gVarMinusKey.minusKey(e.V);
                return gVarMinusKey2 == i.INSTANCE ? new h.k2.c(bVar, eVar) : new h.k2.c(new h.k2.c(gVarMinusKey2, bVar), eVar);
            }
        }

        @i.c.a.d
        public static g a(g gVar, @i.c.a.d g gVar2) {
            i0.f(gVar2, com.umeng.analytics.pro.d.R);
            return gVar2 == i.INSTANCE ? gVar : (g) gVar2.fold(gVar, C0242a.INSTANCE);
        }
    }

    /* compiled from: CoroutineContext.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    public interface b extends g {

        /* compiled from: CoroutineContext.kt */
        public static final class a {
            /* JADX WARN: Multi-variable type inference failed */
            @i.c.a.e
            public static <E extends b> E a(b bVar, @i.c.a.d c<E> cVar) {
                i0.f(cVar, "key");
                if (!i0.a(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new e1("null cannot be cast to non-null type E");
            }

            @i.c.a.d
            public static g a(b bVar, @i.c.a.d g gVar) {
                i0.f(gVar, com.umeng.analytics.pro.d.R);
                return a.a(bVar, gVar);
            }

            @i.c.a.d
            public static g b(b bVar, @i.c.a.d c<?> cVar) {
                i0.f(cVar, "key");
                return i0.a(bVar.getKey(), cVar) ? i.INSTANCE : bVar;
            }

            public static <R> R a(b bVar, R r, @i.c.a.d p<? super R, ? super b, ? extends R> pVar) {
                i0.f(pVar, "operation");
                return pVar.invoke(r, bVar);
            }
        }

        @Override // h.k2.g
        <R> R fold(R r, @i.c.a.d p<? super R, ? super b, ? extends R> pVar);

        @Override // h.k2.g
        @i.c.a.e
        <E extends b> E get(@i.c.a.d c<E> cVar);

        @i.c.a.d
        c<?> getKey();

        @Override // h.k2.g
        @i.c.a.d
        g minusKey(@i.c.a.d c<?> cVar);
    }

    /* compiled from: CoroutineContext.kt */
    public interface c<E extends b> {
    }

    <R> R fold(R r, @i.c.a.d p<? super R, ? super b, ? extends R> pVar);

    @i.c.a.e
    <E extends b> E get(@i.c.a.d c<E> cVar);

    @i.c.a.d
    g minusKey(@i.c.a.d c<?> cVar);

    @i.c.a.d
    g plus(@i.c.a.d g gVar);
}

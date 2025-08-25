package h.k2;

import androidx.exifinterface.media.ExifInterface;
import h.e1;
import h.k2.g;
import h.q2.s.p;
import h.q2.t.i0;
import h.t0;
import h.y;

/* compiled from: ContinuationInterceptor.kt */
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface e extends g.b {
    public static final b V = b.f16245a;

    /* compiled from: ContinuationInterceptor.kt */
    public static final class a {
        @i.c.a.e
        public static <E extends g.b> E a(e eVar, @i.c.a.d g.c<E> cVar) {
            i0.f(cVar, "key");
            if (!(cVar instanceof h.k2.b)) {
                if (e.V != cVar) {
                    return null;
                }
                if (eVar != null) {
                    return eVar;
                }
                throw new e1("null cannot be cast to non-null type E");
            }
            h.k2.b bVar = (h.k2.b) cVar;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e2 = (E) bVar.a(eVar);
            if (e2 instanceof g.b) {
                return e2;
            }
            return null;
        }

        @i.c.a.d
        public static g a(e eVar, @i.c.a.d g gVar) {
            i0.f(gVar, com.umeng.analytics.pro.d.R);
            return g.b.a.a(eVar, gVar);
        }

        public static <R> R a(e eVar, R r, @i.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
            i0.f(pVar, "operation");
            return (R) g.b.a.a(eVar, r, pVar);
        }

        public static void a(e eVar, @i.c.a.d d<?> dVar) {
            i0.f(dVar, "continuation");
        }

        @i.c.a.d
        public static g b(e eVar, @i.c.a.d g.c<?> cVar) {
            i0.f(cVar, "key");
            if (!(cVar instanceof h.k2.b)) {
                return e.V == cVar ? i.INSTANCE : eVar;
            }
            h.k2.b bVar = (h.k2.b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.a(eVar) == null) ? eVar : i.INSTANCE;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    public static final class b implements g.c<e> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f16245a = new b();

        private b() {
        }
    }

    void a(@i.c.a.d d<?> dVar);

    @i.c.a.d
    <T> d<T> b(@i.c.a.d d<? super T> dVar);

    @Override // h.k2.g.b, h.k2.g
    @i.c.a.e
    <E extends g.b> E get(@i.c.a.d g.c<E> cVar);

    @Override // h.k2.g.b, h.k2.g
    @i.c.a.d
    g minusKey(@i.c.a.d g.c<?> cVar);
}

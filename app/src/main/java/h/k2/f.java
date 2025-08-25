package h.k2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.tencent.open.SocialConstants;
import h.a0;
import h.q0;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.t.f0;
import h.q2.t.i0;
import h.r0;
import h.t0;
import h.y;
import h.y1;

/* compiled from: Continuation.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a<\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00012\u001a\b\u0004\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\f\u0012\u0004\u0012\u00020\r0\u000bH\u0087\bø\u0001\u0000\u001a3\u0010\u000e\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u001a\b\u0004\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0004\u0012\u00020\r0\u000bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\r\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0006\u0010\u001b\u001a\u0002H\bH\u0087\b¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\r\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\b\u001a>\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010!\u001aW\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\"\u001b\u0010\u0000\u001a\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, com.umeng.analytics.pro.d.R, "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", SurveyH5Bean.VALUE, "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Continuation.kt */
    public static final class a<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f16246a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f16247b;

        public a(g gVar, l lVar) {
            this.f16246a = gVar;
            this.f16247b = lVar;
        }

        @Override // h.k2.d
        @i.c.a.d
        public g getContext() {
            return this.f16246a;
        }

        @Override // h.k2.d
        public void resumeWith(@i.c.a.d Object obj) {
            this.f16247b.invoke(q0.m771boximpl(obj));
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    public static /* synthetic */ void a() {
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> void a(@i.c.a.d d<? super T> dVar, T t) {
        q0.a aVar = q0.Companion;
        dVar.resumeWith(q0.m772constructorimpl(t));
    }

    @t0(version = "1.3")
    public static final <T> void b(@i.c.a.d l<? super d<? super T>, ? extends Object> lVar, @i.c.a.d d<? super T> dVar) {
        i0.f(lVar, "$this$startCoroutine");
        i0.f(dVar, "completion");
        d dVarA = h.k2.m.c.a(h.k2.m.c.a(lVar, dVar));
        y1 y1Var = y1.f16671a;
        q0.a aVar = q0.Companion;
        dVarA.resumeWith(q0.m772constructorimpl(y1Var));
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> Object c(l<? super d<? super T>, y1> lVar, d<? super T> dVar) throws Throwable {
        f0.c(0);
        k kVar = new k(h.k2.m.c.a(dVar));
        lVar.invoke(kVar);
        Object objA = kVar.a();
        if (objA == h.k2.m.d.b()) {
            h.k2.n.a.h.c(dVar);
        }
        f0.c(1);
        return objA;
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> void a(@i.c.a.d d<? super T> dVar, Throwable th) {
        q0.a aVar = q0.Companion;
        dVar.resumeWith(q0.m772constructorimpl(r0.a(th)));
    }

    @t0(version = "1.3")
    public static final <R, T> void b(@i.c.a.d p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, @i.c.a.d d<? super T> dVar) {
        i0.f(pVar, "$this$startCoroutine");
        i0.f(dVar, "completion");
        d dVarA = h.k2.m.c.a(h.k2.m.c.a(pVar, r, dVar));
        y1 y1Var = y1.f16671a;
        q0.a aVar = q0.Companion;
        dVarA.resumeWith(q0.m772constructorimpl(y1Var));
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> d<T> a(g gVar, l<? super q0<? extends T>, y1> lVar) {
        return new a(gVar, lVar);
    }

    private static final g b() {
        throw new a0("Implemented as intrinsic");
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> d<y1> a(@i.c.a.d l<? super d<? super T>, ? extends Object> lVar, @i.c.a.d d<? super T> dVar) {
        i0.f(lVar, "$this$createCoroutine");
        i0.f(dVar, "completion");
        return new k(h.k2.m.c.a(h.k2.m.c.a(lVar, dVar)), h.k2.m.d.b());
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <R, T> d<y1> a(@i.c.a.d p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, @i.c.a.d d<? super T> dVar) {
        i0.f(pVar, "$this$createCoroutine");
        i0.f(dVar, "completion");
        return new k(h.k2.m.c.a(h.k2.m.c.a(pVar, r, dVar)), h.k2.m.d.b());
    }
}

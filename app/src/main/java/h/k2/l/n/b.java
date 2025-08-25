package h.k2.l.n;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.tencent.open.SocialConstants;
import h.e1;
import h.k2.l.e;
import h.m2.f;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.n1;
import h.t0;
import h.y;
import h.y1;
import i.c.a.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u0010\b\u0004\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0082\b¢\u0006\u0002\b\r\u001aD\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\t*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a]\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\t*#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aA\u0010\u0016\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\t*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aZ\u0010\u0016\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\t*#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u001a\u0010\u0000\u001a\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u0019"}, d2 = {"COROUTINE_SUSPENDED", "", "COROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "buildContinuationByInvokeCall", "Lkotlin/coroutines/experimental/Continuation;", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "block", "Lkotlin/Function0;", "buildContinuationByInvokeCall$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnchecked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/coroutines/experimental/intrinsics/IntrinsicsKt")
/* loaded from: classes2.dex */
public class b {

    /* compiled from: IntrinsicsJvm.kt */
    public static final class a implements h.k2.l.c<y1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.k2.l.c f16276a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.q2.s.a f16277b;

        public a(h.k2.l.c cVar, h.q2.s.a aVar) {
            this.f16276a = cVar;
            this.f16277b = aVar;
        }

        @Override // h.k2.l.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void resume(@d y1 y1Var) {
            i0.f(y1Var, SurveyH5Bean.VALUE);
            h.k2.l.c cVar = this.f16276a;
            try {
                Object objInvoke = this.f16277b.invoke();
                if (objInvoke != b.b()) {
                    if (cVar == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                    }
                    cVar.resume(objInvoke);
                }
            } catch (Throwable th) {
                cVar.resumeWithException(th);
            }
        }

        @Override // h.k2.l.c
        @d
        public e getContext() {
            return this.f16276a.getContext();
        }

        @Override // h.k2.l.c
        public void resumeWithException(@d Throwable th) {
            i0.f(th, "exception");
            this.f16276a.resumeWithException(th);
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.l.n.b$b, reason: collision with other inner class name */
    public static final class C0244b implements h.k2.l.c<y1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.k2.l.c f16278a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f16279b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.k2.l.c f16280c;

        public C0244b(h.k2.l.c cVar, l lVar, h.k2.l.c cVar2) {
            this.f16278a = cVar;
            this.f16279b = lVar;
            this.f16280c = cVar2;
        }

        @Override // h.k2.l.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void resume(@d y1 y1Var) {
            i0.f(y1Var, SurveyH5Bean.VALUE);
            h.k2.l.c cVar = this.f16278a;
            try {
                l lVar = this.f16279b;
                if (lVar == null) {
                    throw new e1("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
                }
                Object objInvoke = ((l) n1.a(lVar, 1)).invoke(this.f16280c);
                if (objInvoke != b.b()) {
                    if (cVar == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                    }
                    cVar.resume(objInvoke);
                }
            } catch (Throwable th) {
                cVar.resumeWithException(th);
            }
        }

        @Override // h.k2.l.c
        @d
        public e getContext() {
            return this.f16278a.getContext();
        }

        @Override // h.k2.l.c
        public void resumeWithException(@d Throwable th) {
            i0.f(th, "exception");
            this.f16278a.resumeWithException(th);
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class c implements h.k2.l.c<y1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.k2.l.c f16281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f16282b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f16283c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.k2.l.c f16284d;

        public c(h.k2.l.c cVar, p pVar, Object obj, h.k2.l.c cVar2) {
            this.f16281a = cVar;
            this.f16282b = pVar;
            this.f16283c = obj;
            this.f16284d = cVar2;
        }

        @Override // h.k2.l.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void resume(@d y1 y1Var) {
            i0.f(y1Var, SurveyH5Bean.VALUE);
            h.k2.l.c cVar = this.f16281a;
            try {
                p pVar = this.f16282b;
                if (pVar == null) {
                    throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
                }
                Object objInvoke = ((p) n1.a(pVar, 2)).invoke(this.f16283c, this.f16284d);
                if (objInvoke != b.b()) {
                    if (cVar == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                    }
                    cVar.resume(objInvoke);
                }
            } catch (Throwable th) {
                cVar.resumeWithException(th);
            }
        }

        @Override // h.k2.l.c
        @d
        public e getContext() {
            return this.f16281a.getContext();
        }

        @Override // h.k2.l.c
        public void resumeWithException(@d Throwable th) {
            i0.f(th, "exception");
            this.f16281a.resumeWithException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.1")
    @d
    public static <T> h.k2.l.c<y1> a(@d l<? super h.k2.l.c<? super T>, ? extends Object> lVar, @d h.k2.l.c<? super T> cVar) {
        i0.f(lVar, "$this$createCoroutineUnchecked");
        i0.f(cVar, "completion");
        if (!(lVar instanceof h.k2.l.o.a.a)) {
            return h.k2.l.o.a.b.a(cVar.getContext(), new C0244b(cVar, lVar, cVar));
        }
        h.k2.l.c<y1> cVarCreate = ((h.k2.l.o.a.a) lVar).create(cVar);
        if (cVarCreate != null) {
            return ((h.k2.l.o.a.a) cVarCreate).getFacade();
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
    }

    @t0(version = "1.1")
    public static /* synthetic */ void a() {
    }

    @f
    @t0(version = "1.1")
    private static final <T> Object b(@d l<? super h.k2.l.c<? super T>, ? extends Object> lVar, h.k2.l.c<? super T> cVar) {
        if (lVar != null) {
            return ((l) n1.a(lVar, 1)).invoke(cVar);
        }
        throw new e1("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
    }

    @f
    @t0(version = "1.1")
    private static final <R, T> Object b(@d p<? super R, ? super h.k2.l.c<? super T>, ? extends Object> pVar, R r, h.k2.l.c<? super T> cVar) {
        if (pVar != null) {
            return ((p) n1.a(pVar, 2)).invoke(r, cVar);
        }
        throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
    }

    @d
    public static Object b() {
        return h.k2.m.d.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.1")
    @d
    public static <R, T> h.k2.l.c<y1> a(@d p<? super R, ? super h.k2.l.c<? super T>, ? extends Object> pVar, R r, @d h.k2.l.c<? super T> cVar) {
        i0.f(pVar, "$this$createCoroutineUnchecked");
        i0.f(cVar, "completion");
        if (!(pVar instanceof h.k2.l.o.a.a)) {
            return h.k2.l.o.a.b.a(cVar.getContext(), new c(cVar, pVar, r, cVar));
        }
        h.k2.l.c<y1> cVarCreate = ((h.k2.l.o.a.a) pVar).create(r, cVar);
        if (cVarCreate != null) {
            return ((h.k2.l.o.a.a) cVarCreate).getFacade();
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
    }

    private static final <T> h.k2.l.c<y1> a(h.k2.l.c<? super T> cVar, h.q2.s.a<? extends Object> aVar) {
        return h.k2.l.o.a.b.a(cVar.getContext(), new a(cVar, aVar));
    }
}

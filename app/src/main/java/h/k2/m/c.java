package h.k2.m;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import h.e1;
import h.k2.g;
import h.k2.i;
import h.k2.n.a.h;
import h.k2.n.a.j;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.n1;
import h.r0;
import h.t0;
import h.y;
import h.y1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: classes2.dex */
public class c {

    /* compiled from: IntrinsicsJvm.kt */
    public static final class a extends j {
        final /* synthetic */ l $block;
        final /* synthetic */ h.k2.d $completion;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, h.k2.d dVar, h.k2.d dVar2) {
            super(dVar2);
            this.$block = lVar;
            this.$completion = dVar;
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        protected Object invokeSuspend(@i.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                r0.b(obj);
                return this.$block.invoke(this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            r0.b(obj);
            return obj;
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class b extends h.k2.n.a.d {
        final /* synthetic */ l $block;
        final /* synthetic */ h.k2.d $completion;
        final /* synthetic */ g $context;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, h.k2.d dVar, g gVar, h.k2.d dVar2, g gVar2) {
            super(dVar2, gVar2);
            this.$block = lVar;
            this.$completion = dVar;
            this.$context = gVar;
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        protected Object invokeSuspend(@i.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                r0.b(obj);
                return this.$block.invoke(this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            r0.b(obj);
            return obj;
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$c, reason: collision with other inner class name */
    public static final class C0246c extends j {
        final /* synthetic */ h.k2.d $completion;
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0246c(h.k2.d dVar, h.k2.d dVar2, l lVar) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        protected Object invokeSuspend(@i.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            l lVar = this.$this_createCoroutineUnintercepted$inlined;
            if (lVar != null) {
                return ((l) n1.a(lVar, 1)).invoke(this);
            }
            throw new e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class d extends h.k2.n.a.d {
        final /* synthetic */ h.k2.d $completion;
        final /* synthetic */ g $context;
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h.k2.d dVar, g gVar, h.k2.d dVar2, g gVar2, l lVar) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        protected Object invokeSuspend(@i.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            l lVar = this.$this_createCoroutineUnintercepted$inlined;
            if (lVar != null) {
                return ((l) n1.a(lVar, 1)).invoke(this);
            }
            throw new e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class e extends j {
        final /* synthetic */ h.k2.d $completion;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h.k2.d dVar, h.k2.d dVar2, p pVar, Object obj) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        protected Object invokeSuspend(@i.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            p pVar = this.$this_createCoroutineUnintercepted$inlined;
            if (pVar != null) {
                return ((p) n1.a(pVar, 2)).invoke(this.$receiver$inlined, this);
            }
            throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class f extends h.k2.n.a.d {
        final /* synthetic */ h.k2.d $completion;
        final /* synthetic */ g $context;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h.k2.d dVar, g gVar, h.k2.d dVar2, g gVar2, p pVar, Object obj) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        protected Object invokeSuspend(@i.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            p pVar = this.$this_createCoroutineUnintercepted$inlined;
            if (pVar != null) {
                return ((p) n1.a(pVar, 2)).invoke(this.$receiver$inlined, this);
            }
            throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @i.c.a.d
    public static <T> h.k2.d<y1> a(@i.c.a.d l<? super h.k2.d<? super T>, ? extends Object> lVar, @i.c.a.d h.k2.d<? super T> dVar) {
        i0.f(lVar, "$this$createCoroutineUnintercepted");
        i0.f(dVar, "completion");
        h.k2.d<?> dVarA = h.a(dVar);
        if (lVar instanceof h.k2.n.a.a) {
            return ((h.k2.n.a.a) lVar).create(dVarA);
        }
        g context = dVarA.getContext();
        if (context == i.INSTANCE) {
            if (dVarA != null) {
                return new C0246c(dVarA, dVarA, lVar);
            }
            throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVarA != null) {
            return new d(dVarA, context, dVarA, context, lVar);
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> Object b(@i.c.a.d l<? super h.k2.d<? super T>, ? extends Object> lVar, h.k2.d<? super T> dVar) {
        if (lVar != null) {
            return ((l) n1.a(lVar, 1)).invoke(dVar);
        }
        throw new e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T> Object b(@i.c.a.d p<? super R, ? super h.k2.d<? super T>, ? extends Object> pVar, R r, h.k2.d<? super T> dVar) {
        if (pVar != null) {
            return ((p) n1.a(pVar, 2)).invoke(r, dVar);
        }
        throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @i.c.a.d
    public static <R, T> h.k2.d<y1> a(@i.c.a.d p<? super R, ? super h.k2.d<? super T>, ? extends Object> pVar, R r, @i.c.a.d h.k2.d<? super T> dVar) {
        i0.f(pVar, "$this$createCoroutineUnintercepted");
        i0.f(dVar, "completion");
        h.k2.d<?> dVarA = h.a(dVar);
        if (pVar instanceof h.k2.n.a.a) {
            return ((h.k2.n.a.a) pVar).create(r, dVarA);
        }
        g context = dVarA.getContext();
        if (context == i.INSTANCE) {
            if (dVarA != null) {
                return new e(dVarA, dVarA, pVar, r);
            }
            throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVarA != null) {
            return new f(dVarA, context, dVarA, context, pVar, r);
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @i.c.a.d
    public static <T> h.k2.d<T> a(@i.c.a.d h.k2.d<? super T> dVar) {
        h.k2.d<T> dVar2;
        i0.f(dVar, "$this$intercepted");
        h.k2.n.a.d dVar3 = !(dVar instanceof h.k2.n.a.d) ? null : dVar;
        return (dVar3 == null || (dVar2 = (h.k2.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }

    @t0(version = "1.3")
    private static final <T> h.k2.d<y1> a(h.k2.d<? super T> dVar, l<? super h.k2.d<? super T>, ? extends Object> lVar) {
        g context = dVar.getContext();
        if (context == i.INSTANCE) {
            if (dVar != null) {
                return new a(lVar, dVar, dVar);
            }
            throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVar != null) {
            return new b(lVar, dVar, context, dVar, context);
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
}

package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.c1;
import h.q2.t.i0;
import h.q2.t.j0;
import h.r0;
import h.t0;
import h.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0010\"\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00050\u000bH\u0002¢\u0006\u0002\b\u0016\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0007¢\u0006\u0002\b\u0018\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a@\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001e0\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00150\u001d0\u0001¨\u0006\u001f"}, d2 = {"Sequence", "Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes2.dex */
public class s extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class a<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.a f16629a;

        public a(h.q2.s.a aVar) {
            this.f16629a = aVar;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<T> iterator() {
            return (Iterator) this.f16629a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class b<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f16630a;

        public b(Iterator it) {
            this.f16630a = it;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<T> iterator() {
            return this.f16630a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    static final class c<T> extends j0 implements h.q2.s.l<m<? extends T>, Iterator<? extends T>> {
        public static final c INSTANCE = new c();

        c() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final Iterator<T> invoke(@i.c.a.d m<? extends T> mVar) {
            i0.f(mVar, "it");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    static final class d<T> extends j0 implements h.q2.s.l<Iterable<? extends T>, Iterator<? extends T>> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final Iterator<T> invoke(@i.c.a.d Iterable<? extends T> iterable) {
            i0.f(iterable, "it");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    static final class e<T> extends j0 implements h.q2.s.l<T, T> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        @Override // h.q2.s.l
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    static final class f<T> extends j0 implements h.q2.s.l<T, T> {
        final /* synthetic */ h.q2.s.a $nextFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(h.q2.s.a aVar) {
            super(1);
            this.$nextFunction = aVar;
        }

        @Override // h.q2.s.l
        @i.c.a.e
        public final T invoke(@i.c.a.d T t) {
            i0.f(t, "it");
            return (T) this.$nextFunction.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    static final class g<T> extends j0 implements h.q2.s.a<T> {
        final /* synthetic */ Object $seed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Object obj) {
            super(0);
            this.$seed = obj;
        }

        @Override // h.q2.s.a
        @i.c.a.e
        public final T invoke() {
            return (T) this.$seed;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @h.k2.n.a.f(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {0, 0, 1, 1}, l = {67, 69}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class h<T> extends h.k2.n.a.k implements h.q2.s.p<o<? super T>, h.k2.d<? super y1>, Object> {
        final /* synthetic */ h.q2.s.a $defaultValue;
        final /* synthetic */ m $this_ifEmpty;
        Object L$0;
        Object L$1;
        int label;
        private o p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(m mVar, h.q2.s.a aVar, h.k2.d dVar) {
            super(2, dVar);
            this.$this_ifEmpty = mVar;
            this.$defaultValue = aVar;
        }

        @Override // h.k2.n.a.a
        @i.c.a.d
        public final h.k2.d<y1> create(@i.c.a.e Object obj, @i.c.a.d h.k2.d<?> dVar) {
            i0.f(dVar, "completion");
            h hVar = new h(this.$this_ifEmpty, this.$defaultValue, dVar);
            hVar.p$ = (o) obj;
            return hVar;
        }

        @Override // h.q2.s.p
        public final Object invoke(Object obj, h.k2.d<? super y1> dVar) {
            return ((h) create(obj, dVar)).invokeSuspend(y1.f16671a);
        }

        @Override // h.k2.n.a.a
        @i.c.a.e
        public final Object invokeSuspend(@i.c.a.d Object obj) {
            Object objB = h.k2.m.d.b();
            int i2 = this.label;
            if (i2 == 0) {
                r0.b(obj);
                o oVar = this.p$;
                Iterator<? extends T> it = this.$this_ifEmpty.iterator();
                if (it.hasNext()) {
                    this.L$0 = oVar;
                    this.L$1 = it;
                    this.label = 1;
                    if (oVar.a((Iterator) it, (h.k2.d<? super y1>) this) == objB) {
                        return objB;
                    }
                } else {
                    m<? extends T> mVar = (m) this.$defaultValue.invoke();
                    this.L$0 = oVar;
                    this.L$1 = it;
                    this.label = 2;
                    if (oVar.a((m) mVar, (h.k2.d<? super y1>) this) == objB) {
                        return objB;
                    }
                }
            } else {
                if (i2 != 1 && i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r0.b(obj);
            }
            return y1.f16671a;
        }
    }

    @h.m2.f
    private static final <T> m<T> a(h.q2.s.a<? extends Iterator<? extends T>> aVar) {
        return new a(aVar);
    }

    @i.c.a.d
    public static <T> m<T> b() {
        return h.x2.g.f16588a;
    }

    @h.q2.e(name = "flattenSequenceOfIterable")
    @i.c.a.d
    public static final <T> m<T> c(@i.c.a.d m<? extends Iterable<? extends T>> mVar) {
        i0.f(mVar, "$this$flatten");
        return a((m) mVar, (h.q2.s.l) d.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    @t0(version = "1.3")
    private static final <T> m<T> d(@i.c.a.e m<? extends T> mVar) {
        return mVar != 0 ? mVar : b();
    }

    @i.c.a.d
    public static final <T, R> h.i0<List<T>, List<R>> e(@i.c.a.d m<? extends h.i0<? extends T, ? extends R>> mVar) {
        i0.f(mVar, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (h.i0<? extends T, ? extends R> i0Var : mVar) {
            arrayList.add(i0Var.getFirst());
            arrayList2.add(i0Var.getSecond());
        }
        return c1.a(arrayList, arrayList2);
    }

    @i.c.a.d
    public static final <T> m<T> a(@i.c.a.d Iterator<? extends T> it) {
        i0.f(it, "$this$asSequence");
        return a(new b(it));
    }

    @i.c.a.d
    public static final <T> m<T> b(@i.c.a.d m<? extends m<? extends T>> mVar) {
        i0.f(mVar, "$this$flatten");
        return a((m) mVar, (h.q2.s.l) c.INSTANCE);
    }

    @i.c.a.d
    public static final <T> m<T> a(@i.c.a.d T... tArr) {
        i0.f(tArr, "elements");
        return tArr.length == 0 ? b() : h.g2.r.g((Object[]) tArr);
    }

    @i.c.a.d
    public static final <T> m<T> b(@i.c.a.d h.q2.s.a<? extends T> aVar) {
        i0.f(aVar, "nextFunction");
        return a(new j(aVar, new f(aVar)));
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> m<T> a(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.q2.s.a<? extends m<? extends T>> aVar) {
        i0.f(mVar, "$this$ifEmpty");
        i0.f(aVar, "defaultValue");
        return q.d(new h(mVar, aVar, null));
    }

    private static final <T, R> m<R> a(@i.c.a.d m<? extends T> mVar, h.q2.s.l<? super T, ? extends Iterator<? extends R>> lVar) {
        if (mVar instanceof z) {
            return ((z) mVar).a(lVar);
        }
        return new i(mVar, e.INSTANCE, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static <T> m<T> a(@i.c.a.d m<? extends T> mVar) {
        i0.f(mVar, "$this$constrainOnce");
        return mVar instanceof h.x2.a ? mVar : new h.x2.a(mVar);
    }

    @h.m2.g
    @i.c.a.d
    public static final <T> m<T> a(@i.c.a.e T t, @i.c.a.d h.q2.s.l<? super T, ? extends T> lVar) {
        i0.f(lVar, "nextFunction");
        if (t == null) {
            return h.x2.g.f16588a;
        }
        return new j(new g(t), lVar);
    }

    @i.c.a.d
    public static <T> m<T> a(@i.c.a.d h.q2.s.a<? extends T> aVar, @i.c.a.d h.q2.s.l<? super T, ? extends T> lVar) {
        i0.f(aVar, "seedFunction");
        i0.f(lVar, "nextFunction");
        return new j(aVar, lVar);
    }
}

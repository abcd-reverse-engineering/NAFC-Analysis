package h.k2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import h.e1;
import h.k2.g;
import h.q2.s.p;
import h.q2.t.g1;
import h.q2.t.i0;
import h.q2.t.j0;
import h.q2.t.v;
import h.t0;
import h.y;
import h.y1;
import java.io.Serializable;

/* compiled from: CoroutineContextImpl.kt */
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", com.umeng.analytics.pro.d.R, "equals", DispatchConstants.OTHER, "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class c implements g, Serializable {
    private final g.b element;
    private final g left;

    /* compiled from: CoroutineContextImpl.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    private static final class a implements Serializable {
        public static final C0240a Companion = new C0240a(null);
        private static final long serialVersionUID = 0;

        @i.c.a.d
        private final g[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: h.k2.c$a$a, reason: collision with other inner class name */
        public static final class C0240a {
            private C0240a() {
            }

            public /* synthetic */ C0240a(v vVar) {
                this();
            }
        }

        public a(@i.c.a.d g[] gVarArr) {
            i0.f(gVarArr, "elements");
            this.elements = gVarArr;
        }

        private final Object readResolve() {
            g[] gVarArr = this.elements;
            g gVarPlus = i.INSTANCE;
            for (g gVar : gVarArr) {
                gVarPlus = gVarPlus.plus(gVar);
            }
            return gVarPlus;
        }

        @i.c.a.d
        public final g[] getElements() {
            return this.elements;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    static final class b extends j0 implements p<String, g.b, String> {
        public static final b INSTANCE = new b();

        b() {
            super(2);
        }

        @Override // h.q2.s.p
        @i.c.a.d
        public final String invoke(@i.c.a.d String str, @i.c.a.d g.b bVar) {
            i0.f(str, "acc");
            i0.f(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: h.k2.c$c, reason: collision with other inner class name */
    static final class C0241c extends j0 implements p<y1, g.b, y1> {
        final /* synthetic */ g[] $elements;
        final /* synthetic */ g1.f $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0241c(g[] gVarArr, g1.f fVar) {
            super(2);
            this.$elements = gVarArr;
            this.$index = fVar;
        }

        @Override // h.q2.s.p
        public /* bridge */ /* synthetic */ y1 invoke(y1 y1Var, g.b bVar) {
            invoke2(y1Var, bVar);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@i.c.a.d y1 y1Var, @i.c.a.d g.b bVar) {
            i0.f(y1Var, "<anonymous parameter 0>");
            i0.f(bVar, "element");
            g[] gVarArr = this.$elements;
            g1.f fVar = this.$index;
            int i2 = fVar.element;
            fVar.element = i2 + 1;
            gVarArr[i2] = bVar;
        }
    }

    public c(@i.c.a.d g gVar, @i.c.a.d g.b bVar) {
        i0.f(gVar, "left");
        i0.f(bVar, "element");
        this.left = gVar;
        this.element = bVar;
    }

    private final int a() {
        int i2 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.left;
            if (!(gVar instanceof c)) {
                gVar = null;
            }
            cVar = (c) gVar;
            if (cVar == null) {
                return i2;
            }
            i2++;
        }
    }

    private final Object writeReplace() {
        int iA = a();
        g[] gVarArr = new g[iA];
        g1.f fVar = new g1.f();
        fVar.element = 0;
        fold(y1.f16671a, new C0241c(gVarArr, fVar));
        if (fVar.element == iA) {
            return new a(gVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.a() != a() || !cVar.a(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // h.k2.g
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return pVar.invoke((Object) this.left.fold(r, pVar), this.element);
    }

    @Override // h.k2.g
    @i.c.a.e
    public <E extends g.b> E get(@i.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        c cVar2 = this;
        while (true) {
            E e2 = (E) cVar2.element.get(cVar);
            if (e2 != null) {
                return e2;
            }
            g gVar = cVar2.left;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(cVar);
            }
            cVar2 = (c) gVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // h.k2.g
    @i.c.a.d
    public g minusKey(@i.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        g gVarMinusKey = this.left.minusKey(cVar);
        return gVarMinusKey == this.left ? this : gVarMinusKey == i.INSTANCE ? this.element : new c(gVarMinusKey, this.element);
    }

    @Override // h.k2.g
    @i.c.a.d
    public g plus(@i.c.a.d g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return g.a.a(this, gVar);
    }

    @i.c.a.d
    public String toString() {
        return "[" + ((String) fold("", b.INSTANCE)) + "]";
    }

    private final boolean a(g.b bVar) {
        return i0.a(get(bVar.getKey()), bVar);
    }

    private final boolean a(c cVar) {
        while (a(cVar.element)) {
            g gVar = cVar.left;
            if (!(gVar instanceof c)) {
                if (gVar != null) {
                    return a((g.b) gVar);
                }
                throw new e1("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            cVar = (c) gVar;
        }
        return false;
    }
}

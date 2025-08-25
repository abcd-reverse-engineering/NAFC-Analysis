package h.z2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.e1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Strings.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class h implements h.x2.m<h.v2.k> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f16694a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16695b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16696c;

    /* renamed from: d, reason: collision with root package name */
    private final h.q2.s.p<CharSequence, Integer, h.i0<Integer, Integer>> f16697d;

    /* compiled from: Strings.kt */
    public static final class a implements Iterator<h.v2.k>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        private int f16698a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f16699b;

        /* renamed from: c, reason: collision with root package name */
        private int f16700c;

        /* renamed from: d, reason: collision with root package name */
        @i.c.a.e
        private h.v2.k f16701d;

        /* renamed from: e, reason: collision with root package name */
        private int f16702e;

        a() {
            this.f16699b = h.v2.q.a(h.this.f16695b, 0, h.this.f16694a.length());
            this.f16700c = this.f16699b;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void g() {
            /*
                r6 = this;
                int r0 = r6.f16700c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f16698a = r1
                r0 = 0
                r6.f16701d = r0
                goto La2
            Lc:
                h.z2.h r0 = h.z2.h.this
                int r0 = h.z2.h.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L25
                int r0 = r6.f16702e
                int r0 = r0 + r3
                r6.f16702e = r0
                int r0 = r6.f16702e
                h.z2.h r4 = h.z2.h.this
                int r4 = h.z2.h.c(r4)
                if (r0 >= r4) goto L33
            L25:
                int r0 = r6.f16700c
                h.z2.h r4 = h.z2.h.this
                java.lang.CharSequence r4 = h.z2.h.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L49
            L33:
                int r0 = r6.f16699b
                h.v2.k r1 = new h.v2.k
                h.z2.h r4 = h.z2.h.this
                java.lang.CharSequence r4 = h.z2.h.b(r4)
                int r4 = h.z2.c0.c(r4)
                r1.<init>(r0, r4)
                r6.f16701d = r1
                r6.f16700c = r2
                goto La0
            L49:
                h.z2.h r0 = h.z2.h.this
                h.q2.s.p r0 = h.z2.h.a(r0)
                h.z2.h r4 = h.z2.h.this
                java.lang.CharSequence r4 = h.z2.h.b(r4)
                int r5 = r6.f16700c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                h.i0 r0 = (h.i0) r0
                if (r0 != 0) goto L79
                int r0 = r6.f16699b
                h.v2.k r1 = new h.v2.k
                h.z2.h r4 = h.z2.h.this
                java.lang.CharSequence r4 = h.z2.h.b(r4)
                int r4 = h.z2.c0.c(r4)
                r1.<init>(r0, r4)
                r6.f16701d = r1
                r6.f16700c = r2
                goto La0
            L79:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f16699b
                h.v2.k r4 = h.v2.o.d(r4, r2)
                r6.f16701d = r4
                int r2 = r2 + r0
                r6.f16699b = r2
                int r2 = r6.f16699b
                if (r0 != 0) goto L9d
                r1 = 1
            L9d:
                int r2 = r2 + r1
                r6.f16700c = r2
            La0:
                r6.f16698a = r3
            La2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.z2.h.a.g():void");
        }

        public final void a(@i.c.a.e h.v2.k kVar) {
            this.f16701d = kVar;
        }

        public final void b(int i2) {
            this.f16699b = i2;
        }

        public final int c() {
            return this.f16699b;
        }

        public final void d(int i2) {
            this.f16698a = i2;
        }

        public final int e() {
            return this.f16700c;
        }

        public final int f() {
            return this.f16698a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16698a == -1) {
                g();
            }
            return this.f16698a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void a(int i2) {
            this.f16702e = i2;
        }

        public final int b() {
            return this.f16702e;
        }

        public final void c(int i2) {
            this.f16700c = i2;
        }

        @i.c.a.e
        public final h.v2.k d() {
            return this.f16701d;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @i.c.a.d
        public h.v2.k next() {
            if (this.f16698a == -1) {
                g();
            }
            if (this.f16698a == 0) {
                throw new NoSuchElementException();
            }
            h.v2.k kVar = this.f16701d;
            if (kVar == null) {
                throw new e1("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f16701d = null;
            this.f16698a = -1;
            return kVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@i.c.a.d CharSequence charSequence, int i2, int i3, @i.c.a.d h.q2.s.p<? super CharSequence, ? super Integer, h.i0<Integer, Integer>> pVar) {
        h.q2.t.i0.f(charSequence, "input");
        h.q2.t.i0.f(pVar, "getNextMatch");
        this.f16694a = charSequence;
        this.f16695b = i2;
        this.f16696c = i3;
        this.f16697d = pVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<h.v2.k> iterator() {
        return new a();
    }
}

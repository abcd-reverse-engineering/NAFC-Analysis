package h.g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;

/* compiled from: SlidingWindow.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class p1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @h.k2.n.a.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
    static final class a<T> extends h.k2.n.a.k implements h.q2.s.p<h.x2.o<? super List<? extends T>>, h.k2.d<? super h.y1>, Object> {
        final /* synthetic */ Iterator $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private h.x2.o p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, int i3, Iterator it, boolean z, boolean z2, h.k2.d dVar) {
            super(2, dVar);
            this.$size = i2;
            this.$step = i3;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // h.k2.n.a.a
        @i.c.a.d
        public final h.k2.d<h.y1> create(@i.c.a.e Object obj, @i.c.a.d h.k2.d<?> dVar) {
            h.q2.t.i0.f(dVar, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, dVar);
            aVar.p$ = (h.x2.o) obj;
            return aVar;
        }

        @Override // h.q2.s.p
        public final Object invoke(Object obj, h.k2.d<? super h.y1> dVar) {
            return ((a) create(obj, dVar)).invokeSuspend(h.y1.f16671a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00fa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x017f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c1 -> B:30:0x00c4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0144 -> B:59:0x0147). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0176 -> B:72:0x0179). Please report as a decompilation issue!!! */
        @Override // h.k2.n.a.a
        @i.c.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@i.c.a.d java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 410
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.g2.p1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class b<T> implements h.x2.m<List<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.x2.m f16158a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16159b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f16160c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f16161d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f16162e;

        public b(h.x2.m mVar, int i2, int i3, boolean z, boolean z2) {
            this.f16158a = mVar;
            this.f16159b = i2;
            this.f16160c = i3;
            this.f16161d = z;
            this.f16162e = z2;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<List<? extends T>> iterator() {
            return p1.a(this.f16158a.iterator(), this.f16159b, this.f16160c, this.f16161d, this.f16162e);
        }
    }

    public static final void a(int i2, int i3) {
        String str;
        if (i2 > 0 && i3 > 0) {
            return;
        }
        if (i2 != i3) {
            str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
        } else {
            str = "size " + i2 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @i.c.a.d
    public static final <T> h.x2.m<List<T>> a(@i.c.a.d h.x2.m<? extends T> mVar, int i2, int i3, boolean z, boolean z2) {
        h.q2.t.i0.f(mVar, "$this$windowedSequence");
        a(i2, i3);
        return new b(mVar, i2, i3, z, z2);
    }

    @i.c.a.d
    public static final <T> Iterator<List<T>> a(@i.c.a.d Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        h.q2.t.i0.f(it, "iterator");
        return !it.hasNext() ? i0.f16140a : h.x2.q.c(new a(i2, i3, it, z2, z, null));
    }
}

package g.a.y0.j;

import java.util.Comparator;
import java.util.List;

/* compiled from: MergerBiFunction.java */
/* loaded from: classes2.dex */
public final class p<T> implements g.a.x0.c<List<T>, List<T>, List<T>> {

    /* renamed from: a, reason: collision with root package name */
    final Comparator<? super T> f16054a;

    public p(Comparator<? super T> comparator) {
        this.f16054a = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0037, code lost:
    
        r3 = null;
     */
    @Override // g.a.x0.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<T> apply(java.util.List<T> r6, java.util.List<T> r7) throws java.lang.Exception {
        /*
            r5 = this;
            int r0 = r6.size()
            int r1 = r7.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L11
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L11:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r6.hasNext()
            r2 = 0
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r6.next()
            goto L2b
        L2a:
            r0 = r2
        L2b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r7.next()
            goto L37
        L36:
            r3 = r2
        L37:
            if (r0 == 0) goto L61
            if (r3 == 0) goto L61
            java.util.Comparator<? super T> r4 = r5.f16054a
            int r4 = r4.compare(r0, r3)
            if (r4 >= 0) goto L53
            r1.add(r0)
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L51
            java.lang.Object r0 = r6.next()
            goto L37
        L51:
            r0 = r2
            goto L37
        L53:
            r1.add(r3)
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r7.next()
            goto L37
        L61:
            if (r0 == 0) goto L74
            r1.add(r0)
        L66:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L87
            java.lang.Object r7 = r6.next()
            r1.add(r7)
            goto L66
        L74:
            if (r3 == 0) goto L87
            r1.add(r3)
        L79:
            boolean r6 = r7.hasNext()
            if (r6 == 0) goto L87
            java.lang.Object r6 = r7.next()
            r1.add(r6)
            goto L79
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.y0.j.p.apply(java.util.List, java.util.List):java.util.List");
    }
}

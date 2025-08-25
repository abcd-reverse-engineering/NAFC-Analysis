package c.b.c.x;

import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;

/* compiled from: AztecReader.java */
/* loaded from: classes.dex */
public final class b implements p {
    @Override // c.b.c.p
    public r a(c.b.c.c cVar) throws h, m {
        return a(cVar, null);
    }

    @Override // c.b.c.p
    public void reset() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d A[LOOP:0: B:32:0x005b->B:33:0x005d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    @Override // c.b.c.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c.b.c.r a(c.b.c.c r6, java.util.Map<c.b.c.e, ?> r7) throws c.b.c.h, c.b.c.m {
        /*
            r5 = this;
            c.b.c.x.e.a r0 = new c.b.c.x.e.a
            c.b.c.z.b r6 = r6.a()
            r0.<init>(r6)
            r6 = 0
            r1 = 0
            c.b.c.x.a r2 = r0.a(r6)     // Catch: c.b.c.h -> L25 c.b.c.m -> L2b
            c.b.c.t[] r3 = r2.b()     // Catch: c.b.c.h -> L25 c.b.c.m -> L2b
            c.b.c.x.d.a r4 = new c.b.c.x.d.a     // Catch: c.b.c.h -> L21 c.b.c.m -> L23
            r4.<init>()     // Catch: c.b.c.h -> L21 c.b.c.m -> L23
            c.b.c.z.e r2 = r4.a(r2)     // Catch: c.b.c.h -> L21 c.b.c.m -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L2f
        L21:
            r2 = move-exception
            goto L27
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r1
        L27:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L2f
        L2b:
            r2 = move-exception
            r3 = r1
        L2d:
            r4 = r3
            r3 = r1
        L2f:
            if (r1 != 0) goto L4e
            r1 = 1
            c.b.c.x.a r0 = r0.a(r1)     // Catch: c.b.c.h -> L44 c.b.c.m -> L46
            c.b.c.t[] r4 = r0.b()     // Catch: c.b.c.h -> L44 c.b.c.m -> L46
            c.b.c.x.d.a r1 = new c.b.c.x.d.a     // Catch: c.b.c.h -> L44 c.b.c.m -> L46
            r1.<init>()     // Catch: c.b.c.h -> L44 c.b.c.m -> L46
            c.b.c.z.e r1 = r1.a(r0)     // Catch: c.b.c.h -> L44 c.b.c.m -> L46
            goto L4e
        L44:
            r6 = move-exception
            goto L47
        L46:
            r6 = move-exception
        L47:
            if (r2 != 0) goto L4d
            if (r3 == 0) goto L4c
            throw r3
        L4c:
            throw r6
        L4d:
            throw r2
        L4e:
            if (r7 == 0) goto L65
            c.b.c.e r0 = c.b.c.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r7 = r7.get(r0)
            c.b.c.u r7 = (c.b.c.u) r7
            if (r7 == 0) goto L65
            int r0 = r4.length
        L5b:
            if (r6 >= r0) goto L65
            r2 = r4[r6]
            r7.a(r2)
            int r6 = r6 + 1
            goto L5b
        L65:
            c.b.c.r r6 = new c.b.c.r
            java.lang.String r7 = r1.i()
            byte[] r0 = r1.f()
            c.b.c.a r2 = c.b.c.a.AZTEC
            r6.<init>(r7, r0, r4, r2)
            java.util.List r7 = r1.a()
            if (r7 == 0) goto L7f
            c.b.c.s r0 = c.b.c.s.BYTE_SEGMENTS
            r6.a(r0, r7)
        L7f:
            java.lang.String r7 = r1.b()
            if (r7 == 0) goto L8a
            c.b.c.s r0 = c.b.c.s.ERROR_CORRECTION_LEVEL
            r6.a(r0, r7)
        L8a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.x.b.a(c.b.c.c, java.util.Map):c.b.c.r");
    }
}

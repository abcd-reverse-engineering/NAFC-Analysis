package h.x2;

import h.f1;
import h.j1;
import h.n1;
import h.q2.t.i0;
import h.t0;
import h.t1;
import java.util.Iterator;

/* compiled from: _USequences.kt */
/* loaded from: classes2.dex */
class b0 {
    @h.q2.e(name = "sumOfUByte")
    @t0(version = "1.3")
    @h.k
    public static final int a(@i.c.a.d m<f1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<f1> it = mVar.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = j1.c(iC + j1.c(it.next().a() & f1.f16099c));
        }
        return iC;
    }

    @h.q2.e(name = "sumOfUInt")
    @t0(version = "1.3")
    @h.k
    public static final int b(@i.c.a.d m<j1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<j1> it = mVar.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = j1.c(iC + it.next().a());
        }
        return iC;
    }

    @h.q2.e(name = "sumOfULong")
    @t0(version = "1.3")
    @h.k
    public static final long c(@i.c.a.d m<n1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<n1> it = mVar.iterator();
        long jC = 0;
        while (it.hasNext()) {
            jC = n1.c(jC + it.next().a());
        }
        return jC;
    }

    @h.q2.e(name = "sumOfUShort")
    @t0(version = "1.3")
    @h.k
    public static final int d(@i.c.a.d m<t1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<t1> it = mVar.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = j1.c(iC + j1.c(it.next().a() & t1.f16480c));
        }
        return iC;
    }
}

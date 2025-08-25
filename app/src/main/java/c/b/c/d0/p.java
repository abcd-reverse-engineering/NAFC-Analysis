package c.b.c.d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: classes.dex */
public final class p extends q {

    /* renamed from: a, reason: collision with root package name */
    private final x[] f2589a;

    public p(Map<c.b.c.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(c.b.c.e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(c.b.c.a.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(c.b.c.a.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(c.b.c.a.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(c.b.c.a.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.f2589a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.m {
        int[] iArrA = x.a(aVar);
        for (x xVar : this.f2589a) {
            try {
                c.b.c.r rVarA = xVar.a(i2, aVar, iArrA, map);
                boolean z = rVarA.a() == c.b.c.a.EAN_13 && rVarA.e().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(c.b.c.e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(c.b.c.a.UPC_A);
                if (!z || !z2) {
                    return rVarA;
                }
                c.b.c.r rVar = new c.b.c.r(rVarA.e().substring(1), rVarA.b(), rVarA.d(), c.b.c.a.UPC_A);
                rVar.a(rVarA.c());
                return rVar;
            } catch (c.b.c.q unused) {
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public void reset() {
        for (x xVar : this.f2589a) {
            xVar.reset();
        }
    }
}

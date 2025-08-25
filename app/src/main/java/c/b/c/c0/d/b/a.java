package c.b.c.c0.d.b;

import c.b.c.e;
import c.b.c.f0.d.c;
import c.b.c.f0.d.f;
import c.b.c.m;
import c.b.c.q;
import c.b.c.u;
import c.b.c.z.g;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MultiDetector.java */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    private static final g[] f2440c = new g[0];

    public a(c.b.c.z.b bVar) {
        super(bVar);
    }

    public g[] b(Map<e, ?> map) throws m {
        f[] fVarArrB = new b(b(), map == null ? null : (u) map.get(e.NEED_RESULT_POINT_CALLBACK)).b(map);
        if (fVarArrB.length == 0) {
            throw m.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (f fVar : fVarArrB) {
            try {
                arrayList.add(a(fVar));
            } catch (q unused) {
            }
        }
        return arrayList.isEmpty() ? f2440c : (g[]) arrayList.toArray(new g[arrayList.size()]);
    }
}

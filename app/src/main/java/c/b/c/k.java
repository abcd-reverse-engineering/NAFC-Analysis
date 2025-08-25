package c.b.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader.java */
/* loaded from: classes.dex */
public final class k implements p {

    /* renamed from: a, reason: collision with root package name */
    private Map<e, ?> f2828a;

    /* renamed from: b, reason: collision with root package name */
    private p[] f2829b;

    private r c(c cVar) throws m {
        p[] pVarArr = this.f2829b;
        if (pVarArr != null) {
            for (p pVar : pVarArr) {
                try {
                    return pVar.a(cVar, this.f2828a);
                } catch (q unused) {
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    @Override // c.b.c.p
    public r a(c cVar) throws m {
        a((Map<e, ?>) null);
        return c(cVar);
    }

    public r b(c cVar) throws m {
        if (this.f2829b == null) {
            a((Map<e, ?>) null);
        }
        return c(cVar);
    }

    @Override // c.b.c.p
    public void reset() {
        p[] pVarArr = this.f2829b;
        if (pVarArr != null) {
            for (p pVar : pVarArr) {
                pVar.reset();
            }
        }
    }

    @Override // c.b.c.p
    public r a(c cVar, Map<e, ?> map) throws m {
        a(map);
        return c(cVar);
    }

    public void a(Map<e, ?> map) {
        this.f2828a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new c.b.c.d0.o(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new c.b.c.f0.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new c.b.c.a0.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new c.b.c.x.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new c.b.c.e0.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new c.b.c.b0.a());
            }
            if (z && z2) {
                arrayList.add(new c.b.c.d0.o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new c.b.c.d0.o(map));
            }
            arrayList.add(new c.b.c.f0.a());
            arrayList.add(new c.b.c.a0.a());
            arrayList.add(new c.b.c.x.b());
            arrayList.add(new c.b.c.e0.b());
            arrayList.add(new c.b.c.b0.a());
            if (z2) {
                arrayList.add(new c.b.c.d0.o(map));
            }
        }
        this.f2829b = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }
}

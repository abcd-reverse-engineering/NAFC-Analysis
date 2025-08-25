package c.b.c.d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader.java */
/* loaded from: classes.dex */
public final class o extends q {

    /* renamed from: a, reason: collision with root package name */
    private final q[] f2588a;

    public o(Map<c.b.c.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(c.b.c.e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(c.b.c.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(c.b.c.a.EAN_13) || collection.contains(c.b.c.a.UPC_A) || collection.contains(c.b.c.a.EAN_8) || collection.contains(c.b.c.a.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(c.b.c.a.CODE_39)) {
                arrayList.add(new e(z));
            }
            if (collection.contains(c.b.c.a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(c.b.c.a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(c.b.c.a.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(c.b.c.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(c.b.c.a.RSS_14)) {
                arrayList.add(new c.b.c.d0.a0.e());
            }
            if (collection.contains(c.b.c.a.RSS_EXPANDED)) {
                arrayList.add(new c.b.c.d0.a0.g.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new c.b.c.d0.a0.e());
            arrayList.add(new c.b.c.d0.a0.g.d());
        }
        this.f2588a = (q[]) arrayList.toArray(new q[arrayList.size()]);
    }

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.m {
        for (q qVar : this.f2588a) {
            try {
                return qVar.a(i2, aVar, map);
            } catch (c.b.c.q unused) {
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public void reset() {
        for (q qVar : this.f2588a) {
            qVar.reset();
        }
    }
}

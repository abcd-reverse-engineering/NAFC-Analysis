package c.b.c.c0.d;

import c.b.c.c0.c;
import c.b.c.e;
import c.b.c.f0.c.i;
import c.b.c.m;
import c.b.c.q;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeMultiReader.java */
/* loaded from: classes.dex */
public final class a extends c.b.c.f0.a implements c {

    /* renamed from: c, reason: collision with root package name */
    private static final r[] f2438c = new r[0];

    /* renamed from: d, reason: collision with root package name */
    private static final t[] f2439d = new t[0];

    /* compiled from: QRCodeMultiReader.java */
    private static final class b implements Comparator<r>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(r rVar, r rVar2) {
            int iIntValue = ((Integer) rVar.c().get(s.STRUCTURED_APPEND_SEQUENCE)).intValue();
            int iIntValue2 = ((Integer) rVar2.c().get(s.STRUCTURED_APPEND_SEQUENCE)).intValue();
            if (iIntValue < iIntValue2) {
                return -1;
            }
            return iIntValue > iIntValue2 ? 1 : 0;
        }
    }

    private static List<r> a(List<r> list) {
        boolean z;
        Iterator<r> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().c().containsKey(s.STRUCTURED_APPEND_SEQUENCE)) {
                z = true;
                break;
            }
        }
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<r> arrayList2 = new ArrayList();
        for (r rVar : list) {
            arrayList.add(rVar);
            if (rVar.c().containsKey(s.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(rVar);
            }
        }
        Collections.sort(arrayList2, new b());
        StringBuilder sb = new StringBuilder();
        int length = 0;
        int length2 = 0;
        for (r rVar2 : arrayList2) {
            sb.append(rVar2.e());
            length += rVar2.b().length;
            if (rVar2.c().containsKey(s.BYTE_SEGMENTS)) {
                Iterator it2 = ((Iterable) rVar2.c().get(s.BYTE_SEGMENTS)).iterator();
                while (it2.hasNext()) {
                    length2 += ((byte[]) it2.next()).length;
                }
            }
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length2];
        int length3 = 0;
        int length4 = 0;
        for (r rVar3 : arrayList2) {
            System.arraycopy(rVar3.b(), 0, bArr, length3, rVar3.b().length);
            length3 += rVar3.b().length;
            if (rVar3.c().containsKey(s.BYTE_SEGMENTS)) {
                for (byte[] bArr3 : (Iterable) rVar3.c().get(s.BYTE_SEGMENTS)) {
                    System.arraycopy(bArr3, 0, bArr2, length4, bArr3.length);
                    length4 += bArr3.length;
                }
            }
        }
        r rVar4 = new r(sb.toString(), bArr, f2439d, c.b.c.a.QR_CODE);
        if (length2 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            rVar4.a(s.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(rVar4);
        return arrayList;
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar) throws m {
        return b(cVar, null);
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar, Map<e, ?> map) throws m {
        ArrayList arrayList = new ArrayList();
        for (g gVar : new c.b.c.c0.d.b.a(cVar.a()).b(map)) {
            try {
                c.b.c.z.e eVarA = a().a(gVar.a(), map);
                t[] tVarArrB = gVar.b();
                if (eVarA.e() instanceof i) {
                    ((i) eVarA.e()).a(tVarArrB);
                }
                r rVar = new r(eVarA.i(), eVarA.f(), tVarArrB, c.b.c.a.QR_CODE);
                List<byte[]> listA = eVarA.a();
                if (listA != null) {
                    rVar.a(s.BYTE_SEGMENTS, listA);
                }
                String strB = eVarA.b();
                if (strB != null) {
                    rVar.a(s.ERROR_CORRECTION_LEVEL, strB);
                }
                if (eVarA.j()) {
                    rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarA.h()));
                    rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarA.g()));
                }
                arrayList.add(rVar);
            } catch (q unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f2438c;
        }
        List<r> listA2 = a(arrayList);
        return (r[]) listA2.toArray(new r[listA2.size()]);
    }
}

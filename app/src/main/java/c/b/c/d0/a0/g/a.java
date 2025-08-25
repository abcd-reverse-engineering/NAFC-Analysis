package c.b.c.d0.a0.g;

import java.util.List;

/* compiled from: BitArrayBuilder.java */
/* loaded from: classes.dex */
final class a {
    private a() {
    }

    static c.b.c.z.a a(List<b> list) {
        int size = (list.size() * 2) - 1;
        if (list.get(list.size() - 1).c() == null) {
            size--;
        }
        c.b.c.z.a aVar = new c.b.c.z.a(size * 12);
        int iB = list.get(0).c().b();
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & iB) != 0) {
                aVar.e(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = list.get(i4);
            int iB2 = bVar.b().b();
            int i5 = i2;
            for (int i6 = 11; i6 >= 0; i6--) {
                if (((1 << i6) & iB2) != 0) {
                    aVar.e(i5);
                }
                i5++;
            }
            if (bVar.c() != null) {
                int iB3 = bVar.c().b();
                for (int i7 = 11; i7 >= 0; i7--) {
                    if (((1 << i7) & iB3) != 0) {
                        aVar.e(i5);
                    }
                    i5++;
                }
            }
            i2 = i5;
        }
        return aVar;
    }
}

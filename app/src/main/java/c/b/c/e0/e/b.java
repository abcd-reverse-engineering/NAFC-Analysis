package c.b.c.e0.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f2634a = new HashMap();

    b() {
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f2634a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return c.b.c.e0.a.a(arrayList);
    }

    void b(int i2) {
        Integer num = this.f2634a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.f2634a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }

    public Integer a(int i2) {
        return this.f2634a.get(Integer.valueOf(i2));
    }
}

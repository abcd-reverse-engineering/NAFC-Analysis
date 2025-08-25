package c.b.c.y.a;

import java.util.ArrayList;

/* compiled from: AddressBookAUResultParser.java */
/* loaded from: classes.dex */
public final class b extends u {
    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String strB = u.b(rVar);
        if (!strB.contains("MEMORY") || !strB.contains("\r\n")) {
            return null;
        }
        String strB2 = u.b("NAME1:", strB, '\r', true);
        String strB3 = u.b("NAME2:", strB, '\r', true);
        String[] strArrA = a("TEL", 3, strB, true);
        String[] strArrA2 = a("MAIL", 3, strB, true);
        String strB4 = u.b("MEMORY:", strB, '\r', false);
        String strB5 = u.b("ADD:", strB, '\r', true);
        return new d(u.a(strB2), null, strB3, strArrA, null, strArrA2, null, null, strB4, strB5 != null ? new String[]{strB5} : null, null, null, null, null, null, null);
    }

    private static String[] a(String str, int i2, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i3 = 1; i3 <= i2; i3++) {
            String strB = u.b(str + i3 + ':', str2, '\r', z);
            if (strB == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i2);
            }
            arrayList.add(strB);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}

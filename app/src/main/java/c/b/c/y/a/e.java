package c.b.c.y.a;

import java.util.ArrayList;

/* compiled from: BizcardResultParser.java */
/* loaded from: classes.dex */
public final class e extends a {
    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String strB = u.b(rVar);
        if (!strB.startsWith("BIZCARD:")) {
            return null;
        }
        String strA = a(a.b("N:", strB, true), a.b("X:", strB, true));
        String strB2 = a.b("T:", strB, true);
        String strB3 = a.b("C:", strB, true);
        return new d(u.a(strA), null, null, a(a.b("B:", strB, true), a.b("M:", strB, true), a.b("F:", strB, true)), null, u.a(a.b("E:", strB, true)), null, null, null, a.a("A:", strB, true), null, strB3, null, strB2, null, null);
    }

    private static String[] a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }
}

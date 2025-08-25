package c.b.c.y.a;

/* compiled from: AddressBookDoCoMoResultParser.java */
/* loaded from: classes.dex */
public final class c extends a {
    private static String e(String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + ' ' + str.substring(0, iIndexOf);
    }

    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String[] strArrA;
        String strB = u.b(rVar);
        if (!strB.startsWith("MECARD:") || (strArrA = a.a("N:", strB, true)) == null) {
            return null;
        }
        String strE = e(strArrA[0]);
        String strB2 = a.b("SOUND:", strB, true);
        String[] strArrA2 = a.a("TEL:", strB, true);
        String[] strArrA3 = a.a("EMAIL:", strB, true);
        String strB3 = a.b("NOTE:", strB, false);
        String[] strArrA4 = a.a("ADR:", strB, true);
        String strB4 = a.b("BDAY:", strB, true);
        return new d(u.a(strE), null, strB2, strArrA2, null, strArrA3, null, null, strB3, strArrA4, null, a.b("ORG:", strB, true), !u.b(strB4, 8) ? null : strB4, null, a.a("URL:", strB, true), null);
    }
}

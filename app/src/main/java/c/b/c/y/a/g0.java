package c.b.c.y.a;

import java.util.List;

/* compiled from: VEventResultParser.java */
/* loaded from: classes.dex */
public final class g0 extends u {
    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> listB = f0.b(charSequence, str, z, false);
        if (listB == null || listB.isEmpty()) {
            return null;
        }
        int size = listB.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = listB.get(i2).get(0);
        }
        return strArr;
    }

    private static String e(String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    @Override // c.b.c.y.a.u
    public g a(c.b.c.r rVar) throws NumberFormatException {
        double d2;
        String strB = u.b(rVar);
        if (strB.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String strA = a((CharSequence) "SUMMARY", strB, true);
        String strA2 = a((CharSequence) "DTSTART", strB, true);
        if (strA2 == null) {
            return null;
        }
        String strA3 = a((CharSequence) "DTEND", strB, true);
        String strA4 = a((CharSequence) "DURATION", strB, true);
        String strA5 = a((CharSequence) "LOCATION", strB, true);
        String strE = e(a((CharSequence) "ORGANIZER", strB, true));
        String[] strArrB = b("ATTENDEE", strB, true);
        if (strArrB != null) {
            for (int i2 = 0; i2 < strArrB.length; i2++) {
                strArrB[i2] = e(strArrB[i2]);
            }
        }
        String strA6 = a((CharSequence) "DESCRIPTION", strB, true);
        String strA7 = a((CharSequence) "GEO", strB, true);
        double d3 = Double.NaN;
        if (strA7 == null) {
            d2 = Double.NaN;
        } else {
            int iIndexOf = strA7.indexOf(59);
            if (iIndexOf < 0) {
                return null;
            }
            try {
                d3 = Double.parseDouble(strA7.substring(0, iIndexOf));
                d2 = Double.parseDouble(strA7.substring(iIndexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new g(strA, strA2, strA3, strA4, strA5, strE, strArrB, strA6, d3, d2);
    }

    private static String a(CharSequence charSequence, String str, boolean z) {
        List<String> listA = f0.a(charSequence, str, z, false);
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return listA.get(0);
    }
}

package c.b.c.y.a;

import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: SMSMMSResultParser.java */
/* loaded from: classes.dex */
public final class v extends u {
    @Override // c.b.c.y.a.u
    public w a(c.b.c.r rVar) {
        String str;
        String strB = u.b(rVar);
        String str2 = null;
        if (!strB.startsWith(DefaultWebClient.SCHEME_SMS) && !strB.startsWith("SMS:") && !strB.startsWith("mms:") && !strB.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> mapB = u.b(strB);
        boolean z = false;
        if (mapB == null || mapB.isEmpty()) {
            str = null;
        } else {
            str2 = mapB.get("subject");
            str = mapB.get("body");
            z = true;
        }
        int iIndexOf = strB.indexOf(63, 4);
        String strSubstring = (iIndexOf < 0 || !z) ? strB.substring(4) : strB.substring(4, iIndexOf);
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int iIndexOf2 = strSubstring.indexOf(44, i3);
            if (iIndexOf2 <= i2) {
                a(arrayList, arrayList2, strSubstring.substring(i3));
                return new w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
            a(arrayList, arrayList2, strSubstring.substring(i3, iIndexOf2));
            i2 = iIndexOf2;
        }
    }

    private static void a(Collection<String> collection, Collection<String> collection2, String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, iIndexOf));
            String strSubstring = str.substring(iIndexOf + 1);
            collection2.add(strSubstring.startsWith("via=") ? strSubstring.substring(4) : null);
        }
    }
}

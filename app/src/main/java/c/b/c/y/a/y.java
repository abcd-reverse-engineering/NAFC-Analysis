package c.b.c.y.a;

/* compiled from: SMTPResultParser.java */
/* loaded from: classes.dex */
public final class y extends u {
    @Override // c.b.c.y.a.u
    public h a(c.b.c.r rVar) {
        String strSubstring;
        String str;
        String strB = u.b(rVar);
        if (!strB.startsWith("smtp:") && !strB.startsWith("SMTP:")) {
            return null;
        }
        String strSubstring2 = strB.substring(5);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            String strSubstring3 = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
            int iIndexOf2 = strSubstring3.indexOf(58);
            if (iIndexOf2 >= 0) {
                String strSubstring4 = strSubstring3.substring(iIndexOf2 + 1);
                strSubstring = strSubstring3.substring(0, iIndexOf2);
                str = strSubstring4;
            } else {
                str = null;
                strSubstring = strSubstring3;
            }
        } else {
            strSubstring = null;
            str = null;
        }
        return new h(new String[]{strSubstring2}, null, null, strSubstring, str);
    }
}

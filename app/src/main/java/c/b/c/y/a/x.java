package c.b.c.y.a;

/* compiled from: SMSTOMMSTOResultParser.java */
/* loaded from: classes.dex */
public final class x extends u {
    @Override // c.b.c.y.a.u
    public w a(c.b.c.r rVar) {
        String strSubstring;
        String strB = u.b(rVar);
        if (!strB.startsWith("smsto:") && !strB.startsWith("SMSTO:") && !strB.startsWith("mmsto:") && !strB.startsWith("MMSTO:")) {
            return null;
        }
        String strSubstring2 = strB.substring(6);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = null;
        }
        return new w(strSubstring2, (String) null, (String) null, strSubstring);
    }
}

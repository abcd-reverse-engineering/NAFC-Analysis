package c.b.c.y.a;

/* compiled from: TelResultParser.java */
/* loaded from: classes.dex */
public final class a0 extends u {
    @Override // c.b.c.y.a.u
    public z a(c.b.c.r rVar) {
        String str;
        String strB = u.b(rVar);
        if (!strB.startsWith("tel:") && !strB.startsWith("TEL:")) {
            return null;
        }
        if (strB.startsWith("TEL:")) {
            str = "tel:" + strB.substring(4);
        } else {
            str = strB;
        }
        int iIndexOf = strB.indexOf(63, 4);
        return new z(iIndexOf < 0 ? strB.substring(4) : strB.substring(4, iIndexOf), str, null);
    }
}

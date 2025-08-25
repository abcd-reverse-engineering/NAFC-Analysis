package c.b.c.y.a;

/* compiled from: URLTOResultParser.java */
/* loaded from: classes.dex */
public final class e0 extends u {
    @Override // c.b.c.y.a.u
    public c0 a(c.b.c.r rVar) {
        int iIndexOf;
        String strB = u.b(rVar);
        if ((strB.startsWith("urlto:") || strB.startsWith("URLTO:")) && (iIndexOf = strB.indexOf(58, 6)) >= 0) {
            return new c0(strB.substring(iIndexOf + 1), iIndexOf > 6 ? strB.substring(6, iIndexOf) : null);
        }
        return null;
    }
}

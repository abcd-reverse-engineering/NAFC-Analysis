package c.b.c.y.a;

/* compiled from: ProductResultParser.java */
/* loaded from: classes.dex */
public final class t extends u {
    @Override // c.b.c.y.a.u
    public s a(c.b.c.r rVar) {
        c.b.c.a aVarA = rVar.a();
        if (aVarA != c.b.c.a.UPC_A && aVarA != c.b.c.a.UPC_E && aVarA != c.b.c.a.EAN_8 && aVarA != c.b.c.a.EAN_13) {
            return null;
        }
        String strB = u.b(rVar);
        if (u.b(strB, strB.length())) {
            return new s(strB, (aVarA == c.b.c.a.UPC_E && strB.length() == 8) ? c.b.c.d0.z.b(strB) : strB);
        }
        return null;
    }
}

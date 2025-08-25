package c.b.c.y.a;

/* compiled from: ISBNResultParser.java */
/* loaded from: classes.dex */
public final class p extends u {
    @Override // c.b.c.y.a.u
    public o a(c.b.c.r rVar) {
        if (rVar.a() != c.b.c.a.EAN_13) {
            return null;
        }
        String strB = u.b(rVar);
        if (strB.length() != 13) {
            return null;
        }
        if (strB.startsWith("978") || strB.startsWith("979")) {
            return new o(strB);
        }
        return null;
    }
}

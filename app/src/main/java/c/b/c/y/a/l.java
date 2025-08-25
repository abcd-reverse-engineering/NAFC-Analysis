package c.b.c.y.a;

/* compiled from: ExpandedProductResultParser.java */
/* loaded from: classes.dex */
public final class l extends u {
    private static String b(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i2);
        for (int i3 = 0; i3 < strSubstring.length(); i3++) {
            char cCharAt = strSubstring.charAt(i3);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (a(i3, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:135:0x020d  */
    @Override // c.b.c.y.a.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c.b.c.y.a.k a(c.b.c.r r25) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.y.a.l.a(c.b.c.r):c.b.c.y.a.k");
    }

    private static String a(int i2, String str) {
        if (str.charAt(i2) != '(') {
            return null;
        }
        String strSubstring = str.substring(i2 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < strSubstring.length(); i3++) {
            char cCharAt = strSubstring.charAt(i3);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }
}

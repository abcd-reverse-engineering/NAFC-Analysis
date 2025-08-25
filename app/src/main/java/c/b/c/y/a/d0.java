package c.b.c.y.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: URIResultParser.java */
/* loaded from: classes.dex */
public final class d0 extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2922f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f2923g = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean e(String str) {
        if (str.contains(c.c.a.b.a.a.f3100g)) {
            return false;
        }
        Matcher matcher = f2922f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f2923g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // c.b.c.y.a.u
    public c0 a(c.b.c.r rVar) {
        String strB = u.b(rVar);
        if (strB.startsWith("URL:") || strB.startsWith("URI:")) {
            return new c0(strB.substring(4).trim(), null);
        }
        String strTrim = strB.trim();
        if (e(strTrim)) {
            return new c0(strTrim, null);
        }
        return null;
    }
}

package c.b.c.y.a;

import com.just.agentweb.DefaultWebClient;
import java.util.regex.Pattern;

/* compiled from: URIParsedResult.java */
/* loaded from: classes.dex */
public final class c0 extends q {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f2907d = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: b, reason: collision with root package name */
    private final String f2908b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2909c;

    public c0(String str, String str2) {
        super(r.URI);
        this.f2908b = a(str);
        this.f2909c = str2;
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.a(this.f2909c, sb);
        q.a(this.f2908b, sb);
        return sb.toString();
    }

    public String c() {
        return this.f2909c;
    }

    public String d() {
        return this.f2908b;
    }

    public boolean e() {
        return f2907d.matcher(this.f2908b).find();
    }

    private static String a(String str) {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        if (iIndexOf >= 0 && !a(strTrim, iIndexOf)) {
            return strTrim;
        }
        return DefaultWebClient.HTTP_SCHEME + strTrim;
    }

    private static boolean a(String str, int i2) {
        int i3 = i2 + 1;
        int iIndexOf = str.indexOf(47, i3);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return u.a(str, i3, iIndexOf - i3);
    }
}

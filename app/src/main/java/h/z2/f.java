package h.z2;

import java.nio.charset.Charset;

/* compiled from: Charsets.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final Charset f16682a;

    /* renamed from: b, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final Charset f16683b;

    /* renamed from: c, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final Charset f16684c;

    /* renamed from: d, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final Charset f16685d;

    /* renamed from: e, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final Charset f16686e;

    /* renamed from: f, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final Charset f16687f;

    /* renamed from: g, reason: collision with root package name */
    private static Charset f16688g;

    /* renamed from: h, reason: collision with root package name */
    private static Charset f16689h;

    /* renamed from: i, reason: collision with root package name */
    private static Charset f16690i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f16691j = new f();

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        h.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-8\")");
        f16682a = charsetForName;
        Charset charsetForName2 = Charset.forName(i.a.a.a.c.f16731c);
        h.q2.t.i0.a((Object) charsetForName2, "Charset.forName(\"UTF-16\")");
        f16683b = charsetForName2;
        Charset charsetForName3 = Charset.forName(i.a.a.a.c.f16732d);
        h.q2.t.i0.a((Object) charsetForName3, "Charset.forName(\"UTF-16BE\")");
        f16684c = charsetForName3;
        Charset charsetForName4 = Charset.forName(i.a.a.a.c.f16733e);
        h.q2.t.i0.a((Object) charsetForName4, "Charset.forName(\"UTF-16LE\")");
        f16685d = charsetForName4;
        Charset charsetForName5 = Charset.forName(i.a.a.a.c.f16730b);
        h.q2.t.i0.a((Object) charsetForName5, "Charset.forName(\"US-ASCII\")");
        f16686e = charsetForName5;
        Charset charsetForName6 = Charset.forName(i.a.a.a.c.f16729a);
        h.q2.t.i0.a((Object) charsetForName6, "Charset.forName(\"ISO-8859-1\")");
        f16687f = charsetForName6;
    }

    private f() {
    }

    @h.q2.e(name = "UTF32")
    @i.c.a.d
    public final Charset a() {
        Charset charset = f16688g;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32");
        h.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-32\")");
        f16688g = charsetForName;
        return charsetForName;
    }

    @h.q2.e(name = "UTF32_BE")
    @i.c.a.d
    public final Charset b() {
        Charset charset = f16690i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        h.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-32BE\")");
        f16690i = charsetForName;
        return charsetForName;
    }

    @h.q2.e(name = "UTF32_LE")
    @i.c.a.d
    public final Charset c() {
        Charset charset = f16689h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        h.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-32LE\")");
        f16689h = charsetForName;
        return charsetForName;
    }
}

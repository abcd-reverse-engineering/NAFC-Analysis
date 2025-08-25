package c.b.c.a0.e;

import h.f1;
import java.nio.charset.Charset;

/* compiled from: EncoderContext.java */
/* loaded from: classes.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f2370a;

    /* renamed from: b, reason: collision with root package name */
    private l f2371b;

    /* renamed from: c, reason: collision with root package name */
    private c.b.c.f f2372c;

    /* renamed from: d, reason: collision with root package name */
    private c.b.c.f f2373d;

    /* renamed from: e, reason: collision with root package name */
    private final StringBuilder f2374e;

    /* renamed from: f, reason: collision with root package name */
    int f2375f;

    /* renamed from: g, reason: collision with root package name */
    private int f2376g;

    /* renamed from: h, reason: collision with root package name */
    private k f2377h;

    /* renamed from: i, reason: collision with root package name */
    private int f2378i;

    h(String str) {
        byte[] bytes = str.getBytes(Charset.forName(i.a.a.a.c.f16729a));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & f1.f16099c);
            if (c2 == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.f2370a = sb.toString();
        this.f2371b = l.FORCE_NONE;
        this.f2374e = new StringBuilder(str.length());
        this.f2376g = -1;
    }

    private int m() {
        return this.f2370a.length() - this.f2378i;
    }

    public void a(l lVar) {
        this.f2371b = lVar;
    }

    public StringBuilder b() {
        return this.f2374e;
    }

    public char c() {
        return this.f2370a.charAt(this.f2375f);
    }

    public char d() {
        return this.f2370a.charAt(this.f2375f);
    }

    public String e() {
        return this.f2370a;
    }

    public int f() {
        return this.f2376g;
    }

    public int g() {
        return m() - this.f2375f;
    }

    public k h() {
        return this.f2377h;
    }

    public boolean i() {
        return this.f2375f < m();
    }

    public void j() {
        this.f2376g = -1;
    }

    public void k() {
        this.f2377h = null;
    }

    public void l() {
        c(a());
    }

    public void a(c.b.c.f fVar, c.b.c.f fVar2) {
        this.f2372c = fVar;
        this.f2373d = fVar2;
    }

    public void b(int i2) {
        this.f2376g = i2;
    }

    public void c(int i2) {
        k kVar = this.f2377h;
        if (kVar == null || i2 > kVar.b()) {
            this.f2377h = k.a(i2, this.f2371b, this.f2372c, this.f2373d, true);
        }
    }

    public void a(int i2) {
        this.f2378i = i2;
    }

    public void a(String str) {
        this.f2374e.append(str);
    }

    public void a(char c2) {
        this.f2374e.append(c2);
    }

    public int a() {
        return this.f2374e.length();
    }
}

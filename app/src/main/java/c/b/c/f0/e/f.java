package c.b.c.f0.e;

import c.b.c.f0.c.h;
import c.b.c.f0.c.j;

/* compiled from: QRCode.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    public static final int f2817f = 8;

    /* renamed from: a, reason: collision with root package name */
    private h f2818a;

    /* renamed from: b, reason: collision with root package name */
    private c.b.c.f0.c.f f2819b;

    /* renamed from: c, reason: collision with root package name */
    private j f2820c;

    /* renamed from: d, reason: collision with root package name */
    private int f2821d = -1;

    /* renamed from: e, reason: collision with root package name */
    private b f2822e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public c.b.c.f0.c.f a() {
        return this.f2819b;
    }

    public int b() {
        return this.f2821d;
    }

    public b c() {
        return this.f2822e;
    }

    public h d() {
        return this.f2818a;
    }

    public j e() {
        return this.f2820c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f2818a);
        sb.append("\n ecLevel: ");
        sb.append(this.f2819b);
        sb.append("\n version: ");
        sb.append(this.f2820c);
        sb.append("\n maskPattern: ");
        sb.append(this.f2821d);
        if (this.f2822e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f2822e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(h hVar) {
        this.f2818a = hVar;
    }

    public void a(c.b.c.f0.c.f fVar) {
        this.f2819b = fVar;
    }

    public void a(j jVar) {
        this.f2820c = jVar;
    }

    public void a(int i2) {
        this.f2821d = i2;
    }

    public void a(b bVar) {
        this.f2822e = bVar;
    }
}

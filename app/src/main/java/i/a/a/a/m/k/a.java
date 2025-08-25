package i.a.a.a.m.k;

import i.a.a.a.i;

/* compiled from: BeiderMorseEncoder.java */
/* loaded from: classes2.dex */
public class a implements i {

    /* renamed from: a, reason: collision with root package name */
    private e f16803a = new e(d.GENERIC, h.APPROX, true);

    @Override // i.a.a.a.i
    public String a(String str) throws i.a.a.a.g {
        if (str == null) {
            return null;
        }
        return this.f16803a.a(str);
    }

    public h b() {
        return this.f16803a.c();
    }

    public boolean c() {
        return this.f16803a.d();
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new i.a.a.a.g("BeiderMorseEncoder encode parameter is not of type String");
    }

    public d a() {
        return this.f16803a.b();
    }

    public void a(boolean z) {
        this.f16803a = new e(this.f16803a.b(), this.f16803a.c(), z);
    }

    public void a(d dVar) {
        this.f16803a = new e(dVar, this.f16803a.c(), this.f16803a.d());
    }

    public void a(h hVar) {
        this.f16803a = new e(this.f16803a.b(), hVar, this.f16803a.d());
    }
}

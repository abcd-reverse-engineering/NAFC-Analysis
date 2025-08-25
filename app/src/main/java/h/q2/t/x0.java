package h.q2.t;

import java.util.Collection;

/* compiled from: PackageReference.kt */
@h.t0(version = "1.1")
/* loaded from: classes2.dex */
public final class x0 implements s {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final Class<?> f16455a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16456b;

    public x0(@i.c.a.d Class<?> cls, @i.c.a.d String str) {
        i0.f(cls, "jClass");
        i0.f(str, "moduleName");
        this.f16455a = cls;
        this.f16456b = str;
    }

    @Override // h.w2.f
    @i.c.a.d
    public Collection<h.w2.b<?>> a() {
        throw new h.q2.l();
    }

    public boolean equals(@i.c.a.e Object obj) {
        return (obj instanceof x0) && i0.a(m(), ((x0) obj).m());
    }

    public int hashCode() {
        return m().hashCode();
    }

    @Override // h.q2.t.s
    @i.c.a.d
    public Class<?> m() {
        return this.f16455a;
    }

    @i.c.a.d
    public String toString() {
        return m().toString() + " (Kotlin reflection is not available)";
    }
}

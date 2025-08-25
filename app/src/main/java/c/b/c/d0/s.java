package c.b.c.d0;

import java.util.Map;

/* compiled from: UPCAReader.java */
/* loaded from: classes.dex */
public final class s extends x {

    /* renamed from: j, reason: collision with root package name */
    private final x f2590j = new h();

    @Override // c.b.c.d0.x
    public c.b.c.r a(int i2, c.b.c.z.a aVar, int[] iArr, Map<c.b.c.e, ?> map) throws c.b.c.d, c.b.c.h, c.b.c.m {
        return a(this.f2590j.a(i2, aVar, iArr, map));
    }

    @Override // c.b.c.d0.x, c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.d, c.b.c.h, c.b.c.m {
        return a(this.f2590j.a(i2, aVar, map));
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public c.b.c.r a(c.b.c.c cVar) throws c.b.c.h, c.b.c.m {
        return a(this.f2590j.a(cVar));
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public c.b.c.r a(c.b.c.c cVar, Map<c.b.c.e, ?> map) throws c.b.c.h, c.b.c.m {
        return a(this.f2590j.a(cVar, map));
    }

    @Override // c.b.c.d0.x
    c.b.c.a a() {
        return c.b.c.a.UPC_A;
    }

    @Override // c.b.c.d0.x
    protected int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m {
        return this.f2590j.a(aVar, iArr, sb);
    }

    private static c.b.c.r a(c.b.c.r rVar) throws c.b.c.h {
        String strE = rVar.e();
        if (strE.charAt(0) == '0') {
            return new c.b.c.r(strE.substring(1), null, rVar.d(), c.b.c.a.UPC_A);
        }
        throw c.b.c.h.getFormatInstance();
    }
}

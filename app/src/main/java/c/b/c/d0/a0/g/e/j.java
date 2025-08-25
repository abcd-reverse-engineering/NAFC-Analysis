package c.b.c.d0.a0.g.e;

import com.tencent.connect.common.Constants;

/* compiled from: AbstractExpandedDecoder.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.a f2501a;

    /* renamed from: b, reason: collision with root package name */
    private final s f2502b;

    j(c.b.c.z.a aVar) {
        this.f2501a = aVar;
        this.f2502b = new s(aVar);
    }

    protected final s a() {
        return this.f2502b;
    }

    protected final c.b.c.z.a b() {
        return this.f2501a;
    }

    public abstract String c() throws c.b.c.h, c.b.c.m;

    public static j a(c.b.c.z.a aVar) {
        if (aVar.b(1)) {
            return new g(aVar);
        }
        if (!aVar.b(2)) {
            return new k(aVar);
        }
        int iA = s.a(aVar, 1, 4);
        if (iA == 4) {
            return new a(aVar);
        }
        if (iA == 5) {
            return new b(aVar);
        }
        int iA2 = s.a(aVar, 1, 5);
        if (iA2 == 12) {
            return new c(aVar);
        }
        if (iA2 == 13) {
            return new d(aVar);
        }
        switch (s.a(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
            case 63:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }
}

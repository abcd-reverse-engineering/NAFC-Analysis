package c.b.c;

import java.util.Map;

/* compiled from: MultiFormatWriter.java */
/* loaded from: classes.dex */
public final class l implements v {

    /* compiled from: MultiFormatWriter.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2830a = new int[c.b.c.a.values().length];

        static {
            try {
                f2830a[c.b.c.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2830a[c.b.c.a.EAN_13.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2830a[c.b.c.a.UPC_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2830a[c.b.c.a.QR_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2830a[c.b.c.a.CODE_39.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2830a[c.b.c.a.CODE_128.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2830a[c.b.c.a.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2830a[c.b.c.a.PDF_417.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2830a[c.b.c.a.CODABAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2830a[c.b.c.a.DATA_MATRIX.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2830a[c.b.c.a.AZTEC.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        v kVar;
        switch (a.f2830a[aVar.ordinal()]) {
            case 1:
                kVar = new c.b.c.d0.k();
                break;
            case 2:
                kVar = new c.b.c.d0.i();
                break;
            case 3:
                kVar = new c.b.c.d0.t();
                break;
            case 4:
                kVar = new c.b.c.f0.b();
                break;
            case 5:
                kVar = new c.b.c.d0.f();
                break;
            case 6:
                kVar = new c.b.c.d0.d();
                break;
            case 7:
                kVar = new c.b.c.d0.n();
                break;
            case 8:
                kVar = new c.b.c.e0.d();
                break;
            case 9:
                kVar = new c.b.c.d0.b();
                break;
            case 10:
                kVar = new c.b.c.a0.b();
                break;
            case 11:
                kVar = new c.b.c.x.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + aVar);
        }
        return kVar.a(str, aVar, i2, i3, map);
    }
}

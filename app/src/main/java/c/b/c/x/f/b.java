package c.b.c.x.f;

import h.z2.h0;

/* compiled from: BinaryShiftToken.java */
/* loaded from: classes.dex */
final class b extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f2878c;

    /* renamed from: d, reason: collision with root package name */
    private final short f2879d;

    b(g gVar, int i2, int i3) {
        super(gVar);
        this.f2878c = (short) i2;
        this.f2879d = (short) i3;
    }

    @Override // c.b.c.x.f.g
    public void a(c.b.c.z.a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f2879d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                aVar.a(31, 5);
                short s2 = this.f2879d;
                if (s2 > 62) {
                    aVar.a(s2 - 31, 16);
                } else if (i2 == 0) {
                    aVar.a(Math.min((int) s2, 31), 5);
                } else {
                    aVar.a(s2 - 31, 5);
                }
            }
            aVar.a(bArr[this.f2878c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append((int) this.f2878c);
        sb.append("::");
        sb.append((this.f2878c + this.f2879d) - 1);
        sb.append(h0.f16708e);
        return sb.toString();
    }
}

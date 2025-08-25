package c.b.c.b0.b;

import c.b.c.d;
import c.b.c.h;
import c.b.c.z.e;
import com.umeng.analytics.pro.cw;
import h.f1;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static final int f2428b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2429c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2430d = 2;

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.n.c f2431a = new c.b.c.z.n.c(c.b.c.z.n.a.o);

    public e a(c.b.c.z.b bVar) throws d, h {
        return a(bVar, null);
    }

    public e a(c.b.c.z.b bVar, Map<c.b.c.e, ?> map) throws d, h {
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        a(bArrA, 0, 10, 10, 0);
        int i2 = bArrA[0] & cw.f10303m;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            a(bArrA, 20, 84, 40, 1);
            a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i2 != 5) {
                throw h.getFormatInstance();
            }
            a(bArrA, 20, 68, 56, 1);
            a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i2);
    }

    private void a(byte[] bArr, int i2, int i3, int i4, int i5) throws d {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & f1.f16099c;
            }
        }
        try {
            this.f2431a.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (c.b.c.z.n.e unused) {
            throw d.getChecksumInstance();
        }
    }
}

package c.b.c.z.n;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReedSolomonEncoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final a f3079a;

    /* renamed from: b, reason: collision with root package name */
    private final List<b> f3080b = new ArrayList();

    public d(a aVar) {
        this.f3079a = aVar;
        this.f3080b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i2) {
        if (i2 >= this.f3080b.size()) {
            List<b> list = this.f3080b;
            b bVarC = list.get(list.size() - 1);
            for (int size = this.f3080b.size(); size <= i2; size++) {
                a aVar = this.f3079a;
                bVarC = bVarC.c(new b(aVar, new int[]{1, aVar.a((size - 1) + aVar.a())}));
                this.f3080b.add(bVarC);
            }
        }
        return this.f3080b.get(i2);
    }

    public void a(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                b bVarA = a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArrA = new b(this.f3079a, iArr2).a(i2, 1).b(bVarA)[1].a();
                int length2 = i2 - iArrA.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}

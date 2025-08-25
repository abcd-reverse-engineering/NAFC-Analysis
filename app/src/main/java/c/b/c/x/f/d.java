package c.b.c.x.f;

import h.f1;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: HighLevelEncoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    static final int f2886c = 0;

    /* renamed from: d, reason: collision with root package name */
    static final int f2887d = 1;

    /* renamed from: e, reason: collision with root package name */
    static final int f2888e = 2;

    /* renamed from: f, reason: collision with root package name */
    static final int f2889f = 3;

    /* renamed from: g, reason: collision with root package name */
    static final int f2890g = 4;

    /* renamed from: j, reason: collision with root package name */
    static final int[][] f2893j;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2894a;

    /* renamed from: b, reason: collision with root package name */
    static final String[] f2885b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: h, reason: collision with root package name */
    static final int[][] f2891h = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: i, reason: collision with root package name */
    private static final int[][] f2892i = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);

    /* compiled from: HighLevelEncoder.java */
    class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.b() - fVar2.b();
        }
    }

    static {
        f2892i[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            f2892i[0][i2] = (i2 - 65) + 2;
        }
        f2892i[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            f2892i[1][i3] = (i3 - 97) + 2;
        }
        f2892i[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            f2892i[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr = f2892i;
        iArr[2][44] = 12;
        iArr[2][46] = 13;
        int[] iArr2 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            f2892i[3][iArr2[i5]] = i5;
        }
        int[] iArr3 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < iArr3.length; i6++) {
            if (iArr3[i6] > 0) {
                f2892i[4][iArr3[i6]] = i6;
            }
        }
        f2893j = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        for (int[] iArr4 : f2893j) {
            Arrays.fill(iArr4, -1);
        }
        int[][] iArr5 = f2893j;
        iArr5[0][4] = 0;
        iArr5[1][4] = 0;
        iArr5[1][0] = 28;
        iArr5[3][4] = 0;
        iArr5[2][4] = 0;
        iArr5[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.f2894a = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c.b.c.z.a a() {
        /*
            r8 = this;
            c.b.c.x.f.f r0 = c.b.c.x.f.f.f2898e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r0
            r0 = 0
        L9:
            byte[] r3 = r8.f2894a
            int r4 = r3.length
            if (r0 >= r4) goto L50
            int r4 = r0 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L16
            r3 = r3[r4]
            goto L17
        L16:
            r3 = 0
        L17:
            byte[] r5 = r8.f2894a
            r5 = r5[r0]
            r6 = 13
            if (r5 == r6) goto L3b
            r6 = 44
            r7 = 32
            if (r5 == r6) goto L37
            r6 = 46
            if (r5 == r6) goto L33
            r6 = 58
            if (r5 == r6) goto L2f
        L2d:
            r3 = 0
            goto L40
        L2f:
            if (r3 != r7) goto L2d
            r3 = 5
            goto L40
        L33:
            if (r3 != r7) goto L2d
            r3 = 3
            goto L40
        L37:
            if (r3 != r7) goto L2d
            r3 = 4
            goto L40
        L3b:
            r5 = 10
            if (r3 != r5) goto L2d
            r3 = 2
        L40:
            if (r3 <= 0) goto L49
            java.util.Collection r0 = a(r2, r0, r3)
            r2 = r0
            r0 = r4
            goto L4d
        L49:
            java.util.Collection r2 = r8.a(r2, r0)
        L4d:
            int r0 = r0 + 1
            goto L9
        L50:
            c.b.c.x.f.d$a r0 = new c.b.c.x.f.d$a
            r0.<init>()
            java.lang.Object r0 = java.util.Collections.min(r2, r0)
            c.b.c.x.f.f r0 = (c.b.c.x.f.f) r0
            byte[] r1 = r8.f2894a
            c.b.c.z.a r0 = r0.a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.x.f.d.a():c.b.c.z.a");
    }

    private Collection<f> a(Iterable<f> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, linkedList);
        }
        return a(linkedList);
    }

    private void a(f fVar, int i2, Collection<f> collection) {
        char c2 = (char) (this.f2894a[i2] & f1.f16099c);
        boolean z = f2892i[fVar.c()][c2] > 0;
        f fVarB = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = f2892i[i3][c2];
            if (i4 > 0) {
                if (fVarB == null) {
                    fVarB = fVar.b(i2);
                }
                if (!z || i3 == fVar.c() || i3 == 2) {
                    collection.add(fVarB.a(i3, i4));
                }
                if (!z && f2893j[fVar.c()][i3] >= 0) {
                    collection.add(fVarB.b(i3, i4));
                }
            }
        }
        if (fVar.a() > 0 || f2892i[fVar.c()][c2] == 0) {
            collection.add(fVar.a(i2));
        }
    }

    private static Collection<f> a(Iterable<f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, i3, linkedList);
        }
        return a(linkedList);
    }

    private static void a(f fVar, int i2, int i3, Collection<f> collection) {
        f fVarB = fVar.b(i2);
        collection.add(fVarB.a(4, i3));
        if (fVar.c() != 4) {
            collection.add(fVarB.b(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(fVarB.a(2, 16 - i3).a(2, 1));
        }
        if (fVar.a() > 0) {
            collection.add(fVar.a(i2).a(i2 + 1));
        }
    }

    private static Collection<f> a(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.a(fVar)) {
                    z = false;
                    break;
                }
                if (fVar.a(fVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }
}

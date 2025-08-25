package c.b.c.d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Code128Writer.java */
/* loaded from: classes.dex */
public final class d extends r {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2543a = 104;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2544b = 105;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2545c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2546d = 99;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2547e = 106;

    /* renamed from: f, reason: collision with root package name */
    private static final char f2548f = 241;

    /* renamed from: g, reason: collision with root package name */
    private static final char f2549g = 242;

    /* renamed from: h, reason: collision with root package name */
    private static final char f2550h = 243;

    /* renamed from: i, reason: collision with root package name */
    private static final char f2551i = 244;

    /* renamed from: j, reason: collision with root package name */
    private static final int f2552j = 102;

    /* renamed from: k, reason: collision with root package name */
    private static final int f2553k = 97;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2554l = 96;

    /* renamed from: m, reason: collision with root package name */
    private static final int f2555m = 100;

    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) throws NumberFormatException {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int iA = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < ' ' || cCharAt > '~') {
                    switch (cCharAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + cCharAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i3 < length) {
                int iCharAt = 100;
                int i7 = a(str, i3, i5 == 99 ? 2 : 4) ? 99 : 100;
                if (i7 == i5) {
                    switch (str.charAt(i3)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            break;
                        default:
                            if (i5 != 100) {
                                iCharAt = Integer.parseInt(str.substring(i3, i3 + 2));
                                i3++;
                                break;
                            } else {
                                iCharAt = str.charAt(i3) - ' ';
                                break;
                            }
                    }
                    i3++;
                } else {
                    iCharAt = i5 == 0 ? i7 == 100 ? 104 : 105 : i7;
                    i5 = i7;
                }
                arrayList.add(c.f2530a[iCharAt]);
                i4 += iCharAt * i6;
                if (i3 != 0) {
                    i6++;
                }
            }
            arrayList.add(c.f2530a[i4 % 103]);
            arrayList.add(c.f2530a[106]);
            int i8 = 0;
            for (int[] iArr : arrayList) {
                int i9 = i8;
                for (int i10 : iArr) {
                    i9 += i10;
                }
                i8 = i9;
            }
            boolean[] zArr = new boolean[i8];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iA += r.a(zArr, iA, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    private static boolean a(CharSequence charSequence, int i2, int i3) {
        int i4 = i3 + i2;
        int length = charSequence.length();
        while (i2 < i4 && i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt != 241) {
                    return false;
                }
                i4++;
            }
            i2++;
        }
        return i4 <= length;
    }
}

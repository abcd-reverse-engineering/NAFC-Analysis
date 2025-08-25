package c.b.c.d0;

/* compiled from: CodaBarWriter.java */
/* loaded from: classes.dex */
public final class b extends r {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2526a = {'A', 'B', 'C', 'D'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f2527b = {'T', 'N', '*', 'E'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f2528c = {'/', ':', '+', '.'};

    /* renamed from: d, reason: collision with root package name */
    private static final char f2529d = f2526a[0];

    @Override // c.b.c.d0.r
    public boolean[] a(String str) {
        int i2;
        if (str.length() < 2) {
            str = f2529d + str + f2529d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean zA = a.a(f2526a, upperCase);
            boolean zA2 = a.a(f2526a, upperCase2);
            boolean zA3 = a.a(f2527b, upperCase);
            boolean zA4 = a.a(f2527b, upperCase2);
            if (zA) {
                if (!zA2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!zA3) {
                if (zA2 || zA4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                str = f2529d + str + f2529d;
            } else if (!zA4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else {
                if (!a.a(f2528c, str.charAt(i4))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
                }
                i3 += 10;
            }
        }
        boolean[] zArr = new boolean[i3 + (str.length() - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i7 = 0;
            while (true) {
                char[] cArr = a.f2450g;
                if (i7 >= cArr.length) {
                    i2 = 0;
                    break;
                }
                if (upperCase3 == cArr[i7]) {
                    i2 = a.f2451h[i7];
                    break;
                }
                i7++;
            }
            int i8 = i5;
            int i9 = 0;
            boolean z = true;
            while (true) {
                int i10 = 0;
                while (i9 < 7) {
                    zArr[i8] = z;
                    i8++;
                    if (((i2 >> (6 - i9)) & 1) == 0 || i10 == 1) {
                        break;
                    }
                    i10++;
                }
                z = !z;
                i9++;
            }
            if (i6 < str.length() - 1) {
                zArr[i8] = false;
                i8++;
            }
            i5 = i8;
        }
        return zArr;
    }
}

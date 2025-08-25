package c.b.c.x.d;

import androidx.exifinterface.media.ExifInterface;
import c.b.c.h;
import c.b.c.z.e;
import c.b.c.z.n.c;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.bh;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;

/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f2856b = {"CTRL_PS", c.c.a.b.a.a.f3100g, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f2857c = {"CTRL_PS", c.c.a.b.a.a.f3100g, bh.ay, "b", bh.aI, "d", "e", "f", "g", bh.aJ, bh.aF, "j", "k", "l", "m", "n", "o", bh.aA, "q", "r", bh.aE, "t", bh.aK, "v", "w", "x", "y", bh.aG, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f2858d = {"CTRL_PS", c.c.a.b.a.a.f3100g, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", c.c.a.b.a.a.s1, "`", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, Constants.WAVE_SEPARATOR, "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f2859e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER, ".", "/", Constants.COLON_SEPARATOR, ";", "<", ContainerUtils.KEY_VALUE_DELIMITER, ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f2860f = {"CTRL_PS", c.c.a.b.a.a.f3100g, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", Constants.ACCEPT_TIME_SEPARATOR_SP, ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a, reason: collision with root package name */
    private c.b.c.x.a f2861a;

    /* compiled from: Decoder.java */
    /* renamed from: c.b.c.x.d.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0037a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2862a = new int[b.values().length];

        static {
            try {
                f2862a[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2862a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2862a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2862a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2862a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Decoder.java */
    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    private static String b(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVar2 = bVar;
        b bVar3 = bVar2;
        int i2 = 0;
        while (i2 < length) {
            if (bVar2 != b.BINARY) {
                int i3 = bVar2 == b.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int iA = a(zArr, i2, i3);
                i2 += i3;
                String strA = a(bVar2, iA);
                if (strA.startsWith("CTRL_")) {
                    b bVarA = a(strA.charAt(5));
                    if (strA.charAt(6) == 'L') {
                        bVar2 = bVarA;
                        bVar3 = bVar2;
                    } else {
                        bVar2 = bVarA;
                    }
                } else {
                    sb.append(strA);
                    bVar2 = bVar3;
                }
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int iA2 = a(zArr, i2, 5);
                int i4 = i2 + 5;
                if (iA2 == 0) {
                    if (length - i4 < 11) {
                        break;
                    }
                    iA2 = a(zArr, i4, 11) + 31;
                    i4 += 11;
                }
                int i5 = i4;
                int i6 = 0;
                while (true) {
                    if (i6 >= iA2) {
                        i2 = i5;
                        break;
                    }
                    if (length - i5 < 8) {
                        i2 = length;
                        break;
                    }
                    sb.append((char) a(zArr, i5, 8));
                    i5 += 8;
                    i6++;
                }
                bVar2 = bVar3;
            }
        }
        return sb.toString();
    }

    public static String c(boolean[] zArr) {
        return b(zArr);
    }

    public e a(c.b.c.x.a aVar) throws h {
        this.f2861a = aVar;
        return new e(null, b(a(a(aVar.a()))), null, null);
    }

    private static b a(char c2) {
        if (c2 == 'B') {
            return b.BINARY;
        }
        if (c2 == 'D') {
            return b.DIGIT;
        }
        if (c2 == 'P') {
            return b.PUNCT;
        }
        if (c2 == 'L') {
            return b.LOWER;
        }
        if (c2 != 'M') {
            return b.UPPER;
        }
        return b.MIXED;
    }

    private static String a(b bVar, int i2) {
        int i3 = C0037a.f2862a[bVar.ordinal()];
        if (i3 == 1) {
            return f2856b[i2];
        }
        if (i3 == 2) {
            return f2857c[i2];
        }
        if (i3 == 3) {
            return f2858d[i2];
        }
        if (i3 == 4) {
            return f2859e[i2];
        }
        if (i3 == 5) {
            return f2860f[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(boolean[] zArr) throws h {
        c.b.c.z.n.a aVar;
        int i2 = 8;
        if (this.f2861a.d() <= 2) {
            i2 = 6;
            aVar = c.b.c.z.n.a.f3065j;
        } else if (this.f2861a.d() <= 8) {
            aVar = c.b.c.z.n.a.n;
        } else if (this.f2861a.d() <= 22) {
            i2 = 10;
            aVar = c.b.c.z.n.a.f3064i;
        } else {
            i2 = 12;
            aVar = c.b.c.z.n.a.f3063h;
        }
        int iC = this.f2861a.c();
        int length = zArr.length / i2;
        if (length >= iC) {
            int i3 = length - iC;
            int[] iArr = new int[length];
            int length2 = zArr.length % i2;
            int i4 = 0;
            while (i4 < length) {
                iArr[i4] = a(zArr, length2, i2);
                i4++;
                length2 += i2;
            }
            try {
                new c(aVar).a(iArr, i3);
                int i5 = (1 << i2) - 1;
                int i6 = 0;
                for (int i7 = 0; i7 < iC; i7++) {
                    int i8 = iArr[i7];
                    if (i8 == 0 || i8 == i5) {
                        throw h.getFormatInstance();
                    }
                    if (i8 == 1 || i8 == i5 - 1) {
                        i6++;
                    }
                }
                boolean[] zArr2 = new boolean[(iC * i2) - i6];
                int i9 = 0;
                for (int i10 = 0; i10 < iC; i10++) {
                    int i11 = iArr[i10];
                    if (i11 == 1 || i11 == i5 - 1) {
                        Arrays.fill(zArr2, i9, (i9 + i2) - 1, i11 > 1);
                        i9 += i2 - 1;
                    } else {
                        int i12 = i2 - 1;
                        while (i12 >= 0) {
                            int i13 = i9 + 1;
                            zArr2[i9] = ((1 << i12) & i11) != 0;
                            i12--;
                            i9 = i13;
                        }
                    }
                }
                return zArr2;
            } catch (c.b.c.z.n.e e2) {
                throw h.getFormatInstance(e2);
            }
        }
        throw h.getFormatInstance();
    }

    boolean[] a(c.b.c.z.b bVar) {
        boolean zE = this.f2861a.e();
        int iD = this.f2861a.d();
        int i2 = zE ? (iD * 4) + 11 : (iD * 4) + 14;
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[a(iD, zE)];
        int i3 = 2;
        if (zE) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                iArr[(i5 - i7) - 1] = (i6 - r12) - 1;
                iArr[i5 + i7] = (i7 / 15) + i7 + i6 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iD) {
            int i10 = (iD - i8) * 4;
            int i11 = zE ? i10 + 9 : i10 + 12;
            int i12 = i8 * 2;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 * 2;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i9 + i15 + i16] = bVar.b(iArr[i17], iArr[i18]);
                    int i19 = iArr[i18];
                    int i20 = i13 - i16;
                    zArr[(i11 * 2) + i9 + i15 + i16] = bVar.b(i19, iArr[i20]);
                    int i21 = i13 - i14;
                    zArr[(i11 * 4) + i9 + i15 + i16] = bVar.b(iArr[i20], iArr[i21]);
                    zArr[(i11 * 6) + i9 + i15 + i16] = bVar.b(iArr[i21], iArr[i17]);
                    i16++;
                    i3 = 2;
                    iD = iD;
                    zE = zE;
                }
                i14++;
                i3 = 2;
            }
            i9 += i11 * 8;
            i8++;
            i3 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }
}

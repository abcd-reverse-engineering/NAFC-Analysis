package h.a3;

import h.q2.t.i0;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: formatToDecimals.kt */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final DecimalFormatSymbols f16083a;

    /* renamed from: b, reason: collision with root package name */
    private static final DecimalFormatSymbols f16084b;

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f16085c;

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat> f16086d;

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols.setExponentSeparator("e");
        f16083a = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols2.setExponentSeparator("e+");
        f16084b = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        f16085c = threadLocalArr;
        f16086d = new ThreadLocal<>();
    }

    private static final DecimalFormat a(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("0", f16083a);
        if (i2 > 0) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @i.c.a.d
    public static final String b(double d2, int i2) {
        DecimalFormat decimalFormatA = a(0);
        decimalFormatA.setMaximumFractionDigits(i2);
        String str = decimalFormatA.format(d2);
        i0.a((Object) str, "createFormatForDecimals(… }\n        .format(value)");
        return str;
    }

    @i.c.a.d
    public static final String a(double d2, int i2) {
        DecimalFormat decimalFormatA;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f16085c;
        if (i2 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i2];
            DecimalFormat decimalFormatA2 = threadLocal.get();
            if (decimalFormatA2 == null) {
                decimalFormatA2 = a(i2);
                threadLocal.set(decimalFormatA2);
            }
            decimalFormatA = decimalFormatA2;
        } else {
            decimalFormatA = a(i2);
        }
        String str = decimalFormatA.format(d2);
        i0.a((Object) str, "format.format(value)");
        return str;
    }

    @i.c.a.d
    public static final String a(double d2) {
        ThreadLocal<DecimalFormat> threadLocal = f16086d;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", f16083a);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d2 >= ((double) 1) || d2 <= ((double) (-1))) ? f16084b : f16083a);
        String str = decimalFormat2.format(d2);
        i0.a((Object) str, "scientificFormat.getOrSe… }\n        .format(value)");
        return str;
    }
}

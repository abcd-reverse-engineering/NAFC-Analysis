package h.a3;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.n0;
import h.q2.t.i0;
import h.q2.t.v;
import h.q2.t.w;
import h.t0;
import h.y;
import h.z2.c0;
import java.util.concurrent.TimeUnit;

/* compiled from: Duration.kt */
@j
@y(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010-J\u001b\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,J\u0013\u0010/\u001a\u0002002\b\u0010&\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\r\u00103\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u000200¢\u0006\u0004\b7\u00105J\r\u00108\u001a\u000200¢\u0006\u0004\b9\u00105J\r\u0010:\u001a\u000200¢\u0006\u0004\b;\u00105J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010,J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010,J\u0017\u0010@\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010(J\u001b\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010,J\u001b\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010-J\u008d\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\b¢\u0006\u0004\bO\u0010PJx\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\b¢\u0006\u0004\bO\u0010RJc\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\b¢\u0006\u0004\bO\u0010TJN\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110V¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\b¢\u0006\u0004\bO\u0010WJ\u0019\u0010X\u001a\u00020\u00032\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020b¢\u0006\u0004\bc\u0010dJ\u0019\u0010e\u001a\u00020V2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020V¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020V¢\u0006\u0004\bl\u0010jJ\u000f\u0010m\u001a\u00020bH\u0016¢\u0006\u0004\bn\u0010dJ#\u0010m\u001a\u00020b2\n\u0010Y\u001a\u00060Zj\u0002`[2\b\b\u0002\u0010o\u001a\u00020\t¢\u0006\u0004\bn\u0010pJ\u0013\u0010q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\br\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u001a\u0010\"\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006t"}, d2 = {"Lkotlin/time/Duration;", "", SurveyH5Bean.VALUE, "", "constructor-impl", "(D)D", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(D)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMicroseconds", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds-impl", "inMinutes", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "compareTo", DispatchConstants.OTHER, "compareTo-LRDsOJo", "(DD)I", "div", "scale", "div-impl", "(DD)D", "(DI)D", "div-LRDsOJo", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(D)Z", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "plus", "plus-LRDsOJo", "precision", "precision-impl", Constants.KEY_TIMES, "times-impl", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toLong", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "(D)J", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
/* loaded from: classes2.dex */
public final class d implements Comparable<d> {

    /* renamed from: a, reason: collision with root package name */
    private final double f16081a;

    /* renamed from: d, reason: collision with root package name */
    public static final a f16080d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final double f16078b = c(0.0d);

    /* renamed from: c, reason: collision with root package name */
    private static final double f16079c = c(w.f16453f.e());

    /* compiled from: Duration.kt */
    public static final class a {
        private a() {
        }

        public final double a() {
            return d.f16079c;
        }

        public final double b() {
            return d.f16078b;
        }

        public /* synthetic */ a(v vVar) {
            this();
        }

        public final double a(double d2, @i.c.a.d TimeUnit timeUnit, @i.c.a.d TimeUnit timeUnit2) {
            i0.f(timeUnit, "sourceUnit");
            i0.f(timeUnit2, "targetUnit");
            return h.a(d2, timeUnit, timeUnit2);
        }
    }

    private /* synthetic */ d(double d2) {
        this.f16081a = d2;
    }

    public static boolean a(double d2, @i.c.a.e Object obj) {
        return (obj instanceof d) && Double.compare(d2, ((d) obj).a()) == 0;
    }

    public static final double b(double d2, double d3) {
        return d2 / d3;
    }

    @i.c.a.d
    public static final /* synthetic */ d b(double d2) {
        return new d(d2);
    }

    public static double c(double d2) {
        return d2;
    }

    public static final double d(double d2) {
        return s(d2) ? y(d2) : d2;
    }

    @n0
    public static /* synthetic */ void d() {
    }

    public static final boolean d(double d2, double d3) {
        return Double.compare(d2, d3) == 0;
    }

    public static final double e(double d2, double d3) {
        return c(d2 - d3);
    }

    @n0
    public static /* synthetic */ void e() {
    }

    public static final double f(double d2, double d3) {
        return c(d2 + d3);
    }

    @n0
    public static /* synthetic */ void f() {
    }

    public static final double g(double d2) {
        return a(d2, TimeUnit.HOURS);
    }

    private static final int g(double d2, double d3) {
        if (d3 < 1) {
            return 3;
        }
        if (d3 < 10) {
            return 2;
        }
        return d3 < ((double) 100) ? 1 : 0;
    }

    @n0
    public static /* synthetic */ void g() {
    }

    public static final double h(double d2, double d3) {
        return c(d2 * d3);
    }

    public static final double i(double d2) {
        return a(d2, TimeUnit.MILLISECONDS);
    }

    public static final double j(double d2) {
        return a(d2, TimeUnit.MINUTES);
    }

    public static final double k(double d2) {
        return a(d2, TimeUnit.NANOSECONDS);
    }

    public static final double l(double d2) {
        return a(d2, TimeUnit.SECONDS);
    }

    public static final int m(double d2) {
        return (int) (j(d2) % 60);
    }

    public static final int n(double d2) {
        return (int) (k(d2) % 1.0E9d);
    }

    public static final int o(double d2) {
        return (int) (l(d2) % 60);
    }

    public static int p(double d2) {
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public static final boolean q(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    public static final boolean r(double d2) {
        return Double.isInfinite(d2);
    }

    public static final boolean s(double d2) {
        return d2 < ((double) 0);
    }

    public static final boolean t(double d2) {
        return d2 > ((double) 0);
    }

    @i.c.a.d
    public static final String u(double d2) {
        StringBuilder sb = new StringBuilder();
        if (s(d2)) {
            sb.append('-');
        }
        sb.append("PT");
        double d3 = d(d2);
        int iG = (int) g(d3);
        int iM = m(d3);
        int iO = o(d3);
        int iN = n(d3);
        boolean z = true;
        boolean z2 = iG != 0;
        boolean z3 = (iO == 0 && iN == 0) ? false : true;
        if (iM == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(iG);
            sb.append('H');
        }
        if (z) {
            sb.append(iM);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(iO);
            if (iN != 0) {
                sb.append('.');
                String strB = c0.b(String.valueOf(iN), 9, '0');
                if (iN % 1000000 == 0) {
                    sb.append((CharSequence) strB, 0, 3);
                    i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
                } else if (iN % 1000 == 0) {
                    sb.append((CharSequence) strB, 0, 6);
                    i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(strB);
                }
            }
            sb.append('S');
        }
        String string = sb.toString();
        i0.a((Object) string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final long v(double d2) {
        return c(d2, TimeUnit.MILLISECONDS);
    }

    public static final long w(double d2) {
        return c(d2, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    @i.c.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String x(double r8) {
        /*
            boolean r0 = r(r8)
            if (r0 == 0) goto Lc
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto Lc0
        Lc:
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L16
            java.lang.String r8 = "0s"
            goto Lc0
        L16:
            double r0 = d(r8)
            double r0 = k(r0)
            r2 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L2e
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
        L2b:
            r1 = 0
            r4 = 1
            goto L8f
        L2e:
            double r2 = (double) r5
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L37
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1 = 7
            goto L8f
        L37:
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L44
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
        L42:
            r1 = 0
            goto L8f
        L44:
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L50
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MICROSECONDS
            goto L42
        L50:
            r2 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L5c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            goto L42
        L5c:
            r2 = 4786511204640096256(0x426d1a94a2000000, double:1.0E12)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L68
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            goto L42
        L68:
            r2 = 4813020802404319232(0x42cb48eb57e00000, double:6.0E13)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L74
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MINUTES
            goto L42
        L74:
            r2 = 4839562400168542208(0x4329945ca2620000, double:3.6E15)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L80
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.HOURS
            goto L42
        L80:
            r2 = 4920018990336211136(0x44476b344f2a78c0, double:8.64E20)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L8c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L42
        L8c:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L2b
        L8f:
            double r2 = a(r8, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            if (r4 == 0) goto L9f
            java.lang.String r8 = h.a3.k.a(r2)
            goto Lb2
        L9f:
            if (r1 <= 0) goto La6
            java.lang.String r8 = h.a3.k.b(r2, r1)
            goto Lb2
        La6:
            double r6 = java.lang.Math.abs(r2)
            int r8 = g(r8, r6)
            java.lang.String r8 = h.a3.k.a(r2, r8)
        Lb2:
            r5.append(r8)
            java.lang.String r8 = h.a3.i.a(r0)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
        Lc0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a3.d.x(double):java.lang.String");
    }

    public static final double y(double d2) {
        return c(-d2);
    }

    public final /* synthetic */ double a() {
        return this.f16081a;
    }

    public int a(double d2) {
        return a(this.f16081a, d2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return a(dVar.a());
    }

    public boolean equals(Object obj) {
        return a(this.f16081a, obj);
    }

    public int hashCode() {
        return p(this.f16081a);
    }

    @i.c.a.d
    public String toString() {
        return x(this.f16081a);
    }

    public static final double a(double d2, int i2) {
        return c(d2 / i2);
    }

    public static final double b(double d2, int i2) {
        return c(d2 * i2);
    }

    public static final double c(double d2, double d3) {
        return c(d2 / d3);
    }

    public static final int e(double d2) {
        return (int) (g(d2) % 24);
    }

    public static final double f(double d2) {
        return a(d2, TimeUnit.DAYS);
    }

    public static final double h(double d2) {
        return a(d2, TimeUnit.MICROSECONDS);
    }

    public static int a(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    public static final int b(double d2, @i.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        return (int) a(d2, timeUnit);
    }

    public static final long c(double d2, @i.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        return (long) a(d2, timeUnit);
    }

    public static final <T> T a(double d2, @i.c.a.d h.q2.s.s<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> sVar) {
        i0.f(sVar, "action");
        return sVar.invoke(Integer.valueOf((int) f(d2)), Integer.valueOf(e(d2)), Integer.valueOf(m(d2)), Integer.valueOf(o(d2)), Integer.valueOf(n(d2)));
    }

    public static final <T> T a(double d2, @i.c.a.d h.q2.s.r<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> rVar) {
        i0.f(rVar, "action");
        return rVar.invoke(Integer.valueOf((int) g(d2)), Integer.valueOf(m(d2)), Integer.valueOf(o(d2)), Integer.valueOf(n(d2)));
    }

    public static final <T> T a(double d2, @i.c.a.d h.q2.s.q<? super Integer, ? super Integer, ? super Integer, ? extends T> qVar) {
        i0.f(qVar, "action");
        return qVar.invoke(Integer.valueOf((int) j(d2)), Integer.valueOf(o(d2)), Integer.valueOf(n(d2)));
    }

    public static final <T> T a(double d2, @i.c.a.d h.q2.s.p<? super Long, ? super Integer, ? extends T> pVar) {
        i0.f(pVar, "action");
        return pVar.invoke(Long.valueOf((long) l(d2)), Integer.valueOf(n(d2)));
    }

    public static final double a(double d2, @i.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        return h.a(d2, e.b(), timeUnit);
    }

    public static /* synthetic */ String a(double d2, TimeUnit timeUnit, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(d2, timeUnit, i2);
    }

    @i.c.a.d
    public static final String a(double d2, @i.c.a.d TimeUnit timeUnit, int i2) {
        i0.f(timeUnit, "unit");
        if (i2 >= 0) {
            if (r(d2)) {
                return String.valueOf(d2);
            }
            double dA = a(d2, timeUnit);
            StringBuilder sb = new StringBuilder();
            sb.append(Math.abs(dA) < 1.0E14d ? k.a(dA, h.v2.q.b(i2, 12)) : k.a(dA));
            sb.append(i.a(timeUnit));
            return sb.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i2).toString());
    }
}

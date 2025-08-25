package c.b.c.y.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CalendarParsedResult.java */
/* loaded from: classes.dex */
public final class g extends q {

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f2932m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] n = {604800000, 86400000, com.heytap.mcssdk.constant.a.f5801e, com.heytap.mcssdk.constant.a.f5800d, 1000};
    private static final Pattern o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* renamed from: b, reason: collision with root package name */
    private final String f2933b;

    /* renamed from: c, reason: collision with root package name */
    private final Date f2934c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2935d;

    /* renamed from: e, reason: collision with root package name */
    private final Date f2936e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f2937f;

    /* renamed from: g, reason: collision with root package name */
    private final String f2938g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2939h;

    /* renamed from: i, reason: collision with root package name */
    private final String[] f2940i;

    /* renamed from: j, reason: collision with root package name */
    private final String f2941j;

    /* renamed from: k, reason: collision with root package name */
    private final double f2942k;

    /* renamed from: l, reason: collision with root package name */
    private final double f2943l;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(r.CALENDAR);
        this.f2933b = str;
        try {
            this.f2934c = a(str2);
            if (str3 == null) {
                long jA = a((CharSequence) str4);
                this.f2936e = jA < 0 ? null : new Date(this.f2934c.getTime() + jA);
            } else {
                try {
                    this.f2936e = a(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = false;
            this.f2935d = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z = true;
            }
            this.f2937f = z;
            this.f2938g = str5;
            this.f2939h = str6;
            this.f2940i = strArr;
            this.f2941j = str7;
            this.f2942k = d2;
            this.f2943l = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    private static DateFormat n() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static DateFormat o() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.a(this.f2933b, sb);
        q.a(a(this.f2935d, this.f2934c), sb);
        q.a(a(this.f2937f, this.f2936e), sb);
        q.a(this.f2938g, sb);
        q.a(this.f2939h, sb);
        q.a(this.f2940i, sb);
        q.a(this.f2941j, sb);
        return sb.toString();
    }

    public String[] c() {
        return this.f2940i;
    }

    public String d() {
        return this.f2941j;
    }

    public Date e() {
        return this.f2936e;
    }

    public double f() {
        return this.f2942k;
    }

    public String g() {
        return this.f2938g;
    }

    public double h() {
        return this.f2943l;
    }

    public String i() {
        return this.f2939h;
    }

    public Date j() {
        return this.f2934c;
    }

    public String k() {
        return this.f2933b;
    }

    public boolean l() {
        return this.f2937f;
    }

    public boolean m() {
        return this.f2935d;
    }

    private static Date a(String str) throws ParseException {
        if (o.matcher(str).matches()) {
            if (str.length() == 8) {
                return n().parse(str);
            }
            if (str.length() == 16 && str.charAt(15) == 'Z') {
                Date date = o().parse(str.substring(0, 15));
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                long time = date.getTime() + gregorianCalendar.get(15);
                gregorianCalendar.setTime(new Date(time));
                return new Date(time + gregorianCalendar.get(16));
            }
            return o().parse(str);
        }
        throw new ParseException(str, 0);
    }

    private static String a(boolean z, Date date) {
        DateFormat dateTimeInstance;
        if (date == null) {
            return null;
        }
        if (z) {
            dateTimeInstance = DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(date);
    }

    private static long a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f2932m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j2 = 0;
        int i2 = 0;
        while (i2 < n.length) {
            int i3 = i2 + 1;
            if (matcher.group(i3) != null) {
                j2 += n[i2] * Integer.parseInt(r4);
            }
            i2 = i3;
        }
        return j2;
    }
}

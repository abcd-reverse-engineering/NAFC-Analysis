package a.a.j;

import a.a.j.a;
import anet.channel.util.HttpHelper;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f1117a = TimeZone.getTimeZone("GMT");

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f1118b = new ThreadLocal<>();

    public static String a(long j2) {
        return a().format(new Date(j2));
    }

    private static long a(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date date = a().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return date.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static a.C0001a a(Map<String, List<String>> map) throws NumberFormatException {
        long j2;
        long j3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control");
        boolean z = true;
        int i2 = 0;
        if (singleHeaderFieldByKey != null) {
            String[] strArrSplit = singleHeaderFieldByKey.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            j2 = 0;
            while (true) {
                if (i2 >= strArrSplit.length) {
                    break;
                }
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.equals("no-cache")) {
                    j2 = 0;
                    break;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
        } else {
            j2 = 0;
            z = false;
        }
        String singleHeaderFieldByKey2 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.DATE);
        long jA = singleHeaderFieldByKey2 != null ? a(singleHeaderFieldByKey2) : 0L;
        String singleHeaderFieldByKey3 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.EXPIRES);
        long jA2 = singleHeaderFieldByKey3 != null ? a(singleHeaderFieldByKey3) : 0L;
        String singleHeaderFieldByKey4 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.LAST_MODIFIED);
        long jA3 = singleHeaderFieldByKey4 != null ? a(singleHeaderFieldByKey4) : 0L;
        String singleHeaderFieldByKey5 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.ETAG);
        if (z) {
            jCurrentTimeMillis += j2 * 1000;
        } else {
            if (jA <= 0 || jA2 < jA) {
                j3 = jA3;
                if (j3 <= 0) {
                    jCurrentTimeMillis = 0;
                }
                if (jCurrentTimeMillis != 0 && singleHeaderFieldByKey5 == null) {
                    return null;
                }
                a.C0001a c0001a = new a.C0001a();
                c0001a.etag = singleHeaderFieldByKey5;
                c0001a.ttl = jCurrentTimeMillis;
                c0001a.serverDate = jA;
                c0001a.lastModified = j3;
                c0001a.responseHeaders = map;
                return c0001a;
            }
            jCurrentTimeMillis += jA2 - jA;
        }
        j3 = jA3;
        if (jCurrentTimeMillis != 0) {
        }
        a.C0001a c0001a2 = new a.C0001a();
        c0001a2.etag = singleHeaderFieldByKey5;
        c0001a2.ttl = jCurrentTimeMillis;
        c0001a2.serverDate = jA;
        c0001a2.lastModified = j3;
        c0001a2.responseHeaders = map;
        return c0001a2;
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = f1118b.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(f1117a);
        f1118b.set(simpleDateFormat2);
        return simpleDateFormat2;
    }
}

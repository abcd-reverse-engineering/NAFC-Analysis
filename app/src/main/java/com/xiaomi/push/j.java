package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f13249a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, n> f908a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f13250b = -1;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m626a() {
        return a() == 1;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m630b() {
        return a() == 2;
    }

    /* renamed from: c, reason: collision with other method in class */
    public static boolean m631c() {
        if (f13250b < 0) {
            f13250b = !m633e() ? 1 : 0;
        }
        return f13250b > 0;
    }

    /* renamed from: d, reason: collision with other method in class */
    public static boolean m632d() {
        return !n.China.name().equalsIgnoreCase(a(b()).name());
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m633e() {
        String strA = "";
        try {
            strA = q.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(strA);
    }

    public static int a() {
        if (f13249a == 0) {
            try {
                int i2 = 1;
                if (!((TextUtils.isEmpty(m624a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m624a("ro.miui.ui.version.name"))) ? false : true)) {
                    i2 = 2;
                }
                f13249a = i2;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                f13249a = 0;
            }
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f13249a);
        }
        return f13249a;
    }

    public static String b() {
        String strA = q.a("ro.miui.region", "");
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = m629b(q.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("get region from system, region = " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m50a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return m624a("ro.build.characteristics");
    }

    public static String e() {
        return m624a("ro.product.manufacturer");
    }

    public static String c() {
        return m624a("ro.miui.ui.version.name");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m623a() {
        int iA = C0343r.a();
        return (!m626a() || iA <= 0) ? "" : iA < 2 ? "alpha" : iA < 3 ? "development" : "stable";
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m624a(String str) {
        try {
            try {
                return (String) aw.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m627a(Context context) {
        return context != null && m628a(context.getPackageName());
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m628a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static n a(String str) {
        n nVarB = b(str);
        return nVarB == null ? n.Global : nVarB;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m625a() {
        if (f908a != null) {
            return;
        }
        f908a = new HashMap();
        f908a.put("CN", n.China);
        f908a.put("FI", n.Europe);
        f908a.put("SE", n.Europe);
        f908a.put("NO", n.Europe);
        f908a.put("FO", n.Europe);
        f908a.put("EE", n.Europe);
        f908a.put("LV", n.Europe);
        f908a.put("LT", n.Europe);
        f908a.put("BY", n.Europe);
        f908a.put("MD", n.Europe);
        f908a.put("UA", n.Europe);
        f908a.put("PL", n.Europe);
        f908a.put("CZ", n.Europe);
        f908a.put("SK", n.Europe);
        f908a.put("HU", n.Europe);
        f908a.put("DE", n.Europe);
        f908a.put("AT", n.Europe);
        f908a.put("CH", n.Europe);
        f908a.put("LI", n.Europe);
        f908a.put("GB", n.Europe);
        f908a.put("IE", n.Europe);
        f908a.put("NL", n.Europe);
        f908a.put("BE", n.Europe);
        f908a.put("LU", n.Europe);
        f908a.put("FR", n.Europe);
        f908a.put("RO", n.Europe);
        f908a.put("BG", n.Europe);
        f908a.put("RS", n.Europe);
        f908a.put("MK", n.Europe);
        f908a.put("AL", n.Europe);
        f908a.put("GR", n.Europe);
        f908a.put("SI", n.Europe);
        f908a.put("HR", n.Europe);
        f908a.put("IT", n.Europe);
        f908a.put("SM", n.Europe);
        f908a.put("MT", n.Europe);
        f908a.put("ES", n.Europe);
        f908a.put("PT", n.Europe);
        f908a.put("AD", n.Europe);
        f908a.put("CY", n.Europe);
        f908a.put("DK", n.Europe);
        f908a.put("IS", n.Europe);
        f908a.put("UK", n.Europe);
        f908a.put("EL", n.Europe);
        f908a.put("RU", n.Russia);
        f908a.put("IN", n.India);
    }

    private static n b(String str) {
        m625a();
        return f908a.get(str.toUpperCase());
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private static String m629b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    public static int a(Context context) {
        String strM624a = m624a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(strM624a) || !TextUtils.isDigitsOnly(strM624a)) {
            return 0;
        }
        return Integer.parseInt(strM624a);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + c.c.a.b.a.a.f3100g + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

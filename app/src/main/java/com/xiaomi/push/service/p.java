package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.s;
import com.xiaomi.push.service.am;
import java.util.Locale;

/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f13445a;

    /* renamed from: a, reason: collision with other field name */
    public final String f1067a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13446b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13447c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13448d;

    /* renamed from: e, reason: collision with root package name */
    public final String f13449e;

    /* renamed from: f, reason: collision with root package name */
    public final String f13450f;

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.f1067a = str;
        this.f13446b = str2;
        this.f13447c = str3;
        this.f13448d = str4;
        this.f13449e = str5;
        this.f13450f = str6;
        this.f13445a = i2;
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m665b(), bh.aI);
        return bVar;
    }

    public am.b a(am.b bVar, Context context, h hVar, String str) {
        bVar.f998a = context.getPackageName();
        bVar.f1001b = this.f1067a;
        bVar.f13351h = this.f13447c;
        bVar.f13346c = this.f13446b;
        bVar.f13350g = "5";
        bVar.f13347d = "XMPUSH-PASS";
        bVar.f1000a = false;
        s.a aVar = new s.a();
        aVar.a("sdk_ver", 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).a("country_code", b.a(context).b()).a("region", b.a(context).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.m679a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String strA = a(context);
        if (!TextUtils.isEmpty(strA)) {
            aVar.a("latest_country_code", strA);
        }
        String strD = com.xiaomi.push.j.d();
        if (!TextUtils.isEmpty(strD)) {
            aVar.a("device_ch", strD);
        }
        String strE = com.xiaomi.push.j.e();
        if (!TextUtils.isEmpty(strE)) {
            aVar.a("device_mfr", strE);
        }
        bVar.f13348e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.f13448d;
        s.a aVar2 = new s.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m740a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f13349f = aVar2.toString();
        bVar.f997a = hVar;
        return bVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m740a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean a() {
        try {
            return C0343r.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String strM624a = com.xiaomi.push.j.m624a("ro.miui.region");
            return TextUtils.isEmpty(strM624a) ? com.xiaomi.push.j.m624a("ro.product.locale.region") : strM624a;
        }
        return com.xiaomi.push.j.b();
    }
}

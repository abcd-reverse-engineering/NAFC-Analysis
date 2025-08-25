package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class an implements ai {

    /* renamed from: a, reason: collision with root package name */
    private static volatile an f12444a;

    /* renamed from: a, reason: collision with other field name */
    private int f182a = am.f12443a;

    /* renamed from: a, reason: collision with other field name */
    private long f183a;

    /* renamed from: a, reason: collision with other field name */
    private Context f184a;

    /* renamed from: a, reason: collision with other field name */
    private ai f185a;

    /* renamed from: a, reason: collision with other field name */
    private String f186a;

    private an(Context context) {
        this.f184a = context.getApplicationContext();
        this.f185a = am.a(context);
        com.xiaomi.channel.commonutils.logger.b.m50a("create id manager is: " + this.f182a);
    }

    public static an a(Context context) {
        if (f12444a == null) {
            synchronized (an.class) {
                if (f12444a == null) {
                    f12444a = new an(context.getApplicationContext());
                }
            }
        }
        return f12444a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public void a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public boolean mo137a() {
        return this.f185a.mo137a();
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public String mo136a() {
        if (j.m627a(this.f184a)) {
            return a(this.f185a.mo136a());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.f183a) > 86400000) {
            this.f183a = jCurrentTimeMillis;
            String strA = a(this.f185a.mo136a());
            this.f186a = strA;
            return strA;
        }
        return a(this.f186a);
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("udid", strB);
        }
        String strMo136a = mo136a();
        if (!TextUtils.isEmpty(strMo136a)) {
            map.put("oaid", strMo136a);
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            map.put("vaid", strC);
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            map.put("aaid", strD);
        }
        map.put("oaid_type", String.valueOf(this.f182a));
    }
}

package com.xiaomi.push;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class cv {

    /* renamed from: a, reason: collision with root package name */
    private final String f12602a = "power_consumption_stats";

    /* renamed from: b, reason: collision with root package name */
    private final String f12603b = "off_up_ct";

    /* renamed from: c, reason: collision with root package name */
    private final String f12604c = "off_dn_ct";

    /* renamed from: d, reason: collision with root package name */
    private final String f12605d = "off_ping_ct";

    /* renamed from: e, reason: collision with root package name */
    private final String f12606e = "off_pong_ct";

    /* renamed from: f, reason: collision with root package name */
    private final String f12607f = "off_dur";

    /* renamed from: g, reason: collision with root package name */
    private final String f12608g = "on_up_ct";

    /* renamed from: h, reason: collision with root package name */
    private final String f12609h = "on_dn_ct";

    /* renamed from: i, reason: collision with root package name */
    private final String f12610i = "on_ping_ct";

    /* renamed from: j, reason: collision with root package name */
    private final String f12611j = "on_pong_ct";

    /* renamed from: k, reason: collision with root package name */
    private final String f12612k = "on_dur";

    /* renamed from: l, reason: collision with root package name */
    private final String f12613l = com.umeng.analytics.pro.d.p;

    /* renamed from: m, reason: collision with root package name */
    private final String f12614m = com.umeng.analytics.pro.d.q;
    private final String n = "xmsf_vc";
    private final String o = "android_vc";
    private final String p = "uuid";

    public void a(Context context, cu cuVar) {
        if (cuVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("off_up_ct", Integer.valueOf(cuVar.a()));
        map.put("off_dn_ct", Integer.valueOf(cuVar.b()));
        map.put("off_ping_ct", Integer.valueOf(cuVar.c()));
        map.put("off_pong_ct", Integer.valueOf(cuVar.d()));
        map.put("off_dur", Long.valueOf(cuVar.m254a()));
        map.put("on_up_ct", Integer.valueOf(cuVar.e()));
        map.put("on_dn_ct", Integer.valueOf(cuVar.f()));
        map.put("on_ping_ct", Integer.valueOf(cuVar.g()));
        map.put("on_pong_ct", Integer.valueOf(cuVar.h()));
        map.put("on_dur", Long.valueOf(cuVar.m255b()));
        map.put(com.umeng.analytics.pro.d.p, Long.valueOf(cuVar.m256c()));
        map.put(com.umeng.analytics.pro.d.q, Long.valueOf(cuVar.m257d()));
        map.put("xmsf_vc", Integer.valueOf(cuVar.i()));
        map.put("android_vc", Integer.valueOf(cuVar.j()));
        map.put("uuid", com.xiaomi.push.service.q.m742a(context));
        eh.a().a("power_consumption_stats", map);
    }
}

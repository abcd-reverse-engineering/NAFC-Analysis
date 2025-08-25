package com.xiaomi.push;

import android.content.Context;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class cp {

    /* renamed from: a, reason: collision with root package name */
    private final String f12571a = "disconnection_event";

    /* renamed from: b, reason: collision with root package name */
    private final String f12572b = "count";

    /* renamed from: c, reason: collision with root package name */
    private final String f12573c = Constants.KEY_HOST;

    /* renamed from: d, reason: collision with root package name */
    private final String f12574d = "network_state";

    /* renamed from: e, reason: collision with root package name */
    private final String f12575e = "reason";

    /* renamed from: f, reason: collision with root package name */
    private final String f12576f = "ping_interval";

    /* renamed from: g, reason: collision with root package name */
    private final String f12577g = com.umeng.analytics.pro.bh.T;

    /* renamed from: h, reason: collision with root package name */
    private final String f12578h = "wifi_digest";

    /* renamed from: i, reason: collision with root package name */
    private final String f12579i = "duration";

    /* renamed from: j, reason: collision with root package name */
    private final String f12580j = "disconnect_time";

    /* renamed from: k, reason: collision with root package name */
    private final String f12581k = "connect_time";

    /* renamed from: l, reason: collision with root package name */
    private final String f12582l = "xmsf_vc";

    /* renamed from: m, reason: collision with root package name */
    private final String f12583m = "android_vc";
    private final String n = "uuid";

    public void a(Context context, List<co> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        cn.a("upload size = " + list.size());
        String strM742a = com.xiaomi.push.service.q.m742a(context);
        for (co coVar : list) {
            HashMap map = new HashMap();
            map.put("count", Integer.valueOf(coVar.a()));
            map.put(Constants.KEY_HOST, coVar.m244a());
            map.put("network_state", Integer.valueOf(coVar.b()));
            map.put("reason", Integer.valueOf(coVar.c()));
            map.put("ping_interval", Long.valueOf(coVar.m243a()));
            map.put(com.umeng.analytics.pro.bh.T, Integer.valueOf(coVar.d()));
            map.put("wifi_digest", coVar.m246b());
            map.put("connected_network_type", Integer.valueOf(coVar.e()));
            map.put("duration", Long.valueOf(coVar.m245b()));
            map.put("disconnect_time", Long.valueOf(coVar.m247c()));
            map.put("connect_time", Long.valueOf(coVar.m248d()));
            map.put("xmsf_vc", Integer.valueOf(coVar.f()));
            map.put("android_vc", Integer.valueOf(coVar.g()));
            map.put("uuid", strM742a);
            eh.a().a("disconnection_event", map);
        }
    }
}

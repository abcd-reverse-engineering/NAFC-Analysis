package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f6832e = "a";

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f6833f = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f6834a = new ConcurrentHashMap(16);

    /* renamed from: b, reason: collision with root package name */
    private final c f6835b;

    /* renamed from: c, reason: collision with root package name */
    private final c f6836c;

    /* renamed from: d, reason: collision with root package name */
    private final g f6837d;

    public a(c cVar, c cVar2, g gVar) {
        this.f6836c = cVar2;
        this.f6835b = cVar;
        this.f6837d = gVar;
        this.f6837d.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l2 = this.f6834a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l2)) {
            bVar.a(2);
            return;
        }
        if (e.a(l2, 300000L)) {
            this.f6837d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, str, this.f6836c, -1);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f6834a.get(str), 300000L)) {
            this.f6837d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, null, this.f6836c, -1);
        }
    }

    public c a() {
        return this.f6835b;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        Map<String, Map<String, String>> map = f6833f.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map != null && !map.isEmpty()) {
            a(grsBaseInfo, bVar, context, str);
            return map.get(str);
        }
        Logger.i(f6832e, "Cache size is: " + f6833f.size());
        return new HashMap();
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f6835b.b(grsParasKey + "time", "0");
        this.f6834a.remove(grsParasKey + "time");
        f6833f.remove(grsParasKey);
        Logger.i(f6832e, "Cache size is: " + f6833f.size());
        this.f6837d.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.j.c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f6832e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f6833f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f6835b.a(grsParasKey, "")));
            } else {
                this.f6835b.b(grsParasKey, dVar.j());
                f6833f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                this.f6835b.b(grsParasKey + HttpHeaders.ETAG, dVar.e());
            }
            this.f6835b.b(grsParasKey + "time", dVar.a());
            this.f6834a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f6835b.b("geoipCountryCode", dVar.j());
            this.f6835b.b("geoipCountryCodetime", dVar.a());
        }
        Logger.i(f6832e, "Cache size is: " + f6833f.size());
    }

    public g b() {
        return this.f6837d;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) throws NumberFormatException {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String strA = this.f6835b.a(grsParasKey, "");
        String strA2 = this.f6835b.a(grsParasKey + "time", "0");
        long j2 = 0;
        if (!TextUtils.isEmpty(strA2) && strA2.matches("\\d+")) {
            try {
                j2 = Long.parseLong(strA2);
            } catch (NumberFormatException e2) {
                Logger.w(f6832e, "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        f6833f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(strA));
        Logger.i(f6832e, "Cache size is: " + f6833f.size());
        this.f6834a.put(grsParasKey, Long.valueOf(j2));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.f6836c;
    }
}

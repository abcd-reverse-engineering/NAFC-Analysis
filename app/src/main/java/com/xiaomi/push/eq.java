package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* loaded from: classes2.dex */
class eq {
    public static void a(am.b bVar, String str, fa faVar) throws NumberFormatException {
        String strA;
        dp.c cVar = new dp.c();
        if (!TextUtils.isEmpty(bVar.f13346c)) {
            cVar.a(bVar.f13346c);
        }
        if (!TextUtils.isEmpty(bVar.f13348e)) {
            cVar.d(bVar.f13348e);
        }
        if (!TextUtils.isEmpty(bVar.f13349f)) {
            cVar.e(bVar.f13349f);
        }
        cVar.b(bVar.f1000a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f13347d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.f13347d);
        }
        er erVar = new er();
        erVar.c(bVar.f1001b);
        erVar.a(Integer.parseInt(bVar.f13350g));
        erVar.b(bVar.f998a);
        erVar.a("BIND", (String) null);
        erVar.a(erVar.e());
        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim]: bind id=" + erVar.e());
        HashMap map = new HashMap();
        map.put("challenge", str);
        map.put("token", bVar.f13346c);
        map.put("chid", bVar.f13350g);
        map.put("from", bVar.f1001b);
        map.put("id", erVar.e());
        map.put("to", "xiaomi.com");
        if (bVar.f1000a) {
            map.put("kick", "1");
        } else {
            map.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f13348e)) {
            map.put("client_attrs", "");
        } else {
            map.put("client_attrs", bVar.f13348e);
        }
        if (TextUtils.isEmpty(bVar.f13349f)) {
            map.put("cloud_attrs", "");
        } else {
            map.put("cloud_attrs", bVar.f13349f);
        }
        if (bVar.f13347d.equals("XIAOMI-PASS") || bVar.f13347d.equals("XMPUSH-PASS")) {
            strA = az.a(bVar.f13347d, null, map, bVar.f13351h);
        } else {
            bVar.f13347d.equals("XIAOMI-SASL");
            strA = null;
        }
        cVar.f(strA);
        erVar.a(cVar.m374a(), (String) null);
        faVar.b(erVar);
    }

    public static void a(String str, String str2, fa faVar) throws NumberFormatException {
        er erVar = new er();
        erVar.c(str2);
        erVar.a(Integer.parseInt(str));
        erVar.a("UBND", (String) null);
        faVar.b(erVar);
    }
}

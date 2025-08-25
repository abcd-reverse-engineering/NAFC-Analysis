package com.umeng.ut.a.a;

import android.content.Context;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.ut.b.a.a.d;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    public static String a(String str) {
        String appkey;
        Context contextM41a = com.umeng.ut.a.a.a().m41a();
        if (contextM41a == null) {
            return "";
        }
        try {
            appkey = UMUtils.getAppkey(contextM41a);
        } catch (Throwable unused) {
            appkey = "";
        }
        return d.d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", com.umeng.ut.a.a.a().m42a(), a(str, "", appkey, contextM41a.getPackageName())));
    }

    private static String a(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("audid", str2);
        map.put("utdid", str);
        map.put("appkey", str3);
        map.put("appName", str4);
        return new JSONObject(d.a(map)).toString();
    }
}

package com.huawei.hms.framework.network.grs.g.i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6906a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static d f6907b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f6908c = new Object();

    public static synchronized d a(Context context) {
        synchronized (f6908c) {
            if (f6907b != null) {
                return f6907b;
            }
            String strA = c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(strA).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.get(i2).toString());
                    }
                }
                f6907b = new d();
                f6907b.a(arrayList);
                f6907b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                f6907b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e2) {
                Logger.w(f6906a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            }
            return f6907b;
        }
    }
}

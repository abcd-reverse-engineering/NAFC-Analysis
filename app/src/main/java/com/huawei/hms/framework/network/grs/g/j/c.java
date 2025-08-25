package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f6911a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6912b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f6913c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f6911a = grsBaseInfo;
        this.f6912b = context;
    }

    private String e() throws JSONException {
        Set<String> setB = com.huawei.hms.framework.network.grs.f.b.a(this.f6912b.getPackageName()).b();
        if (setB.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = setB.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() throws JSONException {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f6913c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f6912b;
    }

    public void a(String str) {
        this.f6913c.add(str);
    }

    public GrsBaseInfo b() {
        return this.f6911a;
    }

    public String c() {
        return this.f6913c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f6913c;
    }
}

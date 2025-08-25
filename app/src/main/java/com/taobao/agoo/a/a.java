package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bh;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentMap<String, Integer> f8704a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f8705b;

    /* renamed from: c, reason: collision with root package name */
    private long f8706c;

    /* renamed from: d, reason: collision with root package name */
    private Context f8707d;

    public a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f8707d = context.getApplicationContext();
    }

    public void a(String str) throws JSONException {
        Integer num = this.f8704a.get(str);
        if (num == null || num.intValue() != 2) {
            this.f8704a.put(str, 2);
            com.taobao.accs.client.b.a(this.f8707d, "AGOO_BIND", this.f8706c, this.f8704a);
        }
    }

    public boolean b(String str) throws JSONException {
        if (this.f8704a.isEmpty()) {
            b();
        }
        Integer num = this.f8704a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", Constants.KEY_PACKAGE_NAME, str, "appStatus", num, "agooBindStatus", this.f8704a);
        return (UtilityImpl.a(Config.PREFERENCES, this.f8707d) || num == null || num.intValue() != 2) ? false : true;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8705b = str;
    }

    public boolean d(String str) {
        String str2 = this.f8705b;
        return str2 != null && str2.equals(str);
    }

    public void a() {
        this.f8705b = null;
    }

    private void b() throws JSONException {
        try {
            String string = this.f8707d.getSharedPreferences("AGOO_BIND", 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f8706c = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f8706c + 86400000) {
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    this.f8704a.put(jSONObject.getString(bh.aA), Integer.valueOf(jSONObject.getInt(bh.aE)));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.f8704a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(this.f8706c));
            this.f8706c = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

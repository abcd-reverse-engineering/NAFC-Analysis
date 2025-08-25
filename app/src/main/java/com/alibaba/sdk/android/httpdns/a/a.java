package com.alibaba.sdk.android.httpdns.a;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.beacon.Beacon;
import com.alibaba.sdk.android.httpdns.d.b;
import com.alibaba.sdk.android.httpdns.i;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f3997a;
    private Context mContext = null;

    /* renamed from: a, reason: collision with other field name */
    private b f3a = null;

    /* renamed from: a, reason: collision with other field name */
    private Beacon f2a = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3998m = true;

    /* renamed from: a, reason: collision with other field name */
    private final Beacon.OnUpdateListener f1a = new Beacon.OnUpdateListener() { // from class: com.alibaba.sdk.android.httpdns.a.a.1
        @Override // com.alibaba.sdk.android.beacon.Beacon.OnUpdateListener
        public void onUpdate(List<Beacon.Config> list) {
            try {
                a.this.b(list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: a, reason: collision with other field name */
    private final Beacon.OnServiceErrListener f0a = new Beacon.OnServiceErrListener() { // from class: com.alibaba.sdk.android.httpdns.a.a.2
        @Override // com.alibaba.sdk.android.beacon.Beacon.OnServiceErrListener
        public void onErr(Beacon.Error error) {
            String str = "beacon error. errorCode:" + error.errCode + ", errorMsg:" + error.errMsg;
        }
    };

    private a() {
    }

    public static a a() {
        if (f3997a == null) {
            synchronized (a.class) {
                if (f3997a == null) {
                    f3997a = new a();
                }
            }
        }
        return f3997a;
    }

    private boolean a(Beacon.Config config) {
        if (config == null || !config.key.equalsIgnoreCase("___httpdns_service___")) {
            return false;
        }
        String str = config.value;
        if (str != null) {
            String str2 = "httpdns configs:" + str;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ut")) {
                    f(jSONObject.getString("ut"));
                }
                if (jSONObject.has("ip-ranking")) {
                    i(jSONObject.getString("ip-ranking"));
                }
                if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                    j(jSONObject.getString(NotificationCompat.CATEGORY_STATUS));
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<Beacon.Config> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Beacon.Config config : list) {
            if (config.key.equalsIgnoreCase("___httpdns_service___")) {
                a(config);
            }
        }
    }

    private boolean f(String str) {
        if (str == null || this.f3a == null) {
            return false;
        }
        String str2 = "is report enabled:" + str;
        if (str.equalsIgnoreCase("disabled")) {
            this.f3a.e(false);
        } else {
            this.f3a.e(true);
        }
        return true;
    }

    private void i(String str) {
        if (str != null) {
            String str2 = "is IP probe enabled:" + str;
            this.f3998m = !str.equalsIgnoreCase("disabled");
        }
    }

    private void j(String str) {
        if (str != null) {
            com.alibaba.sdk.android.httpdns.b.a(!"disabled".equals(str));
            i.e("[beacon] httpdns enable: " + com.alibaba.sdk.android.httpdns.b.a());
        }
    }

    public void a(b bVar) {
        this.f3a = bVar;
    }

    public void c(Context context, String str) {
        this.mContext = context;
        if (this.mContext != null) {
            HashMap map = new HashMap();
            map.put("sdkId", "httpdns");
            map.put("accountId", str);
            this.f2a = new Beacon.Builder().appKey("24657847").appSecret("f30fc0937f2b1e9e50a1b7134f1ddb10").loopInterval(com.heytap.mcssdk.constant.a.n).extras(map).build();
            this.f2a.addUpdateListener(this.f1a);
            this.f2a.addServiceErrListener(this.f0a);
            this.f2a.start(this.mContext.getApplicationContext());
        }
    }

    public boolean f() {
        return this.f3998m;
    }
}

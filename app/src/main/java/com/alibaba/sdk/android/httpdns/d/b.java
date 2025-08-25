package com.alibaba.sdk.android.httpdns.d;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.AlicloudTracker;
import com.alibaba.sdk.android.utils.AlicloudTrackerManager;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.taobao.accs.common.Constants;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f4018b;

    /* renamed from: a, reason: collision with root package name */
    private AlicloudTracker f4019a;

    /* renamed from: a, reason: collision with other field name */
    private AlicloudTrackerManager f15a;
    private boolean q = true;
    private boolean r = false;

    /* renamed from: b, reason: collision with other field name */
    private a f16b = new a();

    private b(Context context) {
        this.f4019a = null;
        this.f15a = null;
        if (context == null || !(context.getApplicationContext() instanceof Application)) {
            return;
        }
        this.f15a = AlicloudTrackerManager.getInstance((Application) context.getApplicationContext());
        AlicloudTrackerManager alicloudTrackerManager = this.f15a;
        if (alicloudTrackerManager != null) {
            this.f4019a = alicloudTrackerManager.getTracker("httpdns", "1.3.2.3-no-bssid-ssid");
        }
    }

    public static b a() {
        return f4018b;
    }

    public static b a(Context context) {
        if (f4018b == null) {
            synchronized (b.class) {
                if (f4018b == null) {
                    f4018b = new b(context);
                }
            }
        }
        return f4018b;
    }

    public void a(String str, int i2, int i3, int i4) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                if (i4 == 0 || i4 == 1) {
                    final HashMap map = new HashMap();
                    map.put(Constants.KEY_HOST, str);
                    map.put("success", String.valueOf(i2));
                    map.put("ipv6", String.valueOf(i3));
                    map.put("cacheOpen", String.valueOf(i4));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.f4019a.sendCustomHit("perf_getip", map);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    public void a(String str, long j2, int i2) {
        if (this.q && this.f4019a != null && !TextUtils.isEmpty(str) && j2 > 0) {
            if (i2 == 0 || i2 == 1) {
                if (j2 > 30000) {
                    j2 = 30000;
                }
                final HashMap map = new HashMap();
                map.put("scAddr", str);
                map.put("cost", String.valueOf(j2));
                map.put("ipv6", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.f4019a.sendCustomHit("perf_sc", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        final HashMap map = new HashMap();
        map.put(Constants.KEY_HOST, str);
        map.put("scAddr", str2);
        map.put("srvAddr", str3);
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.f4019a.sendCustomHit("biz_sniffer", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void a(String str, String str2, String str3, int i2) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            final HashMap map = new HashMap();
            map.put("scAddr", str);
            map.put("errCode", str2);
            map.put("errMsg", str3);
            map.put("ipv6", String.valueOf(i2));
            this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.f4019a.sendCustomHit("err_sc", map);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        try {
            if (!this.q || this.f4019a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i2 == 0 || i2 == 1) {
                if (i3 == 0 || i3 == 1) {
                    final HashMap map = new HashMap();
                    map.put("srvAddr", str);
                    map.put("errCode", str2);
                    map.put("errMsg", str3);
                    map.put("ipv6", String.valueOf(i2));
                    map.put("ipv6_srv", String.valueOf(i3));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.14
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.f4019a.sendCustomHit("err_srv", map);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3, long j2, long j3, int i2) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i2 <= 0) {
            return;
        }
        if (j2 > com.heytap.mcssdk.constant.a.r) {
            j2 = 5000;
        }
        if (j3 > com.heytap.mcssdk.constant.a.r) {
            j3 = 5000;
        }
        final HashMap map = new HashMap();
        map.put(Constants.KEY_HOST, str);
        map.put("defaultIp", str2);
        map.put("selectedIp", str3);
        map.put("defaultIpCost", String.valueOf(j2));
        map.put("selectedIpCost", String.valueOf(j3));
        map.put("ipCount", String.valueOf(i2));
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.f4019a.sendCustomHit("perf_ipselection", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public boolean a(SDKMessageCallback sDKMessageCallback) {
        try {
            if (this.f15a != null) {
                return this.f15a.registerCrashDefend("httpdns", "1.3.2.3-no-bssid-ssid", 2, 7, sDKMessageCallback);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void b(String str, int i2, int i3, int i4) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                if (i4 == 0 || i4 == 1) {
                    final HashMap map = new HashMap();
                    map.put(Constants.KEY_HOST, str);
                    map.put("success", String.valueOf(i2));
                    map.put("ipv6", String.valueOf(i3));
                    map.put("cacheOpen", String.valueOf(i4));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.6
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.f4019a.sendCustomHit("perf_user_getip", map);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    public void b(String str, long j2, int i2) {
        if (this.q && this.f4019a != null && !TextUtils.isEmpty(str) && j2 > 0) {
            if (i2 == 0 || i2 == 1) {
                if (j2 > 30000) {
                    j2 = 30000;
                }
                final HashMap map = new HashMap();
                map.put("srvAddr", str);
                map.put("cost", String.valueOf(j2));
                map.put("ipv6", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.f4019a.sendCustomHit("perf_srv", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void b(String str, String str2, String str3) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        final HashMap map = new HashMap();
        map.put(Constants.KEY_HOST, str);
        map.put("scAddr", str2);
        map.put("srvAddr", str3);
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.f4019a.sendCustomHit("biz_local_disable", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void c(int i2) {
        if (this.q && this.f4019a != null) {
            if (i2 == 0 || i2 == 1) {
                final HashMap map = new HashMap();
                map.put("enable", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.f4019a.sendCustomHit("biz_cache", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void d(int i2) {
        if (this.q && this.f4019a != null) {
            if (i2 == 0 || i2 == 1) {
                final HashMap map = new HashMap();
                map.put("enable", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.f4019a.sendCustomHit("biz_expired_ip", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void e(int i2) {
        try {
            if (this.q && this.f4019a != null) {
                if (i2 == 0 || i2 == 1) {
                    final HashMap map = new HashMap();
                    map.put("enable", String.valueOf(i2));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.12
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.f4019a.sendCustomHit("biz_ipv6_enable", map);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(boolean z) {
        synchronized (b.class) {
            if (!this.r) {
                this.q = z;
            }
        }
    }

    public void k() {
        synchronized (b.class) {
            this.r = true;
            this.q = false;
        }
    }

    public void k(String str) {
        if (!this.q || this.f4019a == null || TextUtils.isEmpty(str)) {
            return;
        }
        final HashMap map = new HashMap();
        map.put("exception", str);
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.f4019a.sendCustomHit("err_uncaught_exception", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void l() {
        if (this.q && this.f4019a != null) {
            this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.f4019a.sendCustomHit("biz_active", null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void setAccountId(String str) {
        AlicloudTracker alicloudTracker = this.f4019a;
        if (alicloudTracker != null) {
            alicloudTracker.setGlobalProperty("accountId", str);
        }
    }
}

package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static volatile n f4067a = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f4068d = false;

    /* renamed from: e, reason: collision with root package name */
    private static long f4069e = 0;

    /* renamed from: g, reason: collision with root package name */
    private static String f4070g = "https://";

    /* renamed from: h, reason: collision with root package name */
    private static String f4071h = null;

    /* renamed from: h, reason: collision with other field name */
    public static boolean f24h = false;

    /* renamed from: c, reason: collision with root package name */
    private String f4072c;

    /* renamed from: e, reason: collision with other field name */
    private boolean f28e;

    /* renamed from: e, reason: collision with other field name */
    private int f27e = 0;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f25a = null;

    /* renamed from: f, reason: collision with other field name */
    private long f29f = 0;

    /* renamed from: g, reason: collision with other field name */
    private long f31g = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f4073f = 0;

    /* renamed from: f, reason: collision with other field name */
    private boolean f30f = false;

    /* renamed from: g, reason: collision with other field name */
    private boolean f32g = true;

    /* renamed from: i, reason: collision with root package name */
    private String f4074i = null;

    /* renamed from: a, reason: collision with other field name */
    private Handler f26a = null;

    private n() {
    }

    public static n a() {
        if (f4067a == null) {
            synchronized (n.class) {
                if (f4067a == null) {
                    f4067a = new n();
                }
            }
        }
        return f4067a;
    }

    private void a(String str, long j2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.a(str, j2, com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i.d("update server ips from StartIp schedule center.");
        this.f31g = System.currentTimeMillis();
        this.f27e = 0;
        this.f4073f = 0;
        this.f30f = false;
        this.f28e = true;
        this.f32g = true;
        f24h = false;
        m.a().a(f.f4052b.length - 1);
        c.a().submit(m.a());
        this.f26a = null;
    }

    private void d(Throwable th) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                int iA = com.alibaba.sdk.android.httpdns.d.c.a(th);
                bVarA.a(m27d(), String.valueOf(iA), th.getMessage(), com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String e() {
        return (this.f28e || this.f30f) ? f.f4052b[this.f4073f] : f.f19a[this.f27e];
    }

    /* renamed from: e, reason: collision with other method in class */
    private void m26e() {
        int i2 = this.f27e;
        this.f27e = i2 < f.f19a.length + (-1) ? i2 + 1 : 0;
    }

    private void f() {
        int i2 = this.f4073f;
        this.f4073f = i2 < f.f4052b.length + (-1) ? i2 + 1 : 0;
    }

    synchronized void a(Context context, String str) {
        try {
            if (!f4068d) {
                synchronized (n.class) {
                    if (!f4068d) {
                        setAccountId(str);
                        if (context != null) {
                            this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        this.f28e = this.f25a.getBoolean("httpdns_first_start", true);
                        f4071h = this.f25a.getString("httpdns_server_ips", null);
                        this.f4074i = this.f25a.getString("httpdns_region", null);
                        if (f4071h != null) {
                            f.a(f4071h.split(";"));
                        }
                        f4069e = this.f25a.getLong("schedule_center_last_request_time", 0L);
                        if (f4069e == 0 || System.currentTimeMillis() - f4069e >= 86400000) {
                            t.a().c(false);
                            c();
                        }
                        f4068d = true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    synchronized void a(o oVar, long j2) {
        try {
            a(m27d(), j2);
            this.f27e = 0;
            this.f4073f = 0;
            this.f30f = false;
            this.f32g = true;
            HttpDns.switchDnsService(oVar.isEnabled());
            if (a(oVar.b())) {
                i.d("StartIp Scheduler center update success    StartIp isFirstStart：" + this.f28e);
                f24h = true;
                this.f29f = System.currentTimeMillis();
                u.i();
                if (this.f28e) {
                    SharedPreferences.Editor editorEdit = this.f25a.edit();
                    editorEdit.putBoolean("httpdns_first_start", false);
                    editorEdit.commit();
                    this.f28e = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    synchronized boolean a(String[] strArr) {
        try {
            if (!f.a(strArr)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            if (this.f25a == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = this.f25a.edit();
            editorEdit.putString("httpdns_server_ips", sb.toString());
            editorEdit.putLong("schedule_center_last_request_time", System.currentTimeMillis());
            editorEdit.commit();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    synchronized void b(Context context, String str) {
        try {
            if (str.equals(this.f4074i)) {
                i.e("region should be different");
            } else {
                this.f4074i = str;
                if (System.currentTimeMillis() - this.f31g >= 300000) {
                    d();
                } else {
                    long jCurrentTimeMillis = 300000 - (System.currentTimeMillis() - this.f31g);
                    i.e("The call time should be greater than 5 minutes. SDK will initiate an update request after " + (jCurrentTimeMillis / com.heytap.mcssdk.constant.a.f5800d) + " minutes.");
                    if (this.f26a == null) {
                        this.f26a = new Handler();
                        this.f26a.postDelayed(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.d();
                            }
                        }, jCurrentTimeMillis);
                    }
                }
                if (this.f25a == null) {
                    if (context == null) {
                        i.f("sp failed to save, does not affect the current settings");
                        return;
                    }
                    this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                }
                SharedPreferences.Editor editorEdit = this.f25a.edit();
                editorEdit.putString("httpdns_region", this.f4074i);
                editorEdit.putBoolean("httpdns_first_start", true);
                editorEdit.putLong("schedule_center_last_request_time", 0L);
                editorEdit.commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    synchronized void c() {
        m mVarA;
        int length;
        if (System.currentTimeMillis() - this.f29f >= 300000) {
            i.d("update server ips from StartIp schedule center.");
            this.f27e = 0;
            this.f4073f = 0;
            this.f30f = false;
            this.f32g = true;
            f24h = false;
            if (this.f28e) {
                mVarA = m.a();
                length = f.f4052b.length;
            } else {
                mVarA = m.a();
                length = f.f19a.length;
            }
            mVarA.a(length - 1);
            c.a().submit(m.a());
        } else {
            i.d("update server ips from StartIp schedule center too often, give up. ");
            u.j();
        }
    }

    synchronized void c(Throwable th) {
        try {
            f24h = false;
            d(th);
            if (this.f28e) {
                f();
            } else {
                if (!this.f30f) {
                    m26e();
                }
                if (this.f27e == 0) {
                    this.f30f = true;
                    if (this.f32g) {
                        this.f32g = false;
                        this.f4073f = 0;
                        i.d("StartIp Scheduler center update from StartIp");
                        m.a().a(f.f4052b.length - 1);
                        c.a().submit(m.a());
                    } else {
                        f();
                        if (this.f4073f == 0) {
                            this.f29f = System.currentTimeMillis();
                            i.f("StartIp Scheduler center update failed");
                            u.j();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    synchronized String m27d() {
        StringBuilder sb;
        String str;
        try {
            sb = new StringBuilder();
            sb.append(f4070g);
            sb.append(e());
            sb.append("/");
            sb.append(this.f4072c == null ? f.f4053c : this.f4072c);
            sb.append("/ss?platform=android&sdk_version=");
            sb.append("1.3.2.3-no-bssid-ssid");
            sb.append("&sid=");
            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
            sb.append("&net=");
            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
            if (TextUtils.isEmpty(this.f4074i)) {
                str = "";
            } else {
                str = "&region=" + this.f4074i;
            }
            sb.append(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public void setAccountId(String str) {
        this.f4072c = str;
    }
}

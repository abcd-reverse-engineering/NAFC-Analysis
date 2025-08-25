package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bj;
import com.tencent.bugly.proguard.bk;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f9005a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static long f9006b = 259200000;

    /* renamed from: c, reason: collision with root package name */
    private static a f9007c;

    /* renamed from: i, reason: collision with root package name */
    private static String f9008i;

    /* renamed from: d, reason: collision with root package name */
    private final List<com.tencent.bugly.a> f9009d;

    /* renamed from: h, reason: collision with root package name */
    private Context f9013h;

    /* renamed from: g, reason: collision with root package name */
    private StrategyBean f9012g = null;

    /* renamed from: f, reason: collision with root package name */
    private final StrategyBean f9011f = new StrategyBean();

    /* renamed from: e, reason: collision with root package name */
    private final am f9010e = am.a();

    protected a(Context context, List<com.tencent.bugly.a> list) {
        this.f9013h = context;
        this.f9009d = list;
    }

    public StrategyBean c() {
        StrategyBean strategyBean = this.f9012g;
        if (strategyBean != null) {
            if (!aq.c(strategyBean.r)) {
                this.f9012g.r = StrategyBean.f8993b;
            }
            if (!aq.c(this.f9012g.s)) {
                this.f9012g.s = StrategyBean.f8994c;
            }
            return this.f9012g;
        }
        if (!aq.a(f9008i) && aq.c(f9008i)) {
            StrategyBean strategyBean2 = this.f9011f;
            String str = f9008i;
            strategyBean2.r = str;
            strategyBean2.s = str;
        }
        return this.f9011f;
    }

    public StrategyBean d() {
        byte[] bArr;
        List<ag> listA = ae.a().a(2);
        if (listA == null || listA.size() <= 0 || (bArr = listA.get(0).f9209g) == null) {
            return null;
        }
        return (StrategyBean) aq.a(bArr, StrategyBean.CREATOR);
    }

    public synchronized boolean b() {
        return this.f9012g != null;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        if (f9007c == null) {
            f9007c = new a(context, list);
        }
        return f9007c;
    }

    public void a(long j2) {
        this.f9010e.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Map<String, byte[]> mapA = ae.a().a(a.f9005a, (ad) null, true);
                    if (mapA != null) {
                        byte[] bArr = mapA.get("device");
                        byte[] bArr2 = mapA.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f9013h).e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f9013h).d(new String(bArr2));
                        }
                    }
                    a.this.f9012g = a.this.d();
                    if (a.this.f9012g != null) {
                        if (!aq.a(a.f9008i) && aq.c(a.f9008i)) {
                            a.this.f9012g.r = a.f9008i;
                            a.this.f9012g.s = a.f9008i;
                        } else if (com.tencent.bugly.crashreport.common.info.a.b() == null || !"oversea".equals(com.tencent.bugly.crashreport.common.info.a.b().F)) {
                            if (TextUtils.isEmpty(a.this.f9012g.r)) {
                                a.this.f9012g.r = StrategyBean.f8993b;
                            }
                            if (TextUtils.isEmpty(a.this.f9012g.s)) {
                                a.this.f9012g.s = StrategyBean.f8994c;
                            }
                        } else if ("http://android.bugly.qq.com/rqd/async".equals(a.this.f9012g.s) || "http://aexception.bugly.qq.com:8012/rqd/async".equals(a.this.f9012g.s) || TextUtils.isEmpty(a.this.f9012g.s)) {
                            a.this.f9012g.r = StrategyBean.f8993b;
                            a.this.f9012g.s = StrategyBean.f8994c;
                        }
                    }
                } catch (Throwable th) {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f9012g, false);
            }
        }, j2);
    }

    public static synchronized a a() {
        return f9007c;
    }

    protected void a(StrategyBean strategyBean, boolean z) {
        an.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f9009d) {
            try {
                an.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!aq.a(str) && aq.c(str)) {
            f9008i = str;
        } else {
            an.d("URL user set is invalid.", new Object[0]);
        }
    }

    public void a(bk bkVar) throws NumberFormatException {
        if (bkVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f9012g;
        if (strategyBean == null || bkVar.f9355h != strategyBean.p) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f8998g = bkVar.f9348a;
            strategyBean2.f9000i = bkVar.f9350c;
            strategyBean2.f8999h = bkVar.f9349b;
            if (aq.a(f9008i) || !aq.c(f9008i)) {
                if (aq.c(bkVar.f9351d)) {
                    an.c("[Strategy] Upload url changes to %s", bkVar.f9351d);
                    strategyBean2.r = bkVar.f9351d;
                }
                if (aq.c(bkVar.f9352e)) {
                    an.c("[Strategy] Exception upload url changes to %s", bkVar.f9352e);
                    strategyBean2.s = bkVar.f9352e;
                }
            }
            bj bjVar = bkVar.f9353f;
            if (bjVar != null && !aq.a(bjVar.f9345a)) {
                strategyBean2.u = bkVar.f9353f.f9345a;
            }
            long j2 = bkVar.f9355h;
            if (j2 != 0) {
                strategyBean2.p = j2;
            }
            Map<String, String> map = bkVar.f9354g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = bkVar.f9354g;
                strategyBean2.v = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f9001j = true;
                } else {
                    strategyBean2.f9001j = false;
                }
                String str2 = bkVar.f9354g.get("B3");
                if (str2 != null) {
                    strategyBean2.y = Long.valueOf(str2).longValue();
                }
                int i2 = bkVar.f9359l;
                strategyBean2.q = i2;
                strategyBean2.x = i2;
                String str3 = bkVar.f9354g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i3 = Integer.parseInt(str3);
                        if (i3 > 0) {
                            strategyBean2.w = i3;
                        }
                    } catch (Exception e2) {
                        if (!an.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = bkVar.f9354g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.f9003l = true;
                } else {
                    strategyBean2.f9003l = false;
                }
            }
            an.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f8998g), Boolean.valueOf(strategyBean2.f9000i), Boolean.valueOf(strategyBean2.f8999h), Boolean.valueOf(strategyBean2.f9001j), Boolean.valueOf(strategyBean2.f9002k), Boolean.valueOf(strategyBean2.n), Boolean.valueOf(strategyBean2.o), Long.valueOf(strategyBean2.q), Boolean.valueOf(strategyBean2.f9003l), Long.valueOf(strategyBean2.p));
            this.f9012g = strategyBean2;
            if (!aq.c(bkVar.f9351d)) {
                an.c("[Strategy] download url is null", new Object[0]);
                this.f9012g.r = "";
            }
            if (!aq.c(bkVar.f9352e)) {
                an.c("[Strategy] download crashurl is null", new Object[0]);
                this.f9012g.s = "";
            }
            ae.a().b(2);
            ag agVar = new ag();
            agVar.f9204b = 2;
            agVar.f9203a = strategyBean2.f8996e;
            agVar.f9207e = strategyBean2.f8997f;
            agVar.f9209g = aq.a(strategyBean2);
            ae.a().a(agVar);
            a(strategyBean2, true);
        }
    }
}

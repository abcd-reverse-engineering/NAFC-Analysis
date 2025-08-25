package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f8582a;

    /* renamed from: b, reason: collision with root package name */
    public int f8583b;

    /* renamed from: f, reason: collision with root package name */
    public String f8587f;

    /* renamed from: g, reason: collision with root package name */
    public String f8588g;

    /* renamed from: h, reason: collision with root package name */
    public long f8589h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8590i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8591j;

    /* renamed from: k, reason: collision with root package name */
    private long f8592k = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8584c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f8585d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f8586e = 0;

    public void a() {
        String strValueOf;
        String strValueOf2;
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog()) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (jCurrentTimeMillis - this.f8592k) + " interval1:" + (jCurrentTimeMillis - this.f8589h), new Object[0]);
        }
        if (jCurrentTimeMillis - this.f8592k <= 1200000 || jCurrentTimeMillis - this.f8589h <= com.heytap.mcssdk.constant.a.f5800d) {
            return;
        }
        HashMap map = new HashMap();
        String str2 = null;
        try {
            strValueOf2 = String.valueOf(this.f8585d);
            try {
                String strValueOf3 = String.valueOf(this.f8586e);
                try {
                    strValueOf = String.valueOf(221);
                    try {
                        map.put("connStatus", String.valueOf(this.f8582a));
                        map.put("connType", String.valueOf(this.f8583b));
                        map.put("tcpConnected", String.valueOf(this.f8584c));
                        map.put("proxy", String.valueOf(this.f8587f));
                        map.put("startServiceTime", String.valueOf(this.f8589h));
                        map.put("commitTime", String.valueOf(jCurrentTimeMillis));
                        map.put("networkAvailable", String.valueOf(this.f8590i));
                        map.put("threadIsalive", String.valueOf(this.f8591j));
                        map.put("url", this.f8588g);
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            try {
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, strValueOf3, strValueOf, map), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str2 = strValueOf3;
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, str2, strValueOf, map) + c.c.a.b.a.a.f3100g + th.toString(), new Object[0]);
                            }
                        }
                        str = strValueOf3;
                        try {
                            UTMini.getInstance().commitEvent(66001, "MONITOR", strValueOf2, strValueOf3, strValueOf, map);
                            this.f8592k = jCurrentTimeMillis;
                        } catch (Throwable th2) {
                            th = th2;
                            strValueOf = strValueOf;
                            str2 = str;
                            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, str2, strValueOf, map) + c.c.a.b.a.a.f3100g + th.toString(), new Object[0]);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = strValueOf3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = strValueOf3;
                    strValueOf = null;
                }
            } catch (Throwable th5) {
                th = th5;
                strValueOf = null;
            }
        } catch (Throwable th6) {
            th = th6;
            strValueOf = null;
            strValueOf2 = null;
        }
    }
}

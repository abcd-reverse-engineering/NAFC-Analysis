package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    protected static h f9801a;

    /* renamed from: e, reason: collision with root package name */
    protected HandlerThread f9805e;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f9806f;

    /* renamed from: b, reason: collision with root package name */
    protected Random f9802b = new SecureRandom();

    /* renamed from: d, reason: collision with root package name */
    protected List<Serializable> f9804d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c, reason: collision with root package name */
    protected List<Serializable> f9803c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g, reason: collision with root package name */
    protected Executor f9807g = l.b();

    /* renamed from: h, reason: collision with root package name */
    protected Executor f9808h = l.b();

    private h() {
        this.f9805e = null;
        if (this.f9805e == null) {
            this.f9805e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f9805e.start();
        }
        if (!this.f9805e.isAlive() || this.f9805e.getLooper() == null) {
            return;
        }
        this.f9806f = new Handler(this.f9805e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    h.this.b();
                } else if (i2 == 1001) {
                    h.this.d();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized h a() {
        if (f9801a == null) {
            f9801a = new h();
        }
        return f9801a;
    }

    protected void b() {
    }

    protected Map<String, String> c() throws JSONException {
        List<Serializable> listB = g.b("report_via");
        if (listB != null) {
            this.f9804d.addAll(listB);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f9804d.size());
        if (this.f9804d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f9804d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.f9797a.keySet()) {
                try {
                    String str2 = cVar.f9797a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap map = new HashMap();
            map.put("data", jSONObject2.toString());
            return map;
        } catch (JSONException e3) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    protected void d() {
        if (m.b(com.tencent.open.utils.g.a())) {
            this.f9807g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    int i2;
                    long jB;
                    long jC;
                    long j2;
                    long j3;
                    long j4;
                    boolean z;
                    com.tencent.open.a.g gVarB;
                    JSONObject jSONObjectD;
                    int i3;
                    try {
                        Map<String, String> mapC = h.this.c();
                        if (mapC == null) {
                            return;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, params: " + mapC.toString());
                        int iA = f.a();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i4 = 0;
                        int errorCodeFromException = 0;
                        do {
                            int i5 = i4 + 1;
                            try {
                                try {
                                    gVarB = com.tencent.open.a.f.a().b("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", mapC);
                                    SLog.i("openSDK_LOG.ReportManager", "-->reportVia: statusCode " + gVarB.d());
                                    jSONObjectD = m.d(gVarB.a());
                                    jC = (long) gVarB.c();
                                    i2 = i5;
                                    jB = gVarB.b();
                                } catch (SocketTimeoutException unused) {
                                    i2 = i5;
                                } catch (IOException e2) {
                                    e = e2;
                                    i2 = i5;
                                } catch (JSONException unused2) {
                                    i2 = i5;
                                }
                            } catch (Exception unused3) {
                                i4 = iA;
                                jB = 0;
                                jC = 0;
                                errorCodeFromException = -6;
                            }
                            try {
                                try {
                                } catch (SocketTimeoutException unused4) {
                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                    jB = 0;
                                    jC = 0;
                                    i4 = i2;
                                    errorCodeFromException = -8;
                                } catch (IOException e3) {
                                    e = e3;
                                    errorCodeFromException = HttpUtils.getErrorCodeFromException(e);
                                    jB = 0;
                                    jC = 0;
                                    i4 = i2;
                                }
                                if (gVarB.d() != 200) {
                                    errorCodeFromException = gVarB.d();
                                    break;
                                }
                                try {
                                    i3 = jSONObjectD.getInt("ret");
                                } catch (JSONException unused5) {
                                    i3 = -4;
                                }
                                if (i3 == 0 || jB != 0) {
                                    j4 = jElapsedRealtime;
                                    j2 = jB;
                                    j3 = jC;
                                    z = true;
                                    break;
                                }
                                i4 = i2;
                            } catch (JSONException unused6) {
                                jB = 0;
                                jC = 0;
                                i4 = i2;
                                errorCodeFromException = -4;
                            }
                        } while (i4 < iA);
                        j4 = jElapsedRealtime;
                        j2 = jB;
                        j3 = jC;
                        z = false;
                        h.this.a("mapp_apptrace_sdk", j4, j3, j2, errorCodeFromException, null, false);
                        if (z) {
                            g.a("report_via");
                        } else {
                            g.a("report_via", h.this.f9804d);
                        }
                        h.this.f9804d.clear();
                        SLog.i("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z + " resultCode: " + errorCodeFromException);
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e4);
                    }
                }
            });
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.f9807g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                        bundle2.putString(bh.N, d.a());
                        bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
                        bundle2.putString(bh.M, TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", m.d(com.tencent.open.utils.g.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, m.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", m.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.g.b());
                        bundle2.putString(Constants.PARAM_APP_VER, m.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        h.this.f9804d.add(new c(bundle2));
                        int size = h.this.f9804d.size();
                        int iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA == 0) {
                            iA = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z) {
                            if (h.this.f9806f.hasMessages(1001)) {
                                return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1001;
                            h.this.f9806f.sendMessageDelayed(messageObtain, iA);
                            return;
                        }
                        h.this.d();
                        h.this.f9806f.removeMessages(1001);
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    public void a(String str, long j2, long j3, long j4, int i2) {
        a(str, j2, j3, j4, i2, "", false);
    }

    public void a(String str, long j2, long j3, long j4, int i2, String str2, boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i2 + " | detail: " + str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[PHI: r6
  0x0057: PHI (r6v5 int) = (r6v2 int), (r6v8 int) binds: [B:9:0x003f, B:15:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->availableFrequency, report: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = " | ext: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.d(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r0 == 0) goto L26
            return r2
        L26:
            java.lang.String r0 = "report_cgi"
            boolean r0 = r6.equals(r0)
            r3 = 1
            r4 = 100
            if (r0 == 0) goto L43
            int r6 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L42
            int r6 = r5.a(r6)
            java.util.Random r7 = r5.f9802b
            int r7 = r7.nextInt(r4)
            if (r7 >= r6) goto L5b
            goto L57
        L42:
            return r2
        L43:
            java.lang.String r0 = "report_via"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L59
            int r6 = com.tencent.open.b.f.a(r7)
            java.util.Random r7 = r5.f9802b
            int r7 = r7.nextInt(r4)
            if (r7 >= r6) goto L5b
        L57:
            r2 = 1
            goto L5b
        L59:
            r6 = 100
        L5b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "-->availableFrequency, result: "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r0 = " | frequency: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.tencent.open.log.SLog.d(r1, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1d
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L37
        L1b:
            r0 = 5
            goto L37
        L1d:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L36
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L37
            goto L1b
        L36:
            r0 = 0
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " | dataSize: "
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = " | maxcount: "
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.d(r1, r5)
            if (r6 < r0) goto L61
            r5 = 1
            return r5
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.a(java.lang.String, int):boolean");
    }

    protected int a(int i2) {
        if (i2 == 0) {
            int iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (iA == 0) {
                return 10;
            }
            return iA;
        }
        int iA2 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (iA2 == 0) {
            return 100;
        }
        return iA2;
    }

    public void a(final String str, final Map<String, String> map) {
        if (m.b(com.tencent.open.utils.g.a())) {
            l.b(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    try {
                        int iA = f.a();
                        if (iA == 0) {
                            iA = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                        do {
                            i2++;
                            try {
                                SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.f.a().a(str, map).d());
                            } catch (SocketTimeoutException e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e2);
                            } catch (Exception e3) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e3);
                            }
                        } while (i2 < iA);
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e4);
                    }
                }
            });
        }
    }
}

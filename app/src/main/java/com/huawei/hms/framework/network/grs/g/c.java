package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.d;
import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class c {

    /* renamed from: l, reason: collision with root package name */
    private static final String f6863l = "c";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f6864a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6865b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f6866c;

    /* renamed from: d, reason: collision with root package name */
    private d f6867d;

    /* renamed from: i, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.j.c f6872i;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Future<d>> f6868e = new ConcurrentHashMap(16);

    /* renamed from: f, reason: collision with root package name */
    private final List<d> f6869f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final JSONArray f6870g = new JSONArray();

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f6871h = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    private String f6873j = "";

    /* renamed from: k, reason: collision with root package name */
    private long f6874k = 1;

    public c(com.huawei.hms.framework.network.grs.g.j.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f6872i = cVar;
        this.f6864a = cVar.b();
        this.f6865b = cVar.a();
        this.f6866c = aVar;
        b();
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[LOOP:0: B:3:0x0006->B:36:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.g.d a(java.util.concurrent.ExecutorService r17, java.util.List<java.lang.String> r18, java.lang.String r19, com.huawei.hms.framework.network.grs.e.c r20) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r16 = this;
            r9 = r16
            r10 = 0
            r0 = 0
            r12 = r0
            r11 = 0
        L6:
            int r0 = r18.size()
            if (r11 >= r0) goto L9d
            r13 = r18
            java.lang.Object r0 = r13.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r14 = 1
            if (r1 != 0) goto L8c
            com.huawei.hms.framework.network.grs.g.a r15 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.f6865b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.f6864a
            r1 = r15
            r2 = r0
            r3 = r11
            r4 = r16
            r6 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r15.g()
            r2 = r17
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.f6868e
            r3.put(r0, r1)
            long r3 = r9.f6874k     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            java.lang.Object r0 = r1.get(r3, r0)     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            if (r1 == 0) goto L81
            boolean r0 = r1.o()     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            if (r0 != 0) goto L55
            boolean r0 = r1.m()     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            if (r0 == 0) goto L81
        L55:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.f6863l     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            goto L76
        L5d:
            r12 = r1
            goto L65
        L5f:
            r0 = move-exception
            goto L6f
        L61:
            r0 = move-exception
            goto L7a
        L63:
            r12 = r1
            goto L83
        L65:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.f6863l
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
            goto L8e
        L6d:
            r0 = move-exception
            r1 = r12
        L6f:
            java.lang.String r3 = com.huawei.hms.framework.network.grs.g.c.f6863l
            java.lang.String r4 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w(r3, r4, r0)
        L76:
            r12 = r1
            goto L8f
        L78:
            r0 = move-exception
            r1 = r12
        L7a:
            java.lang.String r3 = com.huawei.hms.framework.network.grs.g.c.f6863l
            java.lang.String r4 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w(r3, r4, r0)
        L81:
            r12 = r1
            goto L8e
        L83:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.f6863l
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            goto L8f
        L8c:
            r2 = r17
        L8e:
            r14 = 0
        L8f:
            if (r14 == 0) goto L99
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.f6863l
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r0, r1)
            goto L9d
        L99:
            int r11 = r11 + 1
            goto L6
        L9d:
            com.huawei.hms.framework.network.grs.g.d r0 = r9.b(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.c.a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.f6864a.getGrsReqParamJoint(false, false, d(), this.f6865b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f6871h.add(sb.toString());
    }

    private d b(d dVar) throws ExecutionException, InterruptedException, TimeoutException {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.f6868e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str = f6863l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(f6863l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e3) {
                e = e3;
                str = f6863l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(f6863l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    private void b() {
        com.huawei.hms.framework.network.grs.g.j.d dVarA = com.huawei.hms.framework.network.grs.g.i.a.a(this.f6865b);
        if (dVarA == null) {
            Logger.w(f6863l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(dVarA);
        List<String> listA = dVarA.a();
        if (listA == null || listA.size() <= 0) {
            Logger.v(f6863l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (listA.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String strB = dVarA.b();
        if (listA.size() > 0) {
            for (String str : listA) {
                if (str.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    a(strB, str);
                } else {
                    Logger.w(f6863l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.v(f6863l, "request to GRS server url is {%s}", this.f6871h);
    }

    private void c() {
        String grsParasKey = this.f6864a.getGrsParasKey(true, true, this.f6865b);
        this.f6873j = this.f6866c.a().a(grsParasKey + HttpHeaders.ETAG, "");
    }

    private String d() {
        com.huawei.hms.framework.network.grs.f.b bVarA = com.huawei.hms.framework.network.grs.f.b.a(this.f6865b.getPackageName());
        com.huawei.hms.framework.network.grs.local.model.a aVarA = bVarA != null ? bVarA.a() : null;
        if (aVarA == null) {
            return "";
        }
        String strA = aVarA.a();
        Logger.v(f6863l, "get appName from local assets is{%s}", strA);
        return strA;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f6871h.isEmpty()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        d dVarA = a(executorService, this.f6871h, str, cVar);
        Logger.i(f6863l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(dVarA == null ? 0 : dVarA.b()));
        e.a(new ArrayList(this.f6869f), SystemClock.elapsedRealtime() - jElapsedRealtime, this.f6870g, this.f6865b);
        this.f6869f.clear();
        return dVarA;
    }

    public String a() {
        return this.f6873j;
    }

    public synchronized void a(d dVar) {
        this.f6869f.add(dVar);
        d dVar2 = this.f6867d;
        if (dVar2 != null && (dVar2.o() || this.f6867d.m())) {
            Logger.v(f6863l, "grsResponseResult is ok");
            return;
        }
        if (dVar.n()) {
            Logger.i(f6863l, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.f6864a.getGrsParasKey(true, true, this.f6865b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
            return;
        }
        if (dVar.m()) {
            Logger.i(f6863l, "GRS server open 304 Not Modified.");
        }
        if (!dVar.o() && !dVar.m()) {
            Logger.v(f6863l, "grsResponseResult has exception so need return");
            return;
        }
        this.f6867d = dVar;
        this.f6866c.a(this.f6864a, this.f6867d, this.f6865b, this.f6872i);
        for (Map.Entry<String, Future<d>> entry : this.f6868e.entrySet()) {
            if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                Logger.i(f6863l, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d dVar) {
    }
}

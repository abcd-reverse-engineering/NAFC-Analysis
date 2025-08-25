package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static final String f6816i = "c";

    /* renamed from: j, reason: collision with root package name */
    private static final ExecutorService f6817j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* renamed from: k, reason: collision with root package name */
    private static long f6818k = 0;

    /* renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f6819a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6820b;

    /* renamed from: c, reason: collision with root package name */
    private g f6821c;

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f6822d;

    /* renamed from: e, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f6823e;

    /* renamed from: f, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f6824f;

    /* renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f6825g;

    /* renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f6826h;

    class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6827a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f6828b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f6827a = context;
            this.f6828b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws NumberFormatException {
            c.this.f6821c = new g();
            c.this.f6823e = new com.huawei.hms.framework.network.grs.e.c(this.f6827a, GrsApp.getInstance().getBrand(c.c.a.b.a.a.s1) + "share_pre_grs_conf_");
            c.this.f6824f = new com.huawei.hms.framework.network.grs.e.c(this.f6827a, GrsApp.getInstance().getBrand(c.c.a.b.a.a.s1) + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.f6822d = new com.huawei.hms.framework.network.grs.e.a(cVar.f6823e, c.this.f6824f, c.this.f6821c);
            c cVar2 = c.this;
            cVar2.f6825g = new com.huawei.hms.framework.network.grs.a(cVar2.f6819a, c.this.f6822d, c.this.f6821c, c.this.f6824f);
            if (com.huawei.hms.framework.network.grs.f.b.a(this.f6827a.getPackageName()) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.f6827a, true);
            }
            String strC = new com.huawei.hms.framework.network.grs.g.j.c(this.f6828b, this.f6827a).c();
            Logger.v(c.f6816i, "scan serviceSet is: " + strC);
            String strA = c.this.f6824f.a("services", "");
            String strA2 = h.a(strA, strC);
            if (!TextUtils.isEmpty(strA2)) {
                c.this.f6824f.b("services", strA2);
                Logger.i(c.f6816i, "postList is:" + StringUtils.anonymizeMessage(strA2));
                Logger.i(c.f6816i, "currentServices:" + StringUtils.anonymizeMessage(strA));
                if (!strA2.equals(strA)) {
                    c.this.f6821c.a(c.this.f6819a.getGrsParasKey(true, true, this.f6827a));
                    c.this.f6821c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f6828b, this.f6827a), null, null, c.this.f6824f, c.this.f6819a.getQueryTimeout());
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - c.f6818k;
            if (c.f6818k == 0 || TimeUnit.MILLISECONDS.toHours(jElapsedRealtime) > 24) {
                Logger.i(c.f6816i, "Try to clear unUsed sp data.");
                long unused = c.f6818k = SystemClock.elapsedRealtime();
                c cVar3 = c.this;
                cVar3.a(cVar3.f6823e.a());
            }
            c.this.f6822d.b(this.f6828b, this.f6827a);
            return true;
        }
    }

    c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f6826h = null;
        this.f6820b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f6819a;
        this.f6826h = new FutureTask<>(new a(this.f6820b, grsBaseInfo2));
        f6817j.execute(this.f6826h);
        Logger.i(f6816i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    c(GrsBaseInfo grsBaseInfo) {
        this.f6826h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f6819a = grsBaseInfo.m39clone();
        } catch (CloneNotSupportedException e2) {
            Logger.w(f6816i, "GrsClient catch CloneNotSupportedException", e2);
            this.f6819a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) throws NumberFormatException {
        if (map == null || map.isEmpty()) {
            Logger.v(f6816i, "sp's content is empty.");
            return;
        }
        Set<String> setKeySet = map.keySet();
        for (String str : setKeySet) {
            if (str.endsWith(this.f6820b.getPackageName() + "time")) {
                String strA = this.f6823e.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(strA) && strA.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(strA);
                    } catch (NumberFormatException e2) {
                        Logger.w(f6816i, "convert expire time from String to Long catch NumberFormatException.", e2);
                    }
                }
                String strSubstring = str.substring(0, str.length() - 4);
                String str2 = strSubstring + HttpHeaders.ETAG;
                if (!b(j2) || !setKeySet.contains(strSubstring) || !setKeySet.contains(str2)) {
                    Logger.i(f6816i, "init interface auto clear some invalid sp's data: " + str);
                    this.f6823e.a(strSubstring);
                    this.f6823e.a(str);
                    this.f6823e.a(str2);
                }
            }
        }
    }

    private boolean b(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f6826h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e2) {
            e = e2;
            str = f6816i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f6816i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e3) {
            e = e3;
            str = f6816i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f6816i, "init compute task timed out");
            return false;
        } catch (Exception e4) {
            e = e4;
            str = f6816i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    String a(String str, String str2, int i2) {
        if (this.f6819a == null || str == null || str2 == null) {
            Logger.w(f6816i, "invalid para!");
            return null;
        }
        if (e()) {
            return this.f6825g.a(str, str2, this.f6820b, i2);
        }
        return null;
    }

    Map<String, String> a(String str, int i2) {
        if (this.f6819a != null && str != null) {
            return e() ? this.f6825g.a(str, this.f6820b, i2) : new HashMap();
        }
        Logger.w(f6816i, "invalid para!");
        return new HashMap();
    }

    void a() {
        if (e()) {
            String grsParasKey = this.f6819a.getGrsParasKey(true, true, this.f6820b);
            this.f6823e.a(grsParasKey);
            this.f6823e.a(grsParasKey + "time");
            this.f6823e.a(grsParasKey + HttpHeaders.ETAG);
            this.f6821c.a(grsParasKey);
        }
    }

    void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i2) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f6816i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f6819a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f6825g.a(str, iQueryUrlsCallBack, this.f6820b, i2);
        } else {
            Logger.i(f6816i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i2) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f6816i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f6819a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f6825g.a(str, str2, iQueryUrlCallBack, this.f6820b, i2);
        } else {
            Logger.i(f6816i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.f6819a.compare(((c) obj).f6819a);
        }
        return false;
    }

    boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.f6819a) == null || (context = this.f6820b) == null) {
            return false;
        }
        this.f6822d.a(grsBaseInfo, context);
        return true;
    }
}

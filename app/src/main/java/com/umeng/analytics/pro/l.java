package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AutoViewPageTracker.java */
@TargetApi(14)
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static String f10437a;

    /* renamed from: b, reason: collision with root package name */
    boolean f10443b;

    /* renamed from: c, reason: collision with root package name */
    boolean f10444c;

    /* renamed from: f, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f10445f;

    /* renamed from: g, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f10446g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Long> f10447h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10448l;

    /* renamed from: m, reason: collision with root package name */
    private int f10449m;
    private int n;

    /* renamed from: i, reason: collision with root package name */
    private static JSONArray f10440i = new JSONArray();

    /* renamed from: j, reason: collision with root package name */
    private static Object f10441j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static Application f10442k = null;

    /* renamed from: d, reason: collision with root package name */
    static String f10438d = null;

    /* renamed from: e, reason: collision with root package name */
    static int f10439e = -1;
    private static boolean o = true;
    private static Object p = new Object();
    private static bm q = new com.umeng.analytics.vshelper.b();

    /* compiled from: AutoViewPageTracker.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final l f10451a = new l();

        private a() {
        }
    }

    static /* synthetic */ int a(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(l lVar) {
        int i2 = lVar.f10449m;
        lVar.f10449m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int e(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(l lVar) {
        int i2 = lVar.f10449m;
        lVar.f10449m = i2 + 1;
        return i2;
    }

    private void g() {
        if (this.f10448l) {
            return;
        }
        this.f10448l = true;
        if (f10442k == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        f10442k.registerActivityLifecycleCallbacks(this.f10446g);
    }

    private l() {
        this.f10447h = new HashMap();
        this.f10448l = false;
        this.f10443b = false;
        this.f10444c = false;
        this.f10449m = 0;
        this.n = 0;
        this.f10445f = PageNameMonitor.getInstance();
        this.f10446g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.f10443b = false;
                    l.q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            boolean unused = l.o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.f10449m <= 0) {
                        if (l.f10438d == null) {
                            l.f10438d = UUID.randomUUID().toString();
                        }
                        if (l.f10439e == -1) {
                            l.f10439e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f10439e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap map = new HashMap();
                            map.put("activityName", activity.toString());
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) map);
                            }
                            l.f10439e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.f10439e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap map2 = new HashMap();
                            map2.put("pairUUID", l.f10438d);
                            map2.put("pid", Integer.valueOf(Process.myPid()));
                            map2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) map2);
                            }
                        }
                    }
                    if (l.this.n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.f10449m <= 0) {
                        if (l.f10439e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = l.f10439e;
                        if ((i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap map = new HashMap();
                            map.put("pairUUID", l.f10438d);
                            map.put("reason", "Normal");
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map.put("activityName", activity.toString());
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) map);
                            }
                            if (l.f10438d != null) {
                                l.f10438d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f10442k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (p) {
            if (o) {
                o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f10441j) {
                    string = f10440i.toString();
                    f10440i = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put(e.d.a.f10374c, new JSONArray(string));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f10448l;
    }

    public static synchronized l a(Context context) {
        if (f10442k == null && context != null) {
            if (context instanceof Activity) {
                f10442k = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                f10442k = (Application) context;
            }
        }
        return a.f10451a;
    }

    public static void a(Context context, String str) {
        if (f10439e == 1 && UMUtils.isMainProgress(context)) {
            HashMap map = new HashMap();
            map.put("pairUUID", f10438d);
            map.put("reason", str);
            if (f10438d != null) {
                f10438d = null;
            }
            if (context != null) {
                map.put("pid", Integer.valueOf(Process.myPid()));
                map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                map.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) map);
            }
        }
    }

    public void b() {
        this.f10448l = false;
        if (f10442k != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                f10442k.unregisterActivityLifecycleCallbacks(this.f10446g);
            }
            f10442k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.f10447h) {
                if (f10437a == null && activity != null) {
                    f10437a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(f10437a) || !this.f10447h.containsKey(f10437a)) {
                    j3 = 0;
                } else {
                    long jLongValue = this.f10447h.get(f10437a).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    this.f10447h.remove(f10437a);
                    j2 = jCurrentTimeMillis;
                    j3 = jLongValue;
                }
            }
            synchronized (f10441j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, f10437a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(d.x, j3);
                    jSONObject.put("type", 0);
                    f10440i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f10437a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f10447h) {
            this.f10447h.put(f10437a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f10445f.activityResume(str);
            if (this.f10443b) {
                this.f10443b = false;
                if (!TextUtils.isEmpty(f10437a)) {
                    if (f10437a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f10437a = str;
                return;
            }
            b(activity);
            synchronized (p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}

package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InternalAgent.java */
/* loaded from: classes2.dex */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a, reason: collision with root package name */
    private static Context f9985a = null;

    /* renamed from: h, reason: collision with root package name */
    private static final String f9986h = "sp_uapp";

    /* renamed from: i, reason: collision with root package name */
    private static final String f9987i = "prepp_uapp";
    private static final int o = 128;
    private static final int p = 256;
    private static String q = "";
    private static String r = "";
    private static final String t = "ekv_bl_ver";
    private static final String w = "ekv_wl_ver";
    private static final String z = "umsp_1";

    /* renamed from: b, reason: collision with root package name */
    private ISysListener f9988b;

    /* renamed from: c, reason: collision with root package name */
    private p f9989c;

    /* renamed from: d, reason: collision with root package name */
    private v f9990d;

    /* renamed from: e, reason: collision with root package name */
    private k f9991e;

    /* renamed from: f, reason: collision with root package name */
    private u f9992f;

    /* renamed from: g, reason: collision with root package name */
    private l f9993g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9994j;

    /* renamed from: k, reason: collision with root package name */
    private volatile JSONObject f9995k;

    /* renamed from: l, reason: collision with root package name */
    private volatile JSONObject f9996l;

    /* renamed from: m, reason: collision with root package name */
    private volatile JSONObject f9997m;
    private boolean n;
    private com.umeng.analytics.filter.a u;
    private com.umeng.analytics.filter.b x;
    private m y;
    private static final String s = d.al;
    private static final String v = d.am;

    /* compiled from: InternalAgent.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f9998a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f9985a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.f9998a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f9995k == null) {
                this.f9995k = new JSONObject();
            }
            if (this.f9996l == null) {
                this.f9996l = new JSONObject();
            }
            String string = sharedPreferences.getString(f9987i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f9997m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f9997m == null) {
                this.f9997m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f9995k;
    }

    public JSONObject c() {
        return this.f9997m;
    }

    public JSONObject d() {
        return this.f9996l;
    }

    public void e() {
        this.f9996l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f9985a)) {
            return q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(f9985a)) {
            return r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            if (f9985a != null) {
                if (!UMUtils.isMainProgress(f9985a)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    UMWorkDispatch.sendEvent(f9985a, o.a.f10483k, CoreProtocol.getInstance(f9985a), Long.valueOf(jCurrentTimeMillis));
                    UMWorkDispatch.sendEvent(f9985a, 4103, CoreProtocol.getInstance(f9985a), Long.valueOf(jCurrentTimeMillis));
                }
            }
            if (this.f9988b != null) {
                this.f9988b.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    void j() {
        try {
            if (f9985a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", jCurrentTimeMillis);
            UMWorkDispatch.sendEvent(f9985a, 4102, CoreProtocol.getInstance(f9985a), jSONObject);
            UMWorkDispatch.sendEvent(f9985a, o.a.o, CoreProtocol.getInstance(f9985a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        if (f9985a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f9995k != null) {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f9985a).edit();
            editorEdit.putString(f9986h, this.f9995k.toString());
            editorEdit.commit();
        } else {
            this.f9995k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        if (f9985a == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f9995k == null) {
            this.f9995k = new JSONObject();
        }
        return this.f9995k;
    }

    public synchronized void m() {
        try {
            if (f9985a != null) {
                if (!UMUtils.isMainProgress(f9985a)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f9985a).edit();
                    editorEdit.remove(f9986h);
                    editorEdit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(o.a.A)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f9985a;
                UMWorkDispatch.sendEvent(context, o.a.A, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private b() {
        this.f9989c = new p();
        this.f9990d = new v();
        this.f9991e = new k();
        this.f9992f = u.a();
        this.f9993g = null;
        this.f9994j = false;
        this.f9995k = null;
        this.f9996l = null;
        this.f9997m = null;
        this.n = false;
        this.u = null;
        this.x = null;
        this.y = null;
        this.f9989c.a(this);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (this.u == null) {
                this.u = new com.umeng.analytics.filter.a(s, "ekv_bl_ver");
                this.u.register(f9985a);
            }
            if (this.x == null) {
                this.x = new com.umeng.analytics.filter.b(v, "ekv_wl_ver");
                this.x.register(f9985a);
            }
            if (UMUtils.isMainProgress(f9985a)) {
                if (!this.f9994j) {
                    this.f9994j = true;
                    i(f9985a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.n) {
                            this.f9993g = l.a(context);
                            if (this.f9993g.a()) {
                                this.n = true;
                            }
                            this.y = m.a();
                            try {
                                m.a(context);
                                this.y.a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else {
                    this.n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(j.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f9985a));
            }
        } catch (Throwable unused2) {
        }
    }

    void b(String str) {
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f9990d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    void c(Context context) {
        if (context == null) {
            UMLog.aq(j.p, 0, "\\|");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.q, 2, "\\|");
        }
        try {
            if (!this.f9994j || !this.n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f9991e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            r = context.getClass().getName();
        }
    }

    void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            if (this.f9993g != null) {
                this.f9993g.c();
            }
            l.a(context, "onKillProcess");
            if (this.f9991e != null) {
                this.f9991e.b();
            }
            if (this.f9990d != null) {
                this.f9990d.b();
            }
            if (f9985a != null) {
                if (this.f9992f != null) {
                    this.f9992f.c(f9985a, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(f9985a).d();
                v.a(f9985a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f9985a);
                }
                PreferenceWrapper.getDefault(f9985a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.f9995k == null) {
            this.f9995k = new JSONObject();
        } else if (this.f9995k.has(str)) {
            return this.f9995k.opt(str);
        }
        return null;
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        this.f9995k = new JSONObject();
        UMWorkDispatch.sendEvent(f9985a, o.a.t, CoreProtocol.getInstance(f9985a), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(j.ap, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        if (this.f9997m.length() > 0) {
            UMWorkDispatch.sendEvent(f9985a, o.a.x, CoreProtocol.getInstance(f9985a), null);
        }
        this.f9997m = new JSONObject();
    }

    void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.o, 2, "\\|");
        }
        try {
            if (!this.f9994j || !this.n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f9991e.a(context.getClass().getName());
            }
            h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(j.aq, 0, "\\|");
            return null;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        if (this.f9997m == null) {
            this.f9997m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f9997m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f9997m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            if (f9985a != null) {
                if (!UMUtils.isMainProgress(f9985a)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(f9985a, o.a.f10480h, CoreProtocol.getInstance(f9985a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(f9985a, 4100, CoreProtocol.getInstance(f9985a), null);
                UMWorkDispatch.sendEvent(f9985a, 4099, CoreProtocol.getInstance(f9985a), null);
                UMWorkDispatch.sendEvent(f9985a, 4105, CoreProtocol.getInstance(f9985a), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f9988b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.an, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        if (this.f9997m == null) {
            this.f9997m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f9997m.has(str)) {
                this.f9997m.remove(str);
                UMWorkDispatch.sendEvent(f9985a, 8200, CoreProtocol.getInstance(f9985a), this.f9997m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean c(String str) {
        if (this.u.enabled() && this.u.matchHit(str)) {
            return true;
        }
        if (!this.x.enabled()) {
            return false;
        }
        if (!this.x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.f9995k == null) {
            this.f9995k = new JSONObject();
        }
        if (this.f9995k.has(str)) {
            this.f9995k.remove(str);
            UMWorkDispatch.sendEvent(f9985a, o.a.u, CoreProtocol.getInstance(f9985a), str);
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(j.N, 0, "\\|");
                return;
            }
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f9994j || !this.n) {
                a(f9985a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap map = new HashMap();
                map.put(d.aE, str);
                a(f9985a, d.aD, (Map<String, Object>) map, -1L, false);
                return;
            }
            UMLog.aq(j.O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f9995k != null) {
            return this.f9995k.toString();
        }
        this.f9995k = new JSONObject();
        return null;
    }

    void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.z, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        AnalyticsConfig.a(f9985a, str);
    }

    void a(String str) {
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f9990d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f9988b = iSysListener;
        }
    }

    public void a(Context context, int i2) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        AnalyticsConfig.a(f9985a, i2);
    }

    public synchronized void b(Object obj) {
        if (f9985a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f9985a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(f9987i, str).commit();
            }
        } else if (editorEdit != null) {
            editorEdit.remove(f9987i).commit();
        }
    }

    public void a(Context context, String str, HashMap<String, Object> map) {
        if (context == null) {
            return;
        }
        try {
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f9994j || !this.n) {
                a(f9985a);
            }
            String string = "";
            if (this.f9995k == null) {
                this.f9995k = new JSONObject();
            } else {
                string = this.f9995k.toString();
            }
            s.a(f9985a).a(str, map, string);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    private boolean b(String str, Object obj) {
        int length;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            length = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            length = 0;
        }
        if (length > 128) {
            MLog.e("key length is " + length + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.w, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.f9994j || !this.n) {
                a(f9985a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(d.Q, 2);
            jSONObject.put(d.R, str);
            jSONObject.put("__ii", this.f9992f.c());
            UMWorkDispatch.sendEvent(f9985a, 4106, CoreProtocol.getInstance(f9985a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f9994j || !this.n) {
                    a(f9985a);
                }
                a(f9985a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e2) {
                if (MLog.DEBUG) {
                    MLog.e(e2);
                    return;
                }
                return;
            }
        }
        UMLog.aq(j.y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j2, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (!this.f9994j || !this.n) {
                a(f9985a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.f9995k == null) {
                this.f9995k = new JSONObject();
            } else {
                string = this.f9995k.toString();
            }
            s.a(f9985a).a(str, str2, j2, i2, string);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, String str, Map<String, Object> map, long j2) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(d.aF).contains(str)) {
                UMLog.aq(j.f10425b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(j.f10427d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(d.aF).contains(it.next().getKey())) {
                    UMLog.aq(j.f10428e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j2, false);
            return;
        }
        UMLog.aq(j.f10426c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j2, boolean z2) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f9985a == null) {
                f9985a = context.getApplicationContext();
            }
            if (!this.f9994j || !this.n) {
                a(f9985a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.f9995k == null) {
                this.f9995k = new JSONObject();
            } else {
                string = this.f9995k.toString();
            }
            s.a(f9985a).a(str, map, j2, string, z2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th) throws JSONException {
        try {
            if (f9985a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                if (this.f9990d != null) {
                    this.f9990d.b();
                }
                l.a(f9985a, "onAppCrash");
                if (this.f9991e != null) {
                    this.f9991e.b();
                }
                if (this.f9993g != null) {
                    this.f9993g.c();
                }
                if (this.f9992f != null) {
                    this.f9992f.c(f9985a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(d.Q, 1);
                    jSONObject.put(d.R, DataHelper.convertExceptionToString(th));
                    i.a(f9985a).a(this.f9992f.c(), jSONObject.toString(), 1);
                }
                o.a(f9985a).d();
                v.a(f9985a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f9985a);
                }
                PreferenceWrapper.getDefault(f9985a).edit().commit();
            }
        } catch (Exception e2) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e2);
            }
        }
    }

    void a(String str, String str2) {
        try {
            if (f9985a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f9985a)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", jCurrentTimeMillis);
            UMWorkDispatch.sendEvent(f9985a, 4101, CoreProtocol.getInstance(f9985a), jSONObject);
            UMWorkDispatch.sendEvent(f9985a, o.a.o, CoreProtocol.getInstance(f9985a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    void a(boolean z2) {
        Context context = f9985a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    void a(double d2, double d3) {
        Context context = f9985a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f9962a == null) {
            AnalyticsConfig.f9962a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f9962a;
        dArr[0] = d2;
        dArr[1] = d3;
    }

    void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f9985a, eScenarioType.toValue());
        }
        if (this.f9994j && this.n) {
            return;
        }
        a(f9985a);
    }

    void a(long j2) {
        Context context = f9985a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j2;
            y.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i2 = 0;
        if (context == null) {
            UMLog.aq(j.af, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f9995k == null) {
                    this.f9995k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i2 < strArr.length) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                                i2++;
                            }
                            MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.f9995k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i2 < jArr.length) {
                            jSONArray2.put(jArr[i2]);
                            i2++;
                        }
                        this.f9995k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i2 < iArr.length) {
                            jSONArray3.put(iArr[i2]);
                            i2++;
                        }
                        this.f9995k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i2 < fArr.length) {
                            jSONArray4.put(fArr[i2]);
                            i2++;
                        }
                        this.f9995k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i2 < dArr.length) {
                            jSONArray5.put(dArr[i2]);
                            i2++;
                        }
                        this.f9995k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i2 < sArr.length) {
                            jSONArray6.put((int) sArr[i2]);
                            i2++;
                        }
                        this.f9995k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.f9995k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(f9985a, o.a.s, CoreProtocol.getInstance(f9985a), this.f9995k.toString());
            return;
        }
        UMLog.aq(j.ag, 0, "\\|");
    }

    private void a(String str, Object obj) {
        try {
            if (this.f9995k == null) {
                this.f9995k = new JSONObject();
            }
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                        i2++;
                    }
                    this.f9995k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.f9995k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.f9995k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.f9995k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.f9995k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.f9995k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.f9995k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f9995k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Object obj) {
        if (f9985a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f9985a).edit();
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(f9986h, this.f9995k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(j.aj, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        s.a(f9985a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        String string;
        Object obj;
        if (context == null) {
            UMLog.aq(j.al, 0, "\\|");
            return;
        }
        if (f9985a == null) {
            f9985a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9985a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f9994j || !this.n) {
            a(f9985a);
        }
        if (this.f9997m == null) {
            this.f9997m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.f9997m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    try {
                        string = itKeys.next().toString();
                        obj = jSONObject.get(string);
                    } catch (Exception unused2) {
                    }
                    if (b(string, obj)) {
                        jSONObject2.put(string, obj);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f9997m = jSONObject2;
            if (this.f9997m.length() > 0) {
                UMWorkDispatch.sendEvent(f9985a, o.a.v, CoreProtocol.getInstance(f9985a), this.f9997m.toString());
            }
            return;
        }
        UMLog.aq(j.am, 0, "\\|");
    }
}

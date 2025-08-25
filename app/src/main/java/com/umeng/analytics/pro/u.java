package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionTracker.java */
/* loaded from: classes2.dex */
public class u implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10514a = "session_start_time";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10515b = "session_end_time";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10516c = "session_id";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10517d = "pre_session_id";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10518e = "a_start_time";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10519f = "a_end_time";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10520g = "fg_count";

    /* renamed from: h, reason: collision with root package name */
    private static String f10521h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Context f10522i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f10523j = false;

    /* renamed from: k, reason: collision with root package name */
    private static long f10524k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f10525l = true;

    /* renamed from: m, reason: collision with root package name */
    private static long f10526m;

    /* compiled from: SessionTracker.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final u f10527a = new u();

        private a() {
        }
    }

    public static u a() {
        return a.f10527a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(f10520g, 0L);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit != null) {
                editorEdit.putLong(f10520g, j2 + 1);
                editorEdit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putLong(f10520g, 0L);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f10522i == null && context != null) {
            f10522i = context.getApplicationContext();
        }
        String strD = y.a().d(f10522i);
        try {
            f(context);
            o.a(f10522i).d((Object) null);
        } catch (Throwable unused) {
        }
        return strD;
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f10522i == null && context != null) {
                f10522i = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f10518e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + jLongValue);
            editorEdit.putLong(f10519f, jLongValue);
            editorEdit.putLong(f10515b, jLongValue);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f10520g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putLong(f10514a, j2);
        editorEdit.commit();
    }

    public void b(Context context, Object obj) {
        long jLongValue;
        try {
            if (f10522i == null) {
                f10522i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                jLongValue = System.currentTimeMillis();
            } else {
                jLongValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
            if (sharedPreferences == null) {
                return;
            }
            f10524k = sharedPreferences.getLong(f10519f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f10524k);
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f10522i);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                editorEdit.putLong(f10514a, jLongValue);
                editorEdit.commit();
                o.a(f10522i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + y.a().c(f10522i));
                f10523j = true;
                a(f10522i, jLongValue, true);
                return;
            }
            if (y.a().e(f10522i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f10523j = true;
                editorEdit.putLong(f10514a, jLongValue);
                editorEdit.commit();
                a(f10522i, jLongValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f10523j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor editorEdit;
        try {
            if (f10522i == null && context != null) {
                f10522i = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f10522i);
            if (TextUtils.isEmpty(string)) {
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(d.az, appVersionName);
                editorEdit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(d.az, "");
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(d.az, appVersionName);
                editorEdit.putString("vers_date", string2);
                editorEdit.putString("vers_pre_version", string3);
                editorEdit.putString("cur_version", string4);
                editorEdit.putInt("vers_code", i2);
                editorEdit.putString("vers_name", string);
                editorEdit.commit();
                if (f10525l) {
                    f10525l = false;
                }
                if (f10523j) {
                    f10523j = false;
                    b(f10522i, jLongValue, true);
                    b(f10522i, jLongValue);
                    return;
                }
                return;
            }
            if (f10523j) {
                f10523j = false;
                if (f10525l) {
                    f10525l = false;
                }
                f10521h = e(context);
                MLog.d("创建新会话: " + f10521h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f10521h);
                return;
            }
            f10521h = sharedPreferences.getString("session_id", null);
            editorEdit.putLong(f10518e, jLongValue);
            editorEdit.putLong(f10519f, 0L);
            editorEdit.commit();
            MLog.d("延续上一个会话: " + f10521h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f10521h);
            if (f10525l) {
                f10525l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMWorkDispatch.sendEventEx(f10522i, o.a.D, CoreProtocol.getInstance(f10522i), null, 0L);
                }
            }
            f(context);
            o.a(f10522i).a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f10521h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f10521h;
    }

    @Deprecated
    public String c() {
        return c(f10522i);
    }

    public boolean b(Context context, long j2, boolean z) {
        SharedPreferences sharedPreferences;
        String strA;
        long j3;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (strA = y.a().a(f10522i)) == null) {
            return false;
        }
        long j4 = sharedPreferences.getLong(f10518e, 0L);
        long j5 = sharedPreferences.getLong(f10519f, 0L);
        if (j4 > 0 && j5 == 0) {
            z2 = true;
            if (z) {
                if (f10524k == 0) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                    j3 = j2;
                } else {
                    j3 = f10524k;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f10524k);
                }
                c(f10522i, Long.valueOf(j3));
            } else {
                c(f10522i, Long.valueOf(j2));
                j3 = j2;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(e.d.a.f10378g, j3);
            } else {
                jSONObject.put(e.d.a.f10378g, j2);
            }
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f10526m);
                jSONObject.put(e.d.a.f10379h, f10526m);
                f10526m = 0L;
            } else {
                jSONObject.put(e.d.a.f10379h, 0L);
            }
            i.a(context).a(strA, jSONObject, i.a.END);
            o.a(f10522i).e();
        }
        return z2;
    }

    public String a(Context context, long j2, boolean z) {
        String strB = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + strB);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            i.a(context).a(strB, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return strB;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f10522i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String b() {
        return f10521h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j2, long j3, long j4) throws JSONException {
        a(f10522i, str2, j2, j3, j4);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f10522i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    private void a(Context context, String str, long j2, long j3, long j4) throws JSONException {
        if (TextUtils.isEmpty(f10521h)) {
            f10521h = y.a().a(f10522i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f10521h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.f10378g, j3);
            jSONObject.put(e.d.a.f10379h, j4);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            i.a(context).a(f10521h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f10526m = j4;
                d(context);
                UMWorkDispatch.sendEventEx(f10522i, o.a.D, CoreProtocol.getInstance(f10522i), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f10521h = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(f10515b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(e.d.a.f10378g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.f10376e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = f10522i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long jLongValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long jLongValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (jLongValue > 0 && jLongValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, jLongValue);
                jSONObject3.put(d.G, jLongValue2);
                jSONObject.put(e.d.a.f10375d, jSONObject3);
            }
            i.a(f10522i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f10522i);
            l.c(f10522i);
        } catch (Throwable unused) {
        }
    }
}

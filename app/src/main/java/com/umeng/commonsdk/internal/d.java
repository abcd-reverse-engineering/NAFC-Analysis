package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMInternalManager.java */
/* loaded from: classes2.dex */
public class d {
    public static void a(Context context) throws JSONException {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bh.aQ, a.f10759e);
            JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, bh.aF, a.f10759e);
            if (jSONObjectBuildEnvelopeWithExtHeader == null || jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    public static JSONObject d(Context context) throws JSONException {
        JSONObject jSONObjectB;
        JSONArray jSONArrayH;
        JSONObject jSONObjectA;
        JSONArray jSONArrayL;
        JSONArray jSONArrayK;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.J) && (jSONArrayK = k(applicationContext)) != null && jSONArrayK.length() > 0) {
                    jSONObject2.put("rs", jSONArrayK);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ao) && (jSONArrayL = l(applicationContext)) != null && jSONArrayL.length() > 0) {
                    jSONObject2.put("by", jSONArrayL);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ap) && (jSONObjectA = a()) != null && jSONObjectA.length() > 0) {
                    jSONObject2.put("build", jSONObjectA);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(applicationContext, e6);
            }
            try {
                JSONObject jSONObjectE = e(applicationContext);
                if (jSONObjectE != null && jSONObjectE.length() > 0) {
                    jSONObject2.put("scr", jSONObjectE);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                JSONObject jSONObjectF = f(applicationContext);
                if (jSONObjectF != null && jSONObjectF.length() > 0) {
                    jSONObject2.put("sinfo", jSONObjectF);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                JSONArray jSONArrayG = g(applicationContext);
                if (jSONArrayG != null && jSONArrayG.length() > 0) {
                    jSONObject2.put("input", jSONArrayG);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ag) && (jSONArrayH = h(applicationContext)) != null && jSONArrayH.length() > 0) {
                    jSONObject2.put("appls", jSONArrayH);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                JSONObject jSONObjectI = i(applicationContext);
                if (jSONObjectI != null && jSONObjectI.length() > 0) {
                    jSONObject2.put("mem", jSONObjectI);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (jSONObjectB = b()) != null && jSONObjectB.length() > 0) {
                    jSONObject2.put(bh.w, jSONObjectB);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(bh.ax, jSONObject2);
            } catch (JSONException e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) throws JSONException {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context applicationContext;
        List<InputMethodInfo> listF;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (listF = com.umeng.commonsdk.internal.utils.a.f((applicationContext = context.getApplicationContext()))) != null) {
            for (InputMethodInfo inputMethodInfo : listF) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) throws JSONException {
        Context applicationContext;
        List<a.C0142a> listG;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (listG = com.umeng.commonsdk.internal.utils.a.g((applicationContext = context.getApplicationContext()))) != null && !listG.isEmpty()) {
            for (a.C0142a c0142a : listG) {
                if (c0142a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0142a.f10792a);
                        jSONObject.put("a_la", c0142a.f10793b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(applicationContext, e2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) throws JSONException {
        Context applicationContext;
        ActivityManager.MemoryInfo memoryInfoH;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (memoryInfoH = com.umeng.commonsdk.internal.utils.a.h((applicationContext = context.getApplicationContext()))) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put("t", memoryInfoH.totalMem);
                }
                jSONObject.put("f", memoryInfoH.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    private static void j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, a.f10760f, b.a(context).a(), null, com.heytap.mcssdk.constant.a.r);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.v, b.a(context).a(), null, com.heytap.mcssdk.constant.a.r);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static JSONArray k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i2 = 0; i2 < runningServices.size(); i2++) {
                if (runningServices.get(i2) != null && runningServices.get(i2).service != null && runningServices.get(i2).service.getClassName() != null && runningServices.get(i2).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i2).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i2).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String strA = j.a(context);
        if (!TextUtils.isEmpty(strA)) {
            try {
                jSONArray.put(new JSONObject(strA));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() throws Throwable {
        try {
            d.a aVarA = com.umeng.commonsdk.internal.utils.d.a();
            if (aVarA == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", aVarA.f10806a);
                jSONObject.put("pla", aVarA.f10807b);
                jSONObject.put("cpus", aVarA.f10808c);
                jSONObject.put("fea", aVarA.f10809d);
                jSONObject.put(at.f10069c, aVarA.f10810e);
                jSONObject.put("arc", aVarA.f10811f);
                jSONObject.put("var", aVarA.f10812g);
                jSONObject.put("par", aVarA.f10813h);
                jSONObject.put("rev", aVarA.f10814i);
                jSONObject.put("har", aVarA.f10815j);
                jSONObject.put("rev", aVarA.f10816k);
                jSONObject.put("ser", aVarA.f10817l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) throws JSONException {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (Build.VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < Build.SUPPORTED_32_BIT_ABIS.length; i2++) {
                    jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i2]);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < Build.SUPPORTED_64_BIT_ABIS.length; i3++) {
                    jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i3]);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i4 = 0; i4 < Build.SUPPORTED_ABIS.length; i4++) {
                    jSONArray3.put(Build.SUPPORTED_ABIS[i4]);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) throws JSONException {
        if (context != null) {
            String strA = k.a(context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strA);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(k.f10829d)) {
                    jSONObject.put(k.f10829d, jSONObject2.opt(k.f10829d));
                }
                if (jSONObject2.has(k.f10828c)) {
                    jSONObject.put(k.f10828c, jSONObject2.opt(k.f10828c));
                }
                if (jSONObject2.has(k.f10827b)) {
                    jSONObject.put(k.f10827b, jSONObject2.opt(k.f10827b));
                }
            } catch (Exception unused) {
            }
        }
    }
}

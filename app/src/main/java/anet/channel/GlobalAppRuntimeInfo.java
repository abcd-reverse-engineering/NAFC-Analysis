package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GlobalAppRuntimeInfo {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1609a;

    /* renamed from: e, reason: collision with root package name */
    private static String f1613e;

    /* renamed from: f, reason: collision with root package name */
    private static String f1614f;

    /* renamed from: g, reason: collision with root package name */
    private static String f1615g;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f1619k;

    /* renamed from: l, reason: collision with root package name */
    private static String f1620l;

    /* renamed from: b, reason: collision with root package name */
    private static ENV f1610b = ENV.ONLINE;

    /* renamed from: c, reason: collision with root package name */
    private static String f1611c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f1612d = "";

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f1616h = true;

    /* renamed from: i, reason: collision with root package name */
    private static SharedPreferences f1617i = null;

    /* renamed from: j, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f1618j = null;

    public static void addBucketInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (GlobalAppRuntimeInfo.class) {
            if (f1618j == null) {
                f1618j = new CopyOnWriteArrayList<>();
            }
            f1618j.add(str);
            f1618j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f1618j;
    }

    public static Context getContext() {
        return f1609a;
    }

    public static String getCurrentProcess() {
        return f1612d;
    }

    public static ENV getEnv() {
        return f1610b;
    }

    @Deprecated
    public static long getInitTime() {
        return f1619k;
    }

    @Deprecated
    public static int getStartType() {
        anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.f1778a;
        }
        return -1;
    }

    public static String getTtid() {
        return f1613e;
    }

    public static String getUserId() {
        return f1614f;
    }

    public static String getUtdid() {
        Context context;
        if (f1615g == null && (context = f1609a) != null) {
            f1615g = Utils.getDeviceId(context);
        }
        return f1615g;
    }

    public static boolean isAppBackground() {
        if (f1609a == null) {
            return true;
        }
        return f1616h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f1611c) || TextUtils.isEmpty(f1612d)) {
            return true;
        }
        return f1611c.equalsIgnoreCase(f1612d);
    }

    public static void setBackground(boolean z) {
        f1616h = z;
    }

    public static void setContext(Context context) {
        f1609a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f1612d)) {
                f1612d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f1611c)) {
                f1611c = Utils.getMainProcessName(context);
            }
            if (f1617i == null) {
                f1617i = PreferenceManager.getDefaultSharedPreferences(context);
                f1614f = f1617i.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f1612d, "TargetProcess", f1611c);
        }
    }

    public static void setCurrentProcess(String str) {
        f1612d = str;
    }

    public static void setEnv(ENV env) {
        f1610b = env;
    }

    @Deprecated
    public static void setInitTime(long j2) {
        f1619k = j2;
    }

    public static void setTargetProcess(String str) {
        f1611c = str;
    }

    public static void setTtid(String str) {
        f1613e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iIndexOf = str.indexOf("@");
            String strSubstring = null;
            String strSubstring2 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            String strSubstring3 = str.substring(iIndexOf + 1);
            int iLastIndexOf = strSubstring3.lastIndexOf(c.c.a.b.a.a.s1);
            if (iLastIndexOf != -1) {
                String strSubstring4 = strSubstring3.substring(0, iLastIndexOf);
                strSubstring = strSubstring3.substring(iLastIndexOf + 1);
                strSubstring3 = strSubstring4;
            }
            f1620l = strSubstring;
            AmdcRuntimeInfo.setAppInfo(strSubstring3, strSubstring, strSubstring2);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f1614f;
        if (str2 == null || !str2.equals(str)) {
            f1614f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f1617i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f1615g;
        if (str2 == null || !str2.equals(str)) {
            f1615g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f1611c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f1611c.equalsIgnoreCase(str);
    }
}

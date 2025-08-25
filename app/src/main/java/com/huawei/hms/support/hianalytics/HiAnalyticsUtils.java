package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HiAnalyticsUtils {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f7291c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f7292d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static HiAnalyticsUtils f7293e;

    /* renamed from: a, reason: collision with root package name */
    private int f7294a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7295b = HianalyticsExist.isHianalyticsExist();

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7296a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7297b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7298c;

        a(Context context, String str, Map map) {
            this.f7296a = context;
            this.f7297b = str;
            this.f7298c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent(this.f7296a, this.f7297b, this.f7298c);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7300a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7301b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7302c;

        b(Context context, String str, String str2) {
            this.f7300a = context;
            this.f7301b = str;
            this.f7302c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f7300a, this.f7301b, this.f7302c);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7304a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7305b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7306c;

        c(Context context, String str, Map map) {
            this.f7304a = context;
            this.f7305b = str;
            this.f7306c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f7304a, this.f7305b, this.f7306c);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7308a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7309b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7310c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f7311d;

        d(Context context, String str, Map map, int i2) {
            this.f7308a = context;
            this.f7309b = str;
            this.f7310c = map;
            this.f7311d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f7308a, this.f7309b, this.f7310c, this.f7311d);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7313a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7314b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7315c;

        e(Context context, String str, Map map) {
            this.f7313a = context;
            this.f7314b = str;
            this.f7315c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f7313a, this.f7314b, this.f7315c);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7317a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7318b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7319c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f7320d;

        f(Context context, String str, Map map, int i2) {
            this.f7317a = context;
            this.f7318b = str;
            this.f7319c = map;
            this.f7320d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f7317a, this.f7318b, this.f7319c, this.f7320d);
        }
    }

    private HiAnalyticsUtils() {
    }

    private static LinkedHashMap<String, String> a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private void b(Context context) {
        synchronized (f7292d) {
            int i2 = this.f7294a;
            if (i2 < 60) {
                this.f7294a = i2 + 1;
            } else {
                this.f7294a = 0;
                if (this.f7295b) {
                    HiAnalyticsOfCpUtils.onReport(context, 0);
                    HiAnalyticsOfCpUtils.onReport(context, 1);
                } else {
                    HmsHiAnalyticsUtils.onReport();
                }
            }
        }
    }

    private void c(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new e(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f7291c) {
            if (f7293e == null) {
                f7293e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f7293e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) throws NumberFormatException {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (this.f7295b) {
            HiAnalyticTools.enableLog(context);
        } else {
            HmsHiAnalyticsUtils.enableLog();
        }
    }

    public boolean getInitFlag() {
        return !this.f7295b ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) throws Settings.SettingNotFoundException {
        if (context == null) {
            return 0;
        }
        int iA = a(context);
        if (iA == 1) {
            return iA;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle bundleCall = context.getApplicationContext().getContentResolver().call(Uri.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", (String) null, bundle);
            if (bundleCall == null) {
                return iA;
            }
            iA = bundleCall.getInt("SWITCH_IS_CHECKED");
            HMSLog.i("HiAnalyticsUtils", "get hms analyticsOobe state " + iA);
            return iA;
        } catch (IllegalArgumentException unused) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return iA;
        } catch (SecurityException unused2) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return iA;
        } catch (Exception unused3) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return iA;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, map)) {
            a(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7295b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, a(map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, a(map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, a(map));
            }
            b(context);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && a(str2)) {
            a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7295b) {
                HiAnalyticsOfCpUtils.onEvent(context, str, str2);
            } else {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            b(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7295b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onEvent(1, str, a((Map<String, String>) map));
            }
            b(context);
        }
    }

    public void onReport(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            c(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7295b) {
                HiAnalyticsOfCpUtils.onStreamEvent(context, 0, str, a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onStreamEvent(context, 1, str, a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onStreamEvent(0, str, a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onStreamEvent(1, str, a((Map<String, String>) map));
            }
        }
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.f7295b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    private int a(Context context) throws Settings.SettingNotFoundException {
        int i2 = 0;
        try {
            i2 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i2);
            return i2;
        } catch (Settings.SettingNotFoundException e2) {
            HMSLog.i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e2.getMessage());
            return i2;
        }
    }

    private boolean a(boolean z, boolean z2, Map<?, ?> map) {
        return !z && z2 && b(map);
    }

    private boolean b(Map<?, ?> map) {
        try {
            Iterator<?> it = map.values().iterator();
            long length = 0;
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    length += ((String) r3).getBytes(Charset.forName("UTF-8")).length;
                }
            }
            return length <= 512;
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th.getMessage());
            return false;
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName("UTF-8")).length <= 512;
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th.getMessage());
            return false;
        }
    }

    public void onReport(Context context, String str, Map map, int i2) {
        if (i2 != 0 && i2 != 1) {
            HMSLog.e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                b(context, str, map, i2);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f7295b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i2, str, a((Map<String, String>) map));
                    return;
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, i2, str, a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    private void a(Context context, String str, Map<String, String> map) {
        try {
            com.huawei.hms.stats.a.c().a(new a(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i2) {
        if (i2 != 0 && i2 != 1) {
            HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                a(context, str, map, i2);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f7295b) {
                    HmsHiAnalyticsUtils.onEvent(i2, str, a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, i2, str, a((Map<String, String>) map));
                }
                b(context);
                return;
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    private void b(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new c(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th.getMessage());
        }
    }

    private void a(Context context, String str, String str2) {
        try {
            com.huawei.hms.stats.a.c().a(new b(context.getApplicationContext(), str, str2));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th.getMessage());
        }
    }

    private void b(Context context, String str, Map map, int i2) {
        try {
            com.huawei.hms.stats.a.c().a(new f(context.getApplicationContext(), str, map, i2));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th.getMessage());
        }
    }

    private void a(Context context, String str, Map map, int i2) {
        try {
            com.huawei.hms.stats.a.c().a(new d(context.getApplicationContext(), str, map, i2));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th.getMessage());
        }
    }
}

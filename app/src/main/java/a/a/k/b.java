package a.a.k;

import a.a.o.c;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1119a = "SERVICE_OPTIMIZE";

    /* renamed from: b, reason: collision with root package name */
    public static final String f1120b = "SESSION_ASYNC_OPTIMIZE";

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f1121c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f1122d = true;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f1123e = true;

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f1124f = 5;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f1125g = true;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f1126h = true;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f1127i = false;

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f1128j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f1129k = false;

    /* renamed from: l, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, List<String>> f1130l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f1131m;
    private static final List<String> n = new ArrayList();
    private static volatile int o = 10000;
    private static volatile boolean p = true;
    private static volatile boolean q = false;
    private static volatile int r = 60000;
    private static volatile CopyOnWriteArrayList<String> s = null;
    private static volatile ConcurrentHashMap<String, List<String>> t = null;
    private static volatile boolean u = true;
    private static volatile boolean v = false;
    private static volatile boolean w = false;
    private static volatile boolean x = true;
    private static volatile boolean y = true;
    private static volatile a z;

    public static void a(a aVar) {
        if (z != null) {
            z.unRegister();
        }
        if (aVar != null) {
            aVar.register();
        }
        z = aVar;
    }

    public static void b(boolean z2) {
        f1127i = z2;
    }

    public static void c(int i2) {
        f1124f = i2;
    }

    public static void d() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(c.getContext());
        f1128j = defaultSharedPreferences.getLong("Cache.Flag", 0L);
        w = defaultSharedPreferences.getBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", false);
        x = defaultSharedPreferences.getBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", true);
    }

    public static boolean e() {
        return f1125g && f1127i;
    }

    public static void f(String str) throws JSONException {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f1130l = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, n);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        f1130l = concurrentHashMap;
    }

    public static boolean g() {
        return f1129k;
    }

    public static void h(boolean z2) {
        q = z2;
    }

    public static void i(boolean z2) {
        f1126h = z2;
    }

    public static void j(boolean z2) {
        f1125g = z2;
    }

    @Deprecated
    public static void k(boolean z2) {
    }

    public static boolean k() {
        return q;
    }

    public static void l(boolean z2) {
        f1123e = z2;
    }

    public static boolean m() {
        return f1125g;
    }

    public static boolean n() {
        return f1123e;
    }

    public static void o(boolean z2) {
        ALog.i("anet.NetworkConfigCenter", "[setSSLEnabled]", null, "enable", Boolean.valueOf(z2));
        f1121c = z2;
    }

    public static void p(boolean z2) {
        ALog.i("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z2));
        f1122d = z2;
    }

    public static boolean q() {
        return f1121c;
    }

    public static boolean r() {
        return f1122d;
    }

    public static boolean b(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f1130l) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == n) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static int c() {
        return f1124f;
    }

    public static void e(String str) throws JSONException {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f1131m = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f1131m = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse bizId failed", null, e2, new Object[0]);
        }
    }

    public static void g(boolean z2) {
        y = z2;
    }

    public static boolean h() {
        return v;
    }

    public static boolean i() {
        return w;
    }

    public static boolean j() {
        return y;
    }

    public static boolean l() {
        return f1126h;
    }

    public static void m(boolean z2) {
        u = z2;
    }

    public static void n(boolean z2) {
        p = z2;
    }

    public static void c(String str) throws JSONException {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            t = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, n);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        t = concurrentHashMap;
    }

    public static boolean o() {
        return u;
    }

    public static boolean p() {
        return p;
    }

    public static void a(long j2) {
        if (j2 != f1128j) {
            ALog.i("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(f1128j), "new", Long.valueOf(j2));
            f1128j = j2;
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(c.getContext()).edit();
            editorEdit.putLong("Cache.Flag", f1128j);
            editorEdit.apply();
            a.a.j.b.a();
        }
    }

    public static void d(boolean z2) {
        f1129k = z2;
    }

    public static void d(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            s = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.KEY_HOST);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (anet.channel.strategy.utils.c.c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            s = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
        }
    }

    public static int b() {
        return o;
    }

    public static void b(int i2) {
        o = i2;
    }

    public static void b(String str) throws JSONException {
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    if (anet.channel.strategy.utils.c.c(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.getInstance().addHosts(arrayList);
            } catch (JSONException e2) {
                ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = f1131m;
        if (f1131m == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void e(boolean z2) {
        v = z2;
    }

    public static int a() {
        return r;
    }

    public static void a(int i2) {
        r = i2;
    }

    public static boolean a(RequestStatistic requestStatistic) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (requestStatistic == null || (copyOnWriteArrayList = s) == null || TextUtils.isEmpty(requestStatistic.host)) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (requestStatistic.host.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = t) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == n) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void f(boolean z2) {
        w = z2;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(c.getContext()).edit();
        editorEdit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", w);
        editorEdit.apply();
    }

    public static void c(boolean z2) {
        x = z2;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(c.getContext()).edit();
        editorEdit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", x);
        editorEdit.apply();
    }

    public static void a(boolean z2) throws JSONException {
        if (z2) {
            h(true);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(16);
            AwcnConfig.registerPresetSessions("[{\"host\":\"trade-acs.m.taobao.com\", \"protocol\":\"http2\", \"rtt\":\"0rtt\", \"publicKey\": \"acs\", \"isKeepAlive\":true}]");
        } else {
            h(false);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(6);
        }
    }

    public static boolean f() {
        return x;
    }
}

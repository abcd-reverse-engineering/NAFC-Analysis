package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f1743a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1744b;

    /* renamed from: f, reason: collision with root package name */
    private static SharedPreferences f1748f;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f1745c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f1746d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static long f1747e = 21600000;

    /* renamed from: g, reason: collision with root package name */
    private static IStrategyFilter f1749g = new anet.channel.e.b();

    /* renamed from: h, reason: collision with root package name */
    private static AtomicInteger f1750h = new AtomicInteger(1);

    /* renamed from: i, reason: collision with root package name */
    private static IStrategyListener f1751i = new c();

    /* renamed from: j, reason: collision with root package name */
    private static NetworkStatusHelper.INetworkStatusChangeListener f1752j = new d();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.e.a$a, reason: collision with other inner class name */
    private static class C0013a {

        /* renamed from: a, reason: collision with root package name */
        long f1753a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1754b;

        private C0013a() {
        }

        /* synthetic */ C0013a(anet.channel.e.b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = f1743a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f1746d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f1744b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f1744b, f1749g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f1745c.compareAndSet(false, true)) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f1746d.set(true);
                    return;
                }
            }
            if (f1743a == null) {
                f1743a = new b();
            }
            if (f1743a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, C0013a> f1755a = new ConcurrentHashMap();

        b() throws JSONException {
            a();
        }

        private void a() throws JSONException {
            anet.channel.e.b bVar = null;
            String string = a.f1748f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    C0013a c0013a = new C0013a(bVar);
                    String string2 = jSONObject.getString("networkUniqueId");
                    c0013a.f1753a = jSONObject.getLong("time");
                    c0013a.f1754b = jSONObject.getBoolean("enable");
                    if (a(c0013a.f1753a)) {
                        synchronized (this.f1755a) {
                            this.f1755a.put(string2, c0013a);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        boolean b(String str) {
            synchronized (this.f1755a) {
                C0013a c0013a = this.f1755a.get(str);
                if (c0013a == null) {
                    return false;
                }
                return c0013a.f1754b;
            }
        }

        boolean a(String str) {
            synchronized (this.f1755a) {
                C0013a c0013a = this.f1755a.get(str);
                boolean z = true;
                if (c0013a == null) {
                    return true;
                }
                if (a(c0013a.f1753a)) {
                    z = false;
                }
                return z;
            }
        }

        private boolean a(long j2) {
            return System.currentTimeMillis() - j2 < a.f1747e;
        }

        void a(String str, boolean z) {
            C0013a c0013a = new C0013a(null);
            c0013a.f1754b = z;
            c0013a.f1753a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f1755a) {
                this.f1755a.put(str, c0013a);
                for (Map.Entry<String, C0013a> entry : this.f1755a.entrySet()) {
                    String key = entry.getKey();
                    C0013a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put("time", value.f1753a);
                        jSONObject.put("enable", value.f1754b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            a.f1748f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            f1748f = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f1744b = f1748f.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f1752j);
            StrategyCenter.getInstance().registerListener(f1751i);
        } catch (Exception e2) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            return;
        }
        f1747e = j2;
    }

    public static void a(boolean z) {
        b bVar = f1743a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z);
        }
    }
}

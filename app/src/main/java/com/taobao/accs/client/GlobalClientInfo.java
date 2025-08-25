package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";

    /* renamed from: a, reason: collision with root package name */
    public static Context f8392a = null;

    /* renamed from: b, reason: collision with root package name */
    public static IAgooAppReceiver f8393b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f8394c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f8395d = false;

    /* renamed from: e, reason: collision with root package name */
    private static final String f8396e = "com.taobao.accs.client.GlobalClientInfo";

    /* renamed from: f, reason: collision with root package name */
    private static volatile GlobalClientInfo f8397f;

    /* renamed from: l, reason: collision with root package name */
    private static Map<String, String> f8398l = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, Map<String, String>> f8399m = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, ILoginInfo> f8400g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, IAppReceiver> f8401h;

    /* renamed from: i, reason: collision with root package name */
    private ActivityManager f8402i;

    /* renamed from: j, reason: collision with root package name */
    private ConnectivityManager f8403j;

    /* renamed from: k, reason: collision with root package name */
    private PackageInfo f8404k;
    private Map<String, AccsDataListener> n = new ConcurrentHashMap();

    static {
        f8398l.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        f8398l.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        f8398l.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        f8392a = getContext();
        if (f8392a == null && context != null) {
            f8392a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new c(this));
    }

    private void a(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (f8399m.get(str) == null) {
            f8399m.put(str, new ConcurrentHashMap());
        }
        f8399m.get(str).putAll(map);
    }

    public static Context getContext() {
        return f8392a;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (f8397f == null) {
            synchronized (GlobalClientInfo.class) {
                if (f8397f == null) {
                    f8397f = new GlobalClientInfo(context);
                }
            }
        }
        return f8397f;
    }

    public void clearLoginInfoImpl() {
        this.f8400g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f8402i == null) {
            this.f8402i = (ActivityManager) f8392a.getSystemService("activity");
        }
        return this.f8402i;
    }

    public Map<String, String> getAllService(String str) {
        if (f8399m.get(str) == null || f8399m.get(str).isEmpty()) {
            return null;
        }
        return f8399m.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.f8401h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f8403j == null) {
            this.f8403j = (ConnectivityManager) f8392a.getSystemService("connectivity");
        }
        return this.f8403j;
    }

    public AccsDataListener getListener(String str) {
        return this.n.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f8400g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f8404k == null) {
                this.f8404k = f8392a.getPackageManager().getPackageInfo(f8392a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f8404k;
    }

    public String getService(String str) {
        return f8398l.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f8400g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f8400g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (f8399m.get(str) == null) {
            f8399m.put(str, new ConcurrentHashMap());
        }
        f8399m.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.n.put(str, accsDataListener);
    }

    public void registerRemoteService(String str, String str2) {
        f8398l.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f8398l.put(str, str2);
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                f8393b = (IAgooAppReceiver) iAppReceiver;
                return;
            }
            if (this.f8401h == null) {
                this.f8401h = new ConcurrentHashMap<>(2);
            }
            this.f8401h.put(str, iAppReceiver);
            a(str, iAppReceiver.getAllServices());
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f8400g == null) {
            this.f8400g = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f8400g.put(str, iLoginInfo);
        }
    }

    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        f8393b = iAgooAppReceiver;
    }

    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.f8401h == null) {
            this.f8401h = new ConcurrentHashMap<>(2);
        }
        this.f8401h.put(str, iAppReceiver);
        a(str, iAppReceiver.getAllServices());
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f8398l.remove(str);
    }

    public void unregisterListener(String str) {
        this.n.remove(str);
    }

    public void unregisterRemoteListener(String str) {
        this.n.remove(str);
    }

    public void unregisterRemoteService(String str) {
        f8398l.remove(str);
    }

    public String getService(String str, String str2) {
        if (f8399m.get(str) != null) {
            return f8399m.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if (TextUtils.isEmpty(str) || accsDataListener == null) {
            return;
        }
        this.n.put(str, accsDataListener);
    }
}

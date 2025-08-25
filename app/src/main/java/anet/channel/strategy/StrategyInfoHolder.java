package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    Map<String, StrategyTable> f1931a = new LruStrategyMap();

    /* renamed from: b, reason: collision with root package name */
    volatile StrategyConfig f1932b = null;

    /* renamed from: c, reason: collision with root package name */
    final a f1933c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final StrategyTable f1934d = new StrategyTable("Unknown");

    /* renamed from: e, reason: collision with root package name */
    private final Set<String> f1935e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private volatile String f1936f = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyTable> entry) {
            anet.channel.strategy.utils.a.a(new f(this, entry));
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            e();
            g();
        } catch (Throwable unused) {
        }
        f();
    }

    public static StrategyInfoHolder a() {
        return new StrategyInfoHolder();
    }

    private void e() {
        NetworkStatusHelper.addStatusChangeListener(this);
        this.f1936f = a(NetworkStatusHelper.getStatus());
    }

    private void f() {
        Iterator<Map.Entry<String, StrategyTable>> it = this.f1931a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        synchronized (this) {
            if (this.f1932b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.b();
                strategyConfig.a(this);
                this.f1932b = strategyConfig;
            }
        }
    }

    private void g() {
        ALog.i("awcn.StrategyInfoHolder", RequestParameters.X_OSS_RESTORE, null, new Object[0]);
        String str = this.f1936f;
        if (!AwcnConfig.isAsyncLoadStrategyEnable()) {
            if (!TextUtils.isEmpty(str)) {
                a(str, true);
            }
            this.f1932b = (StrategyConfig) m.a("StrategyConfig", null);
            if (this.f1932b != null) {
                this.f1932b.b();
                this.f1932b.a(this);
            }
        }
        anet.channel.strategy.utils.a.a(new d(this, str));
    }

    void b() {
        NetworkStatusHelper.removeStatusChangeListener(this);
    }

    void c() {
        synchronized (this) {
            for (StrategyTable strategyTable : this.f1931a.values()) {
                if (strategyTable.f1945d) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    strategyStatObject.writeStrategyFileId = strategyTable.f1942a;
                    m.a(strategyTable, strategyTable.f1942a, strategyStatObject);
                    strategyTable.f1945d = false;
                }
            }
            m.a(this.f1932b.a(), "StrategyConfig", null);
        }
    }

    StrategyTable d() {
        StrategyTable strategyTable = this.f1934d;
        String str = this.f1936f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f1931a) {
                strategyTable = this.f1931a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.f1931a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1936f = a(networkStatus);
        String str = this.f1936f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f1931a) {
            if (!this.f1931a.containsKey(str)) {
                anet.channel.strategy.utils.a.a(new e(this, str));
            }
        }
    }

    protected void a(String str, boolean z) {
        synchronized (this.f1935e) {
            if (this.f1935e.contains(str)) {
                return;
            }
            this.f1935e.add(str);
            StrategyStatObject strategyStatObject = null;
            if (z) {
                strategyStatObject = new StrategyStatObject(0);
                strategyStatObject.readStrategyFileId = str;
            }
            StrategyTable strategyTable = (StrategyTable) m.a(str, strategyStatObject);
            if (strategyTable != null) {
                strategyTable.a();
                synchronized (this.f1931a) {
                    this.f1931a.put(strategyTable.f1942a, strategyTable);
                }
            }
            synchronized (this.f1935e) {
                this.f1935e.remove(str);
            }
            if (z) {
                strategyStatObject.isSucceed = strategyTable != null ? 1 : 0;
                AppMonitor.getInstance().commitStat(strategyStatObject);
            }
        }
    }

    private String a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String strMd5ToHex = StringUtils.md5ToHex(NetworkStatusHelper.getWifiBSSID());
            if (TextUtils.isEmpty(strMd5ToHex)) {
                strMd5ToHex = "";
            }
            return "WIFI$" + strMd5ToHex;
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
    }

    void a(l.d dVar) {
        int i2 = dVar.f2017g;
        if (i2 != 0) {
            AmdcRuntimeInfo.updateAmdcLimit(i2, dVar.f2018h);
        }
        d().update(dVar);
        this.f1932b.a(dVar);
    }
}

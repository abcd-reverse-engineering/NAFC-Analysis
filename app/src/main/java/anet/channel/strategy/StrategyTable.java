package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyTable implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    protected static Comparator<StrategyCollection> f1941e = new o();

    /* renamed from: a, reason: collision with root package name */
    protected String f1942a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile String f1943b;

    /* renamed from: c, reason: collision with root package name */
    Map<String, Long> f1944c;

    /* renamed from: d, reason: collision with root package name */
    protected transient boolean f1945d = false;

    /* renamed from: f, reason: collision with root package name */
    private HostLruCache f1946f;

    /* renamed from: g, reason: collision with root package name */
    private volatile transient int f1947g;

    /* compiled from: Taobao */
    private static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i2) {
            super(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f1923d) {
                return true;
            }
            Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().f1923d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    protected StrategyTable(String str) {
        this.f1942a = str;
        a();
    }

    private void b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f1942a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                this.f1946f.put(str, new StrategyCollection(str));
            }
        }
    }

    private void c() {
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f1942a)) {
                TreeSet treeSet = null;
                synchronized (this.f1946f) {
                    for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                        if (!this.f1946f.containsKey(str)) {
                            this.f1946f.put(str, new StrategyCollection(str));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(str);
                        }
                    }
                }
                if (treeSet != null) {
                    a(treeSet);
                }
            }
        } catch (Exception e2) {
            ALog.e("awcn.StrategyTable", "checkInitHost failed", this.f1942a, e2, new Object[0]);
        }
    }

    protected void a() {
        if (this.f1946f == null) {
            this.f1946f = new HostLruCache(256);
            b();
        }
        Iterator<StrategyCollection> it = this.f1946f.values().iterator();
        while (it.hasNext()) {
            it.next().checkInit();
        }
        ALog.i("awcn.StrategyTable", "strategy map", null, "size", Integer.valueOf(this.f1946f.size()));
        this.f1947g = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
        if (this.f1944c == null) {
            this.f1944c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f1946f) {
            strategyCollection = this.f1946f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            a(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.f1922c;
        }
        return null;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return Collections.EMPTY_LIST;
        }
        c();
        synchronized (this.f1946f) {
            strategyCollection = this.f1946f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f1946f.put(str, strategyCollection);
            }
        }
        if (strategyCollection.f1921b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
        return strategyCollection.queryStrategyList();
    }

    public void update(l.d dVar) {
        l.b[] bVarArr;
        ALog.i("awcn.StrategyTable", "update strategyTable with httpDns response", this.f1942a, new Object[0]);
        try {
            this.f1943b = dVar.f2011a;
            this.f1947g = dVar.f2016f;
            bVarArr = dVar.f2012b;
        } catch (Throwable th) {
            ALog.e("awcn.StrategyTable", "fail to update strategyTable", this.f1942a, th, new Object[0]);
        }
        if (bVarArr == null) {
            return;
        }
        synchronized (this.f1946f) {
            for (l.b bVar : bVarArr) {
                if (bVar != null && bVar.f1997a != null) {
                    if (bVar.f2006j) {
                        this.f1946f.remove(bVar.f1997a);
                    } else {
                        StrategyCollection strategyCollection = this.f1946f.get(bVar.f1997a);
                        if (strategyCollection == null) {
                            strategyCollection = new StrategyCollection(bVar.f1997a);
                            this.f1946f.put(bVar.f1997a, strategyCollection);
                        }
                        strategyCollection.update(bVar);
                    }
                }
            }
        }
        this.f1945d = true;
        if (ALog.isPrintLog(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.f1942a);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
            synchronized (this.f1946f) {
                for (Map.Entry<String, StrategyCollection> entry : this.f1946f.entrySet()) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    sb.append(" = ");
                    sb.append(entry.getValue().toString());
                    ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
                }
            }
        }
    }

    private void b(Set<String> set) {
        TreeSet treeSet = new TreeSet(f1941e);
        synchronized (this.f1946f) {
            treeSet.addAll(this.f1946f.values());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            StrategyCollection strategyCollection = (StrategyCollection) it.next();
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            strategyCollection.f1921b = 30000 + jCurrentTimeMillis;
            set.add(strategyCollection.f1920a);
        }
    }

    private void a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        a(treeSet);
    }

    protected void a(String str, boolean z) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f1946f) {
            strategyCollection = this.f1946f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f1946f.put(str, strategyCollection);
            }
        }
        if (z || strategyCollection.f1921b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
    }

    private void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0) || !NetworkStatusHelper.isConnected()) {
            ALog.i("awcn.StrategyTable", "app in background or no network", this.f1942a, new Object[0]);
            return;
        }
        int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
        if (amdcLimitLevel == 3) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f1946f) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                StrategyCollection strategyCollection = this.f1946f.get(it.next());
                if (strategyCollection != null) {
                    strategyCollection.f1921b = 30000 + jCurrentTimeMillis;
                }
            }
        }
        if (amdcLimitLevel == 0) {
            b(set);
        }
        HttpDispatcher.getInstance().sendAmdcRequest(set, this.f1947g);
    }

    void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyTable", "[notifyConnEvent]", null, "Host", str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            anet.channel.e.a.a(connEvent.isSuccess);
            ALog.e("awcn.StrategyTable", "enable http3", null, "uniqueId", this.f1942a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && anet.channel.strategy.utils.c.b(iConnStrategy.getIp())) {
            this.f1944c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e("awcn.StrategyTable", "disable ipv6", null, "uniqueId", this.f1942a, Constants.KEY_HOST, str);
        }
        synchronized (this.f1946f) {
            strategyCollection = this.f1946f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    boolean a(String str, long j2) {
        Long l2 = this.f1944c.get(str);
        if (l2 == null) {
            return false;
        }
        if (l2.longValue() + j2 >= System.currentTimeMillis()) {
            return true;
        }
        this.f1944c.remove(str);
        return false;
    }
}
